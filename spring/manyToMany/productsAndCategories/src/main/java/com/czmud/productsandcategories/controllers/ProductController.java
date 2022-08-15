package com.czmud.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.czmud.productsandcategories.models.Product;
import com.czmud.productsandcategories.services.CategoryService;
import com.czmud.productsandcategories.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/new")
	public String newProductForm( Model model ) {
		
		model.addAttribute("newProduct", new Product());
		
		return "productform.jsp";
	}
	
	@PostMapping("/create-new-product")
	public String createNewProduct( @Valid @ModelAttribute("newProduct") Product newProduct,
									BindingResult bindingResult) {
		
		if( bindingResult.hasErrors() ) {
			return "productform.jsp";
		}
		
		productService.saveNewProduct( newProduct );
		
		return "redirect:/";
	}
	
	@GetMapping("{productId}")
	public String viewProduct( @PathVariable("productId") Long productId, 
							   Model model ) {
		
		Product viewProduct = productService.getProductById( productId );
		
		if( viewProduct == null ) {
			return "redirect:/";
		}
		
		model.addAttribute("product", viewProduct );
		model.addAttribute( "categoriesToAdd", categoryService.getCategoriesNotInProduct( productId ) );
		
		return "productview.jsp";
	}
	
	@PostMapping("/add-category/{productId}")
	public String addCategoryToProduct( @PathVariable("productId") Long productId,
										@RequestParam("categoryId") Long categoryId) {
		
		productService.addCategoryToProduct( categoryId, productId );
		
		return "redirect:/products/"+productId;
	}
}
