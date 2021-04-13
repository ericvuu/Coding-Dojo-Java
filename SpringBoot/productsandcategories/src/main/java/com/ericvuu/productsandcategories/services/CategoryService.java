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
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public List<Category>allCategories(){
		return categoryRepository.findAll();
	}
	
	public List<Category> filterCategoriesNotInAProduct(Long id){
		Optional<Product> product = productRepository.findById(id);
		List<Category> allCategories = categoryRepository.findAll();
		List<Category> returnedCategories = categoryRepository.findAll();
		List<Category> thisCategory = product.get().getCategories();
		
		for(Category category: allCategories) {
			if(thisCategory.contains(category)) {
				returnedCategories.remove(category);
			}
		}
		
		return returnedCategories;
	}
	
	public void addProductToCurrentService(Product product, Category category) {
		// get product list from category model using getter method
		List<Product> productsList = category.getProducts();
		// add category instance to list
		productsList.add(product);
		// set the new list to category class
		category.setProducts(productsList);
		// save category class
		categoryRepository.save(category);
	}

	
}
