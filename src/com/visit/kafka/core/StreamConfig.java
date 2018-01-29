package com.visit.kafka.core;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.ByteArraySerializer;

import com.visit.kafka.serialization.GenericAvroDeserializer;
import com.visit.kafka.serialization.GenericAvroSerializer;
import com.visit.kafka.util.Constants;
import com.visit.kafka.util.PropertiesCache;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.kafka.ConsumerSettings;
import akka.kafka.ProducerSettings;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Flow;
import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;

abstract class StreamConfig {
  protected final ActorSystem system = ActorSystem.create("kafka-system");

  protected final Materializer materializer = ActorMaterializer.create(system);

  protected final int maxPartitions = 100;

  protected <T> Flow<T, T, NotUsed> business() {
    return Flow.create();
  }

  
  CachedSchemaRegistryClient SchemaRegistryClient = new CachedSchemaRegistryClient(PropertiesCache.getInstance().getProperty(Constants.SCHEMA_REGISTRY_URL_CONFIG), 10000000);
 
  // #settings
  protected final ConsumerSettings<byte[], GenericRecord> consumerSettings =
      ConsumerSettings.create(system, new ByteArrayDeserializer(), new GenericAvroDeserializer(SchemaRegistryClient))
    .withBootstrapServers(PropertiesCache.getInstance().getProperty(Constants.BOOTSTRAP_SERVERS_CONFIG))
    .withGroupId(PropertiesCache.getInstance().getProperty(Constants.KAFKA_GROUP_ID))
    .withProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")
    .withProperty(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG,PropertiesCache.getInstance().getProperty(Constants.SCHEMA_REGISTRY_URL_CONFIG));
  // #settings

  protected final ProducerSettings<byte[], GenericRecord> producerSettings =
      ProducerSettings.create(system, new ByteArraySerializer(), new GenericAvroSerializer(SchemaRegistryClient))
    .withBootstrapServers(PropertiesCache.getInstance().getProperty(Constants.BOOTSTRAP_SERVERS_CONFIG));

}