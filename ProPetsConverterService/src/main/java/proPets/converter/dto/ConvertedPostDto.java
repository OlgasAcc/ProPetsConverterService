package proPets.converter.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class ConvertedPostDto implements Serializable{ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String email; //author's email
	String flag;
	String type;
	String distFeatures;
	String[] picturesTags;
	Double[] location;

}
