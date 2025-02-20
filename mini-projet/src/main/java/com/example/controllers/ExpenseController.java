package com.example.controllers;

import com.example.models.Expense;
import com.example.models.Utilisateur;
import com.example.repositories.UtilisateurRepository;
import com.example.services.CustomUtilisateurDetails;
import com.example.services.ExpenseService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseService expenseService;
    private final UtilisateurRepository utilisateurRepository;

    public ExpenseController(ExpenseService expenseService, UtilisateurRepository utilisateurRepository) {
        this.expenseService = expenseService;
        this.utilisateurRepository = utilisateurRepository;
    }

    @GetMapping
    public String showExpenseForm(Model model, @AuthenticationPrincipal CustomUtilisateurDetails userDetails) {
        model.addAttribute("expense", new Expense());

        if (userDetails != null) {
            List<Expense> expenses = expenseService.getExpensesByUtilisateur(userDetails.getId());
            model.addAttribute("expenses", expenses);
        } else {
            model.addAttribute("expenses", List.of());
        }

        return "expense";
    }

    @PostMapping
    public String submitExpense(@ModelAttribute Expense expense,
            @AuthenticationPrincipal CustomUtilisateurDetails userDetails) {
        if (userDetails != null) {
            Utilisateur user = utilisateurRepository.findById(userDetails.getId())
                    .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

            expense.setUtilisateur(user);

            if (expense.getFraisTransportTrain() == null) {
                expense.setFraisTransportTrain(0.0);
            }
            if (expense.getFraisTransportAvion() == null) {
                expense.setFraisTransportAvion(0.0);
            }
            if (expense.getFraisTransportBus() == null) {
                expense.setFraisTransportBus(0.0);
            }
            if (expense.getFraisTransportVoiture() == null) {
                expense.setFraisTransportVoiture(0.0);
            }
            if (expense.getFraisHebergementHotel() == null) {
                expense.setFraisHebergementHotel(0.0);
            }
            if (expense.getFraisHebergementAirbnb() == null) {
                expense.setFraisHebergementAirbnb(0.0);
            }
            if (expense.getFraisRestauration() == null) {
                expense.setFraisRestauration(0.0);
            }

            expense.setStatus("EN_ATTENTE");

            expenseService.saveExpense(expense);
        } else {
            throw new RuntimeException("Utilisateur non authentifié");
        }
        return "redirect:/expense";
    }
}
