package com.ventogumi.recipe.model.food;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Ingredient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredient_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_recipe", nullable = false)
    @ToString.Exclude
    private Recipe ingredient_recipe;     // 재료 설명에 사용하는 언어의 경우, 이 Recipe의 Language를 사용합니다.
    @Column(nullable = false, length = 77)
    private String ingredient_capacity; // 재료 양을 저장합니다. 단위 포함
    @Column(nullable = true, columnDefinition = "TEXT")
    private String ingredient_note; // 재료에 대한 비고 정보를 저장합니다.
    @Column(nullable = false, columnDefinition = "TEXT")
    private String ingredient_all;

    @OneToOne(fetch = FetchType.LAZY) // MapsID는 복합키 구성에 필수
    @JoinColumns({
            @JoinColumn(name = "ingredient_class", referencedColumnName = "ingredient_class_id", nullable = false),
            @JoinColumn(name = "ingredient_detail", referencedColumnName = "ingredient_detail_id", nullable = false)
    })
    private Ingredient_code ingredient_code;
}
