package project.blog.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Authorities {
	@Id
    private String username;
	private String authority;
    
    @Builder
    public Authorities(String username, String authority) {
    	this.username = username;
    	this.authority = authority;
    }
}
