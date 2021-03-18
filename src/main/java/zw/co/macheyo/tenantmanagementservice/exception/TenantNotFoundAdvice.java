package zw.co.macheyo.tenantmanagementservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TenantNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(TenantNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String tenantNotFoundHandler(TenantNotFoundException ex){
        return ex.getMessage();
    }
}
