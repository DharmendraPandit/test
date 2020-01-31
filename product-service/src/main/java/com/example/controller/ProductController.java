package com.example.controller;

import com.example.exception.ProductException;
import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService service;

    @ExceptionHandler(ProductException.class)
    void handleUserException(ProductException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @PostMapping("search")
    private ResponseEntity<?> search(@RequestBody Product product) {
        return new ResponseEntity<>(service.search(product), HttpStatus.OK);
    }
}
