import java.util.List;

import lu.bnl.browsertrix.client.api.BrowsertrixClient;
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
			BrowsertrixClient client = new BrowsertrixClient(URL, PORT, USERNAME, PASSWORD);
			
			client.connect();
			
			//System.out.println(client.getAuthenticationService().getCurrentUser().toString());

			//System.out.println(client.getArchiveService().listArchives());
			
//			ArchiveListResponse response = client.getArchiveService().listArchives();
//			String id = response.getArchives().get(0).getId();
//			System.out.println(client.getArchiveService().getArchiveById(id));
			
			ArchiveListResponse response = client.getArchiveService().listArchives();
			String id = response.getArchives().get(0).getId();
			System.out.println(client.getCrawlService().listCrawlsByArchiveId(id));
			
		}
		catch (Exception e)
		{
			System.out.println("Test FAILED: " + e.getMessage());
			e.printStackTrace();
		}
		

	}

}
