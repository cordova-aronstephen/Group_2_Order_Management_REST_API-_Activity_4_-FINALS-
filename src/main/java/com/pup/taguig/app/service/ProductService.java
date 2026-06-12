package com.pup.taguig.app.service;

import com.pup.taguig.app.dto.PagedResponseDTO;
import com.pup.taguig.app.dto.ProductRequestDTO;
import com.pup.taguig.app.dto.ProductResponseDTO;

public interface ProductService {
	
	ProductResponseDTO createProduct(ProductRequestDTO request);
    PagedResponseDTO<ProductResponseDTO> listProducts(int page, int size);
    ProductResponseDTO getProductById(Long id);
    
}
