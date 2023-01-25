package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.gps.service.impl.NominatimGeoService;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.services.dto.Address;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource("/application-test.properties")
class HopRepositoryTest {

    @Autowired
    private HopRepository hopRepository;

    @Autowired
    private NominatimGeoService nominatimGeoService;
    @Test
    void findNearestHop() {
        Address sender=new Address();
        sender.setStreet("Laudongasse 36");
        sender.setZip("1080");
        sender.setCity("Vienna");

        Address rec=new Address();
        rec.setStreet("Donaufelderstrasse 54");
        rec.setZip("1080");
        rec.setCity("Vienna");
        GeoCoordinate s=nominatimGeoService.encodeAddress(sender);
        var x=hopRepository.findNearestHop(s.getLon(),s.getLat());
        System.out.println(x);
    }
}