package com.visit.kafka.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CompletionStage;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.visit.kafka.util.Constants;
import com.visit.kafka.util.IpTransformation;
import com.visit.kafka.util.PropertiesCache;
import com.visit.kafka.util.VisitConstants;
import com.visit.kafka.util.VisitTransformation;

import akka.Done;
import akka.kafka.ConsumerMessage;
import akka.kafka.ConsumerMessage.Committable;
import akka.kafka.ProducerMessage;
import akka.kafka.ProducerMessage.Message;
import akka.kafka.Subscriptions;
import akka.kafka.javadsl.Consumer;
import akka.kafka.javadsl.Producer;

class VisitReactiveStreaming extends StreamConfig {
	final Logger logger = LoggerFactory.getLogger(VisitReactiveStreaming.class);

	public static void main(String[] args) {
		new VisitReactiveStreaming().visitTransformation();
	}

	public CompletionStage<Done> visitTransformation() {
		CompletionStage<Done> feedback= Consumer.committableSource(consumerSettings, Subscriptions.topics(PropertiesCache.getInstance().getProperty(Constants.kAFKA_INPUT_TOPIC)))
		.filter(msg -> {
			logger.info("inside the WebAppName filter class for filtering webappname==facility2");
			String webappName =msg.record().value().get("webapp_name").toString();
				System.out.println(webappName);
				if(webappName.equals("facility2"))
					return true;
				else
					return false;
	
		}).map(message -> {

			logger.info("inside VisitTransformationMapper ");
			HashMap<String, String> additionalData = new HashMap<String, String>();
			VisitTransformation visitTransformation = new VisitTransformation();
			IpTransformation ipTransformation = new IpTransformation();
			GenericRecord visitTr = visitTransformation.removeVisitFields(message.record().value());
			Schema schema = null;
			try {
				ClassLoader classLoader = ClassLoader.getSystemClassLoader();
				classLoader.getResource("visit.avsc");
				schema = new Schema.Parser().parse(ClassLoader.getSystemResourceAsStream("visit.avsc"));
				logger.info(
						"getting visit shema form resource folder visit shema is = " + schema.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			GenericRecord genericVisitRecord = new GenericData.Record(schema);

			if (visitTr.get(VisitConstants.client_ip_address) != null) {

				additionalData = ipTransformation
						.getIpDetail(visitTr.get(VisitConstants.client_ip_address).toString());
				logger.info(
						"getting ip details of" + visitTr.get(VisitConstants.client_ip_address).toString());
				System.out.println(visitTr.get(VisitConstants.client_ip_address).toString());
				genericVisitRecord = visitTransformation.addVisitFields(visitTr, schema, additionalData);
				logger.info(
						"sucessfully transform visit fields and added new ip information to the generic record");
			} else {

				logger.info(" ****ip not found*** setting default value to the fields");
				additionalData.put(VisitConstants.client_countryCode, "");
				additionalData.put(VisitConstants.client_regionName, "");
				additionalData.put(VisitConstants.client_city, "");
				additionalData.put(VisitConstants.client_latitude, "");
				additionalData.put(VisitConstants.client_longitude, "");
				additionalData.put(VisitConstants.client_ip_address, "");
				genericVisitRecord = visitTransformation.addVisitFields(visitTr, schema, additionalData);
			}
			Message<byte[], GenericRecord, Committable> record = new ProducerMessage.Message<byte[], GenericRecord, ConsumerMessage.Committable>(
					new ProducerRecord<>(PropertiesCache.getInstance().getProperty(Constants.KAFKA_OUTPUT_TOPIC), genericVisitRecord), message.committableOffset());
			return record;
		}).runWith(Producer.commitableSink(producerSettings), materializer);
		return feedback;
	}
}