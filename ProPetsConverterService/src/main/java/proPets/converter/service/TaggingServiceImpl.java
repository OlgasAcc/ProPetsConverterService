package proPets.converter.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import proPets.converter.configuration.ConverterConfiguration;
import proPets.converter.dto.TagDto;
import proPets.converter.dto.TagResponseDto;
import proPets.converter.dto.TagResultDto;

@Service
public class TaggingServiceImpl implements TaggingService {

	@Autowired
	ConverterConfiguration converterConfiguration;

	
	@Override
	public Set<String> createSetOfPicturesTags(String[] picturesUrls) {
		Set<String> allTags = new HashSet<>();
		for (int i = 0; i < picturesUrls.length; i++) {
			List<TagDto> tagsAndConfidence = new ArrayList<>();
			tagsAndConfidence.addAll(getPictureTags(picturesUrls[i]).getTags());
			tagsAndConfidence.stream()
							.map(obj -> allTags.add(obj.getTag().get("en")))
							.collect(Collectors.toList());
		}
		return allTags;
	}
	
	private TagResultDto getPictureTags(String url) {
		RestTemplate restTemplate = converterConfiguration.restTemplate();
	
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic YWNjXzc5MDBkNDQ3YmUzYTM1Njo2Y2ZkYzFmMmRkY2Y5ZTIxODY3YzFjNGY2ZmVmOGNjYg==");
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(converterConfiguration.getUrl())
				.queryParam("image_url",url)
				.queryParam("language", "en")
				.queryParam("limit", 10);
		RequestEntity<String> request = new RequestEntity<String>(headers, HttpMethod.GET, builder.build().toUri());

		ResponseEntity<TagResponseDto> response = restTemplate.exchange(request, TagResponseDto.class);
		return response.getBody().getResult();
	}

	// скорее всего не понадобится: Эластик ищет обычный целый стринг
	
	@Override
	public Set<String> getDistinctiveFeaturesTags(String newFeatures) {
		Set<String> distinctiveFeatures = new HashSet<>();
		String[] features = newFeatures.split(",");
		for (int i = 0; i < features.length; i++) {
			distinctiveFeatures.add(features[i].trim());
		}
		return distinctiveFeatures;
	}
		
}
