/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class Player {
    
    Scanner scan = new Scanner(System.in);
    
    String player_name;
    int player_score, dealer_score, points;
    ArrayList<Integer> player_cards = new ArrayList<>();
    ArrayList<Integer> dealer_cards = new ArrayList<>();
    Game black_jack = new Game(); 
    
    Player(String p_name)
    {
        player_name = p_name;
        points = 500;       
    }
    
    public void draw()
    {
        player_score =0;
        dealer_score = 0;
        
        black_jack.reshuffle();
        
        player_cards.clear();
        dealer_cards.clear();
        
        int points_bet=0;
        boolean repeat=true;
        boolean has_lost=false;
        int count=0;
        do
        {
            
            if(count == 0)
            {        
                do{
                    //Asks for points to bet
                    System.out.print(player_name + " has ");
                    System.out.print(points);
                    System.out.println(" points, how many would you like to bet? ");
                    points_bet = scan.nextInt();
                    
                }while(points_bet > points);//Makes sure player has that many points
                //Grabs card for player and dealer
                player_cards.add(black_jack.grab_card());
                player_score += black_jack.card_value(player_cards.get(0));
                player_cards.add(black_jack.grab_card());
                player_score += black_jack.card_value(player_cards.get(1));
                player_cards.add(black_jack.grab_card());
                player_score += black_jack.card_value(player_cards.get(2));
                
                dealer_cards.add(black_jack.grab_card());
                dealer_score += black_jack.card_value(dealer_cards.get(0));
                dealer_cards.add(black_jack.grab_card());
                dealer_score += black_jack.card_value(dealer_cards.get(1));                
                dealer_cards.add(black_jack.grab_card());
                dealer_score += black_jack.card_value(dealer_cards.get(2));
                //Tells cards drawn by player
                System.out.println("Cards drawn by you: ");
                for(int c=0; c<3; c++)
                {
                    System.out.println(black_jack.card_value(player_cards.get(c)));
                }
                System.out.println("Your total is:  " + player_score );
                
                count = 3;                
                System.out.print("\nDealer drew two cards and: ");
                System.out.println(black_jack.card_value(dealer_cards.get(2)));
            }
            else
            {
                char response;
                //Determines if player wants another card
                System.out.println("\nWould you like to draw another card?");
                scan.nextLine();
                System.out.println("Hit \'Y\' for yes and \'N\' for no: ");
                response = scan.next().charAt(0);
                
                if(response == 'Y' || response == 'y')//Gives player new card if wanted
                {
                    player_cards.add(black_jack.grab_card());
                    player_score += black_jack.card_value(player_cards.size()-1);
                    
                    System.out.print("\n" + player_name + " drew a: ");
                    System.out.println(black_jack.card_value(player_cards.size()-1));
                    System.out.println("Your total is:  " + player_score );
                }
                else
                {
                    repeat = false;
                }//Stops the repeating if player wants to
            }
            
            if(player_score > 31)
            {
                has_lost=true;
            }
            count++;
        }while(repeat && !has_lost);
        
        if(has_lost)
        {
            System.out.print(player_name);
            System.out.println(" has lost. Dealer wins.\n");
        }
        else
        {
            count = 3;
            while(dealer_score < 26)//draws for dealer until score is at least 26
            {
                dealer_cards.add(black_jack.grab_card());
                dealer_score += black_jack.card_value(dealer_cards.get(count));
                count++;
            }
            
            if(dealer_score > 31)//Dealer loses if score greater than 31
            {
                System.out.print("Dealer has lost. ");
                System.out.print(player_name);
                System.out.print(" has won.\n");
            }
            else
            {//Determines winner and loser
                if( (dealer_score - player_score) > 0 )
                {
                    System.out.print(player_name);
                    System.out.println(" has lost. Dealer wins.\n");
                    points-=points_bet;
                }
                else if( (dealer_score - player_score) < 0 )
                {
                    System.out.print("Dealer has lost. ");
                    System.out.print(player_name);
                    System.out.print(" has won.\n");
                    points+=points_bet;
                }
                else
                {
                    System.out.println("It is a tie.\n");
                }
            }
        }
        
    }
    
    int get_points()//returns player points
    {
        return points;
    }
    
}
