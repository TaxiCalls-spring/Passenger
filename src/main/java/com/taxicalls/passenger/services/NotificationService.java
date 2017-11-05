package com.taxicalls.passenger.services;

import com.taxicalls.passenger.resources.ChooseDriverRequest;
import com.taxicalls.protocol.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author romulo
 */
@FeignClient(name = "notification")
public interface NotificationService {

    @RequestMapping(method = RequestMethod.POST, value = "/drivers")
    public Response chooseDriver(ChooseDriverRequest chooseDriverRequest);

}
