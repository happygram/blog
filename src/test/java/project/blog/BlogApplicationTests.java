package project.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

	@Test
	public void contextLoads() {
	}
	public BlogApplicationTests() {
		System.err.println(new BCryptPasswordEncoder().encode("hyemi"));
		System.err.println(new BCryptPasswordEncoder().encode("seongbeom"));
	}
}
