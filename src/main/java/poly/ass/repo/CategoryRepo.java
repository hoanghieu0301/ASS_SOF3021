package poly.ass.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.ass.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
