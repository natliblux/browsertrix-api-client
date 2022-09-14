package lu.bnl.browsertrix.client.api.filter;

import java.util.List;

public interface Filter<T>
{	
	public List<T> applyTo(List<T> to);	
}
