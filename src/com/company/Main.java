package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int switchInt = 1;
        int userInput = 0;
        String confirm;
        Scanner kb = new Scanner(System.in);
        Deck newDeck = null;
        List<Deck> deckList = new ArrayList<Deck>();
        String nameTemp;

        System.out.println("Welcome to this Flashcard Application!");
        System.out.println("StartuserInput by creating a deck.");

        do {
            switch (switchInt) {
                case 1: System.out.println("1");
                    //Create a deck
                    System.out.println("Enter deck name:");
                    nameTemp = kb.nextLine();
                    newDeck = new Deck (nameTemp);
                    deckList.add(newDeck);
                    break;

                case 2: System.out.println("2");
                    //Study Deck by question
                    if (deckList.size()==0) {
                        System.out.println("No deck is stored");
                        break;
                    }
                    else {
                        System.out.println("Enter an integer to select a deck to study:\n");
                        for (int i = 0; i<deckList.size(); i++) {
                            System.out.println((i+1) + ". " + deckList.get(i).deckName);
                        }
                        userInput = kb.nextInt();
                        deckList.get(userInput-1).studyByQuestion();
                    }
                    break;

                case 3: System.out.println("3");
                    //Study Deck by answer
                    if (newDeck == null) {
                        System.out.println("No deck is stored");
                        break;
                    }
                    else {
                        System.out.println("Enter an integer to select a deck to study:\n");
                        for (int i = 0; i<deckList.size(); i++) {
                            System.out.println((i+1) + ". " + deckList.get(i).deckName);
                        }
                        userInput = kb.nextInt();
                        deckList.get(userInput-1).studyByAnswer();
                    }
                    break;

                case 4: System.out.println("4");
                    //Delete a deck
                    //Probably more useful if we implement multiple deck functionality
                    System.out.println("Enter an integer to choose a deck to delete:\n");
                    for (int i = 0; i<deckList.size(); i++) {
                        System.out.println((i+1) + ". " + deckList.get(i).deckName);
                    }
                    userInput = kb.nextInt();
                    System.out.println("Are you sure you would like to delete " + deckList.get(userInput-1).deckName + "? (Y/N)");
                    if (kb.next()=="y"||kb.next()=="Y") {
                        deckList.remove(userInput - 1);
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