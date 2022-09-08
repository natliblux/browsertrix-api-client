package lu.bnl.browsertrix.client.model.authentication;

import com.google.gson.annotations.SerializedName;

/**
 * Holds the authentication token and the token type sent by the server once
 * the user is logged in.
 *
 */
public class AuthenticationResponse 
{
	@SerializedName("access_token")
	private String accessToken;
	
	@SerializedName("token_type")
	private String tokenType;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	
}
