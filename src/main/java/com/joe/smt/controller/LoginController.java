package com.joe.smt.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("username")
public class LoginController {

	// @ModelAttribute
	// public void populateModel(@RequestParam(required = false, defaultValue =
	// "999") String discount, Model model) {
	// model.addAttribute("discount", discount);
	// }
	//
	// @ModelAttribute
	// public void populateModel2(@RequestParam(required = false, defaultValue =
	// "mouse") String special, Model model) {
	// model.addAttribute("special", special);
	// }

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@RequestMapping("/login")
	public String login(HttpSession session, ModelMap model) {
//		model.addAttribute("pet", "kkkkk");
//		session.setAttribute("petA", "abcbcvbcbcb");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		/* The user is logged in :) */
		if (!(auth instanceof AnonymousAuthenticationToken))
			return "redirect:home";
		return "login";
	}

	@RequestMapping("/loginFailed")
	public String loginFailed(Model model) {
		model.addAttribute("error", "error");
		return "login";
	}
	
//  Do not use GET to logout
//	@RequestMapping(value="/logout", method = RequestMethod.GET)
//	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
//	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	    if (auth != null){    
//	        new SecurityContextLogoutHandler().logout(request, response, auth);
//	    }
//	    return "redirect:/login";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
//	}

	@RequestMapping("/settings")
	public String settings(@ModelAttribute("username") String username,
			@CookieValue("JSESSIONID") String JSESSIONID,
			HttpServletResponse res) {
//		System.out.println(username);
//		System.out.println(JSESSIONID);
//		res.addCookie(new Cookie("c1","lol"));
		return "settings";
	}

	@RequestMapping("/home")
	public String home(ModelMap model, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)auth.getPrincipal();
		model.addAttribute("username", user.getUsername());
//		session.setAttribute("username", user.getUsername());
		return "home";
	}

	@RequestMapping("/error")
	public String error(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("username");
		return "redirect:pageNotFound";
	}

	@RequestMapping("/pageNotFound")
	public String pageNotFound(SessionStatus status) {
		return "pageNotFound";
	}
	
	@RequestMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied";
	}
}