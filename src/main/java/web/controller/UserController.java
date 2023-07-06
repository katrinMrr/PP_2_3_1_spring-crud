package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public String printUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "getUser";
    }

    @GetMapping("/{id}")
    public String show(ModelMap model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user",new User());
        return "new";
    }


    @PostMapping("/create")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}

