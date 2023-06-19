package lu.bnl.browsertrix.client.test;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import lu.bnl.browsertrix.client.BrowsertrixClient;
import lu.bnl.browsertrix.client.api.filter.CrawlConfigFilter;
import lu.bnl.browsertrix.client.api.filter.CrawlFilter;
import lu.bnl.browsertrix.client.exceptions.BrowsertrixApiException;
import lu.bnl.browsertrix.client.model.archive.Archive;
import lu.bnl.browsertrix.client.model.archive.ArchiveListResponse;
import lu.bnl.browsertrix.client.model.crawl.Crawl;
import lu.bnl.browsertrix.client.model.crawl.CrawlConfig;
import lu.bnl.browsertrix.client.model.crawl.CrawlState;

public class AppTest 
{

	// Test connection parameters.
	private static final String URL = "localhost";
	private static final int PORT = 9871;
	private static final String USERNAME = "admin@example.com";
	private static final String PASSWORD = "PASSW0RD0";
	
	public static void main(String[] args)
	{
		try
		{
			testStatisticsFiltering();
		}
		catch (Exception e)
		{
			System.out.println("Test FAILED: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void testStatisticsFiltering() throws BrowsertrixApiException, IOException
	{
		BrowsertrixClient client = new BrowsertrixClient(URL, PORT, USERNAME, PASSWORD);
		client.connect();
		
		ArchiveListResponse response = client.getArchiveService().listArchives();
		
		for (Archive archive : response.getArchives())
		{
		
			CrawlFilter filter = new CrawlFilter();
			List<CrawlState> states = new ArrayList<CrawlState>();
			states.add(CrawlState.PARTIAL_COMPLETE);
			states.add(CrawlState.COMPLETE);
			states.add(CrawlState.FAILED);
			states.add(CrawlState.CANCELED);
			
			filter.setCrawlStates(states);
			
			filter.setFinishedAfter(Instant.now().getEpochSecond() - (24 * 60 * 60));
			
			// Get the filtered result list
			List<Crawl> crawls = client.getCrawlService().listCrawlsByArchiveId(archive.getId(), filter).getCrawls();
			
			for (Crawl crawl : crawls)
			{
				System.out.println("[" + archive.getId() + "] found crawl: '" + crawl.getName() + "'");
			}
		}
	}
	
	private static void testFiltering() throws BrowsertrixApiException, IOException
	{
		BrowsertrixClient client = new BrowsertrixClient(URL, PORT, USERNAME, PASSWORD);
		
		client.connect();
		
		ArchiveListResponse response = client.getArchiveService().listArchives();
		String id = response.getArchives().get(0).getId();

		CrawlFilter filter = new CrawlFilter();
		
		List<CrawlState> states = new ArrayList<CrawlState>();
		states.add(CrawlState.PARTIAL_COMPLETE);
		states.add(CrawlState.COMPLETE);
		states.add(CrawlState.FAILED);
		
		filter.setCrawlStates(states);
		filter.setFinishedAfter(Instant.now().getEpochSecond() - 240*60*60); // in seconds
		
		System.out.println(client.getCrawlService().listCrawlsByArchiveId(id, filter));
	}
	
	private static void testAuthenticationService() throws BrowsertrixApiException, IOException
	{
		BrowsertrixClient client = new BrowsertrixClient(URL, PORT, USERNAME, PASSWORD);
		
		client.connect();
		
		System.out.println(client.getAuthenticationService().getCurrentUser().toString());
		
	}
	
	private static void testArchiveService() throws BrowsertrixApiException, IOException
	{
		BrowsertrixClient client = new BrowsertrixClient(URL, PORT, USERNAME, PASSWORD);
		
		client.connect();
		
		System.out.println(client.getArchiveService().listArchives());
		
		ArchiveListResponse response = client.getArchiveService().listArchives();
		String id = response.getArchives().get(0).getId();
		System.out.println(client.getArchiveService().getArchiveById(id));
		
		System.out.println(client.getCrawlService().listCrawlsByArchiveId(id));
	}
	
	private static void testBrowserProfileService() throws BrowsertrixApiException, IOException
	{
		BrowsertrixClient client = new BrowsertrixClient(URL, PORT, USERNAME, PASSWORD);
		
		client.connect();
		
		System.out.println(client.getBrowserProfileService().listBrowserProfilesByArchiveId("b5fef53a-fbf2-40ed-8b5f-3e27e1608ef7"));

		System.out.println(client.getBrowserProfileService().getBrowserProfileById("b5fef53a-fbf2-40ed-8b5f-3e27e1608ef7", "4255e259-76c9-49d5-8137-90624a0db352"));
	}
	
	private static void testCrawlService() throws BrowsertrixApiException, IOException
	{
		BrowsertrixClient client = new BrowsertrixClient(URL, PORT, USERNAME, PASSWORD);
		
		client.connect();
		
		ArchiveListResponse response = client.getArchiveService().listArchives();
		String id = response.getArchives().get(0).getId();
		System.out.println(client.getCrawlService().listCrawlsByArchiveId(id));
		
		System.out.println(client.getCrawlService().getCrawlById("b5fef53a-fbf2-40ed-8b5f-3e27e1608ef7", "manual-20220816064300-e7849083-cb8"));

		System.out.println(client.getCrawlService().listCrawlConfigsByArchiveId("b5fef53a-fbf2-40ed-8b5f-3e27e1608ef7"));
		
		System.out.println(client.getCrawlService().getCrawlConfigById("b5fef53a-fbf2-40ed-8b5f-3e27e1608ef7", "e7849083-cb84-495c-a4dc-e8489cf8fe96"));
	}

	private static void testCrawlTemplates() throws BrowsertrixApiException, IOException
	{
		BrowsertrixClient client = new BrowsertrixClient(URL, PORT, USERNAME, PASSWORD);
		
		client.connect();
		
		ArchiveListResponse response = client.getArchiveService().listArchives();
		String id = response.getArchives().get(0).getId();
		System.out.println(client.getCrawlService().listCrawlConfigsByArchiveId(id));
	
	}
	
	private static void testFilteredCrawlTemplates() throws BrowsertrixApiException, IOException
	{
		BrowsertrixClient client = new BrowsertrixClient(URL, PORT, USERNAME, PASSWORD);
		
		client.connect();
		
		ArchiveListResponse response = client.getArchiveService().listArchives();
		String id = response.getArchives().get(0).getId();
		
		CrawlConfigFilter filter = new CrawlConfigFilter();
		filter.setOnlyScheduled(true);
		
		System.out.println(client.getCrawlService().listCrawlConfigsByArchiveId(id, filter));
	}
	
	private static void testRunCrawl() throws BrowsertrixApiException, IOException
	{
		BrowsertrixClient client = new BrowsertrixClient(URL, PORT, USERNAME, PASSWORD);
		client.connect();
		
		// Attempts to get the first crawl template with a schedule. If one exists, triggers a crawl from that.
		ArchiveListResponse response = client.getArchiveService().listArchives();
		String archiveId = response.getArchives().get(0).getId();
		CrawlConfigFilter filter = new CrawlConfigFilter();
		filter.setOnlyScheduled(true);
		List<CrawlConfig> crawlConfigs = client.getCrawlService().listCrawlConfigsByArchiveId(archiveId, filter).getCrawlConfigs();
		
		// Now we try to run the crawl from this crawl config
		String crawlId = client.getCrawlService().runCrawl(archiveId, crawlConfigs.get(0).getId());
		
		System.out.println("Successfully started crawl with ID '" + crawlId + "'");
	}
	
}
