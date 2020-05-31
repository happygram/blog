package project.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import lombok.AllArgsConstructor;
import project.blog.dto.BoardDto;
import project.blog.service.BoardService;
import project.blog.service.CategoryService;

@Controller
@RequestMapping("/board")
@AllArgsConstructor
public class BoardController {
	
	private CategoryService categoryService;
	private BoardService boardService;
	
	@GetMapping("/write")
	public String viewWrite(@RequestParam String categoryNm, @RequestParam String categoryLabelNm, Model model) {
		// View attribute
		model.addAttribute("categoryNm", categoryNm);
		model.addAttribute("categoryLabelNm", categoryLabelNm);
		model.addAttribute("categoryList", categoryService.getCategories());
		model.addAttribute("template", "content/write");
		return "index";
	}
	
	@PostMapping("/save")
	public RedirectView saveWrite(BoardDto dto, Model model) {
		boardService.save(dto);
		model.addAttribute("categoryNm", dto.getCategoryNm().toString());
		model.addAttribute("categoryLabelNm", categoryService.getCategoryLabelNm(dto.getCategoryNm().toString()));
		model.addAttribute("boardList", boardService.findByCategoryNm(dto.getCategoryNm().toString(), model));
		return new RedirectView("/main");
	}
	
	@RequestMapping("/list/{seqNo}")
	public String getBoardList(@PathVariable int seqNo, Model model) {
		boardService.update(seqNo);
		model.addAttribute("article", boardService.findBySeqNo(seqNo));
		model.addAttribute("template", "content/board_list");
		return "index";
	}
}
