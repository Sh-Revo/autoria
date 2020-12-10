package com.shandov.autoria.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "value")
    private Long value;

    @Column(name = "name")
    private String name;
}
