package proPets.converter.service;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proPets.converter.configuration.ConverterConfiguration;
import proPets.converter.dto.PostRequestDto;
import proPets.converter.model.ConvertedPost;

@Service
public class ConverterServiceImpl implements ConverterService {

	@Autowired
	ConverterConfiguration converterConfiguration;

	@Autowired
	TaggingService tagService;

	@Autowired
	GeoLocationService geoLocationService;

	@Override
	public ConvertedPost convertToConvertedPost(PostRequestDto postReqDto) throws URISyntaxException {
		return ConvertedPost.builder()
				.flag(postReqDto.getFlag())
				.type(postReqDto.getType())
				.distFeatures(postReqDto.getDistinctiveFeatures())
				.picturesTags(tagService.createSetOfPicturesTags(postReqDto.getPicturesURLs())) 
				.location(geoLocationService.getGeoPointByAddress(postReqDto.getAddress()))
				.build(); 
	}

}
