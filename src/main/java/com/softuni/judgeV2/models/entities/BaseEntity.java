package com.softuni.judgeV2.models.entities;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {
    private long id;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
