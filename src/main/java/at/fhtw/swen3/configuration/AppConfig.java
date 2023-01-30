package at.fhtw.swen3.configuration;

import at.fhtw.swen3.gps.service.impl.NominatimGeoService;
import at.fhtw.swen3.persistence.repositories.*;
import at.fhtw.swen3.services.impl.ParcelServiceImpl;
import at.fhtw.swen3.services.impl.WarehouseServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {
    @Bean
    public ParcelServiceImpl parcelService(ParcelRepository parcelRepository, RecipientRepository recipientRepository, HopRepository hopRepository, NominatimGeoService nominatimGeoService, WarehouseNextHopsRepository warehouseNextHopsRepository, WarehouseRepository warehouseRepository,HopArrivalRepository hopArrivalRepository, TransferwarehouseRepository transferwarehouseRepository) {
        return new ParcelServiceImpl(parcelRepository,recipientRepository,hopRepository,nominatimGeoService, warehouseNextHopsRepository, warehouseRepository, hopArrivalRepository, transferwarehouseRepository);
    }

    @Bean
    public WarehouseServiceImpl warehouseService(WarehouseRepository warehouseRepository, HopRepository hopRepository ) {
        return new WarehouseServiceImpl(warehouseRepository, hopRepository);
    }

    @Bean
    public NominatimGeoService nominatimGeoService(){
        return new NominatimGeoService();
    }

}
