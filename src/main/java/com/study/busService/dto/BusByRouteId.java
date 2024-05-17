package com.study.busService.dto;

import com.study.busService.dto.common.Bus;

public class BusByRouteId extends Bus {
    private String sectOrd; // StopSecton, RouteId
    private String fullSectDist;
    private String sectDist; // StopSection, RouteId
    private String rtDist;
    private String sectionId; // StopSection, RouteId
    private String gpsX;
    private String gpsY;
    private String lastStTm;
    private String nextStTm;
    private String nextStId;
    private String trnstnId;
    private String isrunyn;
    private String islastyn;
}
