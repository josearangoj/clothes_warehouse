package com.cpan228.clothes_warehouse.controller;

import com.cpan228.clothes_warehouse.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/itemlist")
public class ItemListController {
    private ItemRepository itemRepository;

    public ItemListController(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public String showItems(Model model){
        return "itemlist";
    }

    @ModelAttribute
    public void items(Model model){
        model.addAttribute("items", itemRepository.findAll());
    }
}
