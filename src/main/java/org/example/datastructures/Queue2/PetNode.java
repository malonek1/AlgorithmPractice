package org.example.datastructures.Queue2;

import org.example.datastructures.Queue2.animal.Pet;

public class PetNode {
    private Pet pet;
    private PetNode next;
    private PetNode prev;

    public PetNode(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

    public PetNode getNext() {
        return next;
    }

    public void setNext(PetNode next) {
        this.next = next;
    }

    public PetNode getPrev() {
        return prev;
    }

    public void setPrev(PetNode prev) {
        this.prev = prev;
    }
}
