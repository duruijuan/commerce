package org.example.advice;

import org.example.annotation.IgnoreResponseAdvice;
import org.example.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author duruijuan
 * @version 1.0
 * @description: 实现统一响应
 * @date 2025-11-15 16:28
 */
@RestControllerAdvice(value = "org.example")
@SuppressWarnings("all")
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {
    /**
     * @description:判断是否需要对响应进行处理
     * @author: duruijuan
     * @date: 2025-11-15 16:32
     * @param:  * @param methodParameter
     * @param aClass
     * @return: {@link boolean}
     **/
    @Override
    @SuppressWarnings("all")
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
       if(methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class))
       {
           return false;
       }
       if(methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)){
           return false;
       }
       return true;
    }

    @Override
    @SuppressWarnings("all")
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //定义最终返回的对象
        CommonResponse<Object> response=new CommonResponse<>(0,"");
        if(null==o){
            return response;
        }else if(o instanceof CommonResponse){
            response=(CommonResponse<Object>) o;
        }else {
            response.setData(o);
        }

        return null;
    }
}
