package org.example.datastructures.Queue2.animal;

import java.util.Random;

public class Cat implements Pet{

    private String name;
    public Cat(String name) {
        this.name = name;
    }
    @Override
    public String getPetName() {
        return name;
    }

    @Override
    public String getPetVoice() {
        Random rand = new Random();
        String[] voices = {"Meow","Grrr","Mew","Hsssss","Purrrr"};
        return voices[rand.nextInt(voices.length)];
    }
}
