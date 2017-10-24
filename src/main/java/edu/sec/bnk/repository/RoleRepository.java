package edu.sec.bnk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.sec.bnk.vo.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	public static final String getRoleId = "SELECT ROLE_ID FROM USER_ROLE WHERE USER_ID = ?1";
	
	@Query(value = getRoleId, nativeQuery = true)
	public int getRoleId(Long userID);
	Role findById(int roleId);	
	Role findByRole(String roleName);
}
