package proPets.converter.configuration;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@Getter
public class BeanConfiguration {
	private String geoUrl;
	private String url;
	private String geoKey;
	private String authCode;

	public BeanConfiguration(String geoUrl, String url, String geoKey, String authCode) {
		this.geoUrl = geoUrl;
		this.url = url;
		this.geoKey = geoKey;
		this.authCode = authCode;
	}
}
