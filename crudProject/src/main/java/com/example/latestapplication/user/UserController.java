package com.example.latestapplication.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public String showUserList(Model model) {
        List<User> listusers = userService.listALl();
        model.addAttribute("listusers", listusers);
        return "users";
    }
    @GetMapping ("/users/new")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user_form";
    }
    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes ra) {
        userService.save(user);
        ra.addFlashAttribute("message", "The user has been save successfully");
        return  "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model, RedirectAttributes ra) {
       try {
           User user = userService.get(id);
           model.addAttribute("user", user);
           ra.addFlashAttribute("message", "The user updated successfully  ");
           return  "user_form";
       } catch (UserNotFoundException e) {
           ra.addFlashAttribute("message", "The user not found ");
           return  "redirect:/users";
       }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUsers(@PathVariable Integer id,  RedirectAttributes ra) {
        try {
            userService.deleteUser(id);
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", "The user not found ");
        }
        return "redirect:/users";
    }
}
