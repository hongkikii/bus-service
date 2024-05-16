package com.study.busService.controller;

import com.study.busService.dto.ItemByRouteId;
import com.study.busService.dto.ItemByVehicle;
import com.study.busService.dto.ItemInStopSection;
import com.study.busService.dto.common.BusLocationResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bus/location")
public class BusLocationController {

    private final RestTemplate restTemplate;
    private final String apiUrl;

    public BusLocationController(RestTemplate restTemplate, @Value("${bus.location.api.url}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    @GetMapping("/stop-section")
    public BusLocationResponse<ItemInStopSection> getInStopSection(@RequestParam @NotBlank String serviceKey,
                                                                   @RequestParam @NotBlank @Size(max = 9) String busRouteId,
                                                                   @RequestParam @NotBlank @Size(max = 10) String startOrd,
                                                                   @RequestParam @NotBlank @Size(max = 10) String endOrd) {

        // TODO : 메서드 추출
        return restTemplate.getForObject(
                apiUrl +
                        "/getBusPosByRouteSt" +
                        "?ServiceKey={servicekey}&busRouteId={busRouteId}&startOrd={startOrd}&endOrd={endOrd}" +
                        "&resultType=json",
                BusLocationResponse.class,
                serviceKey, busRouteId, startOrd, endOrd);
    }

    @GetMapping("/route-id")
    public BusLocationResponse<ItemByRouteId> getBy(@RequestParam @NotBlank String serviceKey,
                                                    @RequestParam @NotBlank @Size(max = 9) String busRouteId,
                                                    @RequestParam(required = false) @Size(max = 4) String resultType) {
        return restTemplate.getForObject(
                apiUrl +
                        "/getBusPosByRtid" +
                        "?ServiceKey={serviceKey}&busRouteId={busRouteId}" +
                        "&resultType=json",
                BusLocationResponse.class,
                serviceKey, busRouteId, resultType);
    }

//    @GetMapping
//    public BusLocationResponse<ItemByVehicle> getBy() {
//
//    }

}
