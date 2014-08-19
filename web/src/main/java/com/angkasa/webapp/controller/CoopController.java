package com.angkasa.webapp.controller;

import com.angkasa.dao.SearchException;
import com.angkasa.service.CoopManager;
import com.angkasa.model.Coop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/coops*")
public class CoopController {
    private CoopManager coopManager;

    @Autowired
    public void setCoopManager(CoopManager coopManager) {
        this.coopManager = coopManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(coopManager.search(query, Coop.class));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(coopManager.getAll());
        }
        return model;
    }
}
