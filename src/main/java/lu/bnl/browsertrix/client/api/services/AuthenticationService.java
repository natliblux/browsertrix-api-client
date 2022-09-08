package lu.bnl.browsertrix.client.api.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;

import lu.bnl.browsertrix.client.api.ConnectionSettingsProvider;
import lu.bnl.browsertrix.client.api.constants.BrowsertrixEndpoints;
import lu.bnl.browsertrix.client.api.utils.HttpUtils;
import lu.bnl.browsertrix.client.exceptions.BrowsertrixApiException;
import lu.bnl.browsertrix.client.model.authentication.AuthenticationResponse;
import lu.bnl.browsertrix.client.model.authentication.UserInformationResponse;

/**
 * Contains methods related to user authentication/login.
 *
 */
public class AuthenticationService extends BasicApiService
{
	public AuthenticationService(ConnectionSettingsProvider connectionSettingsProvider) 
	{
		super(connectionSettingsProvider);
	}

	/**
	 * Returns true if this client is authenticated with the Browsertrix server using the
	 * current access token.
	 */
	public boolean isAuthenticated() throws IOException
	{
		// Try to get self-identification information from the server
		String urlPrefix = "http://" + getConnectionSettingsProvider().getUrl() + ":" + getConnectionSettingsProvider().getPort();
		HttpResponse response = HttpUtils.executeAuthenticatedGetRequest(urlPrefix + BrowsertrixEndpoints.SELF_ENDPOINT, getConnectionSettingsProvider().getAccessToken());
	
		return (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK);
	}
	
	/**
	 * Authenticates with the Browsertrix server using the credentials given by the provider, then returns
	 * the access token that was generated for this client.
	 */
	public AuthenticationResponse login() throws BrowsertrixApiException, IOException
	{
		// Set up the Browsertrix login payload
		List<NameValuePair> payload = new ArrayList<NameValuePair>();
		payload.add(new BasicNameValuePair("grant_type", "password"));
		payload.add(new BasicNameValuePair("username", getConnectionSettingsProvider().getUsername()));
		payload.add(new BasicNameValuePair("password", getConnectionSettingsProvider().getPassword()));
		
		// Execute the request
		String urlPrefix = "http://" + getConnectionSettingsProvider().getUrl() + ":" + getConnectionSettingsProvider().getPort();
		HttpResponse response = HttpUtils.executeUnauthenticatedPostRequest(urlPrefix + BrowsertrixEndpoints.AUTH_ENDPOINT, payload);

		// Check status
		int status = response.getStatusLine().getStatusCode();
		if (status != HttpStatus.SC_OK)
		{
			throw new BrowsertrixApiException("Server returned status code " + status + " with message '" + response.getStatusLine().getReasonPhrase() + "'");
		}
		
		// Deserialize the response
		String result = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
		Gson gson = new Gson();
		AuthenticationResponse authResponse = gson.fromJson(result, AuthenticationResponse.class);
		
		// We're done!
		return authResponse;
	}
	
	/**
	 * Returns the user that is currently logged in.
	 */
	public UserInformationResponse getCurrentUser() throws IOException, BrowsertrixApiException
	{
		// Try to get self-identification information from the server
		String urlPrefix = "http://" + getConnectionSettingsProvider().getUrl() + ":" + getConnectionSettingsProvider().getPort();
		HttpResponse response = HttpUtils.executeAuthenticatedGetRequest(urlPrefix + BrowsertrixEndpoints.SELF_ENDPOINT, getConnectionSettingsProvider().getAccessToken());
	
		int status = response.getStatusLine().getStatusCode();
		if (status != HttpStatus.SC_OK)
		{
			throw new BrowsertrixApiException("Server returned status code " + status + " with message '" + response.getStatusLine().getReasonPhrase() + "'");
		}
		
		// Deserialize the response
		String result = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
		Gson gson = new Gson();
		UserInformationResponse user = gson.fromJson(result, UserInformationResponse.class);
		
		// We're done!
		return user;
	}
	
}
