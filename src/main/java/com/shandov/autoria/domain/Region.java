package com.shandov.autoria.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "region")
public class Region {

    @Id
    @Column(name = "value")
    private Long value;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "region")
    private List<City> cities;
}
