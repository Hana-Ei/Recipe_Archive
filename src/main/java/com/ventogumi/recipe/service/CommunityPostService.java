import com.ventogumi.recipe.model.CommunityPost;

import java.util.List;

public interface CommunityPostService {
    // 글 저장
    CommunityPost savePost(CommunityPost communityPost);

    // 글 조회
    CommunityPost readPost(Long postId);

    // 글 전체 조회
    public List<CommunityPost> getAllPosts();

    // 아이디로 글 조회
    public CommunityPost getCommunityPostById(Long postId);

    // 글 삭제
    public void removeCommunityPost(Long postId);

    // 글 수정
    public void updateCommunityPost(Long postId, CommunityPost updateCommunityPost);
}