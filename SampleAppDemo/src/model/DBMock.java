/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Framework.BSROException;
import KeyWordDriven.KeyWordDrivenConstants;
import KeyWordDriven.Database.DBConnection;
import model.EntryPoint;

/**
 *
 * @author Amala
 */
public class DBMock {

	public static List<String> tc_id;
	public static String projectNames;
	public String formatProjectNameesForUI(List<String> projectNames){
		StringBuilder returnStr = new StringBuilder();        
		for(String projectName: projectNames)  
		{
			returnStr.append("<a href=\"javascript:projectSelection('"+projectName+"');\">"+projectName+"</a>");
		}
		return returnStr.toString();
	}

	public String formatProjectDetailsForUI(List<String> projectDetails){
		StringBuilder returnStr = new StringBuilder();        
		returnStr.append("<ul>");
		for(String projectDetail: projectDetails)  
		{
			returnStr.append("<li><label for=\"" + projectDetail + "\"><input type=\"checkbox\" name=\"" + projectDetail + "\" id=\"" + projectDetail + "\">" + projectDetail + "</label></li>");
		}

		returnStr.append("<button class=\"button button1\" onclick=\"getSelectedProjectDetails()\">Run</button>");
		returnStr.append("</ul>");
		return returnStr.toString();
	}

	public String getProjectNames() throws Exception
	{
		String result = null;
		List<String> projectNames = new ArrayList<String>();

		Connection connection = DBConnection.getConnection();

		if (connection != null) 
		{

			try {

				Statement statement = connection.createStatement();

				// String Query =
				// "SELECT TC_ID FROM TC_ID WHERE ACTIVITY_STATE = 'ACTIVE' AND PROJECT_NAME='"
				// + KeyWordDrivenConstants.ACTIVE_PROJECT_NAME + "'";

				String Query = "SELECT NAME FROM PROJECTS";

				System.out.println("Query Executing => " + Query);

				//logInfo("Query Executing => " + Query);

				ResultSet resultSet = statement.executeQuery(Query);

				while (resultSet.next())
				{
					String NAME = resultSet.getString("NAME");
					projectNames.add(NAME);
				}
				result = formatProjectNameesForUI(projectNames);
				//System.out.println(result);
				connection.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}


		}
		return result;
	}

	public String getProjectDetails(String projectName) throws BSROException
	{
		int count = 0;
		StringBuilder returnStr;
		String result = null;
		projectNames=projectName;
		List<String> projectDetails = new ArrayList<>();

		Connection connection = DBConnection.getConnection();

		if (connection != null) 
		{
			try {

				Statement statement = connection.createStatement();
				String Query = "SELECT TC_ID FROM TC_ID WHERE ACTIVITY_STATE = 'ACTIVE' AND PROJECT_NAME='"+projectName+"'";
				System.out.println("Query Executing => " + Query);
				ResultSet resultSet = statement.executeQuery(Query);

				while (resultSet.next())
				{
					String TC_ID = resultSet.getString("TC_ID");
					projectDetails.add(TC_ID);
				}
				returnStr = new StringBuilder(formatProjectDetailsForUI(projectDetails));
				//System.out.println(returnStr.toString());
				result=returnStr.toString();
				connection.close();

			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}

		}
		return result;

	}

	public String runProjects(String selected_TC_ID)
	{
		tc_id = new ArrayList<String>();
		System.out.println("SelectedProjectedDetails:"+selected_TC_ID);
		String[] TC_ID_s = selected_TC_ID.split(",");
		for(String TC_ID : TC_ID_s)
		{
			tc_id.add(TC_ID);
		}
		return null;
	}
}
