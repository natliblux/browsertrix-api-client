package lu.bnl.browsertrix.client.model.browser;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class BrowserProfile 
{
	@SerializedName("id")
	private String id;
	
	@SerializedName("aid")
	private String aid;
	
	@SerializedName("created")
	private String created;
	
	@SerializedName("description")
	private String description;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("origins")
	private List<String> origins;
	
	@SerializedName("resource")
	private BrowserProfileResource resource;
	
	@SerializedName("userid")
	private String userid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getOrigins() {
		return origins;
	}

	public void setOrigins(List<String> origins) {
		this.origins = origins;
	}

	public BrowserProfileResource getResource() {
		return resource;
	}

	public void setResource(BrowserProfileResource resource) {
		this.resource = resource;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() 
	{
		String result = "";
		
		for (String origin : origins)
		{
			result += origin + " ";
		}
		
		result += "]";
		
		return "BrowserProfile [id=" + id + ", aid=" + aid + ", created=" + created + ", description=" + description
				+ ", name=" + name + ", origins=" + result + ", resource=" + resource + ", userid=" + userid + "]";
	}
	
}
