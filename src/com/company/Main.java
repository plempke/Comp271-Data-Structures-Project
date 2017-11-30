package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int switchInt = 1;
        int userInput = 0;
        Scanner kb = new Scanner(System.in);

        System.out.println("Welcome to this Flashcard Application!");
        System.out.println("Start by creating a deck.");

        do {
            switch (switchInt) {
                case 1: System.out.println("1");
                    Deck newDeck = new Deck ();
                    //Create a deck
                    break;

                case 2: System.out.println("2");
                    //Study Deck by question

                    break;

                case 3: System.out.println("3");
                    //Study Deck by answer

                    break;

                case 4: System.out.println("4");
                    //Delete a deck
                    //Probably more useful if we implement multiple deck functionality
                    System.out.println("Are you sure you wish to delete your Flashcards?");
                    System.out.println("type 'n' to keep your flashcards, type anything else to delete them");
                    kb.nextLine();
                    if(kb.nextLine()=="n"){
                        break;
                    }
                    else{
                        newDeck = null;
                    }
                    break;

                case 5: break; //Ends Program

                default: System.out.println("invalid entry");
                    break;
            }

            System.out.println("Enter an integer to choose a menu option");
            System.out.println("1. Create a deck.");
            System.out.println("2. Study by term (top side).");
            System.out.println("3. Study by definition (bottom side).");
            System.out.println("4. Delete a deck.");
            System.out.println("5. Exit Program.\n");

            switchInt = kb.nextInt();

        } while (switchInt != 5);

    }
}

/*
class FlashCard {
    String question;
    String answer;

    FlashCard (String q, String a) {
            question = q;
            answer = a;
    }
}
*/