package com.visit.kafka.util;

import java.io.IOException;
import java.util.HashMap;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class VisitTransformation {
//	 initialLocale, initialReferrer, userAgentId, createdTxStamp

	Logger logger = LoggerFactory.getLogger(VisitTransformation.class);
	
	
	public GenericRecord removeVisitFields(GenericRecord record){
	GenericRecord updatedRecord = new  GenericData.Record(record.getSchema());
	logger.info("inside removeVisitFields Method");
	updatedRecord.put(VisitConstants.client_host_name,record.get(VisitConstants.client_host_name));
	updatedRecord.put(VisitConstants.client_ip_address,record.get(VisitConstants.client_ip_address));
	updatedRecord.put(VisitConstants.client_ip_country_geo_id,record.get(VisitConstants.client_ip_country_geo_id));
	updatedRecord.put(VisitConstants.client_ip_isp_name,record.get(VisitConstants.client_ip_isp_name));
	updatedRecord.put(VisitConstants.client_ip_postal_code,record.get(VisitConstants.client_ip_postal_code));
	updatedRecord.put(VisitConstants.client_ip_state_prov_geo_id,record.get(VisitConstants.client_ip_state_prov_geo_id));
	updatedRecord.put(VisitConstants.client_user,record.get(VisitConstants.client_user));
	updatedRecord.put(VisitConstants.contact_mech_id,record.get(VisitConstants.contact_mech_id));
	updatedRecord.put(VisitConstants.created_stamp,record.get(VisitConstants.created_stamp));
//	updatedRecord.put(Visit.created_tx_stamp,record.get(Visit.created_tx_stamp));
	updatedRecord.put(VisitConstants.from_date,record.get(VisitConstants.from_date));
//	updatedRecord.put(Visit.initial_locale,record.get(Visit.initial_locale));
//	updatedRecord.put(Visit.initial_referrer,record.get(Visit.initial_referrer));
	updatedRecord.put(VisitConstants.initial_request,record.get(VisitConstants.initial_request));
	updatedRecord.put(VisitConstants.initial_user_agent,record.get(VisitConstants.initial_user_agent));
	updatedRecord.put(VisitConstants.last_updated_stamp,record.get(VisitConstants.last_updated_stamp));
	updatedRecord.put(VisitConstants.last_updated_tx_stamp,record.get(VisitConstants.last_updated_tx_stamp));
	updatedRecord.put(VisitConstants.party_id,record.get(VisitConstants.party_id));
	updatedRecord.put(VisitConstants.role_type_id,record.get(VisitConstants.role_type_id));
	updatedRecord.put(VisitConstants.server_host_name,record.get(VisitConstants.server_host_name));
	updatedRecord.put(VisitConstants.server_ip_address,record.get(VisitConstants.server_ip_address));
	updatedRecord.put(VisitConstants.session_id,record.get(VisitConstants.session_id));
	updatedRecord.put(VisitConstants.thru_date,record.get(VisitConstants.thru_date));
	updatedRecord.put(VisitConstants.user_login_id,record.get(VisitConstants.user_login_id));
	updatedRecord.put(VisitConstants.user_created,record.get(VisitConstants.user_created));
//	updatedRecord.put(Visit.user_agent_id,record.get(Visit.user_agent_id));
	updatedRecord.put(VisitConstants.visit_id,record.get(VisitConstants.visit_id));
	updatedRecord.put(VisitConstants.visitor_id,record.get(VisitConstants.visitor_id));
	updatedRecord.put(VisitConstants.webapp_name,record.get(VisitConstants.webapp_name));
System.out.println(updatedRecord.toString());
	return updatedRecord;
	//adding new data
	}
	
	public GenericRecord addVisitFields(GenericRecord record,Schema schema,HashMap<String,String> additionalData){
	      logger.info("inside addVisitFields Method for adding ip data to generic record");
		GenericRecord updatedRecord = new  GenericData.Record(schema);
		updatedRecord.put(VisitConstants.client_host_name,record.get(VisitConstants.client_host_name));
		updatedRecord.put(VisitConstants.client_ip_address,additionalData.get(VisitConstants.client_ip_address));
		updatedRecord.put(VisitConstants.client_ip_country_geo_id,record.get(VisitConstants.client_ip_country_geo_id));
		updatedRecord.put(VisitConstants.client_ip_isp_name,record.get(VisitConstants.client_ip_isp_name));
		updatedRecord.put(VisitConstants.client_ip_postal_code,record.get(VisitConstants.client_ip_postal_code));
		updatedRecord.put(VisitConstants.client_ip_state_prov_geo_id,record.get(VisitConstants.client_ip_state_prov_geo_id));
		updatedRecord.put(VisitConstants.client_user,record.get(VisitConstants.client_user));
		updatedRecord.put(VisitConstants.contact_mech_id,record.get(VisitConstants.contact_mech_id));
		updatedRecord.put(VisitConstants.created_stamp,record.get(VisitConstants.created_stamp));
//		updatedRecord.put(Visit.created_tx_stamp,record.get(Visit.created_tx_stamp));
		updatedRecord.put(VisitConstants.from_date,record.get(VisitConstants.from_date));
//		updatedRecord.put(Visit.initial_locale,record.get(Visit.initial_locale));
//		updatedRecord.put(Visit.initial_referrer,record.get(Visit.initial_referrer));
		updatedRecord.put(VisitConstants.initial_request,record.get(VisitConstants.initial_request));
		updatedRecord.put(VisitConstants.initial_user_agent,record.get(VisitConstants.initial_user_agent));
		updatedRecord.put(VisitConstants.last_updated_stamp,record.get(VisitConstants.last_updated_stamp));
		updatedRecord.put(VisitConstants.last_updated_tx_stamp,record.get(VisitConstants.last_updated_tx_stamp));
		updatedRecord.put(VisitConstants.party_id,record.get(VisitConstants.party_id));
		updatedRecord.put(VisitConstants.role_type_id,record.get(VisitConstants.role_type_id));
		updatedRecord.put(VisitConstants.server_host_name,record.get(VisitConstants.server_host_name));
		updatedRecord.put(VisitConstants.server_ip_address,record.get(VisitConstants.server_ip_address));
		updatedRecord.put(VisitConstants.session_id,record.get(VisitConstants.session_id));
		updatedRecord.put(VisitConstants.thru_date,record.get(VisitConstants.thru_date));
		updatedRecord.put(VisitConstants.user_login_id,record.get(VisitConstants.user_login_id));
		updatedRecord.put(VisitConstants.user_created,record.get(VisitConstants.user_created));
//		updatedRecord.put(Visit.user_agent_id,record.get(Visit.user_agent_id));
		updatedRecord.put(VisitConstants.visit_id,record.get(VisitConstants.visit_id));
		updatedRecord.put(VisitConstants.visitor_id,record.get(VisitConstants.visitor_id));
		updatedRecord.put(VisitConstants.webapp_name,record.get(VisitConstants.webapp_name));

		updatedRecord.put(VisitConstants.client_countryCode,additionalData.get(VisitConstants.client_countryCode));
		updatedRecord.put(VisitConstants.client_regionName,additionalData.get(VisitConstants.client_regionName));
		updatedRecord.put(VisitConstants.client_city,additionalData.get(VisitConstants.client_city));
		updatedRecord.put(VisitConstants.client_latitude,additionalData.get(VisitConstants.client_latitude));
		updatedRecord.put(VisitConstants.client_longitude,additionalData.get(VisitConstants.client_longitude).toString());
	return updatedRecord;
	}
	
}