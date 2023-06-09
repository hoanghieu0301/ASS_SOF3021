package poly.ass.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.ass.entity.Account;

public interface AccountRepo extends JpaRepository<Account, String> {

	@Query("SELECT acc FROM Account acc WHERE username = ?1 AND password = ?2")
	Account findByUsernameAndPassword(String username, String password);
	
	Account findByUsername(String username);
}
