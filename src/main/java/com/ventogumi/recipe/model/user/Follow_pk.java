package com.ventogumi.recipe.model.user;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Follow_pk implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "following_user", nullable = false)
    private User following_user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followed_user", nullable = false)
    private User followed_user;

}
