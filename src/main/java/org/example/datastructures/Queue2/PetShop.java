package org.example.datastructures.Queue2;

import org.example.datastructures.Queue2.animal.Cat;
import org.example.datastructures.Queue2.animal.Dog;
import org.example.datastructures.Queue2.animal.Pet;

import java.util.Scanner;

public class PetShop {

    public static void main(String[] args) {
        int done = 0;
        PetQueue q = new PetQueue();
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the pet shop!");
        System.out.println(
                "\n 1) Add dog to the pet shop" +
                "\n 2) Add cat to the pet shop" +
                "\n 3) Adopt a dog from the pet shop" +
                "\n 4) Adopt a cat from the pet shop" +
                "\n 5) Adopt either a dog or a cat from the pet shop" +
                "\n 6) Show all pets" +
                "\n 7) Leave pet shop");
        while (done == 0) {
            try {
                System.out.println("\nPlease select an option 1-7");
                switch (input.nextInt()) {
                    case 1:
                        System.out.println("What would you like to name the newly added dog?");
                        Scanner dogInput = new Scanner(System.in);
                        String dogName = dogInput.nextLine();
                        Pet dog = new Dog(dogName);
                        q.add(dog);
                        break;
                    case 2:
                        System.out.println("What would you like to name the newly added cat?");
                        Scanner catInput = new Scanner(System.in);
                        String catName = catInput.nextLine();
                        Pet cat = new Cat(catName);
                        q.add(cat);
                        break;
                    case 3:
                        q.adoptDog();
                        break;
                    case 4:
                        q.adoptCat();
                        break;
                    case 5:
                        q.dequeueAny();
                    case 6:
                        q.listPets();
                        break;
                    case 7:
                        done++;
                        break;
                }
            }
            catch(Exception e) {
                System.out.println("Please enter a valid input!");
                input.next();
            }
        }
    }
}
