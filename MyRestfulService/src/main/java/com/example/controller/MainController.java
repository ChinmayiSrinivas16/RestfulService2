package com.example.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // It exposes data and service in the form of JSON/XML
public class MainController {
    List<String> itemList = new ArrayList<String>();

    public MainController() {
        itemList.add("Dhoni");
        itemList.add("Virat");
        itemList.add("Rahul");
    }

    @GetMapping("/list")
    //@RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<String> list() {
    	return itemList;
    }

    @GetMapping("/findOne/{index}")
    public String findOne(@PathVariable("index") int index) {
    	return itemList.get(index);
    }

    @PostMapping("/add")
    public void add(@RequestBody String name) {
        //itemList.add("Surya");
        itemList.add(name);
    }

    @PutMapping("/update/{index}")
    public void update(@PathVariable int index, @RequestBody String name) {
        itemList.set(index, name);
    }

    @DeleteMapping("/delete/{index}")
    public void delete(@PathVariable int index) {
        itemList.remove(index);
    }
}
