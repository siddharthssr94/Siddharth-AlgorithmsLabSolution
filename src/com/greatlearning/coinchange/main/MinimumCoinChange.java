package com.greatlearning.coinchange.main;

import com.greatlearning.coinchange.services.SortDenominations;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumCoinChange {
    private static Scanner sc = new Scanner(System.in);

    //Global Variables
    public static int denominations[],denominationCount[] , transactionSize, originalAmount;

    //Get inputs from user
    void getInputs() {

        //Get the size of denominations from user
        System.out.println("Enter the size of currency denominations : ");
        transactionSize = sc.nextInt();
        System.out.println();

        //Allocate an array of provided size
        denominations = new int[transactionSize];

        //Get Denominations from user
        System.out.println("Enter the currency denominations value : ");
        for (int i = 0; i < transactionSize; i++) {
            denominations[i] = sc.nextInt();
        }

    }

    //Calculate remaining amount after coin change and save count of coin for each denomination
    int getMinimumCoinChange(){
        //Allocate an array of provided size
        denominationCount = new int[transactionSize];
        int amount = originalAmount;
        System.out.println();

        // Get Currency count
        for (int i = 0; i < denominations.length; i++) {
            //get no. of notes of current denomination
            int count = (int) (amount / denominations[i]);
            denominationCount[i] = count;

            // set amount to the remaining amount
            amount = amount - (count * denominations[i]);
        }
        return amount;
    }

    //Display denomination and its coin count
    void displayCoinChange(){
        System.out.println("Your payment approach in order to give min no of notes will be : ");
            for (int i = 0; i < denominations.length; i++) {
                if(denominationCount[i] > 0)
                    System.out.println(denominations[i] + " : " + denominationCount[i]);
            }
    }

    //Driver Class
    public static void main(String args[]) {

        MinimumCoinChange change = new MinimumCoinChange();
        change.getInputs();

        //Sort Denomination in descending order
        SortDenominations sd = new SortDenominations();
        sd.sort(denominations, 0, denominations.length - 1);

        //Get the amount to be paid from user
        System.out.println("Enter the amount you want to pay : ");
        originalAmount = sc.nextInt();

        int size = denominations.length;
        boolean changePossible = false;

        while(size>0){

            //Get amount left after change
            int amount = change.getMinimumCoinChange();

            if (amount !=0){
                //Remove 1st(highest always) denomination from the array
                denominations = Arrays.copyOfRange(denominations,1,transactionSize);
                size--;
                continue;
            }else{
                changePossible = true;
                break;
            }

        }

        //Display Result
        if(changePossible == false)
            System.out.println("Given amount is not achievable with given denominations.");
        else
            //Display the denomination with count
            change.displayCoinChange();
    }
}
