package project.blog.dto;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.blog.domain.Board;

@Setter
@Getter
@NoArgsConstructor
public class BoardDto {
	private int seqNo;
	private String writer;
	private String title;
	private String categoryNm;
	private String content;
	private Timestamp regDtTm;
	private Timestamp modDtTm;
	private int hit;
	private boolean hidden;
	
	public BoardDto(Board entity) {
		seqNo = entity.getSeqNo();
		writer = entity.getWriter();
		title = entity.getTitle();
		categoryNm = entity.getCategoryNm();
		content = entity.getContent();
		regDtTm = entity.getRegDtTm();
		modDtTm = entity.getModDtTm();
		hit = entity.getHit();
		hidden = entity.isHidden();
	}
	
	@Builder
	public BoardDto(int seqNo, String writer, String title, String categoryNm, String content, Timestamp regDtTm, Timestamp modDtTm, int hit, boolean hidden) {
		this.writer = writer;
		this.title = title;
		this.categoryNm = categoryNm;
		this.content = content;
		this.regDtTm = regDtTm;
		this.modDtTm = modDtTm;
		this.hit = hit;
		this.hidden = hidden;
	}
	
	public Board toEntity() {
		return Board.builder()
				.writer(writer)
				.title(title)
				.categoryNm(categoryNm)
				.content(content)
				.regDtTm(regDtTm)
				.modDtTm(modDtTm)
				.hit(hit)
				.hidden(hidden)
				.build();
	}
}
