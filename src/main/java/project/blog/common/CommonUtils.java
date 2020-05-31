package project.blog.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class CommonUtils {
	/**
	 * 권한을 Map으로 생성
	 * @param authentication
	 * @return
	 */
	public static Map<String, String> newAuthorityMap(Authentication authentication) {
		Map<String, String> authorityMap = new HashMap<>();
		for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
			String authority = grantedAuthority.getAuthority();
			authorityMap.put(authority, authority);
		}
		return authorityMap;
	}
}
