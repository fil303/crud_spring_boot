package com.bootstart.demo.controllers;


import com.bootstart.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.bootstart.demo.model.User;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Optional;

@Controller

public class HomeController {
    public static String dir = System.getProperty("user.dir") + "/src/main/resources/static/users/";
    @Autowired
    private UserRepository userRepo;
    @GetMapping("/")
    public String home(Model model){
        var users = userRepo.findAll();
        //ArrayList<User> users = new ArrayList();
        model.addAttribute("users",users);
        return "index";
    }

    @GetMapping("/addEditModal")
    public ModelAndView userAddEdit(Model model, @ModelAttribute("id") Integer id){
        model.addAttribute("id",id);
        if(id != 0){
            Optional<User> user = userRepo.findById(id);
            model.addAttribute("user",user.get());
        }
        return new ModelAndView("addModal");
    }

    @PostMapping("/addEditUser")
    public String userAddEditPost(@ModelAttribute("users") User user,@RequestParam("tempPhoto") MultipartFile photo) {
        try{
            System.out.println(user.toString());
            if(!photo.isEmpty()){
                user.uploadPhoto(HomeController.dir,photo);
            }
            user = userRepo.save(user);
            System.out.println(user.toString());
        }catch (NullPointerException | IOException e){
            System.out.print(Arrays.toString(e.getStackTrace()));
            System.out.println("error");
        }

        return "redirect:/";
    }

    @PostMapping("/destroy-user")
    @ResponseBody
    public String destroyUser (@ModelAttribute("id") Integer id){
        userRepo.deleteById(id);
        return "{ \"success\" : true}";
    }
}
