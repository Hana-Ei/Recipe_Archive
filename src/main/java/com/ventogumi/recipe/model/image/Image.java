package com.ventogumi.recipe.model.image;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Image {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long image_id;
    @Column(nullable = false, length = 100)
    private String original_file_name;
    @Column(nullable = false, length = 255)
    private String image_file_name;
}
