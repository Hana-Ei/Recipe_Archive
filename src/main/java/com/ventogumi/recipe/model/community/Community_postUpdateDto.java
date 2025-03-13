package com.ventogumi.recipe.model.community;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
// 데이터 교환을 위한 글 수정 관련 클래스
public class Community_postUpdateDto {
    private Long community_id;
    private String community_title;
    private String community_content;

}