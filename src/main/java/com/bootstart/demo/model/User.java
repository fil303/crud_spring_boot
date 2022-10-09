package com.bootstart.demo.model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Entity(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    String email;
    @Column(nullable = true, length = 64)
    String photo;
    @Transient
    MultipartFile tempPhoto;
    int age;
    String password;

    public User(){}

    public MultipartFile getTempPhoto() {
        System.out.println(tempPhoto.getOriginalFilename());
        return tempPhoto;
    }
    public void uploadPhoto(String path,MultipartFile photo) throws IOException {
        String name = photo.getOriginalFilename();
        this.photo = name;
        Files.write(Path.of(path + name),photo.getBytes());
    }

    public User(String name, String email, String photo, int age, String password) {
      //  this.id = id;
        this.name = name;
        this.email = email;
        this.photo = photo;
        this.age = age;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User\n" +
                "id=" + id +
                "\nname=" + name +
                "\nemail=" + email +
                "\nphoto=" + photo +
                "\nage=" + age +
                "\npassword=" + password ;
    }
}
