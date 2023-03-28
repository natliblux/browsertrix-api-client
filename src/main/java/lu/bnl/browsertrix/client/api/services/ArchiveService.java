package lu.bnl.browsertrix.client.api.services;

import java.io.IOException;

import com.google.gson.Gson;

import lu.bnl.browsertrix.client.api.ConnectionSettingsProvider;
import lu.bnl.browsertrix.client.api.constants.BrowsertrixEndpoints;
import lu.bnl.browsertrix.client.exceptions.BrowsertrixApiException;
import lu.bnl.browsertrix.client.exceptions.HttpRequestFailedException;
import lu.bnl.browsertrix.client.model.archive.Archive;
import lu.bnl.browsertrix.client.model.archive.ArchiveListResponse;
import lu.bnl.browsertrix.client.utils.HttpUtils;

/**
 * Contains methods related to archives.
 *
 */
public class ArchiveService extends BasicApiService
{
	public ArchiveService(ConnectionSettingsProvider connectionSettingsProvider) 
	{
		super(connectionSettingsProvider);
	}

	public ArchiveListResponse listArchives() throws IOException, BrowsertrixApiException
	{
		try
		{
			// Construct and execute the query
			String urlPrefix = "http://" + getConnectionSettingsProvider().getUrl() + ":" + getConnectionSettingsProvider().getPort();
			String result = HttpUtils.executeAuthenticatedGetRequest(urlPrefix + BrowsertrixEndpoints.ARCHIVE_ENDPOINT, getConnectionSettingsProvider().getAccessToken());
		
			// Deserialize the response
			Gson gson = new Gson();
			ArchiveListResponse entity = gson.fromJson(result, ArchiveListResponse.class);
			
			// We're done!
			return entity;
		}
		catch (IOException | HttpRequestFailedException e)
		{
			throw new BrowsertrixApiException("Could not list archives: " + e.getMessage());
		}
	}
	
	public Archive getArchiveById(String archiveId) throws IOException, BrowsertrixApiException
	{
		try
		{
			// Construct and execute the query
			String urlPrefix = "http://" + getConnectionSettingsProvider().getUrl() + ":" + getConnectionSettingsProvider().getPort();
			String result = HttpUtils.executeAuthenticatedGetRequest(urlPrefix + BrowsertrixEndpoints.ARCHIVE_ENDPOINT + "/" + archiveId, getConnectionSettingsProvider().getAccessToken());
			
			// Deserialize the response
			Gson gson = new Gson();
			Archive entity = gson.fromJson(result, Archive.class);
			
			// We're done!
			return entity;
		}
		catch (IOException | HttpRequestFailedException e)
		{
			throw new BrowsertrixApiException("Could not get archive: " + e.getMessage());
		}
	}
	
}
