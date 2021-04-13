package com.ericvuu.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericvuu.productsandcategories.models.Category;
import com.ericvuu.productsandcategories.models.Product;
import com.ericvuu.productsandcategories.repositories.CategoryRepository;
import com.ericvuu.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	public List<Product>allProducts(){
		return productRepository.findAll();
	}
	
	public List<Product> filterProductsNotInACategory(Long category_id){
		Optional<Category> category = categoryRepository.findById(category_id);
		List<Product> allproducts = productRepository.findAll();
		List<Product> returnedProducts = productRepository.findAll();
		List<Product> thisproduct = category.get().getProducts();
		
		for(Product product: allproducts) {
			if(thisproduct.contains(product)) {
				returnedProducts.remove(product);
			}
		}
		
		return returnedProducts;
	}
	
	public void addCategoryToCurrentProduct(Category category, Product product) {
		// get category list from product model using getter method
		List<Category> categoriesList = product.getCategories();
		// add category instance to list
		categoriesList.add(category);
		// set the new list to product class
		product.setCategories(categoriesList);
		// save product class
		productRepository.save(product);
	}

}
