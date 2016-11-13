package com.aljumaro.techtest.domain.greeting;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @Date 12/11/2016
 * @Time 11:47
 * @Author Juanma
 */
@Entity
public class Greeting{

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String text;

    public Greeting() {
    }

    public Greeting(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
