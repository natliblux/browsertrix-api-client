package lu.bnl.browsertrix.client.model.archive;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ArchiveListResponse 
{
	@SerializedName("archives")
	private List<Archive> archives;

	public List<Archive> getArchives() {
		return archives;
	}

	public void setArchives(List<Archive> archives) {
		this.archives = archives;
	}

	@Override
	public String toString() 
	{
		String result = "ArchiveListResponse [";
		
		for (Archive archive : archives)
		{
			result += archive.toString() + " ";
		}
		
		result += "]";
		
		return result;
	}
	
	
}
