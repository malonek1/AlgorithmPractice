package org.example.datastructures;

import org.example.datastructures.Queue2.PetQueue;
import org.example.datastructures.Queue2.animal.Cat;
import org.example.datastructures.Queue2.animal.Dog;
import org.example.datastructures.Queue2.animal.Pet;

public class Driver {
    public static void main(String[] args) {
//        DoubleLinkedList list = new DoubleLinkedList();
//        list.frontInsert(4);
//        list.frontInsert(7);
//        list.frontInsert(2);
//        list.frontInsert(5);
//        list.frontInsert(3);
//        list.frontInsert(1);
//        list.frontInsert(8);
//        list.printList(list);
//        System.out.println();
//        list.deleteDuplicate(5);
//        list.printList(list);

//        HashTable hashTable = new HashTable();
//        hashTable.insert(4, 9);
//        hashTable.insert(6, 8);
//        hashTable.insert(7, 3);
//        hashTable.insert(5, 2);
//        //System.out.println(hashTable.get(4));
//        hashTable.printTable(hashTable);

//        SingleStack stack = new SingleStack();
//        stack.push(5);
//        stack.push(7);
//        stack.push(1);
//        stack.push(9);
//        stack.push(4);
//        stack.printAll(stack);
//        System.out.println("Minimum value in stack: " + stack.findMin());

//        MultiStack multiStack = new MultiStack(2);
//        multiStack.push(1, 345);
//        multiStack.push(1, 43);
//        multiStack.push(1, 78);
//        multiStack.push(0, 56);
//        multiStack.push(0, 99);
//
//        multiStack.printAll(multiStack);



//        Queue queue = new Queue();
//        queue.enqueue(4);
//        queue.enqueue(8);
//        queue.enqueue(3);
//        queue.dequeue();
//        queue.enqueue(7);
//        queue.dequeue();
//        queue.printAll();
//        queue.getValue();

        PetQueue petQueue = new PetQueue();
        Pet dixie = new Dog("Dixie");
        Pet rowdy = new Dog("Rowdy");
        Pet inky = new Cat("Inky");
        Pet boba = new Cat("Boba");
        petQueue.add(dixie);
        petQueue.add(rowdy);
        petQueue.add(inky);
        petQueue.add(boba);
        petQueue.listPets();
        petQueue.adoptCat();
        petQueue.listPets();
        petQueue.adoptDog();
        petQueue.listPets();
    }
}
