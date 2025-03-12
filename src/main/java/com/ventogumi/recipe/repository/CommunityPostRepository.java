package com.ventogumi.recipe.repository;

import com.ventogumi.recipe.model.CommunityPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CommunityPostRepository extends JpaRepository<CommunityPost, Long> {

}