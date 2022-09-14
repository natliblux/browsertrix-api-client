package lu.bnl.browsertrix.client.model.crawl;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class CrawlListResponse 
{
	@SerializedName("crawls")
	private List<Crawl> crawls;
	
	public List<Crawl> getCrawls() {
		return crawls;
	}

	public void setCrawls(List<Crawl> crawls) {
		this.crawls = crawls;
	}

	@Override
	public String toString() 
	{
		String result = "CrawlListResponse [";
		
		for (Crawl crawl : crawls)
		{
			result += "\n " + crawl.toString();
		}
		
		result += "\n]";
		
		return result;
	}
	
}
