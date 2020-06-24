package proPets.converter.service;

import java.net.URISyntaxException;

public interface GeoLocationService {

	String formateAddressForGeoRequest(String address);

	Double[] getLocationByAddress(String address) throws URISyntaxException;

}
