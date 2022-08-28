package com.xu.ggkt.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义异常
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GgktException extends RuntimeException {
    private Integer code;
    private String msg;
}
