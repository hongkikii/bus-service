package com.study.busService.dto;

import lombok.Getter;

@Getter
public class LocationResponse {
    private ComMsgHeader comMsgHeader;
    private MsgHeader msgHeader;
    private MsgBody msgBody;
}
