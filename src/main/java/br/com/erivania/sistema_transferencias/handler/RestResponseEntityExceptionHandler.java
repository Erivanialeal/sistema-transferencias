package br.com.erivania.sistema_transferencias.handler;

import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Getter
public class RestResponseEntityExceptionHandler {
    @ExceptionHandler(APIException.class)
    public ResponseEntity<ErrorApiResponse> handlerGeneric(APIException ex){
        return ex.buildErrorResponseEntity();
    }
}
