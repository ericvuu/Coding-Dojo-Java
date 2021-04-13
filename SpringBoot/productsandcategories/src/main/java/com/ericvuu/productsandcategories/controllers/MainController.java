package com.ericvuu.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ericvuu.productsandcategories.models.Category;
import com.ericvuu.productsandcategories.models.Product;
import com.ericvuu.productsandcategories.services.CategoryService;
import com.ericvuu.productsandcategories.services.ProductService;

@Controller
public class MainController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/")
	public String redirect() {
		return "redirect:/products/new";
	}
	
	@RequestMapping("/products/new")
	public String productForm(@ModelAttribute("product") Product product) {
		return "new_product.jsp";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "new_product.jsp";
		} else {
			productService.addProduct(product);
			return "redirect:/products/new";
		}
	}
	
	@RequestMapping("/categories/new")
	public String categoriesForm(@ModelAttribute("category") Category category) {
		return "new_category.jsp";
	}
	
	@RequestMapping("/addCategory")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "new_category.jsp";
		} else {
			categoryService.addCategory(category);
			return "redirect:/categories/new";
		}
	}
	
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, @ModelAttribute("category") Category category, Model model) {
		Product product = productService.findProduct(id);
		List<Category> filteredCategories = categoryService.filterCategoriesNotInAProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("filteredCategories", filteredCategories);
		return "show_product.jsp";
	}
	
	@RequestMapping(value="/addToProduct/{id}", method=RequestMethod.POST)
	public String addCategoryToProduct(@PathVariable("id") Long id , @Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("There is an error with the form input");
			return "redirect/products/" + id;
		} else {
			Product product = productService.findProduct(id);
			Long longConvert = Long.parseLong(category.getName());
			Category cat = categoryService.findCategory(longConvert);
			productService.addCategoryToCurrentProduct(cat, product);
			return "redirect:/products/" + id;
		}
	}
	
	@RequestMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, @ModelAttribute("product") Product product, Model model) {
		Category category = categoryService.findCategory(id);
		List<Product> filteredProducts = productService.filterProductsNotInACategory(id);
		model.addAttribute("category", category);
		model.addAttribute("filteredProducts", filteredProducts);
		return "show_category.jsp";
	}

	@RequestMapping(value="/addToCategory/{id}", method=RequestMethod.POST)
	public String addProductToCategory(@PathVariable("id") Long id , @Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("There is an error with the form input");
			return "redirect/category/" + id;
		} else {
			Category category = categoryService.findCategory(id);
			Long longConvert = Long.parseLong(product.getName());
			Product prod = productService.findProduct(longConvert);
			categoryService.addProductToCurrentService(prod, category);
			return "redirect:/products/" + id;
		}
	}

	
}



