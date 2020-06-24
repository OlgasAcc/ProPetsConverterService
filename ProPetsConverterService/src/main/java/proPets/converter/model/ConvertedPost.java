package proPets.converter.model;

import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class ConvertedPost { 
	
	String id;
	String email; //authorId (for sending notifications)
	String flag;
	String type;
	String distFeatures;
	Set<String> picturesTags;
	Double[] location;

}
