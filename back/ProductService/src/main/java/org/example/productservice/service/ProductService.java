package org.example.productservice.service;

import org.example.productservice.dto.productDto.ProductDtoRequest;
import org.example.productservice.dto.productDto.ProductDtoResponse;
import org.example.productservice.model.Product;
import org.example.productservice.repository.ProductRepository;
import org.example.productservice.util.ProductMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDtoResponse createProduct(ProductDtoRequest productDtoRequest) {
        Product product = productMapper.mapToEntity(productDtoRequest);
        Product savedProduct = productRepository.save(product);
        return productMapper.mapToDto(savedProduct);
    }

    public ProductDtoResponse getProductById(long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return productMapper.mapToDto(product.get());
        } else {
            throw new RuntimeException("Produit non trouvé avec l'ID : " + id);
        }
    }

    public List<ProductDtoResponse> getAllProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();
        return products.stream()
                .map(productMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public ProductDtoResponse updateProduct(long id, ProductDtoRequest productDtoRequest) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product productToUpdate = existingProduct.get();
            productToUpdate.setName(productDtoRequest.getName());
            productToUpdate.setDescription(productDtoRequest.getDescription());
            productToUpdate.setPrice(productDtoRequest.getPrice());
            productToUpdate.setStock(productDtoRequest.getStock());
            productToUpdate.setCategorie(productDtoRequest.getCategorie());

            Product updatedProduct = productRepository.save(productToUpdate);
            return productMapper.mapToDto(updatedProduct);
        } else {
            throw new RuntimeException("Produit non trouvé avec l'ID : " + id);
        }
    }

    public void deleteProduct(long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException("Produit non trouvé avec l'ID : " + id);
        }
    }
}
