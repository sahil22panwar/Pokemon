package com.tcpl.pokemon.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class Pokemon {
    @Id
    private int id;
    private String name;
    private int hp;
    private int attack;
    private int defense;
    private int specialAttack;
    private int speed;
    private String url;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Pokemon(String url, int id, String name, int hp, int attack, int defense, int specialAttack, int speed) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.speed = speed;
        this.url = url;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public Pokemon(int id, String name) {
        this.id = id;
        this.name=name;
    }
    public Pokemon(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", specialAttack=" + specialAttack +
                ", speed=" + speed +
                ", url='" + url + '\'' +
                '}';
    }
}
