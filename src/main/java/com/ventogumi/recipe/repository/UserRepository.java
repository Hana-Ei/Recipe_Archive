package com.ventogumi.recipe.repository;

import com.ventogumi.recipe.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}