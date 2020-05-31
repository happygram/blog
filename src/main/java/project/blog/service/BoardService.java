package project.blog.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import lombok.AllArgsConstructor;
import project.blog.dto.BoardDto;
import project.blog.dto.CategoryDto;
import project.blog.repository.BoardRepository;

@Service
@AllArgsConstructor
public class BoardService {
	
	private BoardRepository boardRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public void save(BoardDto dto) {
		dto.setRegDtTm(new Timestamp(new Date().getTime()));
		boardRepository.save(dto.toEntity());
	}
	
	@Transactional
	public void update(int seqNo) {
		boardRepository.update(seqNo);
	}
	
	@Transactional(readOnly = true)
	public List<BoardDto> findByCategoryNm(String categoryNm, Model model){
		if(model.containsAttribute("userNm")) return boardRepository.findByCategoryNmOrderByRegDtTmDesc(categoryNm).map(BoardDto::new).collect(Collectors.toList());
		return boardRepository.findByCategoryNmAndHiddenOrderByRegDtTmDesc(categoryNm, false).map(BoardDto::new).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public BoardDto findBySeqNo(int seqNo){
		return boardRepository.findBySeqNo(seqNo);
	}
}
