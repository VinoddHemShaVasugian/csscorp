package com.app;

import java.math.BigDecimal;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="AlignmentPricingQuote")
public class AlignmentPricingQuote {

     private Long alignmentQuoteId;
     private String firstName;
     private String lastName;
     private Long storeNumber;
     private Short vehicleYear;
     private String vehicleMake;
     private String vehicleModel;
     private String vehicleSubmodel;
     private String zip;
     private Short alignmentPricingId;
     private String pricingName;
     private Long article;
     private BigDecimal price;
     private String webSite;
     private BigDecimal mowaaAmount;
     private String createdDate;
     private String donationName;
     private BigDecimal donationAmount;
     private Long donationArticle;
     private String emailAddress;
     
    @DynamoDBAttribute(attributeName="emailAddress") 
    public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
   
	@DynamoDBHashKey(attributeName="alignmentQuoteId") 
    public Long getAlignmentQuoteId() {
        return this.alignmentQuoteId;
    }
    
    public void setAlignmentQuoteId(Long alignmentQuoteId) {
        this.alignmentQuoteId = alignmentQuoteId;
    }
    
    @DynamoDBAttribute(attributeName="firstName")
    public String getFirstName() {
    	return userNameFilter(this.firstName,50);
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @DynamoDBAttribute(attributeName="lastName")
    public String getLastName() {
    	return userNameFilter(this.lastName,80);
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @DynamoDBAttribute(attributeName="storeNumber")
    public Long getStoreNumber() {
        return this.storeNumber;
    }
    
    public void setStoreNumber(Long storeNumber) {
        this.storeNumber = storeNumber;
    }
    
    @DynamoDBAttribute(attributeName="vehicleYear")
    public Short getVehicleYear() {
        return this.vehicleYear;
    }
    
    public void setVehicleYear(Short vehicleYear) {
        this.vehicleYear = vehicleYear;
    }
    
    @DynamoDBAttribute(attributeName="vehicleMake")
    public String getVehicleMake() {
    	return truncate(this.vehicleMake,30);
    }
    
    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }
    
    @DynamoDBAttribute(attributeName="vehicleModel")
    public String getVehicleModel() {
    	return truncate(this.vehicleModel,40);
    }
    
    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
    
    @DynamoDBAttribute(attributeName="vehicleSubmodel")
    public String getVehicleSubmodel() {
        return truncate(this.vehicleSubmodel,80);
    }
    
    public void setVehicleSubmodel(String vehicleSubmodel) {
        this.vehicleSubmodel = vehicleSubmodel;
    }
    
    @DynamoDBAttribute(attributeName="zip")
    public String getZip() {
    	return truncate(this.zip,10);
    }
    
    public void setZip(String zip) {
        this.zip = zip;
    }
    
    @DynamoDBAttribute(attributeName="alignmentPricingId")
    public Short getAlignmentPricingId() {
        return this.alignmentPricingId;
    }
    
    public void setAlignmentPricingId(Short alignmentPricingId) {
        this.alignmentPricingId = alignmentPricingId;
    }
    
    @DynamoDBAttribute(attributeName="pricingName")
    public String getPricingName() {
        return this.pricingName;
    }
    
    public void setPricingName(String pricingName) {
        this.pricingName = pricingName;
    }
    
    
    @DynamoDBAttribute(attributeName="article")
    public Long getArticle() {
        return this.article;
    }
    
    public void setArticle(Long article) {
        this.article = article;
    }
    
    @DynamoDBAttribute(attributeName="price")
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    @DynamoDBAttribute(attributeName="webSite")
    public String getWebSite() {
        return this.webSite;
    }
    
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
    
    @DynamoDBAttribute(attributeName="mowaaAmount")
    public BigDecimal getMowaaAmount() {
        return this.mowaaAmount;
    }
    
    public void setMowaaAmount(BigDecimal mowaaAmount) {
        this.mowaaAmount = mowaaAmount;
    }
    
    @DynamoDBAttribute(attributeName="createdDate")
    public String getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    
    @DynamoDBAttribute(attributeName="donationName")
    public String getDonationName() {
        return this.donationName;
    }
    
    public void setDonationName(String donationName) {
        this.donationName = donationName;
    }
    
    @DynamoDBAttribute(attributeName="donationAmount")
    public BigDecimal getDonationAmount() {
        return this.donationAmount;
    }
    
    public void setDonationAmount(BigDecimal donationAmount) {
        this.donationAmount = donationAmount;
    }

    @DynamoDBAttribute(attributeName="donationArticle")
    public Long getDonationArticle() {
        return this.donationArticle;
    }
    
    public void setDonationArticle(Long donationArticle) {
        this.donationArticle = donationArticle;
    }
    
    public static String userNameFilter(String name, int maxLength){
		if(name == null)
			return null;
		if(maxLength >0)
		    name = name.length() > maxLength ? name.substring(0,maxLength) : name;
		name =     ("First Name".equalsIgnoreCase(name) || "FirstName".equalsIgnoreCase(name) || "Last Name".equalsIgnoreCase(name) || "LastName".equalsIgnoreCase(name)) ? "" : name;
		return name.replaceAll("\\|", "");
	}
	
	public static String userNameFilter(String name){
		return userNameFilter(name, -1);
	}
	
	public static String truncate(String input,int maxLength){
		if(input == null)
			return null;
		if(maxLength >0)
			input = input.length() > maxLength ? input.substring(0,maxLength) : input;
		return input;
	}

}


