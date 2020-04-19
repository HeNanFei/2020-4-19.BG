package com.zjt.main.controller;


import com.zjt.main.Repository.EntityRepository;

import com.zjt.main.Repository.UauthorityRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private EntityRepository repository;
    @Autowired
    private UauthorityRepository2 uauthorityRepository;


    @ResponseBody
    @RequestMapping("/jpa")
    public Object t(){

        return repository.findAllByName("usr");

    }
    @ResponseBody
    @RequestMapping("/jpa2")
    public Object t2(){

        return uauthorityRepository.findAllByUid(1);

    }
    @ResponseBody
    @RequestMapping("/jpa3")
    public Object t3(){

        return "crestina lu";

    }
    @ResponseBody
    @RequestMapping("/jpa4")
    public Object t4(){

        return "luis suares";

    }
    @ResponseBody
    @RequestMapping("/jpa5")
    public Object t5(){

        return "luis suares";

    }


}
