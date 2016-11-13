package com.aljumaro.techtest.domain.account;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

/**
 * @Date 13/11/2016
 * @Time 9:42
 * @Author Juanma
 */
@Entity
public class Role {

    @Id
    private Long id;

    @NotNull
    private String code;

    @NotNull
    private String label;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
