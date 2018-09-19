package com.ypacm.user.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.bind.ValidationException;
import java.net.BindException;
/**
 * Created by pyystone on 16/11/24.
 * email: pyystone@163.com
 * QQ: 862429936
 * github: https://github.com/pyystone
 * code shelf life : forever :-D
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ErrorInfo handleBindException(BindException e) {
        ErrorInfo info = new ErrorInfo();
        info.setCode(ErrorInfo.ERROR);
        info.setMessage(e.getMessage());
        return info;
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public ErrorInfo handleBindException(ValidationException e) {
        ErrorInfo info = new ErrorInfo();
        info.setCode(ErrorInfo.ERROR);
        info.setMessage(e.getMessage());
        return info;
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ErrorInfo handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ErrorInfo info = new ErrorInfo();
        info.setCode(ErrorInfo.ERROR);
        info.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return info;
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorInfo handleException(Exception e) {
        ErrorInfo info = new ErrorInfo();
        info.setCode(ErrorInfo.ERROR);
        info.setMessage("非法请求");
        return info;
    }
}
