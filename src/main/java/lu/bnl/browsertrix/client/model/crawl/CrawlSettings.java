package lu.bnl.browsertrix.client.model.crawl;

import java.util.List;

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
	private String behaviors;
	
	@SerializedName("combineWARC")
	private Boolean combineWarc;
	
	@SerializedName("depth")
	private Integer depth;
	
	@SerializedName("exclude")
	private String exclude;
	
	@SerializedName("include")
	private String include;
	
	@SerializedName("extraHops")
	private Integer extraHops;
	
	@SerializedName("generateWacz")
	private Boolean generateWacz;
	
	@SerializedName("headless")
	private Boolean headless;
	
	@SerializedName("limit")
	private Integer limit;
	
	@SerializedName("logging")
	private String logging;
	
	@SerializedName("scopeType")
	private String scopeType;
	
	@SerializedName("workers")
	private Integer workers;
	
	@SerializedName("seeds")
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

	public String getExclude() {
		return exclude;
	}

	public void setExclude(String exclude) {
		this.exclude = exclude;
	}

	public String getInclude() {
		return include;
	}

	public void setInclude(String include) {
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
