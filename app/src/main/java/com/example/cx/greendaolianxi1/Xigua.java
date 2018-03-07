package com.example.cx.greendaolianxi1;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by cx on 2018/2/25.
 */
@Entity
public class Xigua {
    @Id
    private Long id;

    @Property(nameInDb = "name")
    private String name;

    @Property(nameInDb = "sex")
    private  String sex;

    @Property(nameInDb = "age")
    private String age;

    @Generated(hash = 1464644547)
    public Xigua(Long id, String name, String sex, String age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Generated(hash = 1254242162)
    public Xigua() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }



}
