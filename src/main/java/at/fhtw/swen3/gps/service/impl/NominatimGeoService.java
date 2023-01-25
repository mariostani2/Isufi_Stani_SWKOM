package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.services.dto.Address;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

public class NominatimGeoService implements GeoEncodingService {

//    @Autowired
//    private WebClient nominatimWebClient;
    @Override
    public GeoCoordinate encodeAddress(Address a) {
         var x= WebClient.create("https://nominatim.openstreetmap.org")
                .get()
                .uri(uriBuilder -> uriBuilder.
                        path("/search")
                        .queryParam("street",a.getStreet())
                        .queryParam("city",a.getCity())
                        .queryParam("state",a.getState())
                        .queryParam("postalcode",a.getZip())
                        .queryParam("format","json")
                        .build())
                .retrieve()
                .bodyToMono(GeoCoordinate[].class)
                .block();
         return x[0];
    }
}
