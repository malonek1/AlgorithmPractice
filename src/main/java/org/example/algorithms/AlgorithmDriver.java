package org.example.algorithms;

public class AlgorithmDriver {
    public static void main(String[] args) {
        AlgorithmService service = new AlgorithmService();
        //System.out.println(service.isUnique("here"));
        //System.out.println(service.countFrequency("AaaaaaAAAAAAaa",'a'));
        System.out.println(service.isPermutation("hello","hell"));
    }
}
