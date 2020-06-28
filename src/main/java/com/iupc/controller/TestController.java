package com.iupc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/test")
    public String toTest(Model model)
    {
        return "test/index";
    }

    @RequestMapping("/test/add")
    public String add()
    {
        return  "test/add";
    }
    @RequestMapping("/test/update")
    public String update()
    {
        return  "test/update";
    }
}
