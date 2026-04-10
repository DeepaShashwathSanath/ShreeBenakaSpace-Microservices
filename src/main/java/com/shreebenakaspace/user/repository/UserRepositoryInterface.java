package com.shreebenakaspace.user.repository;

import com.shreebenakaspace.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryInterface extends JpaRepository<User,Long> {

}
