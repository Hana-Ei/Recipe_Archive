package com.ventogumi.recipe.model.community;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
// 데이터 교환을 위한 글 등록 관련 클래스
public class Community_postCreateDto {
    @NotBlank
    @Size(min = 1, message = "제목은 1자 이상 50자 이하로 입력해주세요")
    private String community_title;      // 제목
    private String community_content;    // 내용
    private int community_view;          // 조회수
    private LocalDateTime community_write_time;  // 작성 시간
    private String community_user_name;  // 작성자 이름 (User 엔터티에서 가져옴)

    // 글 조회수 증가 메서드
    public void incrementViews() {
        this.community_view++;
    }
}