package lu.bnl.browsertrix.client.api.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

import com.google.gson.Gson;

import lu.bnl.browsertrix.client.api.ConnectionSettingsProvider;
import lu.bnl.browsertrix.client.api.constants.BrowsertrixEndpoints;
import lu.bnl.browsertrix.client.api.filter.CrawlFilter;
import lu.bnl.browsertrix.client.exceptions.BrowsertrixApiException;
import lu.bnl.browsertrix.client.model.crawl.Crawl;
import lu.bnl.browsertrix.client.model.crawl.CrawlConfig;
import lu.bnl.browsertrix.client.model.crawl.CrawlConfigListResponse;
import lu.bnl.browsertrix.client.model.crawl.CrawlListResponse;
import lu.bnl.browsertrix.client.utils.HttpUtils;

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

	/**
	 * Returns a list of crawls within the archive of the given ID, filtered using the given parameters.
	 * 
	 * Note: the Browsertrix API does not do filtering at this time. The filtering is thus done client-side. 
	 * 
	 */
	public CrawlListResponse listCrawlsByArchiveId(String archiveId, CrawlFilter filter) throws IOException, BrowsertrixApiException
	{
		CrawlListResponse unfilteredResponse = listCrawlsByArchiveId(archiveId);
		
		// Client-side filtering...
		if (filter != null)
		{
			CrawlListResponse filteredResponse = new CrawlListResponse();
			List<Crawl> filteredList = filter.applyTo(unfilteredResponse.getCrawls());
			filteredResponse.setCrawls(filteredList);
			return filteredResponse;
		}
		
		return unfilteredResponse;
	}
	
	/**
	 * Returns a list of crawls within the archive of the given ID.
	 */
	public CrawlListResponse listCrawlsByArchiveId(String archiveId) throws IOException, BrowsertrixApiException
	{
		// Construct and execute the query
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
	
	/**
	 * Returns the crawl with the given ID, under the given archive. Both IDs are necessary to identify the crawl.
	 * 
	 */
	public Crawl getCrawlById(String archiveId, String crawlId) throws IOException, BrowsertrixApiException
	{
		// Construct and execute the query
		String urlPrefix = "http://" + getConnectionSettingsProvider().getUrl() + ":" + getConnectionSettingsProvider().getPort();
		HttpResponse response = HttpUtils.executeAuthenticatedGetRequest(urlPrefix + BrowsertrixEndpoints.ARCHIVE_ENDPOINT + "/" + archiveId + BrowsertrixEndpoints.CRAWLS_ENDPOINT + "/" + crawlId + ".json", getConnectionSettingsProvider().getAccessToken());
	
		int status = response.getStatusLine().getStatusCode();
		if (status != HttpStatus.SC_OK)
		{
			throw new BrowsertrixApiException("Server returned status code " + status + " with message '" + response.getStatusLine().getReasonPhrase() + "'");
		}
		
		// Deserialize the response
		String result = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
		Gson gson = new Gson();
		Crawl entity = gson.fromJson(result, Crawl.class);
		
		// We're done!
		return entity;
	}
	
	
	public CrawlConfigListResponse listCrawlConfigsByArchiveId(String archiveId) throws IOException, BrowsertrixApiException
	{
		// Construct and execute the query
		String urlPrefix = "http://" + getConnectionSettingsProvider().getUrl() + ":" + getConnectionSettingsProvider().getPort();
		HttpResponse response = HttpUtils.executeAuthenticatedGetRequest(urlPrefix + BrowsertrixEndpoints.ARCHIVE_ENDPOINT + "/" + archiveId + BrowsertrixEndpoints.CRAWL_CONFIGS_ENDPOINT, getConnectionSettingsProvider().getAccessToken());
	
		int status = response.getStatusLine().getStatusCode();
		if (status != HttpStatus.SC_OK)
		{
			throw new BrowsertrixApiException("Server returned status code " + status + " with message '" + response.getStatusLine().getReasonPhrase() + "'");
		}
		
		// Deserialize the response
		String result = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
		Gson gson = new Gson();
		CrawlConfigListResponse entity = gson.fromJson(result, CrawlConfigListResponse.class);
		
		// We're done!
		return entity;
	}
	
	/**
	 * Both the archive ID and the crawl config ID are needed to identify a crawl configuration.
	 */
	public CrawlConfig getCrawlConfigById(String archiveId, String crawlConfigId) throws IOException, BrowsertrixApiException
	{
		// Construct and execute the query
		String urlPrefix = "http://" + getConnectionSettingsProvider().getUrl() + ":" + getConnectionSettingsProvider().getPort();
		HttpResponse response = HttpUtils.executeAuthenticatedGetRequest(urlPrefix + BrowsertrixEndpoints.ARCHIVE_ENDPOINT + "/" + archiveId + BrowsertrixEndpoints.CRAWL_CONFIGS_ENDPOINT + "/" + crawlConfigId, getConnectionSettingsProvider().getAccessToken());
	
		int status = response.getStatusLine().getStatusCode();
		if (status != HttpStatus.SC_OK)
		{
			throw new BrowsertrixApiException("Server returned status code " + status + " with message '" + response.getStatusLine().getReasonPhrase() + "'");
		}
		
		// Deserialize the response
		String result = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
		Gson gson = new Gson();
		CrawlConfig entity = gson.fromJson(result, CrawlConfig.class);
		
		// We're done!
		return entity;
	}
	
	
}
