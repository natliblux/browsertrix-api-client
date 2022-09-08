package lu.bnl.browsertrix.client.api.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

import com.google.gson.Gson;

import lu.bnl.browsertrix.client.api.ConnectionSettingsProvider;
import lu.bnl.browsertrix.client.api.constants.BrowsertrixEndpoints;
import lu.bnl.browsertrix.client.api.utils.HttpUtils;
import lu.bnl.browsertrix.client.exceptions.BrowsertrixApiException;
import lu.bnl.browsertrix.client.model.browser.BrowserProfile;
import lu.bnl.browsertrix.client.model.browser.BrowserProfileListResponse;

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
		// Construct and execute the query 
		String urlPrefix = "http://" + getConnectionSettingsProvider().getUrl() + ":" + getConnectionSettingsProvider().getPort();
		HttpResponse response = HttpUtils.executeAuthenticatedGetRequest(urlPrefix + BrowsertrixEndpoints.ARCHIVE_ENDPOINT + "/" + archiveId + BrowsertrixEndpoints.BROWSER_PROFILE_ENDPOINT, getConnectionSettingsProvider().getAccessToken());
	
		int status = response.getStatusLine().getStatusCode();
		if (status != HttpStatus.SC_OK)
		{
			throw new BrowsertrixApiException("Server returned status code " + status + " with message '" + response.getStatusLine().getReasonPhrase() + "'");
		}
		
		// Deserialize the response
		String result = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
		Gson gson = new Gson();
		BrowserProfile[] entity = gson.fromJson(result, BrowserProfile[].class);
		
		// We're done!
		return new BrowserProfileListResponse(entity);
	}
	
	public BrowserProfile getBrowserProfileById(String archiveId, String profileId) throws IOException, BrowsertrixApiException
	{
		// Construct and execute the query 
		String urlPrefix = "http://" + getConnectionSettingsProvider().getUrl() + ":" + getConnectionSettingsProvider().getPort();
		HttpResponse response = HttpUtils.executeAuthenticatedGetRequest(urlPrefix + BrowsertrixEndpoints.ARCHIVE_ENDPOINT + "/" + archiveId + BrowsertrixEndpoints.BROWSER_PROFILE_ENDPOINT + "/" + profileId, getConnectionSettingsProvider().getAccessToken());
	
		int status = response.getStatusLine().getStatusCode();
		if (status != HttpStatus.SC_OK)
		{
			throw new BrowsertrixApiException("Server returned status code " + status + " with message '" + response.getStatusLine().getReasonPhrase() + "'");
		}
		
		// Deserialize the response
		String result = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
		Gson gson = new Gson();
		BrowserProfile entity = gson.fromJson(result, BrowserProfile.class);
		
		// We're done!
		return entity;
	}
	
	
	
}
