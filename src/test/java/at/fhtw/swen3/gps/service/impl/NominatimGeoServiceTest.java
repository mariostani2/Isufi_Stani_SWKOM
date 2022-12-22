package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.services.dto.Address;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class NominatimGeoServiceTest {

    @Autowired
    NominatimGeoService service= new NominatimGeoService();

    @Test
    void encodeAddress() {
        Address a=new Address();
        a.setCity("Vienna");
        a.setState("Vienna");
        a.setZip("1080");
        a.setStreet("Laudongasse 36");

        GeoCoordinate geoCoordinate=service.encodeAddress(a);
        assertEquals(48.2132604,geoCoordinate.getLat(),0.001);
    }
}