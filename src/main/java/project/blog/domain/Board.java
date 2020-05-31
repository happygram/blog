package project.blog.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@org.hibernate.annotations.DynamicUpdate
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int seqNo;
	private String writer;
	private String title;
	private String categoryNm;
	private String content;
	private Timestamp regDtTm;
	private Timestamp modDtTm;
	private int hit;
	private boolean hidden;
	
	@Builder
	public Board(int seqNo, String writer, String title, String categoryNm, String content, Timestamp regDtTm, Timestamp modDtTm, int hit, boolean hidden) {
		this.writer = writer;
		this.title = title;
		this.categoryNm = categoryNm;
		this.content = content;
		this.regDtTm = regDtTm;
		this.modDtTm = modDtTm;
		this.hit = hit;
		this.hidden = hidden;
	}
}
