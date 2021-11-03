package com.kakaofriends.front.controller;

import com.kakaofriends.front.common.annotation.FriendsGlobal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;

@Controller
@FriendsGlobal
@RequestMapping(value = "/{language}")
public class PolicyController {

    private boolean isSync(HttpServletRequest request){
        boolean isSync = false;
        try {
            URL url = new URL( request.getRequestURL().toString() );
            String host = url.getHost();
            isSync = ( host.contains( "privacy" ));

        } catch ( Exception e ){
            e.printStackTrace();
        }
        return isSync;
    }

	@RequestMapping(value = "policy/privacy")
	public ModelAndView privacy(@PathVariable(value = "language") String language,HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
	    mav.addObject( "isSync", isSync( request ) );
		mav.setViewName(language + "/policy/privacy");
		return mav;
	}

	@RequestMapping(value = "policy/privacy_150918")
	public ModelAndView privacy_150918(@PathVariable(value = "language") String language) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(language + "/policy/privacy_150918");
		return mav;
	}

	@RequestMapping(value = "policy/privacy_171201")
	public ModelAndView privacy_171201(@PathVariable(value = "language") String language) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(language + "/policy/privacy_171201");
		return mav;
	}

	@RequestMapping(value = "policy/privacy_171218")
	public ModelAndView privacy_171218(@PathVariable(value = "language") String language) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(language + "/policy/privacy_171218");
		return mav;
	}

	@RequestMapping(value = "policy/provision")
	public ModelAndView provision(@PathVariable(value = "language") String language, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
        mav.addObject( "isSync", isSync( request ) );
		mav.setViewName(language + "/policy/provision");
		return mav;
	}

	@RequestMapping(value = "policy/provision_150918")
	public ModelAndView provision_150918(@PathVariable(value = "language") String language) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(language + "/policy/provision_150918");
		return mav;
	}

	@RequestMapping(value = "policy/provision_171201")
	public ModelAndView provision_171201(@PathVariable(value = "language") String language) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(language + "/policy/provision_171201");
		return mav;
	}

    @RequestMapping(value = "policy/provision_180717")
    public ModelAndView provision_180717(@PathVariable(value = "language") String language) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(language + "/policy/provision_180717");
        return mav;
    }
}
