package com.taxicalls.passenger.services;

import com.taxicalls.passenger.model.Route;
import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author romulo
 */
@FeignClient(name = "routes")
public interface RoutesService {

    @RequestMapping(method = RequestMethod.GET, value = "/routes")
    public List<Route> getRoutes();

    @RequestMapping(method = RequestMethod.POST, value = "/available")
    public List<Route> getAvailableRoutes(Route route);

}
