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
        return callOutBusApi(apiUrl +
                "/getBusPosByRouteSt" +
                "?ServiceKey={servicekey}&busRouteId={busRouteId}&startOrd={startOrd}&endOrd={endOrd}" +
                "&resultType=json", serviceKey, busRouteId, startOrd, endOrd);
    }

    @GetMapping("/route-id")
    public BusLocationResponse<ItemByRouteId> getByRouteId(@RequestParam @NotBlank String serviceKey,
                                                           @RequestParam @NotBlank @Size(max = 9) String busRouteId) {

        return callOutBusApi(apiUrl +
                "/getBusPosByRtid" +
                "?ServiceKey={serviceKey}&busRouteId={busRouteId}" +
                "&resultType=json", serviceKey, busRouteId);
    }

    @GetMapping("/vehicle")
    public BusLocationResponse<ItemByVehicle> getByVehId(@RequestParam @NotBlank String serviceKey,
                                                         @RequestParam @NotBlank @Size(max = 9) String vehId) {
        return callOutBusApi(apiUrl +
                "/getBusPosByVehId" +
                "?ServiceKey={serviceKey}&vehId={vehId}" +
                "&resultType=json", serviceKey, vehId);
    }

    @GetMapping("/stop-section/low")
    public BusLocationResponse<ItemInStopSection> getLowInStopSection(@RequestParam @NotBlank String serviceKey,
                                                                      @RequestParam @NotBlank @Size(max = 9) String busRouteId,
                                                                      @RequestParam @NotBlank @Size(max = 10) String startOrd,
                                                                      @RequestParam @NotBlank @Size(max = 10) String endOrd) {
        return callOutBusApi(apiUrl +
                "/getLowBusPosByRouteSt" +
                "?ServiceKey={servicekey}&busRouteId={busRouteId}&startOrd={startOrd}&endOrd={endOrd}" +
                "&resultType=json", serviceKey, busRouteId, startOrd, endOrd);
    }

    @GetMapping("/route-id/low")
    public BusLocationResponse<ItemByRouteId> getLowByRouteId(@RequestParam @NotBlank String serviceKey,
                                                              @RequestParam @NotBlank @Size(max = 9) String busRouteId) {
        return callOutBusApi(apiUrl +
                "/getLowBusPosByRtid" +
                "?ServiceKey={serviceKey}&busRouteId={busRouteId}" +
                "&resultType=json", serviceKey, busRouteId);
    }

    private BusLocationResponse callOutBusApi(String apiUrl, Object... urlVariables) {
        return restTemplate.getForObject(apiUrl, BusLocationResponse.class, urlVariables);
    }
}
