package lu.bnl.browsertrix.client.api;

import lu.bnl.browsertrix.client.api.request.AccessToken;

/**
 * Provides basic information about an API connection.
 *
 */
public interface ConnectionSettingsProvider 
{
	public String getUrl();
	
	public int getPort();
	
	public String getUsername();
	
	public String getPassword();
	
	public AccessToken getAccessToken();
}
