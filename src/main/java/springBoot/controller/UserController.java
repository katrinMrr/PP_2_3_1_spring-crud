package springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springBoot.model.User;
import springBoot.service.UserService;


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
    public String show(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PutMapping("/create")
    public String create(@ModelAttribute("user") User user) {
        userService.saveOrUpdate(user);
        return "redirect:/users";
    }

    @PatchMapping("/edit/{id}")
    public String edit(@ModelAttribute("user") User user) {
        userService.saveOrUpdate(user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}

