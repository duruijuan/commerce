package org.example.advice;

import cn.hutool.http.server.HttpServerRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author duruijuan
 * @version 1.0
 * @description: 全局异常捕获处理
 * @date 2025-11-15 16:43
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(value = Exception.class)
    public CommonResponse<String> handlerCommerceException(HttpServerRequest request,Exception exception){
        CommonResponse<String > response=new CommonResponse<>(-1,"business error");
        response.setData(exception.getMessage());
        log.error("commerce service has error:[{}]",exception.getMessage(),exception);
        return response;
    }
}
