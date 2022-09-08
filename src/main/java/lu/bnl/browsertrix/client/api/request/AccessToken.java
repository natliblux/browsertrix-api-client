package lu.bnl.browsertrix.client.api.request;

public class AccessToken 
{
	private String authToken;
	private String authType;
	
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getAuthType() {
		return authType;
	}
	public void setAuthType(String authType) {
		this.authType = authType;
	}
	
	public void clear()
	{
		this.authToken = "";
		this.authType = "";
	}
	
}
