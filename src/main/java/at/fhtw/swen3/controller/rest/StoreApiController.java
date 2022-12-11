package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.StoreApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-18T00:22:09.916911Z[Etc/UTC]")
@Controller
public class StoreApiController implements StoreApi {

    private final NativeWebRequest request;

    @Autowired
    public StoreApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
