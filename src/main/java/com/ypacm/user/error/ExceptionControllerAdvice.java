package com.ypacm.user.error;

import com.ypacm.user.model.responsebody.RSData;
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
    @ExceptionHandler(UserException.class)
    @ResponseBody
    public RSData handleUserException(UserException e) {
        return new RSData(e.getCode(),e.getMessage());
    }


    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public RSData handleBindException(BindException e) {
        return new RSData(RSData.ERROR,e.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public RSData handleBindException(ValidationException e) {
        return new RSData(RSData.ERROR,e.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public RSData handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new RSData(RSData.ERROR,e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RSData handleException(Exception e) {
        return new RSData(RSData.ERROR,"非法请求");
    }
}
