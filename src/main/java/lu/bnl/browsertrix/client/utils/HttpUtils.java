package lu.bnl.browsertrix.client.utils;

import java.io.IOException;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import lu.bnl.browsertrix.client.api.request.AccessToken;

/**
 * Provides basic GET/POST request functionality with authentication.
 *
 */
public class HttpUtils 
{

	public static HttpResponse executeAuthenticatedGetRequest(String fullUrl, AccessToken accessToken) throws IOException
	{
		// Construct the request
		CloseableHttpClient client = HttpClients.custom().build();
		HttpGet get = new HttpGet(fullUrl);

		// Insert the headers
		Header headers[] = { new BasicHeader("Accept", "application/json"), 
				             new BasicHeader("Authorization", getAuthHeaderFromAccessToken(accessToken))};
		get.setHeaders(headers);
		
		// Do it!
		return client.execute(get);
	}
	
	public static HttpResponse executeUnauthenticatedPostRequest(String fullUrl, List<NameValuePair> payload) throws IOException
	{
		// Construct the request
		CloseableHttpClient client = HttpClients.custom().build();
		HttpPost post = new HttpPost(fullUrl);

		// Insert the headers
		Header headers[] = { new BasicHeader("Accept", "application/json") };
		post.setHeaders(headers);
		
		// Create the payload
		post.setEntity(new UrlEncodedFormEntity(payload, "UTF-8"));
		
		// Do it!
		return client.execute(post);
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
