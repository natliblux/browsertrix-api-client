package lu.bnl.browsertrix.client.model.crawl;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Contains information about a crawl.
 *
 */
public class Crawl 
{
	@SerializedName("id")
	private String id;
	
	@SerializedName("aid")
	private String aid;
	
	@SerializedName("cid")
	private String cid;
	
	@SerializedName("configName")
	private String name;
	
	@SerializedName("fileCount")
	private Integer fileCount;
	
	@SerializedName("fileSize")
	private Integer fileSize;
	
	@SerializedName("finished")
	private String finished;
	
	@SerializedName("started")
	private String started;
	
	@SerializedName("manual")
	private Boolean manual;
	
	@SerializedName("state")
	private String state;
	
	@SerializedName("userName")
	private String userName;
	
	@SerializedName("userid")
	private String userid;
	
	@SerializedName("resources")
	private List<CrawlResource> resources;
	

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

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFileCount() {
		return fileCount;
	}

	public void setFileCount(Integer fileCount) {
		this.fileCount = fileCount;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	public String getFinished() {
		return finished;
	}

	public void setFinished(String finished) {
		this.finished = finished;
	}

	public String getStarted() {
		return started;
	}

	public void setStarted(String started) {
		this.started = started;
	}

	public Boolean getManual() {
		return manual;
	}

	public void setManual(Boolean manual) {
		this.manual = manual;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public List<CrawlResource> getResources() {
		return resources;
	}

	public void setResources(List<CrawlResource> resources) {
		this.resources = resources;
	}

	@Override
	public String toString() 
	{
		String res = "";
		
		if (resources != null)
		{
			res = "CrawlResources [";
		
			for (CrawlResource resource : resources)
			{
				res += resource.toString() + " ";
			}
			
			res += "]";
		}
		
		
		
		return "Crawl [id=" + id + ", aid=" + aid + ", cid=" + cid + ", name=" + name + ", fileCount=" + fileCount
				+ ", fileSize=" + fileSize + ", finished=" + finished + ", started=" + started + ", manual=" + manual
				+ ", state=" + state + ", userName=" + userName + ", userid=" + userid + ", resources=" + res
				+ " ]";
	}

	
	
}
