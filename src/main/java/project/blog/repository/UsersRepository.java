package project.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.blog.domain.Users;

public interface UsersRepository extends JpaRepository<Users, String> {
	
}