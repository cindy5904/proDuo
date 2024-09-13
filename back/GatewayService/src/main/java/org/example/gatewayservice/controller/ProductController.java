package org.example.gatewayservice.controller;

import org.example.gatewayservice.dto.ProductDto.ProductDtoResponse;
import org.example.gatewayservice.tools.RestClient;
import org.example.gatewayservice.utils.PortApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/products")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class ProductController {
    @GetMapping("")
    public ResponseEntity<List<ProductDtoResponse>> getAllComment (){
        RestClient<ProductDtoResponse[]> productRestCLient = new RestClient<>("http://localhost:"+ PortApi.portProduct +"/api/products");
        List<ProductDtoResponse> productDtoResponses = Arrays.stream(productRestCLient.getRequest(ProductDtoResponse[].class)).toList();
        return new ResponseEntity<>(productDtoResponses, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDtoResponse> getCommentById (@PathVariable String id){
        RestClient<ProductDtoResponse> productRestCLient = new RestClient<>("http://localhost:"+ PortApi.portProduct +"/api/products/"+id);
        ProductDtoResponse productDtoResponse = productRestCLient.getRequest(ProductDtoResponse.class);
        return new ResponseEntity<>(productDtoResponse, HttpStatus.OK);
    }

}
