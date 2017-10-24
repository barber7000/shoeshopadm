package com.hpe.ssa.controller;

import com.hpe.ssa.pojo.Shoes4List;
import com.hpe.ssa.service.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ShoeService shoeService;

    @RequestMapping(value = "/edit/shoe/{sid}",method = RequestMethod.GET)
    public ModelAndView editShoeById(@PathVariable String sid){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/productManagement/shoesEdit");
        return mv;
    }

    @RequestMapping(value = "/get/shoeslist",method = RequestMethod.GET)
    @ResponseBody
    public List<Shoes4List> showShoesList(String index){
        return shoeService.selectShoes4List(Integer.parseInt(index));
    }

    @RequestMapping("/shoemgmt")
    public String showShoeMgmtPage(){
        return "pages/productManagement/shoesList";
    }

    @RequestMapping("/shoesnum")
    @ResponseBody
    public String getTotalNum(){
        return String.valueOf(shoeService.selectShoesNum());
    }
}