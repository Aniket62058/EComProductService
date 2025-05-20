package com.aniket.EcomProductService.controller.controllerAdvice;

import com.aniket.EcomProductService.dto.ErrorResponseDTO;
import com.aniket.EcomProductService.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleProductNotFound(Exception e){
        ErrorResponseDTO errorResponseDTO= new ErrorResponseDTO();
        errorResponseDTO.setMessage(e.getMessage());
        errorResponseDTO.setMessageCode(404);
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }
}
