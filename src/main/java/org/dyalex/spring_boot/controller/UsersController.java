package org.dyalex.spring_boot.controller;

import org.dyalex.spring_boot.model.User;
import org.dyalex.spring_boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsersController {
    private final UserService userService;
    private final User defaultUser = new User("Noname", "Nonamer", "No role");

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUsersPage(ModelMap model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/users/show")
    public String show(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", userService.findById(id).orElse(defaultUser));
        return "users/show";
    }

    @GetMapping("/users/edit")
    public String editUserPage(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", userService.findById(id).orElse(defaultUser));
        return "/users/edit";
    }

    @PutMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/users/new")
    public String createUserForm(@ModelAttribute("user") User user) {
        return "/users/new";
    }

    @PostMapping()
    public String addUserToDb(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @DeleteMapping(value = "/users/delete")
    public String deleteUser(@RequestParam long id) {
        userService.deleteById(id);
        return "redirect:/";
    }
}
