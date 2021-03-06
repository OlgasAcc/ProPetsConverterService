package proPets.converter.service;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.model.GeocodingResult;

import proPets.converter.configuration.ConverterConfiguration;

@Service
public class GeoLocationServiceImpl implements GeoLocationService {

	@Autowired
	ConverterConfiguration converterConfiguration;

	@Override
	public Double[] getLocationByAddress(String address) throws URISyntaxException {

		GeoApiContext context = new GeoApiContext().setApiKey(converterConfiguration.getGeoKey());
		GeocodingApiRequest request = GeocodingApi.newRequest(context).address(formateAddressForGeoRequest(address))
				.language("en");
		try {
			GeocodingResult[] results = request.await();
			Double[] res = new Double[2];
			res[0] = results[0].geometry.location.lat;
			res[1] = results[0].geometry.location.lng;
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String formateAddressForGeoRequest(String address) {
		return address.replace(" ", "+");
	}

}
