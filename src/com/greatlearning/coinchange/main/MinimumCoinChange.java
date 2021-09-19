package com.greatlearning.coinchange.main;
import com.greatlearning.coinchange.services.SortDenominations;
import java.util.Scanner;

public class MinimumCoinChange {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        //Get the size of denominations from user
        System.out.println("Enter the size of currency denominations : ");
        int size = sc.nextInt();
        System.out.println();

        //Allocate an array of provided size
        int denominations[] = new int[size];
        int denominationCount[] = new int[size];

        //Get Denominations from user
        System.out.println("Enter the currency denominations value : ");
        for (int i = 0; i < size; i++) {
            denominations[i] = sc.nextInt();
        }
        System.out.println();

        //Sort Deonimation in descending order
        SortDenominations sd = new SortDenominations();
        sd.sort(denominations, 0, denominations.length - 1);

        //Get the amount to be paid from user
        System.out.println("Enter the amount you want to pay : ");
        int amount = sc.nextInt();
        System.out.println();

        // Get Currency count
        for (int i = 0; i < denominations.length; i++) {
            //get no. of notes of current denomination
            int count = (int) (amount / denominations[i]);
            denominationCount[i] = count;

            // set amount to the remaining amount
            amount = amount - (count * denominations[i]);
        }

        if (amount != 0) {
            System.out.println("Given amount is not acheivable with given denominations.");
        } else {
            System.out.println("Your payment approach in order to give min no of notes will be : ");
            for (int i = 0; i < denominations.length; i++) {
                if(denominationCount[i] > 0)
                    System.out.println(denominations[i] + " : " + denominationCount[i]);
            }
        }
    }
}
