package project.blog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.blog.domain.Authorities;

@Getter
@Setter
@NoArgsConstructor
public class AuthoritiesDto {
	private String username;
	private String authority;
	
	public Authorities toEntity(){
        return Authorities.builder()
        		.username(username)
        		.authority(authority)
                .build();
    }
}