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
import lu.bnl.browsertrix.client.exceptions.BrowsertrixApiException;
import lu.bnl.browsertrix.client.exceptions.HttpRequestFailedException;
import lu.bnl.browsertrix.client.model.authentication.AuthenticationResponse;
import lu.bnl.browsertrix.client.model.authentication.UserInformationResponse;
import lu.bnl.browsertrix.client.utils.HttpUtils;

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
		try
		{
			// Try to get self-identification information from the server
			String urlPrefix = "http://" + getConnectionSettingsProvider().getUrl() + ":" + getConnectionSettingsProvider().getPort();
			HttpUtils.executeAuthenticatedGetRequest(urlPrefix + BrowsertrixEndpoints.SELF_ENDPOINT, getConnectionSettingsProvider().getAccessToken());
		
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	/**
	 * Authenticates with the Browsertrix server using the credentials given by the provider, then returns
	 * the access token that was generated for this client.
	 */
	public AuthenticationResponse login() throws BrowsertrixApiException, IOException
	{
		try
		{
			// Set up the Browsertrix login payload
			List<NameValuePair> payload = new ArrayList<NameValuePair>();
			payload.add(new BasicNameValuePair("grant_type", "password"));
			payload.add(new BasicNameValuePair("username", getConnectionSettingsProvider().getUsername()));
			payload.add(new BasicNameValuePair("password", getConnectionSettingsProvider().getPassword()));
			
			// Execute the request
			String urlPrefix = "http://" + getConnectionSettingsProvider().getUrl() + ":" + getConnectionSettingsProvider().getPort();
			String result = HttpUtils.executePostRequest(urlPrefix + BrowsertrixEndpoints.AUTH_ENDPOINT, payload);
			
			// Deserialize the response
			Gson gson = new Gson();
			AuthenticationResponse authResponse = gson.fromJson(result, AuthenticationResponse.class);
			
			// We're done!
			return authResponse;
		}
		catch (IOException | HttpRequestFailedException e)
		{
			throw new BrowsertrixApiException("Could not log in: " + e.getMessage());
		}
	}
	
	/**
	 * Returns the user that is currently logged in.
	 */
	public UserInformationResponse getCurrentUser() throws IOException, BrowsertrixApiException
	{
		try
		{
			// Try to get self-identification information from the server
			String urlPrefix = "http://" + getConnectionSettingsProvider().getUrl() + ":" + getConnectionSettingsProvider().getPort();
			String result = HttpUtils.executeAuthenticatedGetRequest(urlPrefix + BrowsertrixEndpoints.SELF_ENDPOINT, getConnectionSettingsProvider().getAccessToken());
		
			// Deserialize it
			Gson gson = new Gson();
			UserInformationResponse user = gson.fromJson(result, UserInformationResponse.class);
			
			// We're done!
			return user;
		}
		catch (IOException | HttpRequestFailedException e)
		{
			throw new BrowsertrixApiException("Could not get current user: " + e.getMessage());
		}
	}
	
}
