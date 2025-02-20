package com.example.controllers;

import com.example.services.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin-panel")
public class AdminController {

    private final ExpenseService expenseService;

    public AdminController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public String showAdminPanel(Model model) {
        model.addAttribute("expenses", expenseService.getAllExpenses());
        return "admin-panel";
    }

    @PostMapping("/validate/{id}")
    public String validateExpense(@PathVariable Long id) {
        expenseService.updateExpenseStatus(id, "VALIDE");
        return "redirect:/admin-panel";
    }

    @PostMapping("/invalidate/{id}")
    public String invalidateExpense(@PathVariable Long id) {
        expenseService.updateExpenseStatus(id, "INVALIDE");
        return "redirect:/admin-panel";
    }
}
