package com.company;

import java.util.*;

public class Deck {

    Scanner kbDeck = new Scanner(System.in);
    int deckSize;
    String quest;
    String ans;
    Queue<FlashCard> myDeck = new LinkedList<FlashCard>();

    public Deck(){
        System.out.println("enter an integer deck size:");
        deckSize = kbDeck.nextInt();
        kbDeck.nextLine();
        FlashCard[] fcArray = new FlashCard[deckSize];

        for (int i=0; i<deckSize; i++) {
            System.out.println("\nCard " + (i+1) + "\n");
            System.out.println("enter the top side of the card:");
            quest = kbDeck.nextLine();
            System.out.println("enter the bottom side of the card:");
            ans = kbDeck.nextLine();
            fcArray[i] = new FlashCard(quest, ans);
            myDeck.add(fcArray[i]);
        }
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



class FlashCard {
    String question;
    String answer;

    FlashCard (String q, String a) {
        question = q;
        answer = a;
    }
}
