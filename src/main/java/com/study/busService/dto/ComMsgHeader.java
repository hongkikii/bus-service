package com.study.busService.dto;

import lombok.Getter;

@Getter
public class ComMsgHeader {
   private String errMsg;
   private String responseTime;
   private String responseMsgID;
   private String requestMsgID;
   private String returnCode;
   private String successYN;
}
