package cn.evendy.uniots.module;

import java.io.Serializable;

/**
 * Created by evendy .
 */
public class User implements Serializable {
    public static final int Gender_UnSet = 1;
    public static final int Gender_male = 1;
    public static final int Gender_Female = 2;

    private String name;
    private int id;
    private int gender;
    private long born;
    private int weight;
    private int height;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public long getBorn() {
        return born;
    }

    public void setBorn(long born) {
        this.born = born;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
