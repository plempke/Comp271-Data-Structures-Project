package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int switchInt = 1;
        int userInput;
        String userConfirm;
        Scanner kb = new Scanner(System.in);
        Deck newDeck;
        List<Deck> deckList = new ArrayList<Deck>();
        String nameTemp;

        System.out.println("Welcome to this Flashcard Application!");
        System.out.println("Start by creating a deck.");

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
                        if (userInput > deckList.size()) {
                            System.out.println("Selection not a valid deck.");
                            break;
                        }
                        deckList.get(userInput-1).studyByQuestion();
                    }
                    break;

                case 3: System.out.println("3");
                    //Study Deck by answer
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
                        if (userInput > deckList.size()) {
                            System.out.println("Selection not a valid deck.");
                            break;
                        }
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
                    kb.nextLine();
                    if (userInput > deckList.size()) {
                        System.out.println("Selection not a valid deck.");
                        break;
                    }
                    System.out.println("Are you sure you wish to delete " + deckList.get(userInput-1).deckName + "? (Y/N)");
                    userConfirm = kb.nextLine();
                    if (userConfirm.equalsIgnoreCase("y")) { // WHY IT NO WORK PHIL HELP ME
                        deckList.remove((userInput - 1));
                        System.out.println("Deck deleted");
                    }
                    else{
                        System.out.println("Deck kept");
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
            kb.nextLine();

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