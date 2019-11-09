package com.example.middleware.controller;

import com.example.middleware.entity.Dl;
import com.example.middleware.service.DlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;
import java.util.Map;

@Controller
public class OperateDlController {
    @Autowired
    private DlService dlService;
    @RequestMapping("/show")
    public String show(Model model){
        model.addAttribute("dls",dlService.getAll());
        return "show1";
    }

    @RequestMapping("/dl/toUpdate/{xm}")
    public String toUpdate(Model model, @PathVariable("xm") String xm){
        Dl byXM = dlService.getByXM(xm);
        model.addAttribute("dl",byXM);
        return "updatePage";
    }
    @PostMapping ("/dl/update")
    public String update(@PathParam("xm") String xm,@PathParam("pw") String pw){
        System.out.println(xm);
        System.out.println(pw   );
        Dl d = new Dl(xm,pw);
        boolean b = dlService.update(d);
        if (b)
        return "redirect:/show";
        else{
            return "redirect:/dl/toUpdate/"+xm;
        }
    }
    @RequestMapping("/dl/delete/{xm}")
    public String delete(@PathVariable("xm") String xm){
        boolean b = dlService.remove(xm);
        return "redirect:/show";
    }
}
