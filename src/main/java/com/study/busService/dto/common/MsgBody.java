package com.study.busService.dto.common;

import java.util.List;
import lombok.Getter;

@Getter
public class MsgBody<T> {
    private List<T> itemList;
}
