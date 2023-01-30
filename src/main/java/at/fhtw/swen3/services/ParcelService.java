package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.DALException;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.springframework.stereotype.Service;

@Service("parcelService")
public interface ParcelService {

    void reportParcelDelivery(String trackingId);
    void reportParcelHop(String trackingId, String code) throws DALException, BLException;

    void submitNewParcel(ParcelEntity parcelEntity) throws DALException, BLException;
    TrackingInformation trackParcel(String trackingId) throws DALException;
    void transitionParcel (String trackingId,ParcelEntity parcel) throws BLException, DALException;
}
