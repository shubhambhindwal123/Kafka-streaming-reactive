package com.visit.kafka.model;


public class Visit {
public  String visit_id;
public  String visitor_id;
public  String user_login_id;
public  String user_created;
public  String session_id;
public  String server_ip_address;
public  String server_host_name;
public  String webapp_name;

public  String initial_request;
public  String initial_user_agent;

public  String client_ip_address;
public  String client_host_name;
public  String client_user;
public  String client_ip_isp_name;
public  String client_ip_postal_code;
public  String from_date;
public  String thru_date;
public  String last_updated_stamp;
public  String last_updated_tx_stamp;
@Override
public String toString() {
	return "Visit [visit_id=" + visit_id + ", visitor_id=" + visitor_id + ", user_login_id=" + user_login_id
			+ ", user_created=" + user_created + ", session_id=" + session_id + ", server_ip_address="
			+ server_ip_address + ", server_host_name=" + server_host_name + ", webapp_name=" + webapp_name
			+ ", initial_request=" + initial_request + ", initial_user_agent=" + initial_user_agent
			+ ", client_ip_address=" + client_ip_address + ", client_host_name=" + client_host_name + ", client_user="
			+ client_user + ", client_ip_isp_name=" + client_ip_isp_name + ", client_ip_postal_code="
			+ client_ip_postal_code + ", from_date=" + from_date + ", thru_date=" + thru_date + ", last_updated_stamp="
			+ last_updated_stamp + ", last_updated_tx_stamp=" + last_updated_tx_stamp + ", created_stamp="
			+ created_stamp + ", client_ip_state_prov_geo_id=" + client_ip_state_prov_geo_id
			+ ", client_ip_country_geo_id=" + client_ip_country_geo_id + ", contact_mech_id=" + contact_mech_id
			+ ", party_id=" + party_id + ", role_type_id=" + role_type_id + ", client_countryCode=" + client_countryCode
			+ ", client_regionName=" + client_regionName + ", client_city=" + client_city + ", client_latitude="
			+ client_latitude + ", client_longitude=" + client_longitude + "]";
}
public  String created_stamp;

public  String client_ip_state_prov_geo_id;
public  String client_ip_country_geo_id;
public  String contact_mech_id;
public  String party_id;
public  String role_type_id;

// Data need to be removed
//public  String initial_locale = "initial_locale";
//public  String initial_referrer = "initial_referrer";
//public  String user_agent_id = "user_agent_id" ;
//public  String created_tx_stamp="created_tx_stamp";
//add addtional data
public  String client_countryCode;
public String getVisit_id() {
	return visit_id;
}
public void setVisit_id(String visit_id) {
	this.visit_id = visit_id;
}
public String getVisitor_id() {
	return visitor_id;
}
public void setVisitor_id(String visitor_id) {
	this.visitor_id = visitor_id;
}
public String getUser_login_id() {
	return user_login_id;
}
public void setUser_login_id(String user_login_id) {
	this.user_login_id = user_login_id;
}
public String getUser_created() {
	return user_created;
}
public void setUser_created(String user_created) {
	this.user_created = user_created;
}
public String getSession_id() {
	return session_id;
}
public void setSession_id(String session_id) {
	this.session_id = session_id;
}
public String getServer_ip_address() {
	return server_ip_address;
}
public void setServer_ip_address(String server_ip_address) {
	this.server_ip_address = server_ip_address;
}
public String getServer_host_name() {
	return server_host_name;
}
public void setServer_host_name(String server_host_name) {
	this.server_host_name = server_host_name;
}
public String getWebapp_name() {
	return webapp_name;
}
public void setWebapp_name(String webapp_name) {
	this.webapp_name = webapp_name;
}
public String getInitial_request() {
	return initial_request;
}
public void setInitial_request(String initial_request) {
	this.initial_request = initial_request;
}
public String getInitial_user_agent() {
	return initial_user_agent;
}
public void setInitial_user_agent(String initial_user_agent) {
	this.initial_user_agent = initial_user_agent;
}
public String getClient_ip_address() {
	return client_ip_address;
}
public void setClient_ip_address(String client_ip_address) {
	this.client_ip_address = client_ip_address;
}
public String getClient_host_name() {
	return client_host_name;
}
public void setClient_host_name(String client_host_name) {
	this.client_host_name = client_host_name;
}
public String getClient_user() {
	return client_user;
}
public void setClient_user(String client_user) {
	this.client_user = client_user;
}
public String getClient_ip_isp_name() {
	return client_ip_isp_name;
}
public void setClient_ip_isp_name(String client_ip_isp_name) {
	this.client_ip_isp_name = client_ip_isp_name;
}
public String getClient_ip_postal_code() {
	return client_ip_postal_code;
}
public void setClient_ip_postal_code(String client_ip_postal_code) {
	this.client_ip_postal_code = client_ip_postal_code;
}
public String getFrom_date() {
	return from_date;
}
public void setFrom_date(String from_date) {
	this.from_date = from_date;
}
public String getThru_date() {
	return thru_date;
}
public void setThru_date(String thru_date) {
	this.thru_date = thru_date;
}
public String getLast_updated_stamp() {
	return last_updated_stamp;
}
public void setLast_updated_stamp(String last_updated_stamp) {
	this.last_updated_stamp = last_updated_stamp;
}
public String getLast_updated_tx_stamp() {
	return last_updated_tx_stamp;
}
public void setLast_updated_tx_stamp(String last_updated_tx_stamp) {
	this.last_updated_tx_stamp = last_updated_tx_stamp;
}
public String getCreated_stamp() {
	return created_stamp;
}
public void setCreated_stamp(String created_stamp) {
	this.created_stamp = created_stamp;
}
public String getClient_ip_state_prov_geo_id() {
	return client_ip_state_prov_geo_id;
}
public void setClient_ip_state_prov_geo_id(String client_ip_state_prov_geo_id) {
	this.client_ip_state_prov_geo_id = client_ip_state_prov_geo_id;
}
public String getClient_ip_country_geo_id() {
	return client_ip_country_geo_id;
}
public void setClient_ip_country_geo_id(String client_ip_country_geo_id) {
	this.client_ip_country_geo_id = client_ip_country_geo_id;
}
public String getContact_mech_id() {
	return contact_mech_id;
}
public void setContact_mech_id(String contact_mech_id) {
	this.contact_mech_id = contact_mech_id;
}
public String getParty_id() {
	return party_id;
}
public void setParty_id(String party_id) {
	this.party_id = party_id;
}
public String getRole_type_id() {
	return role_type_id;
}
public void setRole_type_id(String role_type_id) {
	this.role_type_id = role_type_id;
}
public String getClient_countryCode() {
	return client_countryCode;
}
public void setClient_countryCode(String client_countryCode) {
	this.client_countryCode = client_countryCode;
}
public String getClient_regionName() {
	return client_regionName;
}
public void setClient_regionName(String client_regionName) {
	this.client_regionName = client_regionName;
}
public String getClient_city() {
	return client_city;
}
public void setClient_city(String client_city) {
	this.client_city = client_city;
}
public String getClient_latitude() {
	return client_latitude;
}
public void setClient_latitude(String client_latitude) {
	this.client_latitude = client_latitude;
}
public String getClient_longitude() {
	return client_longitude;
}
public void setClient_longitude(String client_longitude) {
	this.client_longitude = client_longitude;
}
public  String client_regionName;
public  String client_city;
public  String client_latitude;
public  String client_longitude;
}
