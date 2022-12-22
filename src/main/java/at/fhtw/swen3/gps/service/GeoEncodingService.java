package at.fhtw.swen3.gps.service;

import at.fhtw.swen3.services.dto.Address;
import at.fhtw.swen3.services.dto.GeoCoordinate;

public interface GeoEncodingService {
    GeoCoordinate encodeAddress(Address a);
}
