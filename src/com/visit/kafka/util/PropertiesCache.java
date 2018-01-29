package com.visit.kafka.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
 
public class PropertiesCache
{
   private final Properties configProp = new Properties();
   
   private static PropertiesCache cache = null;
   
   private PropertiesCache()
   {
      //Private constructor to restrict new instances
      InputStream in = this.getClass().getClassLoader().getResourceAsStream("app.properties");
      System.out.println("Read all properties from file");
      try {
          configProp.load(in);
      System.out.println(configProp.containsKey(Constants.BOOTSTRAP_SERVERS_CONFIG));;
      System.out.println(configProp.get(Constants.BOOTSTRAP_SERVERS_CONFIG));
      } catch (IOException e) {
          e.printStackTrace();
      }
   }
 
   //Bill Pugh Solution for singleton pattern
   
   public static  PropertiesCache getInstance()
   {
      if(cache==null){
    	 cache= new PropertiesCache();
    	 return cache;
      }
      else 
    	  return cache;
	   
   }
    
   public String getProperty(String key){
      return configProp.getProperty(key);
   }
    
   public Set<String> getAllPropertyNames(){
      return configProp.stringPropertyNames();
   }
    
   public boolean containsKey(String key){
      return configProp.containsKey(key);
   }
}