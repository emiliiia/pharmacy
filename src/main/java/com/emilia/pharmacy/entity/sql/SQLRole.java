package com.emilia.pharmacy.entity.sql;

/*
  @author emilia
  @project pharmacy_2
  @className SQLRole
  @version 1.0.0
  @since 18.08.2022
*/

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@ApiModel(value = "RoleModel", description = "Sample model for the documentation")
public class SQLRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    @ApiModelProperty(value = "id of object",
            name = "id",
            dataType = "Integer",
            example = "1")
    private int id;

    @ApiModelProperty(value = "rolename of role",
            name = "rolename",
            dataType = "String",
            example = "USER")
    @Column(name = "rolename")
    private String rolename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
