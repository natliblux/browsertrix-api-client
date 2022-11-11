package lu.bnl.browsertrix.client.api.filter;

import java.util.ArrayList;
import java.util.List;

import lu.bnl.browsertrix.client.model.crawl.CrawlConfig;

/**
 * A basic filter used within the context of listing crawls configurations (templateS) using the CrawlService.
 * 
 */
public class CrawlConfigFilter implements Filter<CrawlConfig>
{
	// Only take crawl configs that have a schedule
	private boolean onlyScheduled = false;

	public boolean isOnlyScheduled() {
		return onlyScheduled;
	}

	public void setOnlyScheduled(boolean onlyScheduled) {
		this.onlyScheduled = onlyScheduled;
	}


	@Override
	public List<CrawlConfig> applyTo(List<CrawlConfig> to) 
	{
		List<CrawlConfig> result = new ArrayList<CrawlConfig>();
		
		for (CrawlConfig crawlConfig : to)
		{
			try
			{
				// Only configs that have a schedule attached
				if (this.onlyScheduled)
				{
					if (crawlConfig.getSchedule() != null && !crawlConfig.getSchedule().trim().isEmpty())
					{
						result.add(crawlConfig);
					}
				}		
			}
			catch (Exception e)
			{
				// There was an issue with this particular object. It's fine...
			}
		}
		
		return result;
	}

	
}
