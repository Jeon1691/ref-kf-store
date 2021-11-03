package com.kakaofriends.front.controller;

import com.kakaofriends.front.common.annotation.FriendsGlobal;
import com.kakaofriends.front.domain.product.ProductExpansion;
import com.kakaofriends.front.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@FriendsGlobal
@RequestMapping(value = "/{language}")
public class OhMyFriendsController {

    @Autowired
    private ProductService productService;

    /**
     * 오마이프렌즈(패션)
     * @param language
     * @return
     */
    @RequestMapping(value = "/ohmyfriends")
    public ModelAndView ohMyFriendsView(@PathVariable("language") String language) {
        List<ProductExpansion> productExpansionList = productService.findProductForOhMyFriends();
        Map<String, ProductExpansion> productMap = new HashMap<>();
        productExpansionList.forEach(productExpansion -> {
            productMap.put(productExpansion.getProduct().getPrCode(), productExpansion);
        });
        ModelAndView mav = new ModelAndView();
        mav.addObject("productMap", productMap);
        mav.setViewName(language + "/ohmyfriends/view");
        return mav;
    }
}
