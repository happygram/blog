package project.blog.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import project.blog.domain.Board;
import project.blog.dto.BoardDto;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	Stream<Board> findByCategoryNmOrderByRegDtTmDesc(String categoryNm);
	Stream<Board> findByCategoryNmAndHiddenOrderByRegDtTmDesc(String categoryNm, boolean hidden);
	BoardDto findBySeqNo(int seqNo);
	
	@Modifying
	@Query("UPDATE Board b SET b.hit = b.hit+1 WHERE b.seqNo = ?1")
	void update(int seqNo);
}
