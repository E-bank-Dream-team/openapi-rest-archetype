package ${package}.extapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ${package}.autogenerated.dto.RestDateTimeServiceResponseDto;

@FeignClient(name = "rest-date-time", url = "${service.rest-date-time.url}")
public interface RestDateTimeClient {

    @RequestMapping(method = RequestMethod.GET, path = "/api/v1/dateTime", consumes = "application/json")
    RestDateTimeServiceResponseDto getDateTime();
}
