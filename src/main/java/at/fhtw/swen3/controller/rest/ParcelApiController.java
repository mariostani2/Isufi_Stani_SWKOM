package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.ParcelApi;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-24T08:44:03.675534Z[Etc/UTC]")
@Controller
@Slf4j
public class ParcelApiController implements ParcelApi {

    private final NativeWebRequest request;

    @Autowired
    public ParcelApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    /**
     * POST /parcel/{trackingId}/reportDelivery/ : Report that a ParcelEntity has been delivered at it&#39;s final destination address.
     *
     * @param trackingId The tracking ID of the parcel. E.g. PYJRB4HZ6  (required)
     * @return Successfully reported hop. (status code 200)
     * or The operation failed due to an error. (status code 400)
     * or ParcelEntity does not exist with this tracking ID.  (status code 404)
     */
    @Override
    public ResponseEntity<Void> reportParcelDelivery(String trackingId) {
        return ParcelApi.super.reportParcelDelivery(trackingId);
    }

    /**
     * POST /parcel/{trackingId}/reportHop/{code} : Report that a ParcelEntity has arrived at a certain hop either Warehouse or Truck.
     *
     * @param trackingId The tracking ID of the parcel. E.g. PYJRB4HZ6  (required)
     * @param code       The Code of the hop (Warehouse or Truck). (required)
     * @return Successfully reported hop. (status code 200)
     * or ParcelEntity does not exist with this tracking ID or hop with code not found.  (status code 404)
     * or The operation failed due to an error. (status code 400)
     */
    @Override
    public ResponseEntity<Void> reportParcelHop(String trackingId, String code) {
        return ParcelApi.super.reportParcelHop(trackingId, code);
    }

    /**
     * POST /parcel : Submit a new parcel to the logistics service.
     *
     * @param parcel (required)
     * @return Successfully submitted the new parcel (status code 201)
     * or The operation failed due to an error. (status code 400)
     * or The address of sender or receiver was not found. (status code 404)
     */
    @Override
    public ResponseEntity<NewParcelInfo> submitParcel(Parcel parcel) {
        return ParcelApi.super.submitParcel(parcel);
    }

    /**
     * GET /parcel/{trackingId} : Find the latest state of a parcel by its tracking ID.
     *
     * @param trackingId The tracking ID of the parcel. E.g. PYJRB4HZ6  (required)
     * @return ParcelEntity exists, here&#39;s the tracking information. (status code 200)
     * or The operation failed due to an error. (status code 400)
     * or ParcelEntity does not exist with this tracking ID. (status code 404)
     */
    @Override
    public ResponseEntity<TrackingInformation> trackParcel(String trackingId) {
        return ParcelApi.super.trackParcel(trackingId);
    }

    /**
     * POST /parcel/{trackingId} : Transfer an existing parcel into the system from the service of a logistics partner.
     *
     * @param trackingId The tracking ID of the parcel. E.g. PYJRB4HZ6  (required)
     * @param parcel     (required)
     * @return Successfully transitioned the parcel (status code 200)
     * or The operation failed due to an error. (status code 400)
     * or A parcel with the specified trackingID is already in the system. (status code 409)
     */
    @Override
    public ResponseEntity<NewParcelInfo> transitionParcel(String trackingId, Parcel parcel) {
        return ParcelApi.super.transitionParcel(trackingId, parcel);
    }
}
