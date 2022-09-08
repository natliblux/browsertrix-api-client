package lu.bnl.browsertrix.client.model.authentication;

import com.google.gson.annotations.SerializedName;

/**
 * Contains all the information about a currently logged in user.
 *
 */
public class UserInformationResponse 
{
	@SerializedName("name")
	private String name;
	
	@SerializedName("id")
	private String id;
	
	@SerializedName("email")
	private String email;
	
	@SerializedName("is_active")
	private Boolean isActive;
	
	@SerializedName("is_superuser")
	private Boolean isSuperuser;
	
	@SerializedName("is_verified")
	private Boolean isVerified;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsSuperuser() {
		return isSuperuser;
	}

	public void setIsSuperuser(Boolean isSuperuser) {
		this.isSuperuser = isSuperuser;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	@Override
	public String toString() {
		return "UserInformationResponse [name=" + name + ", id=" + id + ", email=" + email + ", isActive=" + isActive
				+ ", isSuperuser=" + isSuperuser + ", isVerified=" + isVerified + "]";
	}
	
	
	
	
	
}
