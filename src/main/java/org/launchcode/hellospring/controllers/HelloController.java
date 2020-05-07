package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.awt.datatransfer.StringSelection;
import java.awt.im.InputContext;

@Controller
public class HelloController {
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }
    @GetMapping("hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello " + name;
    }
    // Responds to get and post requests at /hello?coder=LaunchCoder
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello(@RequestParam String coder, @RequestParam String Language) {
        if (Language.equals("eng")) {
            return "Yo " + " " + coder + "!";
        } else if (Language.equals("fr")) {
            return "Bonjour " + coder + "!";
        } else  if(Language.equals("sp")) {
            return "Hola " + coder + "!";
        } else  if (Language.equals("gr")) {
            return  "Hallo " + coder + "!";
        }
        return "Dia duit " + coder + "!";
    }

    @GetMapping
    @ResponseBody
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form method = 'post' action = '/hello'>" +
                        "<input type = 'text' name = 'coder' />" +
                        "<select name='Language' id='language'>" +
                            "<option value='eng'>English</option>" +
                            "<option value='fr'>French</option>" +
                            "<option value='sp'>Spanish</option>" +
                            "<option value='ger'>German</option>" +
                            "<option value='irl'>Gaelic</option>" +
                        "</select>" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                "</html>";
        return html;
    }

}
