package project.blog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.blog.domain.Users;

@Getter
@Setter
@NoArgsConstructor
public class UsersDto {
	private String username;
	private String password;
	private boolean enabled;
	
	public Users toEntity(){
        return Users.builder()
        		.username(username)
        		.password(password)
        		.enabled(enabled)
                .build();
    }
}