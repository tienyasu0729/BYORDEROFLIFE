package com.tienthanh.controllerJDBC;

import com.tienthanh.modelJDBC.Android_PhoneJDBC;
import com.tienthanh.serviceJDBC.IAndroid_PhoneServiceJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping(value = "/tienthanh", method = RequestMethod.GET)
@RequestMapping("/tienthanhJDBC")
public class Android_PhoneControllerJDBC {
    @Autowired
    private IAndroid_PhoneServiceJDBC android_phoneService;
    @GetMapping("")
    public String listAndroid_Phone(Model model) {
        model.addAttribute("listAndroid_Phone", android_phoneService.displayAndroid_Phone());
        model.addAttribute("android_phone", new Android_PhoneJDBC());

//        ModelAndView modelAndView = new ModelAndView("listAndroid_Phone");
//        modelAndView.addObject("listAndroid_Phone", android_phoneService.displayAndroid_Phone());
//        modelAndView.addObject("Android_phone", new Android_Phone());
//        return modelAndView;
        return "listAndroid_PhoneORM";
    }

    @PostMapping("save_create_android_phone")
        public String aaaa(@ModelAttribute Android_PhoneJDBC android_phoneJDBC, Model model){
        System.out.println(android_phoneJDBC.toString());
        android_phoneService.add_New_Android_Phone(android_phoneJDBC);
        System.out.println("kkkkkkkkkkkk");
        return "redirect:/tienthanhJDBC";
    }
}
