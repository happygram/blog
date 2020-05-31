package project.blog.config;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import project.blog.common.CommonUtils;
import project.blog.controller.AdminController;
import project.blog.controller.HomeController;
import project.blog.controller.LoginController;
import project.blog.controller.MainController;
import project.blog.controller.BoardController;

@ControllerAdvice(
assignableTypes= {
		HomeController.class, 
		LoginController.class, 
		MainController.class,
		BoardController.class,
		AdminController.class
})
public class GlobalControllerAdvice{
	@ModelAttribute
	public void handlerAttribute(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Map<String, String> authorityMap = CommonUtils.newAuthorityMap(authentication);
		model.addAttribute("authorityMap", authorityMap);
		if(authentication.getPrincipal() instanceof User)
			model.addAttribute("userNm", ((User)authentication.getPrincipal()).getUsername().toString());
	}
}
