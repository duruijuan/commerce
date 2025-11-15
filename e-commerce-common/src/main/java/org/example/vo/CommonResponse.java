package org.example.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author duruijuan
 * @version 1.0
 * @description:通用响应对象定义
 * {
 *     "code":0,
 *     "message":"",
 *     "data":{}
 * }
 * @date 2025-11-14 18:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> implements Serializable {
    /**
     * 错误码
     **/
    private Integer code;
    /**
     * 错误信息
     **/
    private String message;
    /**
     * 泛型响应数据
     **/
    private T Data;

    public CommonResponse(Integer code, String message) {
        this.code = code;
        this.message = message;

    }
}
