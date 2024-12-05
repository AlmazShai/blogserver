package com.almaz.blogserver.restful.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Setter;
import lombok.Getter;

@Entity
public class BlogPost {
    @NotNull
    @NotEmpty
    @Getter
    private String title;

    @NotNull
    @NotEmpty
    @Getter
    private String content;
    @Getter
    private String category;
    @Getter
    private String[] tag;
}
