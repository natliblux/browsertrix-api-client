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
		// Construct and execute the query
		String urlPrefix = "http://" + getConnectionSettingsProvider().getUrl() + ":" + getConnectionSettingsProvider().getPort();
		HttpResponse response = HttpUtils.executeAuthenticatedGetRequest(urlPrefix + BrowsertrixEndpoints.ARCHIVE_ENDPOINT, getConnectionSettingsProvider().getAccessToken());
	
		int status = response.getStatusLine().getStatusCode();
		if (status != HttpStatus.SC_OK)
		{
			throw new BrowsertrixApiException("Server returned status code " + status + " with message '" + response.getStatusLine().getReasonPhrase() + "'");
		}
		
		// Deserialize the response
		String result = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
		Gson gson = new Gson();
		ArchiveListResponse entity = gson.fromJson(result, ArchiveListResponse.class);
		
		// We're done!
		return entity;
	}
	
	public Archive getArchiveById(String archiveId) throws IOException, BrowsertrixApiException
	{
		// Construct and execute the query
		String urlPrefix = "http://" + getConnectionSettingsProvider().getUrl() + ":" + getConnectionSettingsProvider().getPort();
		HttpResponse response = HttpUtils.executeAuthenticatedGetRequest(urlPrefix + BrowsertrixEndpoints.ARCHIVE_ENDPOINT + "/" + archiveId, getConnectionSettingsProvider().getAccessToken());
	
		int status = response.getStatusLine().getStatusCode();
		if (status != HttpStatus.SC_OK)
		{
			throw new BrowsertrixApiException("Server returned status code " + status + " with message '" + response.getStatusLine().getReasonPhrase() + "'");
		}
		
		// Deserialize the response
		String result = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
		Gson gson = new Gson();
		Archive entity = gson.fromJson(result, Archive.class);
		
		// We're done!
		return entity;
	}
	
}
