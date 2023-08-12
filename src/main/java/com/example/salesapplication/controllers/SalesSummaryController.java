package com.example.salesapplication.controllers;

import com.example.salesapplication.models.Items;
import com.example.salesapplication.models.Sales;
import com.example.salesapplication.services.ItemService;
import com.example.salesapplication.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class SalesSummaryController {

    private final SalesService salesService;
    private final ItemService itemService;

    @Autowired
    public SalesSummaryController(SalesService salesService, ItemService itemService) {
        this.salesService = salesService;
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String showAllSales(Model model) {
        //Get all sales
        List<Sales> salesList = salesService.getAllSales();
        model.addAttribute("sales", salesList);

        //Get all items to populate box
        List<Items> itemsList = itemService.getAllItems();
        model.addAttribute("items", itemsList);
        System.out.println(itemsList);

        return "sales_summary";
    }


    // Currently not working... issue with date parsing
    @PostMapping("/add-sale")
    public String addSale(@ModelAttribute("saleForm") @DateTimeFormat(pattern = "yyyy-MM-dd") Sales salesForm) {

        salesService.addOne(salesForm);

        return "redirect:/"; // Redirect to the sales page
    }

    @GetMapping("/edit-sale/{id}")
    public String showEditSaleForm(@PathVariable Long id, Model model) {
        Optional<Sales> sale = salesService.getById(id);

        if (sale.isPresent()) {
            model.addAttribute("saleForm", sale.get());
            return "edit_sale";
        } else {
            // Handle sale not found error
            return "redirect:/";
        }
    }

    @PostMapping("/edit-sale/{id}")
    public String editSale(@PathVariable Long id, @ModelAttribute("saleForm") Sales updatedSale) {
        Optional<Sales> sale = salesService.getById(id);

        if (sale.isPresent()) {
            Sales existingSale = sale.get();
            existingSale.setRecno(updatedSale.getRecno());
            existingSale.setIcode(updatedSale.getIcode());
            existingSale.setQty(updatedSale.getQty());
            existingSale.setDot(updatedSale.getDot());

            salesService.updateOne(id, updatedSale);

            return "redirect:/";
        } else {
            // Handle sale not found error
            return "redirect:/";
        }
    }

    @GetMapping("/delete-sale/{id}")
    public String deleteSale(@PathVariable Long id) {
        Optional<Sales> sale = salesService.getById(id);

        if (sale.isPresent()) {
            salesService.deleteOne(id);
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }



}
