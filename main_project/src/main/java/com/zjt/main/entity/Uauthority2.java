package com.zjt.main.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@Entity
public class Uauthority2 {
    @Id
    private int uid;

    private String username;

    private String password;

    private String authorities;



}
