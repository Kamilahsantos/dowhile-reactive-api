package com.rocketseat.projeto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document(collection = "devs")
public class Devs {

    public Devs(String id, String name, String stack) {
        this.id = id;
        this.name = name;
        this.stack = stack;
    }

    public Devs() {
    }

    @Id
    private String id;

    @NotBlank
    @Size(max = 255)
    private String name;

    private String stack;

    @NotBlank
    @Size(max = 255)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }


}
