package TexasHoldEm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Card {
    
    private int value;
    private String suit;
    private String colour;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit.toLowerCase();
        
        if (suit.equalsIgnoreCase("hearts") || suit.equalsIgnoreCase("diamonds")) {
            this.colour="red";
        }
        else {
            this.colour="black";
        }
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        
        String symbol="";
        
        if (suit.equals("hearts")) symbol="♥";
        else if (suit.equals("diamonds")) symbol="♦";
        else if (suit.equals("spades")) symbol="♠";
        else if (suit.equals("clubs")) symbol="♣";
        
        if (value==1) {
            
        }
        
        return symbol+value;
    }
    
    public static void main(String[] args) {
        
        List<Card> pakka=new ArrayList<>();
        
        for(int i=1;i<14;i++) {
        
        pakka.add(new Card(i,"spades"));
        pakka.add(new Card(i,"hearts"));
        pakka.add(new Card(i,"clubs"));
        pakka.add(new Card(i,"diamonds"));
        }
        
        Collections.shuffle(pakka);
        System.out.println(pakka);
        
        
        
        System.out.println(pakka.get(0).getColour());
        
        
    }
    
}
