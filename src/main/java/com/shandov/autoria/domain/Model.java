package com.shandov.autoria.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "model")
public class Model {

    @Id
    @Column(name = "value")
    private Long value;

    @Column(name = "name")
    private String name;

//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private Category category;
}
