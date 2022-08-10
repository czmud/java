package com.czmud.safetravels.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czmud.safetravels.models.Expense;
import com.czmud.safetravels.services.ExpenseService;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
	private final ExpenseService expenseService;
	
	public ExpenseController( ExpenseService expenseService ) {
		this.expenseService = expenseService;
	}
	
	
	@GetMapping("")
	public String index( @ModelAttribute("expense") Expense expense, 
						Model model ){
		
		List<Expense> expenses = expenseService.allExpenses();
		
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@GetMapping("/{expenseId}")
	public String showExpense( Model model,
								@PathVariable("expenseId") Long expenseId ) {
		
		model.addAttribute("expense", expenseService.findExpenseById( expenseId ));
		
		return "showexpense.jsp"; 
	}
	
	@GetMapping("/edit/{expenseId}")
	public String editExpense( @ModelAttribute("expense") Expense expense, 
							  Model model,
							  @PathVariable("expenseId") Long expenseId ) {
		
		model.addAttribute("expense", expenseService.findExpenseById( expenseId ));
		
		return "editexpense.jsp";
	}
	
	@PostMapping("/add-new-expense")
	public String addNewExpense( @Valid @ModelAttribute("expense") Expense expense,
								 BindingResult bindingResult,
								 Model model,
								 HttpSession session) {
		
		if( bindingResult.hasErrors() ) {
			model.addAttribute("expenses", expenseService.allExpenses());
			return "index.jsp";
		}
		
		expenseService.createExpense( expense );
		
		return "redirect:/expenses";
	}
	
	@DeleteMapping("/delete-expense/{expenseId}")
	public String destroy( @PathVariable("expenseId") Long id) {
		expenseService.deleteExpenseById( id );
		return "redirect:/expenses";
	}
	
	@PutMapping("/update-expense/{expenseId}")
	public String updateExpenseById( @Valid @ModelAttribute("expense") Expense expense,
			 						BindingResult bindingResult,
			 						@PathVariable("expenseId") Long expenseId) {
		
		if( bindingResult.hasErrors() ) {
			return "editexpense.jsp";
		}
		
		expense.setId(expenseId);
		expenseService.updateExpense( expense );
		
		return "redirect:/expenses";
	}
}
