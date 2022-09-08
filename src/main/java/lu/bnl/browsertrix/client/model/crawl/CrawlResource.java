package lu.bnl.browsertrix.client.model.crawl;

import com.google.gson.annotations.SerializedName;

/**
 * Contains information about a resource, eg. a file, relative to this crawl.
 *
 */
public class CrawlResource 
{
	@SerializedName("hash")
	private String hash;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("path")
	private String path;
	
	@SerializedName("size")
	private Integer size;

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "CrawlResource [hash=" + hash + ", name=" + name + ", path=" + path + ", size=" + size + "]";
	}
	
	
}
