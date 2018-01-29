package com.visit.kafka.model;
//pojo class for IP locations
public class IpLocation {
	String as;
	String city;
	String country;
	String countryCode;
	String isp;
	String lat;
	String lon;
	String org;
	String query;
	String region;
	String regionName;
	String status;
	String timezone;
	String zip;

	public String getAs() {
		return as;
	}
	public void setAs(String as) {
		this.as = as;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getIsp() {
		return isp;
	}
	public void setIsp(String isp) {
		this.isp = isp;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "IpLocation [as=" + as + ", city=" + city + ", country=" + country + ", countryCode=" + countryCode
				+ ", isp=" + isp + ", lat=" + lat + ", lon=" + lon + ", org=" + org + ", query=" + query + ", region="
				+ region + ", regionName=" + regionName + ", status=" + status + ", timezone=" + timezone + ", zip="
				+ zip + "]";
	}

	
}
