package com.app;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class Temp {

	public static void main(String[] args) throws Exception{
//QA AWS
//	    AWSCredentials creds = new BasicAWSCredentials("AKIAJNC7RBGEV3HFSAUQ","+9ryX+JrqadbmZ3n6CgUpqFz3zwEX9VTad/3Nbd3");
//Prod AWS
		AWSCredentials creds = new BasicAWSCredentials("AKIAJOMUDY3BRDXIIMEQ","eR7n7aACSRjx3Hi+B+Mx3v4D5rZ24OgVkHZu+at1");
	    AmazonDynamoDBClient dyndbclient = new AmazonDynamoDBClient(creds);
	    dyndbclient.setRegion(Region.getRegion(Regions.US_EAST_1));
	    DynamoDBMapper mapper = new DynamoDBMapper(dyndbclient);
	      
	    Map<String,AttributeValue> map=new HashMap<String,AttributeValue>();
	    map.put(":s1", new AttributeValue().withS("2017-10-25 05:00:00"));
	    map.put(":s2", new AttributeValue().withS("2017-10-26 04:59:59"));	    
	    System.out.println("started");
/*		//Appointment
	    DynamoDBScanExpression query = new DynamoDBScanExpression();
	    		query.setConsistentRead(false);
	    		query.setFilterExpression("createdDateTime between :s1 and :s2"); 
	    		query.withExpressionAttributeValues(map);
	    List<Appointment> list = mapper.scan(Appointment.class, query);
	    
	    System.out.println("Count : "+list.size());
	    FileWriter writer = new FileWriter(new File("a.txt"));
	    for(Appointment a:list){
	    	writer.write(a.getAppointmentId().toString()+"\n");
	    	//System.out.println(a.getCustomerId());
	    }
	    writer.close();
*/	  
	    
	    //Signup
	    DynamoDBScanExpression query = new DynamoDBScanExpression();
	    		query.setConsistentRead(false);
	    		query.setFilterExpression("createdDate between :s1 and :s2"); 
	    		query.withExpressionAttributeValues(map);
	    List<EmailSignup> list = mapper.scan(EmailSignup.class, query);
	    
	    System.out.println("Count : "+list.size());
	    FileWriter writer = new FileWriter(new File("a.txt"));
	    for(EmailSignup a:list){
	    	writer.write(a.getSignupId().toString()+"\n");
//	    	writer.write(a.getAppointmentId().toString()+"\n");
	    }
	    writer.close();

	    
/*	    //AlignmentPricingQuote
	    DynamoDBScanExpression query = new DynamoDBScanExpression();
	    		query.setConsistentRead(false);
	    		query.setFilterExpression("createdDate between :s1 and :s2"); 
	    		query.withExpressionAttributeValues(map);
	    List<AlignmentPricingQuote> list = mapper.scan(AlignmentPricingQuote.class, query);
	    
	    System.out.println("Count : "+list.size());
	    FileWriter writer = new FileWriter(new File("a.txt"));
	    for(AlignmentPricingQuote a:list){
	    	writer.write(a.getAlignmentQuoteId().toString()+"\n");
//	    	writer.write(a.getAppointmentId().toString()+"\n");
	    }
	    writer.close();
*/	    
	    System.out.println("ended");
	}
}
