    package com.cpan228.clothes_warehouse.controller;

    import com.cpan228.clothes_warehouse.model.ItemModel;
    import com.cpan228.clothes_warehouse.model.ItemModel.FashionBrand;

    import com.cpan228.clothes_warehouse.model.User;
    import com.cpan228.clothes_warehouse.repository.ItemRepository;
    import jakarta.validation.Valid;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.access.prepost.PreAuthorize;
    import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
            ItemModel itemModel = new ItemModel();
            model.addAttribute("itemModel", itemModel);
            return "ItemForm";
        }

        @ModelAttribute
        public void brands(Model model) {
            var brands = EnumSet.allOf(FashionBrand.class);
            model.addAttribute("brands", brands);
        }

        @PostMapping
        public String checkItemInfo(@Valid ItemModel itemModel, BindingResult results) {
            if (results.hasErrors()) {
                return "ItemForm";
            }
            itemRepository.save(itemModel);
            Long generatedId = itemModel.getId();
            return "redirect:/itemlist";
        }

        @PostMapping("/deleteAllItems")
        @PreAuthorize("hasRole('ROLE_ADMIN')")
        public String processFightersDeletion(@AuthenticationPrincipal User user) {
            itemRepository.deleteAll();
            return "redirect:/";
        }
    }
