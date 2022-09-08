package lu.bnl.browsertrix.client.model.browser;

import java.util.Arrays;
import java.util.List;

public class BrowserProfileListResponse 
{
	private List<BrowserProfile> browserProfiles;
	
	public BrowserProfileListResponse(BrowserProfile[] entity)
	{
		setBrowserProfiles(Arrays.asList(entity));
	}
	
	public List<BrowserProfile> getBrowserProfiles() {
		return browserProfiles;
	}

	public void setBrowserProfiles(List<BrowserProfile> browserProfiles) {
		this.browserProfiles = browserProfiles;
	}

	@Override
	public String toString() 
	{
		String result = "BrowserProfileListResponse [";
		
		for (BrowserProfile entity: browserProfiles)
		{
			result += "\n " + entity.toString();
		}
		
		result += "\n]";
		
		return result;
	}
}
