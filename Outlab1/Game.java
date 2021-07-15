/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author Tom
 */
public class Game {
    
    Random rand = new Random();   
    Card[] deck = new Card[52];
    int[] is_used = new int[52];
    
    
    
    public Game()
    {
        for(int i=0; i<50; i++)
        {
            deck[i] = new Card(i);   
        }
    }
    
    int grab_card()
    {
        int index;
        
                
        index = rand.nextInt(1000) % 52;
        
        return index;    //Returns index of card
    }
    
    int card_value(int i)
    {
        return deck[i].get_value();
    }
    
    String card_suit(int i)
    {
        return deck[i].get_suit();
    }
    
    String drawn_card(int i)
    {
        return deck[i].card_drawn();
    }
    
    void reshuffle()
    {
        Arrays.fill(is_used, 0);
    }
}