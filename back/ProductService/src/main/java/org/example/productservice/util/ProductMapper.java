package org.example.productservice.util;

import org.example.productservice.dto.productDto.ProductDtoRequest;
import org.example.productservice.dto.productDto.ProductDtoResponse;
import org.example.productservice.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private final ModelMapper mapper;

    @Autowired
    public ProductMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }


    public ProductDtoResponse mapToDto(Product product) {
        return mapper.map(product, ProductDtoResponse.class);
    }


    public Product mapToEntity(ProductDtoRequest productDtoRequest) {
        return mapper.map(productDtoRequest, Product.class);
    }
}

