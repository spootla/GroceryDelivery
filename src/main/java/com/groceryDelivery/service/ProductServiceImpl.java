package com.groceryDelivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.groceryDelivery.entity.Product;
import com.groceryDelivery.entity.ProductDTO;
import com.groceryDelivery.exception.ProductNotFoundException;
import com.groceryDelivery.repository.ProductDao;

@Service
public class ProductServiceImpl  implements ProductService{
	
	 @Autowired
	 private ProductDao productDao;

	@Override
	public Product addProduct(Product product) {
		return this.productDao.save(product);	
		}

	@Override
	public Product updateProduct(ProductDTO productDTO) throws ProductNotFoundException {

		Optional<Product> productOpt=this.productDao.findById(productDTO.getId());
		if(productOpt.isEmpty())
			throw new ProductNotFoundException("Product id does not Exist");
		
		Product updateProduct=productOpt.get();
		updateProduct.setName(productDTO.getName());
		updateProduct.setDescription(productDTO.getDescription());
		updateProduct.setPrice(productDTO.getPrice());
		updateProduct.setPictureUrl(productDTO.getPictureUrl());
		return this.productDao.save(updateProduct);
	}

	@Override
	public String deleteProductById(Long productId) throws ProductNotFoundException {
		Optional<Product> productOpt=this.productDao.findById(productId);
		if(productOpt.isEmpty())
			throw new ProductNotFoundException("Product id not exist to delete");
		this.productDao.deleteById(productId);
        return "productId deleted successfully";
	}

	@Override
	public Product getProductById(Long productId)  throws ProductNotFoundException {
		Optional<Product> productOpt=this.productDao.findById(productId);
        if(productOpt.isEmpty())
            throw new ProductNotFoundException("Product Not Found");
        return productOpt.get();
	}

	@Override
	public List<Product> getAllProducts() {
		return this.productDao.findAll();
	}

	
}
