package com.gantt.ganttcenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;

import org.apache.http.client.HttpClient;
import org.apache.http.StatusLine;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * @author AJ Green Makes web service calls and returns JSON object
 *         representations
 */
public class JSONParser {

	public static int POST = 0;

	public static int GET = 1;

	public static int PUT = 2;

	public static int PUREGET = 3;

	public static int DELETE = 4;

	private DefaultHttpClient httpClient;

	private int httpStatusCode;

	private String cif;

	private String deviceTokenCookie;

	private String sessionState;

	private String csrfChallengeToken;

	private String applicationVersion;

	private Date dateFromResponseHeader;

	private static final int emptyResponseCode = 204;

	private static final String accept = "application/json";
	private static final String acceptEncoding = "UTF-8";
	private static final String acceptLanguage = "en-us";
	private static final String contentType = "application/x-www-form-urlencoded";

	/**
	 * Generated constructor stub
	 */
	public JSONParser() {

	}

    public String getJSON(String address){
        StringBuilder builder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(address);
        try{
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if(statusCode == 200)
            {
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while((line = reader.readLine()) != null)
                {
                    builder.append(line);
                }
            }
            else
            {
            }
        }catch(ClientProtocolException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }
}
