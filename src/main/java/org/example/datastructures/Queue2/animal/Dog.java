package org.example.datastructures.Queue2.animal;

import java.util.Random;

public class Dog implements Pet{

    private String name;

    public Dog(String name) {
        this.name = name;
    }
    @Override
    public String getPetName() {
        return name;
    }

    @Override
    public String getPetVoice() {
        Random rand = new Random();
        String[] voices = {"Woof","Bark","Bork","Ruff","Awooga"};
        return voices[rand.nextInt(voices.length)];
    }
}
