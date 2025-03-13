package com.ventogumi.recipe.model.food;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Ingredient_code{
    @EmbeddedId // 복합키 사용시 필수
    private Ingredient_code_pk ingredient_code_id; // 복합키 클래스인 ingredient_code_pk를 참조합니다
    @Column(nullable = false)
    public String ingredient_class_kor_name;
    @Column(nullable = false)
    public String ingredient_detail_kor_name;
    @Column(nullable = false)
    public String ingredient_class_jap_name;
    @Column(nullable = false)
    public String ingredient_detail_jap_name;

}
