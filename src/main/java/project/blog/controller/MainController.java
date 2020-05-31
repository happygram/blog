package project.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project.blog.service.BoardService;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping
	public String viewMain(@RequestParam String categoryNm, @RequestParam String categoryLabelNm, Model model) {
		// View attribute
		model.addAttribute("categoryNm", categoryNm);
		model.addAttribute("categoryLabelNm", categoryLabelNm);
		model.addAttribute("boardList", boardService.findByCategoryNm(categoryNm,model));
		model.addAttribute("template", "content/main");
		return "index";
	}
	
}
