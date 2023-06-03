package poly.ass.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import poly.ass.entity.Account;
import poly.ass.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {
	
	Page<Order> findByAccount(Account account, Pageable pageable);

	
}
