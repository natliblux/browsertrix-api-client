package lu.bnl.browsertrix.client.model.crawl;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * A list of crawl configs (or "crawl templates", as shown in Browsertrix Cloud...)
 *
 */
public class CrawlConfigListResponse 
{
	@SerializedName("crawlConfigs")
	private List<CrawlConfig> crawlConfigs;
	
	public List<CrawlConfig> getCrawlConfigs() {
		return crawlConfigs;
	}

	public void setCrawlConfigs(List<CrawlConfig> crawlConfigs) {
		this.crawlConfigs = crawlConfigs;
	}

	@Override
	public String toString() 
	{
		String result = "CrawlConfigListResponse [";
		
		for (CrawlConfig crawlConfig : crawlConfigs)
		{
			result += crawlConfig.toString() + "\n ";
		}
		
		result += "\n]";
		
		return result;
	}
}
