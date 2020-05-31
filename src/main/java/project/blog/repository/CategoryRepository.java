package project.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.blog.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {
	Category findByNm(String nm);
}
