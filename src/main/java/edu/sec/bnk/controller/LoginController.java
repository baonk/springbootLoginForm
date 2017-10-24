package edu.sec.bnk.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import edu.sec.bnk.service.UserService;
import edu.sec.bnk.vo.User;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	private final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public String registration(Model model){	
		logger.debug("Run here!");
		User user = new User();
		model.addAttribute("user", user);
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String createNewUser(@Valid User user, BindingResult bindingResult, Model model) {
		logger.debug("Run here2!");		
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			return "registration";
		} else {
			userService.saveUser(user);
			model.addAttribute("successMessage", "User has been registered successfully");
			model.addAttribute("user", new User());
			return "registration";			
		}				
	}
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String home(Model model){
		//ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		model.addAttribute("userName", user.getUsername());
		model.addAttribute("email", user.getEmail());
		return "home";
	}
	

}
