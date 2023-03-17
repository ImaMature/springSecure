package com.cos.model.dto.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor(staticName = "of")
public class ResultDto<D> {
    private final String resultCode;
    private final String msg;
    private final D data;
    public static <D> ResultDto<D> ofSuccess(String msg, D data) {
        return new ResultDto<>("SUCCESS", msg, data);
    }
    public static <D> ResultDto<D> ofFail(String msg) {
        return new ResultDto<>("FAIL", msg, null);
    }
}
