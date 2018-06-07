package jmeter;

import java.util.Arrays;

public class BatteryResult {

	public static void main(String[] args) {
		String jmeterAwsPartNumber = "[\"7005423\",\"7098434\"]";
		String[] awsitems = jmeterAwsPartNumber.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
		String jmeterAwsPerformanceWarrantyMonths = "[\"60\",\"72\"]";
		String[] awsitems2 = jmeterAwsPerformanceWarrantyMonths.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
		String jmeterAwsWebPrice = "[\"99.99\",\"119.99\"]";
		String[] awsitems3 = jmeterAwsWebPrice.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

		int[] iawsPartNumber = new int[awsitems.length];
		int[] iawsPerformanceWarrantyMonths = new int[awsitems.length];
		float[] iawsWebPrice = new float[awsitems.length];
		for (int i = 0; i < awsitems.length; i++) {
		    try {
		    	String temp = awsitems[i];
		    	temp=temp.replaceAll("\"", "");
		        iawsPartNumber[i] = Integer.parseInt(temp);
		        	String temp1 = awsitems2[i];
		    	temp1=temp1.replaceAll("\"", "");
		        iawsPerformanceWarrantyMonths[i] = Integer.parseInt(temp1);
		         	String temp2 = awsitems3[i];
		     temp2=temp2.replaceAll("\"", "");
		        iawsWebPrice[i] = Float.parseFloat(temp2);
		      } catch (NumberFormatException nfe){
					System.out.println("Exception noticed in AWS convertion");
		    }
		}
		
		Arrays.sort(iawsPartNumber);
		Arrays.sort(iawsPerformanceWarrantyMonths);
		Arrays.sort(iawsWebPrice);

		String awsPerformanceWarrantyMonths=Arrays.toString(iawsPerformanceWarrantyMonths);
		String awsPartNumber=Arrays.toString(iawsPartNumber);
		String awsWebPrice=Arrays.toString(iawsWebPrice);
		
		System.out.println("AWS partNumber Sorted as string: "+awsPartNumber);
		System.out.println("AWS performanceWarrantyMonths Sorted as string: "+awsPerformanceWarrantyMonths);
		System.out.println("AWS webPrice Sorted as string: "+awsWebPrice);

	}

}
