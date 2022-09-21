package com.groceryDelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.groceryDelivery.entity.Product;
import com.groceryDelivery.entity.ProductDTO;
import com.groceryDelivery.exception.ProductNotFoundException;
import com.groceryDelivery.repository.ProductDao;
import com.groceryDelivery.service.ProductService;
@RestController
	@RequestMapping(value = "/product")
	@CrossOrigin(value="http://localhost:4200/")
	public class ProductController {

	@Autowired
	private ProductService productService; 
	
	@PostMapping("product")
	public Product addUser(@RequestBody ProductDTO productDTO) {
		Product product=new Product(null,productDTO.getName(),productDTO.getDescription(),productDTO.getPrice(),productDTO.getPictureUrl(),null);
		System.out.println(product);
		System.out.println(productDTO);
		return this.productService.addProduct(product);
	}
	
	@PutMapping("product")
	public Product updateMember(@RequestBody ProductDTO productDTO) throws ProductNotFoundException{
		return this.productService.updateProduct(productDTO);
	}
	
	@DeleteMapping("product/{productId}")
	public String deleteProductById(@PathVariable("productId") Long productId) throws ProductNotFoundException {
		return this.productService.deleteProductById(productId);
		}
	
	@GetMapping("product/{productId}")
	public Product getProductById(@PathVariable("productId") Long productId) throws ProductNotFoundException {
		return this.productService.getProductById(productId);
	}
	@GetMapping("products")
	public List<Product> getAllProducts(){
		return  this.productService.getAllProducts();
	}

}


