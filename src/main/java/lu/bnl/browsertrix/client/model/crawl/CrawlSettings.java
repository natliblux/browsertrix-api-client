package lu.bnl.browsertrix.client.model.crawl;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Contains technical settings for a given crawl.
 *
 */
public class CrawlSettings 
{
	@SerializedName("behaviorTimeout")
	private String behaviorTimeout;
	
	@SerializedName("behaviors")
	@Expose
	private String behaviors;
	
	@SerializedName("combineWARC")
	@Expose
	private Boolean combineWarc;
	
	@SerializedName("depth")
	@Expose
	private Integer depth;
	
	@SerializedName("exclude")
	private List<String> exclude;
	
	@SerializedName("include")
	private List<String> include;
	
	@SerializedName("extraHops")
	@Expose
	private Integer extraHops;
	
	@SerializedName("generateWacz")
	@Expose
	private Boolean generateWacz;
	
	@SerializedName("headless")
	@Expose
	private Boolean headless;
	
	@SerializedName("limit")
	@Expose
	private Integer limit;

	@Expose
	@SerializedName("logging")
	private String logging;
	
	@SerializedName("scopeType")
	@Expose
	private String scopeType;
	
	@SerializedName("workers")
	@Expose
	private Integer workers;
	
	@SerializedName("seeds")
	@Expose
	private List<String> seeds;

	public String getBehaviorTimeout() {
		return behaviorTimeout;
	}

	public void setBehaviorTimeout(String behaviorTimeout) {
		this.behaviorTimeout = behaviorTimeout;
	}

	public String getBehaviors() {
		return behaviors;
	}

	public void setBehaviors(String behaviors) {
		this.behaviors = behaviors;
	}

	public Boolean getCombineWarc() {
		return combineWarc;
	}

	public void setCombineWarc(Boolean combineWarc) {
		this.combineWarc = combineWarc;
	}

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	public List<String> getExclude() {
		return exclude;
	}

	public void setExclude(List<String> exclude) {
		this.exclude = exclude;
	}

	public List<String> getInclude() {
		return include;
	}

	public void setInclude(List<String> include) {
		this.include = include;
	}

	public Integer getExtraHops() {
		return extraHops;
	}

	public void setExtraHops(Integer extraHops) {
		this.extraHops = extraHops;
	}

	public Boolean getGenerateWacz() {
		return generateWacz;
	}

	public void setGenerateWacz(Boolean generateWacz) {
		this.generateWacz = generateWacz;
	}

	public Boolean getHeadless() {
		return headless;
	}

	public void setHeadless(Boolean headless) {
		this.headless = headless;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getLogging() {
		return logging;
	}

	public void setLogging(String logging) {
		this.logging = logging;
	}

	public String getScopeType() {
		return scopeType;
	}

	public void setScopeType(String scopeType) {
		this.scopeType = scopeType;
	}

	public Integer getWorkers() {
		return workers;
	}

	public void setWorkers(Integer workers) {
		this.workers = workers;
	}

	public List<String> getSeeds() {
		return seeds;
	}

	public void setSeeds(List<String> seeds) {
		this.seeds = seeds;
	}

	@Override
	public String toString() 
	{
		String result = "";
		
		for (String seed : seeds)
		{
			result += seed + " ";
		}
		
		result += "]";
		
		return "CrawlSettings [behaviorTimeout=" + behaviorTimeout + ", behaviors=" + behaviors + ", combineWarc="
				+ combineWarc + ", depth=" + depth + ", exclude=" + exclude + ", include=" + include + ", extraHops="
				+ extraHops + ", generateWacz=" + generateWacz + ", headless=" + headless + ", limit=" + limit
				+ ", logging=" + logging + ", scopeType=" + scopeType + ", workers=" + workers + ", seeds=" + result
				+ "]";
	}
	
	
	
	
	
	
	
	
}
