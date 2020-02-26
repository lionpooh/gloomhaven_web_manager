package org.lionpooh.ghm.controller.vo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Member {

    @Id
    private String email;
    private String password;



}
