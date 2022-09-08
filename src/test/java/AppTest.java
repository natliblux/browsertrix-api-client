import java.io.IOException;
import java.util.List;

import lu.bnl.browsertrix.client.BrowsertrixClient;
import lu.bnl.browsertrix.client.exceptions.BrowsertrixApiException;
import lu.bnl.browsertrix.client.model.archive.ArchiveListResponse;

public class AppTest 
{

	// Test connection parameters
	private static final String URL = "localhost";
	private static final int PORT = 9871;
	private static final String USERNAME = "admin@example.com";
	private static final String PASSWORD = "PASSW0RD0";
	
	public static void main(String[] args) 
	{
		try
		{
			testCrawlService();
		}
		catch (Exception e)
		{
			System.out.println("Test FAILED: " + e.getMessage());
			e.printStackTrace();
		}
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

}
