package TexasHoldEm;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class Card implements Comparable<Card> {
    
    private int value;
    private String suit;
    private Color colour;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit.toLowerCase();
        
        if (suit.equalsIgnoreCase("hearts") || suit.equalsIgnoreCase("diamonds")) {
            this.colour=Color.red;
        }
        else {
            this.colour=Color.black;
        }
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public Color getColour() {
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
            return symbol+"A";
        }
        if (value==13) {
            return symbol+"K";
        }
        if (value==12) {
            return symbol+"Q";
        }
        if (value==11) {
            return symbol+"J";
        }
        
        return symbol+value;
    }
    
    public static void main(String[] args) {
        
        Stack<Card> pakka=new Stack<>();
        
        for(int i=1;i<14;i++) {
        
        pakka.add(new Card(i,"spades"));
        pakka.add(new Card(i,"hearts"));
        pakka.add(new Card(i,"clubs"));
        pakka.add(new Card(i,"diamonds"));
        }
        
        System.out.println(pakka);
        
        Collections.shuffle(pakka);
        System.out.println(pakka);
        
        Collections.shuffle(pakka);
        System.out.println(pakka);
        
        Collections.shuffle(pakka);
        System.out.println(pakka);
        
//        Card kortti = pakka.pop();
//        
//        System.out.println(kortti.getColour()+","+kortti);
//        
//        kortti = pakka.pop();
//        
//        System.out.println(kortti.getColour()+","+kortti);
        
        
    }

    @Override
    public int compareTo(Card o) {
        Integer value=this.value;
        return value.compareTo(o.value);
    }
    
}
