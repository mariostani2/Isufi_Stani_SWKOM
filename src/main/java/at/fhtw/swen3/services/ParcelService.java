package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import org.springframework.stereotype.Service;

@Service("parcelService")
public interface ParcelService {
    void submitNewParcel(ParcelEntity parcelEntity);
}
