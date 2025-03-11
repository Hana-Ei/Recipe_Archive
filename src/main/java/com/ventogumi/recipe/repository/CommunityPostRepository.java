package com.ventogumi.recipe.repository;

import com.ventogumi.recipe.model.CommunityPost;

import java.util.List;

public interface CommunityPostRepository {
    // 글 등록
    void saveCommunityPost(CommunityPost communityPost);

    // 글 조회
    CommunityPost findCommunityPost(Long PostId);

    // 로그인한 아이디로 글 조회
    CommunityPost findCommunityPostById(Long postId);

    // 글 전체 조회
    List<CommunityPost> findAllCommunityPosts();

    // 글 수정
    void updateCommunityPost(CommunityPost updateCommunityPost);

    // 글 삭제
    void removeCommunityPost(Long postId);
}