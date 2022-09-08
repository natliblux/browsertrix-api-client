package lu.bnl.browsertrix.client.model.browser;

import com.google.gson.annotations.SerializedName;

/**
 * Contains information about the file that stores the browser profile that was created using
 * Browsertrix Cloud.
 *
 */
public class BrowserProfileResource 
{
	@SerializedName("filename")
	private String filename;
	
	@SerializedName("hash")
	private String hash;
	
	@SerializedName("size")
	private Integer size;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "BrowserProfileResource [filename=" + filename + ", hash=" + hash + ", size=" + size + "]";
	}
	
	
}
