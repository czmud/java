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

import com.czmud.productsandcategories.models.Category;
import com.czmud.productsandcategories.services.CategoryService;
import com.czmud.productsandcategories.services.ProductService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	
	@GetMapping("new")
	public String newCategoryForm( Model model ) {
		
		model.addAttribute("newCategory", new Category() );
		
		return "categoryform.jsp";
	}
	
	@PostMapping("/create-new-category")
	public String createNewCategory( @Valid @ModelAttribute("newCategory") Category newCategory,
									 BindingResult bindingResult ) {
		
		if( bindingResult.hasErrors() ) {
			return "categoryform.jsp";
		}
		
		categoryService.saveNewCategory( newCategory );
		
		return "redirect:/";
	}
	
	@GetMapping("{categoryId}")
	public String viewCategory( @PathVariable("categoryId") Long categoryId,
								Model model ) {
		
		Category viewCategory = categoryService.getCategoryById( categoryId );
		
		if( viewCategory == null ) {
			return "redirect:/";
		}
		
		model.addAttribute("category", viewCategory );
		model.addAttribute("productsToUpdate", productService.getProductsNotInCategory( categoryId ));
		
		return "categoryview.jsp";
		
	}
	
	@PostMapping("/add-to-product/{categoryId}")
	public String addCategoryToProduct( @PathVariable("categoryId") Long categoryId,
				  						@RequestParam("productId") Long productId ) {
		
		productService.addCategoryToProduct( categoryId, productId );
		
		return "redirect:/categories/"+categoryId;
	}
}
