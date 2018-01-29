package com.visit.kafka.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.visit.kafka.model.IpLocation;

public class IpTransformation {

	public HashMap<String, String> getIpDetail(String clientIpAddress) {
		String[] clientIpAddressList;
		 String ipAdress = null;
		try{
		 clientIpAddressList = clientIpAddress.split(",");
		ipAdress = clientIpAddressList[0].replace( " ","");
		System.out.println("ipAdress"+ipAdress);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		URL obj = null;
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> ipAdressData = new HashMap<String, String>();
		try {
			obj = new URL("http://ip-api.com/json/" + ipAdress);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.getInputStream();
			StringBuffer response = new StringBuffer();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());
			IpLocation ipLocation = mapper.readValue(response.toString(), IpLocation.class);
			String countryCode = ipLocation.getCountryCode();
			String regionName = ipLocation.getRegionName();
			String city = ipLocation.getCity();
			String lat = ipLocation.getLat();
			String lon = ipLocation.getLon();
			System.out.println("lon===="+lon);
			ipAdressData.put(VisitConstants.client_countryCode, countryCode);
			ipAdressData.put(VisitConstants.client_regionName, regionName);
			ipAdressData.put(VisitConstants.client_city, city);
			ipAdressData.put(VisitConstants.client_latitude, lat);
			ipAdressData.put(VisitConstants.client_longitude, lon);
			ipAdressData.put(VisitConstants.client_ip_address,ipAdress);

			System.out.println(ipAdressData.get(VisitConstants.client_longitude));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ipAdressData;
	}

}
