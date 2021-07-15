/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Tom
 */
public class Card {
    
    private String value;//The number or letter printed on the card
    private int num_value;
    private String suit;//String holding the card's suit
    private int points;//Amount of points given for the particular card
    
    public Card(int card_num)//uses index value for card assignment
    {
        points = card_num%13+1;
        if(points>10)
            points=10;//ensures that highest value of card is 10        
        
        switch(card_num % 13){
            case 0: value = "Ace";
                    num_value = 1;
                    break;
            case 1: value = "2";
                    num_value = 2;
                    break;
            case 2: value = "3";
                    num_value = 3;
                    break;
            case 3: value = "4";
                    num_value = 4;
                    break;
            case 4: value = "5";
                    num_value = 5;
                    break;
            case 5: value = "6";
                    num_value = 6;
                    break;
            case 6: value = "7";
                    num_value = 7;
                    break;
            case 7: value = "8";
                    num_value = 8;
                    break;
            case 8: value = "9";
                    num_value = 9;
                    break;
            case 9: value = "10";
                    num_value = 10;
                    break;
            case 10: value = "Jack";
                    num_value = 10;
                    break;
            case 11: value = "Queen";
                    num_value = 10;
                    break;
            case 12: value = "King";
                    num_value = 10;
                    break;
            default: value = "Ace";
                    num_value = 1;
                    break;
        }
        
        switch(card_num / 13){
            case 0: suit = "Hearts";
                    break;
            case 1: suit = "Spades";
                    break;
            case 2: suit = "Clubs";
                    break;
            default: suit = "Diamonds";
                    break;
        }
    }
    
    public String get_suit()
    {
        return suit;
    }
    
    public int get_value()
    {
       return num_value;
    }
    
    public String card_drawn()
    {
        String card;
        card = value + " of " + suit;
        return card;
    }
}
