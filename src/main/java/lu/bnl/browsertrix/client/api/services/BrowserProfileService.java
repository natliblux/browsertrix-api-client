package lu.bnl.browsertrix.client.api.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

import com.google.gson.Gson;

import lu.bnl.browsertrix.client.api.ConnectionSettingsProvider;
import lu.bnl.browsertrix.client.api.constants.BrowsertrixEndpoints;
import lu.bnl.browsertrix.client.exceptions.BrowsertrixApiException;
import lu.bnl.browsertrix.client.exceptions.HttpRequestFailedException;
import lu.bnl.browsertrix.client.model.browser.BrowserProfile;
import lu.bnl.browsertrix.client.model.browser.BrowserProfileListResponse;
import lu.bnl.browsertrix.client.utils.HttpUtils;

/**
 * Contains methods related browser profiles that are used within the context of crawl configurations.
 *
 */
public class BrowserProfileService extends BasicApiService
{
	public BrowserProfileService(ConnectionSettingsProvider connectionSettingsProvider) 
	{
		super(connectionSettingsProvider);
	}

	public BrowserProfileListResponse listBrowserProfilesByArchiveId(String archiveId) throws IOException, BrowsertrixApiException
	{
		try
		{
			// Construct and execute the query 
			String urlPrefix = "http://" + getConnectionSettingsProvider().getUrl() + ":" + getConnectionSettingsProvider().getPort();
			String result = HttpUtils.executeAuthenticatedGetRequest(urlPrefix + BrowsertrixEndpoints.ARCHIVE_ENDPOINT + "/" + archiveId + BrowsertrixEndpoints.BROWSER_PROFILE_ENDPOINT, getConnectionSettingsProvider().getAccessToken());
			
			// Deserialize the response
			Gson gson = new Gson();
			BrowserProfile[] entity = gson.fromJson(result, BrowserProfile[].class);
			
			// We're done!
			return new BrowserProfileListResponse(entity);
		}
		catch (IOException | HttpRequestFailedException e)
		{
			throw new BrowsertrixApiException("Could not list profiles: " + e.getMessage());
		}
	}
	
	public BrowserProfile getBrowserProfileById(String archiveId, String profileId) throws IOException, BrowsertrixApiException
	{
		try
		{
			// Construct and execute the query 
			String urlPrefix = "http://" + getConnectionSettingsProvider().getUrl() + ":" + getConnectionSettingsProvider().getPort();
			String result = HttpUtils.executeAuthenticatedGetRequest(urlPrefix + BrowsertrixEndpoints.ARCHIVE_ENDPOINT + "/" + archiveId + BrowsertrixEndpoints.BROWSER_PROFILE_ENDPOINT + "/" + profileId, getConnectionSettingsProvider().getAccessToken());
		
			// Deserialize the response
			Gson gson = new Gson();
			BrowserProfile entity = gson.fromJson(result, BrowserProfile.class);
			
			// We're done!
			return entity;
		}
		catch (IOException | HttpRequestFailedException e)
		{
			throw new BrowsertrixApiException("Could not get profile: " + e.getMessage());
		}
	}
	
	
	
}
