package com.taxicalls.passenger.services;

import com.taxicalls.passenger.model.Route;
import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author romulo
 */
@FeignClient(name = "routes")
public interface RoutesService {

    @RequestMapping(method = RequestMethod.GET, value = "/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Route> getRoutes();

}
