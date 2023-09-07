package com.ensat.controllers;

import com.ensat.entities.Product;
import com.ensat.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Product controller.
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("products", productService.listAllProducts());
        System.out.println("Returning products:");
        return "products"; // Assuming you have a "products.html" template
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "productshow"; // Assuming you have a "productshow.html" template
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "productform"; // Assuming you have a "productform.html" template
    }

    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "productform"; // Assuming you have a "productform.html" template
    }

    @PostMapping("/product") // Corrected URL mapping
    public String saveProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products/" + product.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}

