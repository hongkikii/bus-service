package com.study.busService.dto.common;

import lombok.Getter;

@Getter
public class BusLocationResponse<T> {
    private ComMsgHeader comMsgHeader;
    private MsgHeader msgHeader;
    private MsgBody<T> msgBody;
}
