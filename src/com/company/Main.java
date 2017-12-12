package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int firstSwitchInt = 1;                     // create, select, end.
        int secondSwitchInt;                        // Study by question/answer, shuffle, delete.
        int userInput;                              // used for deck selection
        String userConfirm;                         // Y/N string for confirmation
        Scanner kb = new Scanner(System.in);        // Keyboard
        Deck newDeck;                               // temporary storage for deck creation
        Deck selectedDeck;                          // storage for selected deck sub-menu
        List<Deck> deckList = new ArrayList<Deck>();   // list of decks
        String nameTemp;                            // temporary string for the name of the new deck in deck creation



        System.out.println("Welcome to this Flashcard Application!");
        System.out.println("Start by creating a deck.");




        do {    // This is a do statement so that we can push the user to create a deck right off the bat.
            switch (firstSwitchInt) {

                case 1: // Create a deck

                    //System.out.println("1"); //Debug purposes
                    System.out.println("Enter deck name:");
                    nameTemp = kb.nextLine();
                    newDeck = new Deck(nameTemp);
                    deckList.add(newDeck);  // creates a new deck with the name as an argument
                    break;

                case 2: // Select a deck

                    //System.out.println("2"); //Debug purposes
                    if (deckList.size() == 0) {
                        System.out.println("No deck is stored");    // this if statement is for the case that there is no deck
                        break;
                    }

                    else {
                        System.out.println("Enter an integer to select a deck:\n");
                        for (int i = 0; i < deckList.size(); i++) {
                            System.out.println((i + 1) + ". " + deckList.get(i).deckName);  // this for loop prints out all the deck names with a "#. " before them
                        }
                        userInput = kb.nextInt();

                        if (userInput > deckList.size() || userInput <= 0) {  // this if statement runs if the user inputs a number higher than the number of decks or is less than or equal to 0
                            System.out.println("Selection not a valid deck.");
                            break;
                        }
                        selectedDeck = deckList.get(userInput-1);   // takes the deck that the user selected and stores it in SelectedDeck




                                // beginning of the sub-menu for the individual deck
                        do {    // this is a do rather than a while so that when the user selects 5 to return to the main menu, this loop will still run correctly upon returning

                            System.out.println("\n1. Study " + selectedDeck.deckName + " by question");
                            System.out.println("2. Study " + selectedDeck.deckName + " by answer");
                            System.out.println("3. Shuffle " + selectedDeck.deckName);
                            System.out.println("4. Delete " + selectedDeck.deckName);
                            System.out.println("5. Return to main menu\n");

                            secondSwitchInt = kb.nextInt();
                            kb.nextLine();

                            switch (secondSwitchInt) {
                                case 1:
                                    //Study by question
                                    selectedDeck.studyByQuestion(); // runs the studyByQuestion method
                                    break;

                                case 2:
                                    //Study by answer
                                    selectedDeck.studyByAnswer();   // runs the studyByAnswer method
                                    break;

                                case 3:
                                    //Shuffle Deck
                                    //selectedDeck.shuffle
                                    System.out.println("Shuffle is not yet implemented");   // Debug purposes
                                    break;

                                case 4:
                                    //Delete Deck
                                    System.out.println("Are you sure you wish to delete " + selectedDeck.deckName + "? (Y/N)"); // The confirmation inquiry exists for the case that the user hits 4 on accident (user health)
                                    userConfirm = kb.nextLine();
                                    if (userConfirm.equalsIgnoreCase("y")) {
                                        deckList.remove((userInput - 1));   // deleting the deck stored in selectedDeck does not actually remove it from the list as selectedDeck is just copy of the deck from the list
                                                                            // one benefit of using a dummy deck for these operations is that the original order is stored in the event that the user wants to return to the original deck order after shuffling.
                                        System.out.println("Deck deleted.");    //debug purposes
                                    }
                                    else {
                                        System.out.println("Deck not deleted.");    //debug purposes
                                    }
                                    break;

                                case 5:
                                    // return to main menu
                                    // it's more important that secondSwitchInt = 5 for the while statement below than the actual case statement here
                                    break;

                                default:    // if the user inputs a number that is not 1-5
                                    System.out.println("Invalid choice");

                            }
                        } while (secondSwitchInt != 5); // if the user imputs 5 for the case statement, this while will break
                        System.out.println("Returning to main menu.");  // debug purposes
                    }
                    break;




                case 3:
                    // end program
                    // it's more important that firstSwitchInt = 3 for the while statement below than the actual case statement here
                    break;

                default:
                    System.out.println("invalid entry");
                    break;
            }
            
            // the menu prints and prompts user selected down here because it is a do loop rather than a while.
            // this is so we can push the user straight into creating a deck without extraneously printing the menu options
            System.out.println("Enter an integer to choose a menu option");
            System.out.println("1. Create a deck.");
            System.out.println("2. Select a deck.");
            System.out.println("3. Exit Program.\n");

            firstSwitchInt = kb.nextInt();
            kb.nextLine();

        } while (firstSwitchInt != 3);
    }
}