package com.pup.taguig.app.service;

import com.pup.taguig.app.dto.PagedResponseDTO;
import com.pup.taguig.app.dto.ProductRequestDTO;
import com.pup.taguig.app.dto.ProductResponseDTO;

public interface ProductService {
	
	public ProductResponseDTO createProduct(ProductRequestDTO request);
    public PagedResponseDTO<ProductResponseDTO> listProducts(int page, int size);
    public ProductResponseDTO getProductById(Long id);
    
}
