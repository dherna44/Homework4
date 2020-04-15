package com.homework4API.homework4API.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Property fields for the jokes table in the database:
@Entity
@Table (name= "jokes")
public class ChuckJokes {

    @Id
    //Id of the API call data:
    @Column(name = "id")
    private String id;
    //Value of the API call data:
    @Column(name = "value")
    private String value;

    public ChuckJokes(){

    }

    //Constructor for ChuckJokes class:
    public ChuckJokes(String id, String value){
        this.id=id;
        this.value=value;
    }

    //Setter and Getter for ID:
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    //Setter and Getter for Value:
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
