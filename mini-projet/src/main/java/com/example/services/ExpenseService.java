package com.example.services;

import com.example.models.Expense;
import com.example.repositories.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getExpensesByUtilisateur(Long userId) {
        return expenseRepository.findByUtilisateurId(userId);
    }

    public void saveExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public void updateExpenseStatus(Long id, String status) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
        expense.setStatus(status);
        expenseRepository.save(expense);
    }
}
