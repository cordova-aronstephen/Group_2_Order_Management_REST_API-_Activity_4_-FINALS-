package com.pup.taguig.app.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.pup.taguig.app.model.Product;

@Mapper
public interface ProductMapper {
	
	public void insertProduct(Product product);
	public Product findById(Long id);
	public List<Product> findAllProducts();
	public int countAllProducts();
	public void decreaseStock(@Param("productId") Long productId,
							 @Param("quantity") int quantity);
	
}
