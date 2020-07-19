package proPets.converter.configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import proPets.converter.dto.ConvertedPostDto;

@Configuration
@RefreshScope
public class ConverterConfiguration {

	Map<String, ConvertedPostDto> posts = new ConcurrentHashMap<>();
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Value("${imagga.url}")
	String url;
	
	@RefreshScope
	public String getUrl() {
		return url;
	}
	
	@Value("${geo.api.url}")
	String geoUrl;
	
	@RefreshScope
	public String getGeoUrl() {
		return geoUrl;
	}
	
	@Value("${geo.api.key}")
	String geoKey;
	
	@RefreshScope
	public String getGeoKey() {
		return geoKey;
	}
}