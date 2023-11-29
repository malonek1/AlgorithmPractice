package org.example.datastructures.Queue2;

import org.example.datastructures.Queue2.animal.Cat;
import org.example.datastructures.Queue2.animal.Dog;
import org.example.datastructures.Queue2.animal.Pet;

public class PetQueue {

    PetNode front;

    PetNode rear;

    public void add(Pet pet) {
        PetNode current = new PetNode(pet);
        if(front == null) {
            front = current;
            rear = current;
        }
        else {
            rear.setNext(current);
            current.setPrev(rear);
            rear = current;
        }
        System.out.println("Thank you for adding " + pet.getPetName() + " to the pet shop!");
    }

    public void dequeueAny() {
        if(front != null) {
            if (front.getPet().getClass() == Dog.class) {
                System.out.println("\nYou've adopted a dog from the pet shop!");
                System.out.println(front.getPet().getPetName() + " the dog says " + front.getPet().getPetVoice() + "!");
            } else {
                System.out.println("\nYou've adopted a cat from the pet shop!");
                System.out.println(front.getPet().getPetName() + " the cat says " + front.getPet().getPetVoice() + "!");
            }
            front = front.getNext();
        }
    }

    public void adoptCat() {
        if(front != null) {
            PetNode temp = front;
            int index = 0;
            while(temp != null) {
                if (temp.getPet().getClass() == Cat.class && index == 0) {
                    System.out.println("\nYou've adopted a cat from the pet shop!");
                    System.out.println(temp.getPet().getPetName() + " the cat says " + temp.getPet().getPetVoice() + "!");
                    front = front.getNext();
                    break;
                }
                else if (temp.getPet().getClass() == Cat.class && index > 0) {
                    System.out.println("\nYou've adopted a cat from the pet shop!");
                    System.out.println(temp.getPet().getPetName() + " the cat says " + temp.getPet().getPetVoice() + "!");
                    temp.getPrev().setNext(temp.getNext());
                    break;
                }
                else {
                    if(temp.getNext() != null) {
                        temp = temp.getNext();
                        index++;
                    }
                    else {
                        System.out.println("\nThere are no cats in the pet shop!");
                        break;
                    }
                }
            }
        }
        else {
            System.out.println("There are no cats in the pet shop to adopt yet! Try adding cats to the pet shop");
        }
    }

    public void adoptDog() {
        if(front != null) {
            PetNode temp = front;
            int index = 0;
            while(temp != null) {
                if (temp.getPet().getClass() == Dog.class && index == 0) {
                    System.out.println("\nYou've adopted a dog from the pet shop!");
                    System.out.println(temp.getPet().getPetName() + " the dog says " + temp.getPet().getPetVoice() + "!");
                    front = front.getNext();
                    break;
                }
                else if (temp.getPet().getClass() == Dog.class && index > 0) {
                    System.out.println("\nYou've adopted a dog from the pet shop!");
                    System.out.println(temp.getPet().getPetName() + " the dog says " + temp.getPet().getPetVoice() + "!");
                    temp.getPrev().setNext(temp.getNext());
                    break;
                }
                else {
                    if(temp.getNext() != null) {
                        temp = temp.getNext();
                        index++;
                    }
                    else {
                        System.out.println("\nThere are no dogs in the pet shop!");
                        break;
                    }
                }
            }
        }
        else {
            System.out.println("There are no dogs in the pet shop to adopt yet! Try adding dogs to the pet shop");
        }
    }

    public void listPets() {
        PetNode temp = front;
        if(front != null) {
            System.out.println("\nThe following is a list of pets in the pet shop: ");
            while (temp != null) {
                if(temp.getPet().getClass() == Dog.class) {
                    System.out.println("Dog: " + temp.getPet().getPetName() + " says " + temp.getPet().getPetVoice() + "!");
                }
                else {
                    System.out.println("Cat: " + temp.getPet().getPetName() + " says " + temp.getPet().getPetVoice() + "!");
                }
                temp = temp.getNext();
            }
        }
        else {
            System.out.println("There are no pets in the pet shop!");
        }
    }
}
