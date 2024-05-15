package com.study.busService.controller;

import com.study.busService.dto.LocationResponse;
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
public class LocationController {

    private final RestTemplate restTemplate;
    private final String apiUrl;

    public LocationController(RestTemplate restTemplate, @Value("${bus.location.api.url}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    @GetMapping
    public LocationResponse getByRouteIdAndSectionInfo(@RequestParam @NotBlank String serviceKey,
                                                       // TODO : 노선 -> 노선 ID 매핑
                                                       @RequestParam @NotBlank @Size(max = 9) String busRouteId,
                                                       @RequestParam @NotBlank @Size(max = 10) String startOrd,
                                                       @RequestParam @NotBlank @Size(max = 10) String endOrd,
                                                       // ToDo : enum [xml, json]으로 변경
                                                       @RequestParam(required = false) @Size(max = 4) String resultType) {

        if (resultType == null) {
            resultType = "json";
        }
        LocationResponse locationResponse = restTemplate.getForObject(
                apiUrl +
                        "/getBusPosByRouteSt" +
                        "?ServiceKey={servicekey}&busRouteId={busRouteId}" +
                        "&startOrd={startOrd}&endOrd={endOrd}&resultType={resultType}",
                LocationResponse.class,
                serviceKey, busRouteId, startOrd, endOrd, resultType);

        System.out.println(locationResponse.toString());
        return locationResponse;
    }
}
