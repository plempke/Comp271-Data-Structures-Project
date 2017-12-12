package com.company;

import java.util.*;

public class Deck {

    Scanner kbDeck = new Scanner(System.in);        // scanner for this class
    int deckSize;                                   // integer for the number of cards in the deck
    // this integer is not actually the number of cards in the deck but is equal to it instead.
    // basically, when the number of cards in the deck changes from the pop method, this number does not actually change and allows the for loops to run correctly
    String deckName;                                // name of the deck
    String quest;                                   // top side of the deck (question)
    String ans;                                     // bottom side of the deck (answer)
    Queue<FlashCard> myDeck = new LinkedList<FlashCard>();  // queue to display cards in the order they are entered


    public Deck(String name) {   // constructor using the argument from line 33 in Main.java
        deckName = name;
        System.out.println("Enter an integer deck size:");  // rather than ask the user if they want to enter a new card every time, we ask ahead of time what the deck size for faster, more streamlined deck creation
        deckSize = kbDeck.nextInt();
        kbDeck.nextLine();
        FlashCard[] fcArray = new FlashCard[deckSize];  // creates an array of flashcards the size of the user inputted value

        for (int i = 0; i < deckSize; i++) {    // creates one card and repeats an amount of times equal to the user input for deck size
            System.out.println("\nCard " + (i + 1));
            System.out.println("enter the top side of the card:");
            quest = kbDeck.nextLine();
            System.out.println("enter the bottom side of the card:");
            ans = kbDeck.nextLine();
            fcArray[i] = new FlashCard(quest, ans); // constructor to create a flashcard (9 line class at the bottom of this file)
            myDeck.add(fcArray[i]); // adds the flashcard to the queue
        }
    }

    public void studyByQuestion() {  // runs through the queue displaying the top side of the card

        FlashCard temp;
        for (int i = 0; i < deckSize; i++) {    // this is where deckSize's unchanging value is important as the deck's actual size DOES change during this loop
            temp = myDeck.poll();   // pulls the card out of the front of the queue (this removes it from the queue)
            System.out.println("Top:");
            System.out.println(temp.question);
            kbDeck.nextLine();
            System.out.println("Bottom:");
            System.out.println(temp.answer + "\n");
            myDeck.add(temp);       // re-adds the pulled card to the back of the queue

        }
    }

    public void studyByAnswer() {    // runs through the queue displaying the bottom side of the card

        FlashCard temp;
        for (int i = 0; i < deckSize; i++) {    // this is where deckSize's unchanging value is important as the deck's actual size DOES change during this loop
            temp = myDeck.poll();   // pulls the card out of the front of the queue (this removes it from the queue)
            System.out.println("Bottom:");
            System.out.println(temp.answer);
            kbDeck.nextLine();
            System.out.println("Top:");
            System.out.println(temp.question + "\n");
            myDeck.add(temp);   // re-adds the pulled card to the back of the queue
        }
    }

    public void showDeck() {
        FlashCard temp;

        for (int i = 0; i < deckSize; i++) {
            temp = myDeck.poll();
            System.out.println("Card " + (i+1));
            System.out.println(temp.question);
            System.out.println(temp.answer);
            myDeck.add(temp);

        }
    }

    public void shuffleDeck() {
        FlashCard[] shuffleDeck = new FlashCard[deckSize];
        FlashCard temp;

        for (int i = 0; i < deckSize; i++) {     //pulls queue and stores in array
            shuffleDeck[i] = myDeck.poll();
        }
        for (int i = deckSize - 1; i >= 1; i--) {       //shuffles the created array
            int n = (int) Math.floor(Math.random() * (i));
            temp = shuffleDeck[i];
            shuffleDeck[i] = shuffleDeck[n];
            shuffleDeck[n] = temp;
        }
        for (int i = 0; i < deckSize; i++) {     //post shuffle
            myDeck.add(shuffleDeck[i]);
        }
    }


    /*
        Scanner kb = new Scanner(System.in);
        int cardTotal = 0;
        String quest;
        String ans;
        Queue<FlashCard> myDeck = new LinkedList<FlashCard>();

        System.out.println("enter a card amount:");
        cardTotal = kb.nextInt();
        kb.nextLine();
        FlashCard[] fcArray = new FlashCard[cardTotal];

        for(int i=0; i<cardTotal; i++){
            System.out.println("\nCard " + (i+1) + "\n");
            System.out.println("enter the top side of the card:");
            quest = kb.nextLine();
            System.out.println("enter the bottom side of the card");
            ans = kb.nextLine();
            fcArray[i] = new FlashCard(quest, ans);
            myDeck.add(fcArray[i]);
        }
    }
    */


    class FlashCard {       // very simple custom object that just holds two strings representing two sides of a flashcard
        String question;    // top side
        String answer;      // bottom side

        FlashCard(String q, String a) {    // constructor from line 29 of this file
            question = q;
            answer = a;
        }
    }
}