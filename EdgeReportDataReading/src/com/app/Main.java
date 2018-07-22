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

public class Main {

	public static void main(String[] args) throws Exception{
//Prod AWS
//		AWSCredentials creds = new BasicAWSCredentials("AKIAJXXRDVXYVLWHHQWQ","bmKdzqUKksgFP7bY+xfi4xwEQW+iV5JBSX5td2rV");
//QA AWS
	    AWSCredentials creds = new BasicAWSCredentials("AKIAJNC7RBGEV3HFSAUQ","+9ryX+JrqadbmZ3n6CgUpqFz3zwEX9VTad/3Nbd3");
//Prod AWS
//		AWSCredentials creds = new BasicAWSCredentials("AKIAJOMUDY3BRDXIIMEQ","eR7n7aACSRjx3Hi+B+Mx3v4D5rZ24OgVkHZu+at1");
	    AmazonDynamoDBClient dyndbclient = new AmazonDynamoDBClient(creds);
	    dyndbclient.setRegion(Region.getRegion(Regions.US_EAST_1));
	    DynamoDBMapper mapper = new DynamoDBMapper(dyndbclient);
	    //DynamoDB db=new DynamoDB(dyndbclient);
	    
	    //Table tb=db.getTable("Appointment");

/*ScanSpec scanRequest = new ScanSpec()
    .withFilterExpression("#d  <> :d1 ")//and :d2")
    .withNameMap(new NameMap().with("#d", "createdDateTime"))
    .withValueMap(new ValueMap()
    //.withString(":d1","2017-10-23 07:55:59")
    .withString(":d1","2017-10-02 14:42:15"));
System.out.println(tb.scan(scanRequest).getTotalScannedCount());
ItemCollection<ScanOutcome> coll=tb.scan(scanRequest);
System.out.println(coll.getTotalCount());*/
//coll.forEach(n->System.out.println(n));
/*Map<String,Condition> map=new HashMap<String,Condition>();
map.put("createdDateTime", new Condition().setComparisonOperator("2017-10-02 14:42:15"));
dyndbclient.scan("Appointment",map);
*/
/*for (Map<String, AttributeValue> item : result.getItems()){
    System.out.println(item);
	}*/
	   /* SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    String strDate = "2017-10-08 03:00:00";
	    
	    Table table=db.getTable("Appointment");
		Index index=table.getIndex("createdDateHour-webSite-index");
	    QuerySpec spec=new QuerySpec();
	    
		spec.withKeyConditionExpression("#date =:d and webSite=:s1")
		.withNameMap(new NameMap().with("#date","createdDateHour"))
		.withValueMap(new ValueMap().withString(":d", "2017-10-08 03:00:00")
			.withString(":s1","FCAC"));
		
		ItemCollection<QueryOutcome> colll=index.query(spec);
		colll.forEach(n->System.out.println(n.asMap()));*/
	    
	    Map<String,AttributeValue> map=new HashMap<String,AttributeValue>();
	    map.put(":s1", new AttributeValue().withS("2017-10-27 00:00:00"));
	    map.put(":s2", new AttributeValue().withS("2017-10-27 23:00:00"));
//	    map.put(":w", new AttributeValue().withS("FCAC"));
	    //map.put(":n",new AttributeValue().withN("5832691"));
	    
	    System.out.println("started");
	    DynamoDBScanExpression query = new DynamoDBScanExpression();
	    		query.setConsistentRead(false);
//	    		query.setFilterExpression("createdDateTime between :s1 and :s2 and webSite=:w");
	    		query.setFilterExpression("createdDateTime between :s1 and :s2");
	    		//query.setFilterExpression("appointmentId=:n");
	    		query.withExpressionAttributeValues(map);
	    List<Appointment> list = mapper.scan(Appointment.class, query);
	    
	    System.out.println("Count : "+list.size());
	    FileWriter writer = new FileWriter(new File("a.txt"));
	    for(Appointment a:list){
	    	writer.write(a.getAppointmentId().toString()+"\n");
	    	System.out.println(a.getAppointmentId());
	    	System.out.println(a.getEmailAddress());
	    	System.out.println(a.getBookingConfirmationId());
//	    	a.getCreatedDateTime()
	    	System.out.println(a.getCreatedDateTime());
	    	
	    }
	    writer.close();
	    System.out.println("ended");
	}
}
