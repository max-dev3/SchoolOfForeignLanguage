package com.example.course.model.mongo;
/*
 * author Fushtei Maksym
 * project course
 * classname Days
 * INSTITUTE OF PHYSICAL, TECHNICAL AND COMPUTER SCIENCES
 * since 7/25/2022
 * Copyright notice
 */


public enum Day {
    Понеділок, Вівторок, Середа, Четвер,
    Пятниця, Субота, Неділя;

    public String toString(){
        switch(this){
            case Понеділок:
                return "Понеділок";
            case Вівторок:
                return "Вівторок";
            case Середа:
                return "Середа";
            case Четвер:
                return "Четвер";
            case Пятниця:
                return "П'ятниця";
            case Субота:
                return "Субота";
            case Неділя:
                return "Неділя";
        }
        return null;
    }
}
