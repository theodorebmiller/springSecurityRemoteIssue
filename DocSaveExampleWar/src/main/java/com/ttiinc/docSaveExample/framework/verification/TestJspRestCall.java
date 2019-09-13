package com.ttiinc.docSaveExample.framework.verification;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class TestJspRestCall {
	
	public static void main(String[] args) {
		String userName = "thmiller";
		String url = "http://localhost:9080/HatsSecurityWar/validate/hasRoleAccess?role=ROLE_APPS_HATSWebServices&loginId="
				+ userName;

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);

		HttpResponse response;
		try {
			response = client.execute(request);
		

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		String requestResult = result.toString();
		
		System.out.println("Result: " + requestResult);
		} catch (Exception e) {
		
			e.printStackTrace();
		}

	}
}
