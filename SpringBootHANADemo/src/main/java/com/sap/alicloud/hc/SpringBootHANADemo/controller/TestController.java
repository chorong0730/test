package com.sap.alicloud.hc.SpringBootHANADemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sap.alicloud.hc.SpringBootHANADemo.model.JobExecutionStatus;
import com.sap.alicloud.hc.SpringBootHANADemo.service.NativeSQLRunner;

@Controller
@RequestMapping("/home")
public class TestController {
    @Autowired
    NativeSQLRunner runner_native_sql;

    @GetMapping
    public String hello(Model model) {
    	
    	List<JobExecutionStatus> items = runner_native_sql.startTest2();
    	model.addAttribute("items", items);
    	model.addAttribute("count", items.size());
    	
        return "home";
    }

    @PostMapping("/create_sql")
    public String test_native_sql(RedirectAttributes redirectAttributes) {
        runner_native_sql.startTest(5);
        return "redirect:";
    }
    
    @PostMapping("/delete_sql")
    public String delete_sql(RedirectAttributes redirectAttributes) {
        runner_native_sql.startTest3();
        return "redirect:";
    }

}