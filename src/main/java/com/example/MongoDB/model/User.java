package com.example.MongoDB.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "user")
public class User {
    @Id
    private Integer id;

    @Column(name = "userName", length = 45)
    private String userName;

    @Column(name = "passWord", length = 45)
    private String passWord;

    public User() {}

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
