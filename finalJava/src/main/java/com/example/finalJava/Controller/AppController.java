package com.example.finalJava.Controller;

import com.example.finalJava.Service.ProductService;
import com.example.finalJava.dto.Product;
import com.example.finalJava.dto.User;
import com.example.finalJava.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProductService ProductService;

    @GetMapping("")
    public String viewHomePage() {

        return "index";
    }

    @GetMapping("/login")
    public String viewLoginPage() {

        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "register-form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        userRepo.save(user);
        return "redirect:";
    }

    @GetMapping("/product")
    public String showProductList(Model model){
        List<Product> productList = ProductService.getAllProduct();
        model.addAttribute("productList", productList);
        return "shop-grid";
    }

    @GetMapping("/product/{id}")
    public String getProductById(@PathVariable int id, Model model) {
        Product product = ProductService.getProductById(id);
        model.addAttribute("product", product);
        return "shop-details";
    }
}