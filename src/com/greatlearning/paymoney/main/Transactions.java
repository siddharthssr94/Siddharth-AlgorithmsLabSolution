package com.greatlearning.paymoney.main;

import java.util.Scanner;

public class Transactions {

    private static Scanner sc = new Scanner( System.in );

    //Calculate Transaction Count
    static int getTargetTransactions(int arr[], int target) {
        int sum = 0, steps = 0;

        //Get sum and check target acheived
        for (int i = 0; i < arr.length; i++) {
            steps+= 1;
            sum = sum + arr[i];

            //Check target achieved
            if(sum >= target){
                return steps;
            }
        }
        return 0;
    }

    //Driver Class
    public static void main(String args[]){

        //Get the size of transactions from user
        System.out.println("Enter the size of transaction array : ");
        int size = sc.nextInt();

        //Allocate an array of provided size
        int transcArray[] = new int [size];

        int target , totalTarget;

        System.out.println("Enter the values of array : ");
        //Get elements of transaction array
        for(int i = 0; i<size; i++){
            transcArray[i] = sc.nextInt();
        }

        //Get the total number of targets from user
        System.out.println("Enter the total no of targets that needs to be achieved : ");
        totalTarget = sc.nextInt();

        //Repeat the steps to get no of transaction for total targets
        while(totalTarget>0) {

            //Get target to be achieved from user
            System.out.println("Enter the value of target : ");
            target = sc.nextInt();

            //Calculate no of transaction required to achieve target
            int transactionCount = getTargetTransactions(transcArray, target);

            //Check target achieved
            if(transactionCount > 0)
                System.out.println("Target achieved after " + transactionCount + " transactions.");
            else
                System.out.println("Given target is not acheived");

            totalTarget--;
        }
    }
}
