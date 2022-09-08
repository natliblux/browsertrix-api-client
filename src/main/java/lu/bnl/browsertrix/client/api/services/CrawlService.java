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
import lu.bnl.browsertrix.client.model.crawl.CrawlListResponse;

/**
 * Contains methods related to crawls and crawl configs.
 *
 */
public class CrawlService extends BasicApiService
{
	public CrawlService(ConnectionSettingsProvider connectionSettingsProvider) 
	{
		super(connectionSettingsProvider);
	}

	public CrawlListResponse listCrawlsByArchiveId(String archiveId) throws IOException, BrowsertrixApiException
	{
		// Try to get self-identification information from the server
		String urlPrefix = "http://" + getConnectionSettingsProvider().getUrl() + ":" + getConnectionSettingsProvider().getPort();
		HttpResponse response = HttpUtils.executeAuthenticatedGetRequest(urlPrefix + BrowsertrixEndpoints.ARCHIVE_ENDPOINT + "/" + archiveId + BrowsertrixEndpoints.CRAWLS_ENDPOINT, getConnectionSettingsProvider().getAccessToken());
	
		int status = response.getStatusLine().getStatusCode();
		if (status != HttpStatus.SC_OK)
		{
			throw new BrowsertrixApiException("Server returned status code " + status + " with message '" + response.getStatusLine().getReasonPhrase() + "'");
		}
		
		// Deserialize the response
		String result = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
		Gson gson = new Gson();
		CrawlListResponse entity = gson.fromJson(result, CrawlListResponse.class);
		
		// We're done!
		return entity;
	}
	
	
	
}
