package proPets.converter.service;

import java.net.URISyntaxException;

import proPets.converter.model.GeoPoint;

public interface GeoLocationService {

	String formateAddressForGeoRequest(String address);

	Double[] getLocationByAddress(String address) throws URISyntaxException;

	GeoPoint getGeoPointByAddress(String address) throws URISyntaxException;

}
