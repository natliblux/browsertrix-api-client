package lu.bnl.browsertrix.client.model.crawl;

public enum CrawlState 
{
	COMPLETE			("complete"),
	PARTIAL_COMPLETE	("partial_complete"),
	FAILED				("failed"),
	CANCELED			("canceled"),
	STARTING			("starting"),
	CANCELING			("canceling"),
	STOPPING			("stopping"),
	RUNNING				("running");
	
	private String stringValue;
	
	CrawlState(String stringValue)
	{
		this.stringValue = stringValue;
	}
	
	public String getStringValue()
	{
		return this.stringValue;
	}
}
