package proPets.converter.service;

import java.net.URISyntaxException;
import java.util.Set;

import org.apache.commons.httpclient.URIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proPets.converter.configuration.ConverterConfiguration;
import proPets.converter.dto.ConvertedLocationData;
import proPets.converter.dto.ConvertedPostDto;
import proPets.converter.dto.PostRequestDto;

@Service
public class ConverterServiceImpl implements ConverterService {

	@Autowired
	ConverterConfiguration converterConfiguration;

	@Autowired
	TaggingService tagService;

	@Autowired
	GeoLocationService geoLocationService;

	@Override
	public ConvertedPostDto convertToConvertedPost(PostRequestDto postReqDto) throws URISyntaxException {
		   Set<String> set = tagService.createSetOfPicturesTags(postReqDto.getPicturesURLs());
		String[] arr = set.stream().toArray(String[] ::new); 
		   
		return ConvertedPostDto.builder()
				.id(postReqDto.getId())
				.flag(postReqDto.getFlag())
				.email(postReqDto.getEmail())
				.type(postReqDto.getType())
				.distFeatures(postReqDto.getDistinctiveFeatures())
				.picturesTags(arr) 
				.location(geoLocationService.getLocationByAddress(postReqDto.getAddress()))
				.build(); 
	}

	@Override
	public ConvertedLocationData getLocationData(String address) throws URISyntaxException, URIException {
		try {
			return new ConvertedLocationData(geoLocationService.getLocationByAddress(address));
		} catch (Exception e) {
			throw new URIException();
			//e.printStackTrace();
		}
	}

}
