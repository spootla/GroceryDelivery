package com.groceryDelivery.service;

import java.util.List;

import com.groceryDelivery.entity.Product;
import com.groceryDelivery.entity.ProductDTO;
import com.groceryDelivery.exception.ProductNotFoundException;

public interface ProductService {
	
	public Product addProduct(Product product);
    public Product updateProduct(ProductDTO productDTO) throws ProductNotFoundException;
    public String deleteProductById(Long productId) throws ProductNotFoundException;
    public Product getProductById(Long productId) throws ProductNotFoundException;
    public List<Product> getAllProducts();
	
}
