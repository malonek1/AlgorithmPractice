package org.example.controller;

import org.example.algorithms.AlgorithmService;
import org.example.datastructures.doublelinkedlist.DoubleLinkedList;
import org.example.datastructures.linkedlist.LinkedList;
import org.example.implementations.sort.queue.*;
import org.example.implementations.BinarySearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AlgorithmController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private AlgorithmService algorithmService;

    @Autowired
    public AlgorithmController(AlgorithmService algorithmService) {
        this.algorithmService = algorithmService;
    }

    @GetMapping("/max")
    public Map<String, Integer> maxNumInList() {
        logger.info("getting results for the following endpoint: max");
        Map<String, Integer> map = new HashMap<>();
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 7, 3, 5, 6, 15, 4, 9));
        map.put("Using input " + nums.toString() + " the maximum number determined is" ,algorithmService.findMax(nums));
        return map;
    }

    @GetMapping("/min")
    public Map<String, Integer> minDelCharFreq() {
        logger.info("getting results for the following endpoint: min");
        Map<String, Integer> map = new HashMap<>();
        map.put("Using input 'aab' the minimum number of deletions is", algorithmService.minDeletions("aab"));
        return map;
    }

    @GetMapping("/2d")
    public int[][] return2dArray() {
        logger.info("getting results for the following endpoint: 2d");
        int[] original = {1,2,3,7,4,6};
        return algorithmService.construct2DArray(original, 2, 3);
    }

    @GetMapping("/1d")
    public int[] return1dArray() {
        logger.info("getting results for the following endpoint: 1d");
        int[][] original = {{1,2,3,7,4,6},{4,2,4,5,6,8}};
        return algorithmService.construct1DArray(original);
    }

    @GetMapping("/palindrome")
    public boolean isPalindrome() {
        logger.info("getting results for the following endpoint: palindrome");
        return algorithmService.isPalindrome(121);
    }

    @GetMapping("/3sum")
    public int threeSumClosest() {
        logger.info("getting results for the following endpoint: 3sum");
        int[] nums = {-1,2,1,-4,9,-12,1};
        return algorithmService.threeSumClosest(nums, -5);
    }

    @GetMapping("/binary")
    public String binary() {
        logger.info("getting results for the following endpoint: binary");
        BinarySearch ob = new BinarySearch();
        int arr[] = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, x);
        if (result == -1) return "Element is not present in array";
        return "Element is present at " + "index " + result;
    }

    @GetMapping("/queue")
    public String queue() {
        logger.info("getting results for the following endpoint: queue");
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.dequeue();
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.dequeue();
        return "PetQueue Front: " + ((q.front != null) ? (q.front).key : -1) +
        " PetQueue Rear: " + ((q.rear != null) ? (q.rear).key : -1);
    }

    @GetMapping("/substring")
    public String stringCharCount() {
        logger.info("getting results for the following endpoint: substring");
        return algorithmService.stringCharCount("geeksforgeeks", 's', 1);
    }

    @GetMapping("/fizzbuzz")
    public void fizzBuzz() {
        logger.info("getting results for the following endpoint: fizzbuzz");
        algorithmService.fizzbuzz();
    }

    @GetMapping("/armstrong")
    public String armstrongNumber() {
        logger.info("getting results for the following endpoint: armstrong");
        return algorithmService.armstrong(1253);
    }

    @GetMapping("/repeat")
    public int repeatingInt() {
        logger.info("getting results for the following endpoint: repeat");
        int[] arr = {10, 5, 3, 4, 1, 1, 6};
        return algorithmService.repeatingInt(arr);
    }

    @GetMapping("/linkedlist")
    public void linkedList() {
        logger.info("getting results for the following endpoint: linkedlist");
        DoubleLinkedList list = new DoubleLinkedList();
        list.backInsert(4);
        list.backInsert(7);
        list.backInsert(2);
        list.deleteDuplicate(7);
        list.printList(list);
    }


}
