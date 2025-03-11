package com.ventogumi.recipe.model.user;

import com.ventogumi.recipe.model.alarm.Alarm;
import com.ventogumi.recipe.model.community.Community;
import com.ventogumi.recipe.model.community.Community_comment;
import com.ventogumi.recipe.model.image.Image;
import com.ventogumi.recipe.model.food.Recipe;
import com.ventogumi.recipe.model.food.Recipe_comment;
import com.ventogumi.recipe.model.relish.Relish;
import com.ventogumi.recipe.model.scrap.Scrap;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id; // 기본키
    @Column(nullable = false)
    private String user_name; // 로그인 아이디. 소셜 로그인의 경우 소셜이 제공하는 이메일
    @Column(nullable = false)
    private String user_password; // 비밀번호. 소셜 로그인의 경우 무작위의 값
    @Column(nullable = false)
    private String user_email; // 이메일. 소셜 로그인의 경우 로그인 아이디와 동일
    @Column(nullable = false)
    private String user_nickname; // 표시되는 유저 이름
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_image", nullable = true)
    private Image user_image; // 유저의 프로필 사진.
    @Column(nullable = false) @Enumerated(EnumType.ORDINAL)
    private Range user_range;
    @Column(nullable = false)
    private LocalDate user_register_date;
    @Column(nullable = false) @Enumerated(EnumType.ORDINAL)
    private Provider user_provider;
    @Column(nullable = false) @Enumerated(EnumType.ORDINAL)
    private Rank user_rank;
    @Column(nullable = false) @Enumerated(EnumType.ORDINAL)
    private Role user_role;

    // 아래는 ManyToOne을 연결시키는 OneToMany들
    @OneToMany(mappedBy = "alarm_user", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Alarm> user_alarms;
    @OneToMany(mappedBy = "recipe_user", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Recipe> user_recipes;
    @OneToMany(mappedBy = "recipe_comment_user", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Recipe_comment> user_recipe_comments;
    @OneToMany(mappedBy = "community_user", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Community> user_communities;
    @OneToMany(mappedBy = "community_comment_user", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Community_comment> user_community_comments;
    @OneToMany(mappedBy = "relish_pk.relish_user", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Relish> user_relishes;
    @OneToMany(mappedBy = "scrap_pk.scrap_user", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Scrap> user_scraps;
    @OneToMany(mappedBy = "follow_pk.following_user", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Follow> users_following;
    @OneToMany(mappedBy = "follow_pk.followed_user", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Follow> users_followed;


}
