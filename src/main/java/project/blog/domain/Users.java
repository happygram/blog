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
public class Users {
	@Id
    private String username;
	private String password;
    private boolean enabled;
    
    @Builder
    public Users(String username, String password, boolean enabled) {
    	this.username = username;
    	this.password = password;
    	this.enabled = enabled;
    }
}