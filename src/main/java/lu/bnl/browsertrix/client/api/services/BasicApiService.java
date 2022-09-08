package lu.bnl.browsertrix.client.api.services;

import lu.bnl.browsertrix.client.api.ConnectionSettingsProvider;

/**
 * Represents a basic API service exposed by BrowsertrixCloud.
 *
 */
public abstract class BasicApiService 
{
	private ConnectionSettingsProvider connectionSettingsProvider;
	
	public BasicApiService(ConnectionSettingsProvider connectionSettingsProvider)
	{
		this.connectionSettingsProvider = connectionSettingsProvider;
	}

	public ConnectionSettingsProvider getConnectionSettingsProvider() {
		return connectionSettingsProvider;
	}

	public void setConnectionSettingsProvider(ConnectionSettingsProvider connectionSettingsProvider) {
		this.connectionSettingsProvider = connectionSettingsProvider;
	}

}
