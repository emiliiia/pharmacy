package com.emilia.pharmacy.entity.sql;

/*
  @author emilia
  @project pharmacy
  @className SQLKey
  @version 1.0.0
  @since 16.08.2022
*/

import com.emilia.pharmacy.enums.Role;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "keys")
@ApiModel(value = "KeyModel", description = "Sample model for the documentation")
public class SQLKey {
    @Id
    @ApiModelProperty(value = "id of object",
            name = "id",
            dataType = "Integer",
            example = "1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ApiModelProperty(value = "username of the key",
            name = "username",
            dataType = "String",
            example = "lily")
    @Column(name = "username")
    private String username;

    @ApiModelProperty(value = "password of the key",
            name = "password",
            dataType = "String",
            example = "lily")
    @Column(name = "password")
    private String password;

    @ApiModelProperty(value = "role of the key",
            name = "role",
            dataType = "String",
            example = "USER")
    @ManyToOne()
    @JoinColumn(name="fk_role_id")
    private SQLRole role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SQLRole getRole() {
        return role;
    }

    public void setRole(SQLRole role) {
        this.role = role;
    }
}
