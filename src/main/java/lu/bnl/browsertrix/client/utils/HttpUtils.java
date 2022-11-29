package lu.bnl.browsertrix.client.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import lu.bnl.browsertrix.client.api.request.AccessToken;
import lu.bnl.browsertrix.client.exceptions.HttpRequestFailedException;

/**
 * Provides basic GET/POST request functionality with authentication.
 *
 */
public class HttpUtils 
{

	public static String executeAuthenticatedGetRequest(String fullUrl, AccessToken accessToken) throws IOException, HttpRequestFailedException
	{
		// Construct the request
		CloseableHttpClient client = HttpClients.custom().build();
		HttpGet get = new HttpGet(fullUrl);

		// Insert the headers
		Header headers[] = { new BasicHeader("Accept", "application/json"), 
				             new BasicHeader("Authorization", getAuthHeaderFromAccessToken(accessToken))};
		get.setHeaders(headers);
		
		// Do it!
		HttpResponse response = client.execute(get);
		
		// Check status
		int status = response.getStatusLine().getStatusCode();
		if (status != HttpStatus.SC_OK)
		{
			throw new HttpRequestFailedException("Server returned status code " + status + " with message '" + response.getStatusLine().getReasonPhrase() + "'");
		}
		
		String result = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
		
		// Close the stream gracefully
		client.close();
		
		return result;
	}
	
	public static String executePostRequest(String fullUrl, List<NameValuePair> payload, AccessToken accessToken) throws IOException, HttpRequestFailedException
	{
		// Construct the request
		CloseableHttpClient client = HttpClients.custom().build();
		HttpPost post = new HttpPost(fullUrl);

		// Insert the headers
		Header headers[] = { new BasicHeader("Accept", "application/json") };
		post.setHeaders(headers);
		
		if (accessToken != null)
		{
			Header header = new BasicHeader("Authorization", getAuthHeaderFromAccessToken(accessToken));
			post.addHeader(header);
		}
		
		// Create the payload
		if (payload != null && !payload.isEmpty())
		{
			post.setEntity(new UrlEncodedFormEntity(payload, "UTF-8"));
		}
		
		// Do it!
		HttpResponse response = client.execute(post);
		
		// Check status
		int status = response.getStatusLine().getStatusCode();
		if (status != HttpStatus.SC_OK)
		{
			throw new HttpRequestFailedException("Server returned status code " + status + " with message '" + response.getStatusLine().getReasonPhrase() + "'");
		}
		
		String result = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
		
		// Close the stream gracefully
		client.close();
		
		return result;
	}

	public static String executePostRequest(String fullUrl, List<NameValuePair> payload) throws IOException, HttpRequestFailedException
	{
		return executePostRequest(fullUrl, payload, null);
	}
	
	/**
	 * Returns a string version of the given access token, for use in a request header.
	 * 
	 */
	private static String getAuthHeaderFromAccessToken(AccessToken accessToken)
	{
		// Quite simple, for the time being...
		String authHeader = accessToken.getAuthType() + " " + accessToken.getAuthToken();
		return authHeader;
	}
	
}
