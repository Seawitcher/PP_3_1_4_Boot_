package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;


@Controller
@RequestMapping("/api")
public class UserController {
    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String getUser(Model model) {
        model.addAttribute("userList", userService.getList());
        return "user";
    }

    @GetMapping("/newAddUser")
    public String addNewUser(Model model) {
       User user = new User();
        model.addAttribute("user", user);
        return "user_info";
    }

    @PostMapping("/newAddUser")
    public String saveNewUser (@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/api";
    }
//    @DeleteMapping("delete/{id}")
//    public String deleteUser(@PathVariable("id") long id) {
//        userService.deleteUser(id);
//        return "redirect:/";
//    }
    @GetMapping("/api/editUser/{id}")
    public String editUser (Model model, @PathVariable("id") long id) {

        model.addAttribute("user", userService.getUser(id));
        return "user_edit";
    }
    @PatchMapping("/api/{id}")
    public String userSaveEdit (@PathVariable("id") long id, @ModelAttribute("user") User user) {
       userService.editUser(user);
        return "redirect:/api";
    }

}
