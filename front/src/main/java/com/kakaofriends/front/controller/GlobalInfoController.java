package com.kakaofriends.front.controller;

import com.kakaofriends.front.common.annotation.FriendsGlobal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@FriendsGlobal
@RequestMapping( value = "/{language}" )
public class GlobalInfoController {

    @RequestMapping( value = "/global/{globalPage}" )
    public ModelAndView globalPage( @PathVariable( "language" ) String language, @PathVariable( "globalPage" ) String globalPage ) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName( language + "/global/" + globalPage );
        return mav;
    }

}