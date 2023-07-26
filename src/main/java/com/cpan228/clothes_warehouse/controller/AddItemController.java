    package com.cpan228.clothes_warehouse.controller;

    import com.cpan228.clothes_warehouse.model.Item;
    import com.cpan228.clothes_warehouse.model.Item.FashionBrand;

    import com.cpan228.clothes_warehouse.repository.ItemRepository;
    import jakarta.validation.Valid;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;

    import org.springframework.validation.BindingResult;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestMapping;

    import org.springframework.ui.Model;
    import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
    import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

    import java.util.EnumSet;


    @Controller
    @Slf4j //for the .log
    @RequestMapping("/add")
    public class AddItemController implements WebMvcConfigurer {

        @Autowired
        private ItemRepository itemRepository;

        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/confirm").setViewName("confirm");
        }

        @GetMapping
        public String showAddItemForm(Model model) {
            System.out.println("====== testing testing");
            Item itemModel = new Item();
            model.addAttribute("itemModel", itemModel);
            System.out.println(model);
            return "ItemForm";
        }

        @ModelAttribute
        public void brands(Model model) {
            var brands = EnumSet.allOf(FashionBrand.class);
            model.addAttribute("brands", brands);
        }

        @PostMapping
        public String checkItemInfo(@Valid Item itemModel, BindingResult results) {
            if (results.hasErrors()) {
                return "ItemForm";
            }
            log.info("Processing item: {}", itemModel);
            itemRepository.save(itemModel);
            Long generatedId = itemModel.getId();
            log.info("Generated ID: " + generatedId);
            return "redirect:/itemlist";
        }
    }
