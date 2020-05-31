package project.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import project.blog.dto.UsersDto;
import project.blog.service.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService usersService;

	@GetMapping
	public @ResponseBody List<UsersDto> getUsers() {
		return usersService.getUsers();
	}
	
	@PostMapping
	public RedirectView newUsers(@ModelAttribute UsersDto userDto) {
		usersService.newUsers(userDto);
		return new RedirectView("/admin/users");
	}
}