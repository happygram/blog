package project.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.blog.domain.Authorities;

public interface AuthoritiesRepository extends JpaRepository<Authorities, String> {
	
}
