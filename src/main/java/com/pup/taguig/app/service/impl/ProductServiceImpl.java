package com.pup.taguig.app.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pup.taguig.app.dto.PagedResponseDTO;
import com.pup.taguig.app.dto.ProductRequestDTO;
import com.pup.taguig.app.dto.ProductResponseDTO;
import com.pup.taguig.app.model.Product;
import com.pup.taguig.app.repository.ProductMapper;
import com.pup.taguig.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = LogManager.getLogger(ProductServiceImpl.class);
	
	@Autowired
    private ProductMapper productMapper;
	
	@Override
	public ProductResponseDTO createProduct(ProductRequestDTO request) {
		
		LOGGER.info("Enter createProduct");

        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());

        productMapper.insertProduct(product);

        LOGGER.info("End createProduct");
        
        return this.toDTO(product);
	}

	@Override
	public PagedResponseDTO<ProductResponseDTO> listProducts(int page, int size) {
		LOGGER.info("Enter listProducts");

        int total = productMapper.countAllProducts();

        List<Product> products;
        int totalPages;

        if (size > 0) {
            int offset = page * size;
            products   = productMapper.findProductsPaged(offset, size);
            totalPages = (int) Math.ceil((double) total / size);
        } else {
            products   = productMapper.findAllProducts();
            totalPages = 1;
        }

        List<ProductResponseDTO> content = products.stream()
                .map(product -> new ProductResponseDTO(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getStock()
                ))
                .toList();

        LOGGER.info("End listProducts");

        PagedResponseDTO<ProductResponseDTO> response = new PagedResponseDTO<>();
        response.setContent(content);
        response.setPage(page);
        response.setSize(size);
        response.setTotalElements(total);
        response.setTotalPages(totalPages);
        response.setLast(size > 0 ? page >= totalPages - 1 : true);

        return response;
	}

	@Override
	public ProductResponseDTO getProductById(Long id) {
		LOGGER.info("Enter getProductById");

        Product product = productMapper.findById(id);

        if (product == null) {
            throw new IllegalArgumentException("Product not found: ID " + id);
        }

        LOGGER.info("End getProductById");
        return this.toDTO(product);
    }

    private ProductResponseDTO toDTO(Product product) {

        ProductResponseDTO responseDTO = new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock()
        );

        return responseDTO;
	}

}
