package com.app;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="EmailSignup")
public class EmailSignup {
	
	private Long signupId;
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String email;
	private String emailAddress;
	private String confirmEmail;
	private String createdDate;
	private String source;
	private String optinCode;
	private String confirmOptin;
	private String couponId;
	private String friendsEmail;
	private String phoneNumber;
	private String actionCode;
	private String modifiedDate;
	private String accessCode;
	
	@DynamoDBHashKey(attributeName="signupId")
	public Long getSignupId() {
		return signupId;
	}
	public void setSignupId(Long signupId) {
		this.signupId = signupId;
	}
	
	@DynamoDBAttribute(attributeName="firstName")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@DynamoDBAttribute(attributeName="middleInitial")
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	
	@DynamoDBAttribute(attributeName="lastName")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@DynamoDBAttribute(attributeName="address1")
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	@DynamoDBAttribute(attributeName="address2")
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	@DynamoDBAttribute(attributeName="city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@DynamoDBAttribute(attributeName="state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@DynamoDBAttribute(attributeName="zip")
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	@DynamoDBIgnore
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.emailAddress = email; // email attribute should be saved as emailAddress
	}
	
	@DynamoDBAttribute(attributeName="emailAddress")
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@DynamoDBIgnore
	public String getConfirmEmail() {
		return confirmEmail;
	}
	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}
	
	@DynamoDBAttribute(attributeName="createdDate")
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	@DynamoDBAttribute(attributeName="source")
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	@DynamoDBAttribute(attributeName="optinCode")
	public String getOptinCode() {
		return optinCode;
	}
	public void setOptinCode(String optinCode) {
		this.optinCode = optinCode;
	}
	
	@DynamoDBAttribute(attributeName="confirmOptin")
	public String getConfirmOptin() {
		return confirmOptin;
	}
	public void setConfirmOptin(String confirmOptin) {
		this.confirmOptin = confirmOptin;
	}
	
	@DynamoDBAttribute(attributeName="couponId")
	public String getCouponId() {
		return couponId;
	}
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	
	@DynamoDBAttribute(attributeName="friendsEmail")
	public String getFriendsEmail() {
		return friendsEmail;
	}
	public void setFriendsEmail(String friendsEmail) {
		this.friendsEmail = friendsEmail;
	}
	
	@DynamoDBAttribute(attributeName="phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@DynamoDBAttribute(attributeName="actionCode")
	public String getActionCode() {
		return actionCode;
	}
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}
	
	@DynamoDBAttribute(attributeName="modifiedDate")
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	@DynamoDBAttribute(attributeName="accessCode")
	public String getAccessCode() {
		return accessCode;
	}
	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}
	
}
