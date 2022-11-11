package lu.bnl.browsertrix.client.api.constants;

public class BrowsertrixEndpoints 
{
	
	public static final String ROOT_ENDPOINT = "/api";
	
	 // Authentication
	public static final String AUTH_ENDPOINT = ROOT_ENDPOINT + "/auth/jwt/login";
	public static final String SELF_ENDPOINT = ROOT_ENDPOINT + "/users/me";
	
	// Archives and crawling
	public static final String ARCHIVE_ENDPOINT = ROOT_ENDPOINT + "/archives";
	public static final String CRAWLS_ENDPOINT = "/crawls";
	public static final String CRAWL_CONFIGS_ENDPOINT = "/crawlconfigs";
	public static final String BROWSER_PROFILE_ENDPOINT = "/profiles";
	public static final String RUN_CRAWL_ENDPOINT = "/run";
	
	
	
}
