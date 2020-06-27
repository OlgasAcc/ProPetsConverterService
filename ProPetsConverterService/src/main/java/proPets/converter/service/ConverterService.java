package proPets.converter.service;

import java.net.URISyntaxException;

import org.apache.commons.httpclient.URIException;

import proPets.converter.dto.ConvertedLocationData;
import proPets.converter.dto.ConvertedPostDto;
import proPets.converter.dto.PostRequestDto;

public interface ConverterService {

	ConvertedPostDto convertToConvertedPost (PostRequestDto postRequestDto) throws URISyntaxException;

	ConvertedLocationData getLocationData(String address) throws URISyntaxException, URIException;
	
	

}
