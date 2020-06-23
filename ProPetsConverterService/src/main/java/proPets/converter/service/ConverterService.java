package proPets.converter.service;

import java.net.URISyntaxException;

import proPets.converter.dto.PostRequestDto;
import proPets.converter.model.ConvertedPost;

public interface ConverterService {

	ConvertedPost convertToConvertedPost (PostRequestDto postRequestDto) throws URISyntaxException;
	
	

}
