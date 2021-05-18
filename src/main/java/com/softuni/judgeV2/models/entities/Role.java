package com.softuni.judgeV2.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    private RoleName name;

    public Role() {
    }

    public Role(RoleName name) {
        this.name = name;
    }

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
