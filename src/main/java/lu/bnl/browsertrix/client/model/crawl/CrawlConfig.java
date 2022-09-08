package lu.bnl.browsertrix.client.model.crawl;

import com.google.gson.annotations.SerializedName;

/**
 * Contains all information about a crawl configuration (i.e., the "crawl template" on Browsertrix Cloud).
 *
 */
public class CrawlConfig 
{
	@SerializedName("id")
	private String id;
	
	@SerializedName("aid")
	private String aid;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("config")
	private CrawlSettings crawlSettings;
	
	@SerializedName("crawlAttemptCount")
	private Integer crawlAttemptCount;
	
	@SerializedName("crawlCount")
	private Integer crawlCount;
	
	@SerializedName("crawlTimeout")
	private Integer crawlTimeout;
	
	@SerializedName("created")
	private String created;
	
	@SerializedName("currCrawlId")
	private String currCrawlId;
	
	@SerializedName("lastCrawlId")
	private String lastCrawlId;
	
	@SerializedName("inactive")
	private Boolean inactive;
	
	@SerializedName("lastCrawlState")
	private String lastCrawlState;
	
	@SerializedName("lastCrawlTime")
	private String lastCrawlTime;
	
	@SerializedName("newId")
	private String newId;
	
	@SerializedName("oldId")
	private String oldId;
	
	@SerializedName("profileName")
	private String profileName;
	
	@SerializedName("profileid")
	private String profileid;
	
	@SerializedName("scale")
	private Integer scale;
	
	@SerializedName("schedule")
	private String schedule;
	
	@SerializedName("userName")
	private String userName;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CrawlSettings getCrawlSettings() {
		return crawlSettings;
	}

	public void setCrawlSettings(CrawlSettings crawlSettings) {
		this.crawlSettings = crawlSettings;
	}

	public Integer getCrawlAttemptCount() {
		return crawlAttemptCount;
	}

	public void setCrawlAttemptCount(Integer crawlAttemptCount) {
		this.crawlAttemptCount = crawlAttemptCount;
	}

	public Integer getCrawlCount() {
		return crawlCount;
	}

	public void setCrawlCount(Integer crawlCount) {
		this.crawlCount = crawlCount;
	}

	public Integer getCrawlTimeout() {
		return crawlTimeout;
	}

	public void setCrawlTimeout(Integer crawlTimeout) {
		this.crawlTimeout = crawlTimeout;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getCurrCrawlId() {
		return currCrawlId;
	}

	public void setCurrCrawlId(String currCrawlId) {
		this.currCrawlId = currCrawlId;
	}

	public String getLastCrawlId() {
		return lastCrawlId;
	}

	public void setLastCrawlId(String lastCrawlId) {
		this.lastCrawlId = lastCrawlId;
	}

	public Boolean getInactive() {
		return inactive;
	}

	public void setInactive(Boolean inactive) {
		this.inactive = inactive;
	}

	public String getLastCrawlState() {
		return lastCrawlState;
	}

	public void setLastCrawlState(String lastCrawlState) {
		this.lastCrawlState = lastCrawlState;
	}

	public String getLastCrawlTime() {
		return lastCrawlTime;
	}

	public void setLastCrawlTime(String lastCrawlTime) {
		this.lastCrawlTime = lastCrawlTime;
	}

	public String getNewId() {
		return newId;
	}

	public void setNewId(String newId) {
		this.newId = newId;
	}

	public String getOldId() {
		return oldId;
	}

	public void setOldId(String oldId) {
		this.oldId = oldId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getProfileid() {
		return profileid;
	}

	public void setProfileid(String profileid) {
		this.profileid = profileid;
	}

	public Integer getScale() {
		return scale;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
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

	@Override
	public String toString() {
		return "CrawlConfig [id=" + id + ", aid=" + aid + ", name=" + name + ", crawlSettings=" + crawlSettings
				+ ", crawlAttemptCount=" + crawlAttemptCount + ", crawlCount=" + crawlCount + ", crawlTimeout="
				+ crawlTimeout + ", created=" + created + ", currCrawlId=" + currCrawlId + ", lastCrawlId="
				+ lastCrawlId + ", inactive=" + inactive + ", lastCrawlState=" + lastCrawlState + ", lastCrawlTime="
				+ lastCrawlTime + ", newId=" + newId + ", oldId=" + oldId + ", profileName=" + profileName
				+ ", profileid=" + profileid + ", scale=" + scale + ", schedule=" + schedule + ", userName=" + userName
				+ ", userid=" + userid + "]";
	}
	
	
	
}
