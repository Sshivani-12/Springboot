package com.miccroservice.user.service.UserService.external;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {

}
