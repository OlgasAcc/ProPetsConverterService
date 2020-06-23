package proPets.converter.model;

import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import proPets.converter.model.GeoPoint;

@Getter
@Setter
@Builder

public class ConvertedPost { 
	
	String id;
	String flag;
	String type;
	String distFeatures;
	Set<String> picturesTags;
	GeoPoint location;

}
