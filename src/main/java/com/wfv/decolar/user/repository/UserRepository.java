package com.wfv.decolar.user.repository;

import com.wfv.decolar.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
