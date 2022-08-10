package com.czmud.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.czmud.safetravels.models.Expense;
import com.czmud.safetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService( ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public Expense createExpense( Expense expense ) {
		return expenseRepository.save( expense);
	}
	
	public Expense updateExpense( Expense expense ) {
		return expenseRepository.save( expense );
	}
	
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}
	
	public Expense findExpenseById( Long id ) {
		Optional<Expense> expense = expenseRepository.findById(id);
		if(expense.isPresent()) {
			return expense.get();
		}
		return null;
	}
	
	public void deleteExpenseById( Long id ) {
		expenseRepository.deleteById( id );
	}
}
