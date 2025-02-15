package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Reusables {
	RequestSpecification req;
	ResponseSpecification resSpec;
	public  RequestSpecification requestSpecification() throws IOException{
		
		PrintStream log= new PrintStream(new FileOutputStream("Logs.txt"));
		
		req=new RequestSpecBuilder().setBaseUri(getConfigVal("baseUrl"))
				.addHeader("Content-Type", "Application/Json")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return req;
	}
	
	
	public ResponseSpecification responseSpecification(int statusCode) {
		resSpec= new ResponseSpecBuilder().expectStatusCode(statusCode).expectContentType(ContentType.JSON).build();
		return resSpec;
	}
	
	
	public  String getConfigVal(String key) throws IOException {
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream("config.properties");
		prop.load(fis);
		return prop.getProperty(key);
	
	}

}
