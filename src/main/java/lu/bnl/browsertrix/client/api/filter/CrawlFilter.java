package lu.bnl.browsertrix.client.api.filter;

import java.util.ArrayList;
import java.util.List;

import lu.bnl.browsertrix.client.model.crawl.Crawl;
import lu.bnl.browsertrix.client.model.crawl.CrawlState;
import lu.bnl.browsertrix.client.utils.TimeUtils;

/**
 * A basic filter used within the context of listing crawls using the CrawlService.
 * 
 */
public class CrawlFilter implements Filter<Crawl>
{
	// The state of the crawl
	private List<CrawlState> crawlStates;
	
	// This is relative to the amount of seconds since Epoch
	private Long finishedAfter;

	
	public List<CrawlState> getCrawlStates() {
		return crawlStates;
	}

	public void setCrawlStates(List<CrawlState> crawlStates) {
		this.crawlStates = crawlStates;
	}

	public Long getFinishedAfter() {
		return finishedAfter;
	}

	public void setFinishedAfter(Long finishedAfter) {
		this.finishedAfter = finishedAfter;
	}

	@Override
	public List<Crawl> applyTo(List<Crawl> to) 
	{
		List<Crawl> result = new ArrayList<Crawl>();
		
		for (Crawl crawl : to)
		{
			try
			{
				// Finished time filtering
				if (this.finishedAfter != null && this.finishedAfter > 0L)
				{		
					String timestamp = crawl.getFinished();
					if (timestamp == null || timestamp.trim().isEmpty() ||
					   (TimeUtils.timestampToSecondsSinceEpoch(crawl.getFinished()) < this.finishedAfter))
					{
						continue;
					}
				}
				
				// Status filtering
				for (CrawlState state : crawlStates)
				{
					if (state.getStringValue().equals(crawl.getState()))
					{
						// Add it
						result.add(crawl);
						break;
					}
				}
				
			}
			catch (Exception e)
			{
				// There was an issue with this particular object. It's fine...
				// TODO add logging
			}
		}
		
		return result;
	}

	
}
