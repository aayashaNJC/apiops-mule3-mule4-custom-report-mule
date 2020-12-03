package com.jsoupdemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ReadReport {
	
	public static void main(String[] args) throws IOException {
		
		// read the summary.html file		
		// String msg = getReport("C:\\Users\\aayas\\Desktop\\summary.html");
				
	}
	
	//Method that returns the first word
	public static String firstWord(String input) {
		return input.split(" ")[0]; // Create array of words and return the 0th word
	}
		
/*	
	// return total errors listed in the report and create a new report
	public static int[] errorNumber(String url, String storeLocation, String customtemplate) throws IOException {
			
		System.out.println("Start errorNumber function");
		//create a customeReport template an return number of errors based on error type
		// response example [1, ,5, 1]  - it means there is 1 issue of error type, 5 issues of warning type and 1 issue of info type
		int error[] = createNewReport(url, storeLocation, customtemplate); // get total number of errors in each category
			
		// add new issues in the CSV file
		writeToCsvFile(url, storeLocation);
			
		System.out.println("End errorNumber function");
		return error; 
	}
*/
/*
	// edit the customReport.html file 
	public static int[] createNewReport(String url, String storeLocation, String customtemplate) throws IOException {

		int errorSummary[] = new int[3]; // store the total number of errors in each error category
		int index = 0;					// to represent the index in array
			
			
		//System.out.println("storeLocation :: " + storeLocation);		// to add errors in *.csv file location
		System.out.println("customtemplate :: " + customtemplate);		// to edit the *.html file 
			
		try {
			File input = new File(url);
			Document doc = Jsoup.parse(input, "UTF-8", "");
								
			// overwrite the existing customtemplate.html file 
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(customtemplate, false)));
				
				
				
			// add html header in the file 
			out.println("<html> \n<head>\n\t<title>Mule Migration Assistant Report</title>");
			out.println("<link ref=\"icon\" type=\"image/webp\" href=\"https://static.wixstatic.com/media/e53d99_925f5d1798bc46cb902b14dbe62dfdff~mv2.png/v1/fill/w_73,h_99,al_c,q_85,usm_0.66_1.00_0.01/njclogo.webp\" sizes=\"120x120\" >");
			//out.println("<link ref=\"icon\" type=\"image/jpg\" href=\"C:/Users/aayas/Desktop/records/njc_logo1.jpg\" sizes=\"120x120\" >");
			//https://static.wixstatic.com/media/e53d99_925f5d1798bc46cb902b14dbe62dfdff~mv2.png/v1/fill/w_73,h_99,al_c,q_85,usm_0.66_1.00_0.01/njclogo.webp
			out.println("<style>\n" + 
						".h-style {\n" + 
						 "  border: 2px solid black;\n" + 
						 "  margin: 50px;\n" + 
						 "  background-color: #0B614B;\n" + 
						 "  color:white;\n" + 
						 " text-align: center\n" +
						 "}\n" + 
						 		
						".col-left-margin { margin: 50px;font-weight: bold;}\n" + 
								
						".td-col1 {style=\"width:70%;\"}"+
						".td-col2 {style=\"width:30%;\"}"+
									
						".hr-line {width: 60%;margin-left: auto;margin-right: auto;}\n" + 
								
						".hr-align{ text-align: center; background-color: #85C1E9; padding-top: 15px; padding-right: 30px; padding-bottom: 15px; padding-left: 80px; border: 1px solid black;}\n" +
								
						".normal-text{font-weight: normal;}"+
								
						"#report {\n"+
							"  font-family: Arial, Helvetica,\n" + 
							"  sans-serif;\n" + 
							"  border-collapse: collapse;\n" + 
							"  width: 100%;" +
							"}\n" + 
								
						".column { float: left; width: 33.33%; padding: 5px;}" + 
								
						".row::after {content: \"\"; clear: both; display: table; }"+	
								
						"#report td, #report th { border: 1px solid #8d8d8d; padding: 8px;}"+
													
						"#report th {\n"+
						"  padding-top: 12px;\n" + 
						"  padding-bottom: 12px;\n" +
						"  padding-right: 5px;" +
						"  padding-left: 5px;" +
						"  text-align: left;\n" + 
						"  background-color: #0B614B;\n" +
						"  color: white;\n" +
						"}\n" + 
						
						"#report-issue {\n"+
						"  font-family: Arial, Helvetica,\n" + 
						"  sans-serif;\n" + 
						"  border-collapse: collapse;\n" + 
						"  width: 100%;" +
						"}\n" + 

						"#report-issue th {\n"+
						"  padding-top: 12px;\n" + 
						"  padding-bottom: 12px;\n" + 
						"  padding-right: 15px;" +
						"  padding-left: 15px;" +
						"  text-align: left;\n" + 
						"  background-color: #F1C40F;\n" +
						"  color:black;\n" + 
						"}\n" +
								
						"#report-issue td { border: 1px; padding: 8px;}"+
						
						".tr-border{ border: 1px solid #ddd; }"+
						
						"</style>");
			out.println("</head>\n <body> \n");
			//out.println("<div class=\"h-style\">\n\t<h1>Mule Migration Assistant Report </h1>\n </div>"); style=\"width:100%\"
			out.println("<div class=\"row\"><div class=\"column\">" +
					"<img src=\"NJC_LOGO.PNG\" width=\"100\" height=\"100\" style=\"vertical-align:middle;margin:0px 50px\" >"+
					"</div><div class=\"column\">" +
					"<h1>Mule Migration Assistant Report </h1></div>" +
					" </div>");
			out.println("<div class=\"h-style\">\n\t<h4>Issues found during migration: </h4>\n</div>");
			out.println("<div class=\"col-left-margin\">");  
					 
					 
			//Elements divlist = doc.getElementsByTag("div");
			//col-md-8 col-md-offset-1
			Elements divlist = doc.select("div.col-md-offset-1");
			index = 0; 
					
			out.println("<table id=\"report-issue\" width: 100%; >");  // start to create table in HTML
			for (Element list: divlist)
			{
						
				// write error type in file 
				if(!list.getElementsByTag("h2").text().isEmpty())
				out.println("<tr> <td colspan=2> <h3 class=\"hr-align\">"+ list.getElementsByTag("h2").text().replace(":"," ") + "</h3> </td></tr>");
											
				Elements errortype = list.select("tr");
				int countIssues = 0;
				for (Element type: errortype)
				{
					//check if the text read is a filename
					if((type.text()).contains(".xml")){
						out.println("<tr class=\"tr-border\">");
						out.println("<th class=\"td-col1\" >"+(type.text()).split(" ")[0] + "</th>");
						out.println("<th class=\"td-col2\" > #Issues</th></tr>");
					}
							
					else if(!(type.text()).contains("#")) {
								
					Elements info = type.select("td");
								
					// Read Issues description from the report
					for (Element col: info)
					{
						if(isNumber(col.text()) == false) {
							out.println("<tr class=\"tr-border\"> " );
							out.println("<td>"+ (col.getElementsByTag("a").text()) +"</td>" );
										
						}
						else 
						{
							out.println( "<td style=\"text-align:center;\">" +col.getElementsByTag("td").text() +"</td></tr>" );
							countIssues += Integer.parseInt(col.getElementsByTag("td").text());
									
						}
					}							
				}						
			}
						
			errorSummary[index] = countIssues;
			index++;
		}
					
		out.println("</table>");
		out.println("</div>");
		out.println("<div class=\"col-left-margin\"><h3>Estimated Time</h3>");
		out.println("<table id=\"report\"><tr>\n<th>Complexity </th>\n<th>Estimated time </th>\n<th>Estimated cost </th></tr>");
		out.println("\n<tr>\n<td>#[payload.migrationComplexity] </td>\n<td>#[payload.timespan] </td>\n<td>#[payload.cost] </td></tr>\n</table>\n</div>");
		//out.println("\n<tr>\n<td>#[vars.data.migrationComplexity] </td>\n<td>#[vars.data.timespan] </td>\n<td>#[vars.data.cost] </td></tr>\n</table>\n</div>");
		
		out.println("</body>\n </html>");
					
		out.flush();
		out.close();
				    
		} 
		catch (IOException e) {
			System.out.println("An error occurred reading the html file.");
			e.printStackTrace();
		}
				
				// add new issues in the CSV file
				//writeToCsvFile(url);
		return errorSummary;	
	}
*/		
	// check if the passed string is a number or not
	public static boolean isNumber(String content)
	{
		for (int i = 0; i < content.length(); i++)
			if (Character.isDigit(content.charAt(i)) == false)
				return false;
		 
		return true;
	}
/*			
	//  write to a CSV file
	public static void writeToCsvFile(String url, String storeLocation) throws IOException {
		 
			// header for csv file
			//String[] recordHeader = {"Issue", "Time"};
						
			System.out.println("storeLocation :: " + storeLocation);		// to add errors in *.csv file location
			
			try {
				// Read the content from the summary.html and parse the content
				File input = new File(url);
				Document doc = Jsoup.parse(input, "UTF-8", "");
				
				System.out.println("Start writing to file");
				
				// Check if the file exists
				File csvFile = new File(storeLocation);	
				PrintWriter csvWrite = null;
				
				if (csvFile.exists())
				{
					System.out.println("Create new CSV file");
					csvWrite = new PrintWriter(new BufferedWriter(new FileWriter(storeLocation, true)));
					
					System.out.println("File exists : " + csvFile.exists());
				}
				else {
				//PrintWriter csvWrite = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\aayas\\Desktop\\records\\report.csv", true)));
				csvWrite = new PrintWriter(new BufferedWriter(new FileWriter(storeLocation, true)));
				System.out.println("File not exists : " + csvFile.exists());
				csvWrite.print("Issue");
				csvWrite.print(",");
				csvWrite.print("Time");
				csvWrite.println();
				}
				
				//System.out.println("open file");
				String description = "";   			// variable to store each issue at a time 
				
				// get the error description from each error type
				Elements errortype = doc.select("tr");
				
				// loop through content in tr tag
				for (Element trElement: errortype)
				{
					if(!(trElement.text()).contains(".xml") 
							&& !(trElement.text()).contains("#") 
							&& !(trElement.text()).contains("No info") 
							&& !(trElement.text()).contains("No errors")){
						System.out.println(trElement.text().replaceAll("[-|,|;]",""));
						description = trElement.text().replaceAll("[-|,|;]","");
						description = description.substring(0, description.length() - 1).trim();
						
						// add new issue to the csv file 
						if(!readCsvFile(description, storeLocation))
							csvWrite.println(description+",0");

					}
					else if((trElement.text()).contains("No info") || (trElement.text()).contains("No errors")) {
						description = trElement.text().replaceAll("[-|,|;]","");
						description = description.substring(0, description.length() - 1).trim();
					}
				}
				
				System.out.println("New issues added to CSV completed");
				
				csvWrite.flush();
				csvWrite.close();
				
			}
			catch (Exception e) {
				System.out.println("An error occurred while writing the csv.");
				e.printStackTrace();
			}		    
		}
*/
		// return list of errors
		public static List<String> getErrorList(String url) throws IOException {
				
			//String errorList = "";  // hold all the errors
			List<String> errorList = new ArrayList<String>();
				
			String issue;
				
			File input = new File(url);
			Document doc = Jsoup.parse(input, "UTF-8", "");
				
			//System.out.println("collect error list ");
				
			// get the filename
			Element filenameElement = doc.select("a").first();
			String filename = filenameElement.text();
				
				
			// get the error description from each error type
			Elements issues = doc.getElementsByTag("a");
			for (Element link: issues)
			{
				if(!link.text().isEmpty() && !link.text().equals(filename))
				{
					//System.out.println((link.text()).replaceAll("[-|,|;|']"," "));
					issue = (link.text()).replaceAll("[-|,|;]","").trim();
					//errorList = errorList + issue;
						
					errorList.add(issue);
					//System.out.println("+++++++++" + errorList);
				}		
						
			}
				//System.out.println("Complete Error merge");
				//System.out.println("Errors \n" + errorList);
				    
			return errorList;
		}
			
		
/*		// return list of errors with number of issue
		public static List<String> getErrorList_new(String url) throws IOException {
			
			System.out.println(url);
			//String errorList = "";  // hold all the errors
			List<String> errorList = new ArrayList<String>();
			
			String issue = "";
			
			File input = new File(url);
			Document doc = Jsoup.parse(input, "UTF-8", "");
			
			
			// get the error description from each error type
			Elements readTr = doc.getElementsByTag("tr");
			for (Element eachTr: readTr)
			{
				Elements readTd = eachTr.select("td");
				if(!readTd.text().isEmpty() && 
						!readTd.text().contains(".xml") && 
						!readTd.text().contains("No info") &&  
						!readTd.text().contains("No errors"))
				{
					//System.out.print((readTd.text()).replaceAll("[-|,]"," ").trim());
					//issue = (readTd.text()).replaceAll("[-|,|;|']"," ").trim();
					issue = (readTd.text()).replaceAll("[-|,|;]","").trim();
					
					// add special character ":" 
					issue = addSpecialCharacter(issue);
					errorList.add(issue);
					//System.out.println("issue ++++++++++"+ issue);
					
				}		
				System.out.println("");	

			}
			//System.out.println("+++++++++" + errorList);
			
			return errorList;
		}
*/		
		public static String addSpecialCharacter(String description) {
			
			int lastIndex = description.lastIndexOf(" ");
			int length = description.length(); 

			String first = description.substring(0, lastIndex);
			String last = description.substring(lastIndex+1, length);
			
			if (isNumber(last) == false)
				return (first+" "+last);
			
			return (first+":"+last);
		}
		
	/*	// check if an issue exists in the csv file
		public static boolean readCsvFile(String issue, String storeLocation) {
				
			//boolean exists = false;  // check if the issue exist or not 
			String line ="";
			try {
				BufferedReader fileRead = new BufferedReader(new FileReader(new File (storeLocation) ));
				line = fileRead.readLine();
					
				// read until end of the file 
				while(line != null) {
				// Split the row
					String[] col = line.split(",");
					//System.out.println(col[0]);
					if(issue.equals(col[0])) {
						//exists = true;
						fileRead.close();
						
					return true;
				}
						
				line = fileRead.readLine();
						
			}
					
			fileRead.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
				
		return false;
	}		*/

		// get the erros count grouped by error type
		public static int[]  errorByCategory(String url) throws IOException{
			int errorSummary[] = new int[3]; // store the total number of errors in each error category
			int index = 0;					// to represent the index in array
			
			try {
				File input = new File(url);
				Document doc = Jsoup.parse(input, "UTF-8", "");
				
				Elements divlist = doc.select("div.col-md-offset-1");
				index = 0;
				
				for (Element list: divlist)
				{
					Elements errortype = list.select("tr");
					int countIssues = 0;
					for (Element type: errortype)
					{
						
						
						if(!(type.text()).contains("#") && !(type.text()).contains(".xml")) {
									
							Elements info = type.select("td");
										
							// Read Issues description from the report
							for (Element col: info)
							{
								//System.out.println(col.text());
								if(isNumber(col.text()) == true) {
									countIssues += Integer.parseInt(col.getElementsByTag("td").text());	
								}
								
							}	
						}
						
					}	
					//System.out.println("+++++++++++++++++");
					errorSummary[index] = countIssues;
					index++;
				}	
				
			}
			catch (IOException e) {
				//System.out.println("An error occurred reading the html file.");
				e.printStackTrace();
			}
			
			//System.out.println("Errors ::" + errorSummary[0] + ":" + errorSummary[1] + ":" + errorSummary[2]);
			return errorSummary;
		}	
		
		public static List<String> getErrorList_new_ByType(String url) throws IOException {
			
			//System.out.println("storeLocation:: "  +storeLocation);
			System.out.println("url:: "  +url);
			//String errorList = "";  // hold all the errors
			List<String> errorList = new ArrayList<String>();
			
			String issue = "";
			String issueType = "";
			
			File input = new File(url);
			Document doc = Jsoup.parse(input, "UTF-8", "");
			
			
			// get the error description from specific error type
			Elements divlist = doc.select("div.col-md-offset-1");
			for (Element list: divlist)
			{
				// write error type in file 
				if(!list.getElementsByTag("h2").text().isEmpty())
				{	
					issueType = list.getElementsByTag("h2").text().replace(":"," ").trim();
					System.out.println(issueType);
					errorList.add(issueType);
				}
				
				//if(issueType.equals( category ))
				{
					Elements readTr = list.getElementsByTag("tr");
					for (Element eachTr: readTr)
					{
						Elements readTd = eachTr.select("td");
						if(!readTd.text().isEmpty())
						{
							//System.out.print((readTd.text()).replaceAll("[-|,]"," ").trim());
							//issue = (readTd.text()).replaceAll("[-|,|;]","").trim();
							issue = (readTd.text()).replaceAll("[,|;]","").trim();
							
							
							// add special character ":" 
							System.out.println(issue);	
							issue = addSpecialCharacter(issue);
							
							// check if the string starts with hyphen
							//char checkHyphen = issue.charAt(0);
							if ( issue.charAt(0) == '-') {
								int len = issue.length();
								issue = issue.substring(1, len);
							}
								
							errorList.add(issue.trim());
							
						}		
						System.out.println("");	
	
					}
				}
				
			}
		
			System.out.println("+++++++++" + errorList);
			return errorList;
		}
		
		
}
