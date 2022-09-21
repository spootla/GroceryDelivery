package com.groceryDelivery.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.groceryDelivery.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long>{

}


