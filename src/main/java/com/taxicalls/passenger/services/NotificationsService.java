package com.taxicalls.passenger.services;

import com.taxicalls.passenger.model.Route;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author romulo
 */
@FeignClient(name = "notifications")
public interface NotificationsService {

    @RequestMapping(method = RequestMethod.POST, value = "/chooseDriver")
    public void chooseDriver(Route route);

}
