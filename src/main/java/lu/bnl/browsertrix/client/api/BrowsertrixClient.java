package lu.bnl.browsertrix.client.api;

import java.io.IOException;

import lu.bnl.browsertrix.client.api.request.AccessToken;
import lu.bnl.browsertrix.client.api.services.ArchiveService;
import lu.bnl.browsertrix.client.api.services.AuthenticationService;
import lu.bnl.browsertrix.client.api.services.CrawlService;
import lu.bnl.browsertrix.client.exceptions.BrowsertrixApiException;
import lu.bnl.browsertrix.client.model.authentication.AuthenticationResponse;

public class BrowsertrixClient implements ConnectionSettingsProvider
{
	// Connection parameters
	private String url;
	private int port;
	
	// Credentials
	private String username;
	private String password;
	
	// The API access token
	private AccessToken accessToken;
	
	// Handle to the different API services
	private AuthenticationService authenticationService;
	private ArchiveService archiveService;
	private CrawlService crawlService;
	
	
	public BrowsertrixClient(String url, int port, String username, String password)
	{
		// TODO
		this.url = url;
		this.port = port;
		this.username = username;
		this.password = password;
		
		this.accessToken = new AccessToken();
		this.accessToken.clear();
		
		setupServices();
	}
	
	private void setupServices()
	{
		this.authenticationService = new AuthenticationService(this);
		this.archiveService = new ArchiveService(this);
		this.crawlService = new CrawlService(this);
	}
	

	
	/**
	 * If not already connected, logs in to the server using the given credentials.
	 * 
	 */
	public void connect() throws BrowsertrixApiException, IOException
	{
		if (!authenticationService.isAuthenticated())
		{
			authenticate();
		}
	}
	
	/**
	 * Uses the authentication service to log in and store the access token for further use.
	 * 
	 */
	private void authenticate() throws BrowsertrixApiException, IOException
	{
		AuthenticationResponse response = authenticationService.login();
		
		AccessToken token = new AccessToken();
		token.setAuthToken(response.getAccessToken());
		token.setAuthType(response.getTokenType());
		
		setAccessToken(token);
	}
	
	/**
	 * Disconnects from the server and flushes all auth information.
	 * 
	 */
	public void disconnect()
	{
		// TODO
		this.accessToken.clear();
	}

	public String getUsername() 
	{
		return username;
	}

	public String getPassword() 
	{
		return password;
	}

	public String getUrl() 
	{
		return url;
	}

	public int getPort() 
	{
		return port;
	}

	public AccessToken getAccessToken() 
	{
		return accessToken;
	}
	
	private void setAccessToken(AccessToken accessToken)
	{
		this.accessToken = accessToken;
	}

	public AuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	public ArchiveService getArchiveService() {
		return archiveService;
	}
	
	public CrawlService getCrawlService() {
		return crawlService;
	}
	
	
}
