package com.almaz.blogserver.restful.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Model {
    private String title;
    private String content;
    private String category;
    private String[] tag;
}
