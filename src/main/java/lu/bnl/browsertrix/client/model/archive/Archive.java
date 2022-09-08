package lu.bnl.browsertrix.client.model.archive;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a Browsertrix archive, owned by a user.
 * 
 * TODO incomplete.
 *
 */
public class Archive 
{
	@SerializedName("id")
	private String id;
	
	@SerializedName("name")
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Archive [id=" + id + ", name=" + name + "]";
	}
	
	
}
