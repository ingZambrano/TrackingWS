package com.avior.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("sMSService")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class SMSServiceImpl implements SMSService {

	private final String url = "https://rest.nexmo.com/sms/json";
	private final String apiKey = "c6812d31";
	private final String apiSecret = "803bbd5c";
	private final String from = "Avior";
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public int sendMessage(String noTelefono, String mensaje) {

		int ret = -1;		 
		
		try {
			ret = this.parseJSON(this.sendPost("52"+noTelefono, mensaje));
			
			if(ret == 0){
				logger.info("SMS enviado correctamente para: 52"+ noTelefono);
			}else{
				logger.error("SMS no enviado para: 52"+noTelefono);
			}
			
		} catch (ClientProtocolException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return ret;
	}

	private String sendPost(String noTelefono, String mensaje) throws ClientProtocolException,
			IOException {

		// "http://rest.nexmo.com/sms/json?api_key=c6812d31&api_secret=803bbd5c&from=Avior&to=525544411467&text=Prueba"
		String url = this.url;
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);

		post.setHeader("X-Requested-With", "XMLHttpRequest");

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("api_key", this.apiKey));
		urlParameters.add(new BasicNameValuePair("api_secret", this.apiSecret));
		urlParameters.add(new BasicNameValuePair("from", this.from));
		urlParameters.add(new BasicNameValuePair("to", noTelefono));
		urlParameters.add(new BasicNameValuePair("text", mensaje));

		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		HttpResponse response = client.execute(post);

		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		return result.toString();
	}
	
	private int parseJSON(String JSONString){
		
		int ret=-1;
		JsonFactory jfactory = new JsonFactory();
		try {
			JsonParser jParser = jfactory.createJsonParser(JSONString);
			while (jParser.nextToken() != JsonToken.END_OBJECT) {

				String fieldname = jParser.getCurrentName();
				
				if ("messages".equals(fieldname)) {

					jParser.nextToken(); // current token is "[", move next
					while (jParser.nextToken() != JsonToken.END_ARRAY) {
						
						if(jParser.getText().equals("status")){
							jParser.nextToken();
							ret = Integer.parseInt(jParser.getText());
							break;							
						}						
					}					
				}
			}
			jParser.close();
		} catch (JsonParseException e) {
			ret = -1;
			e.printStackTrace();
		} catch (IOException e) {
			ret = -1;
			e.printStackTrace();
		}
		
		return ret;
		
	}
	


}
