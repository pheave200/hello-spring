package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.im.InputContext;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";

//    @GetMapping("goodbye")
//    @ResponseBody
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }
    @GetMapping("hello")
    public String helloWithQueryParam(@RequestParam String coder, Model model) {
        String greeting = "Hello " + coder + "!";
        model.addAttribute("greeting", greeting);
        return "Hello " + coder;
    }
    // Responds to get and post requests at /hello?coder=LaunchCoder
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String coder, String Language, Model model) {
        String greeting = Language + coder + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping
    public String helloForm() {
        return "form";
    }
    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Phil");
        names.add("Patch");
        names.add("Chrissie");
        model.addAttribute("names, names");
        return "hello-list";
    }
}
