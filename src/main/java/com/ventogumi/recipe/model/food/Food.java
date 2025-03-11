package com.ventogumi.recipe.model.food;

import com.ventogumi.recipe.model.image.Image;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Food {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long food_id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_image", nullable = false)
    private Image food_image;
    @Column(nullable = false)
    private String food_name_kor;
    @Column(nullable = false)
    private String food_name_jap;

    @OneToOne(fetch = FetchType.LAZY) // MapsID는 복합키 구성에 필수
    @JoinColumns({
            @JoinColumn(name = "food_ingredient_class", referencedColumnName = "ingredient_class_id", nullable = false),
            @JoinColumn(name = "food_ingredient_detail", referencedColumnName = "ingredient_detail_id", nullable = false)
    })
    private Ingredient_code food_ingredient_code;

}
