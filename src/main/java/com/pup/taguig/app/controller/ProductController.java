package com.pup.taguig.app.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pup.taguig.app.dto.PagedResponseDTO;
import com.pup.taguig.app.dto.ProductRequestDTO;
import com.pup.taguig.app.dto.ProductResponseDTO;
import com.pup.taguig.app.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
	private ProductService productService;

    @PostMapping("/")
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO request) {

    		ProductResponseDTO result = null;

        if (Objects.nonNull(request)) {
            result = productService.createProduct(request);
        }

        return result;
    }

    @GetMapping("/")
    public PagedResponseDTO<ProductResponseDTO> listProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0") int size) {

        PagedResponseDTO<ProductResponseDTO> result = null;

        if (Objects.nonNull(page) && Objects.nonNull(size)) {
            result = productService.listProducts(page, size);
        }

        return result;
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(@PathVariable Long id) {

        if (Objects.nonNull(id)) {
            return productService.getProductById(id);
        }

        return null;
    }

}
