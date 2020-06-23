package proPets.converter.service;

import java.util.Set;

public interface TaggingService {

	//TagResultDto getPictureTags (String url);
	
	Set<String> createSetOfPicturesTags(String [] picturesUrls);
	
	Set<String> getDistinctiveFeaturesTags (String newFeatures);

}
