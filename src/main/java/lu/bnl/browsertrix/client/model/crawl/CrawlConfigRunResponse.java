package lu.bnl.browsertrix.client.model.crawl;

import com.google.gson.annotations.SerializedName;

/**
 * Contains all information about a crawl configuration (i.e., the "crawl template" on Browsertrix Cloud).
 *
 */
public class CrawlConfigRunResponse 
{
	@SerializedName("started")
	private String crawlId;

	public String getCrawlId() {
		return crawlId;
	}

	public void setCrawlId(String crawlId) {
		this.crawlId = crawlId;
	}

	@Override
	public String toString() {
		return "CrawlConfigRunResponse [crawlId=" + crawlId + "]";
	}
	
}
