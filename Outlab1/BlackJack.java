/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;

/**
 *
 * @author Tom
 */
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        Player p1 = new Player("Tom");
        char repeat;
        boolean bool_repeat;
        do
        {
            
            bool_repeat = false;
            p1.draw();
            System.out.println("Would you like to draw again?\nType \'Y\' for yes and \'N\' for no: " );
            repeat = scan.next().charAt(0);
            
            if(repeat == 'Y' || repeat == 'y')
                bool_repeat = true;
            
        }while((p1.get_points() > 0) && bool_repeat);
        
        Player p2 = new Player("Mike");
        do
        {
            
            bool_repeat = false;
            p2.draw();
            System.out.println("Would you like to draw again?\nType \'Y\' for yes and \'N\' for no: " );
            repeat = scan.next().charAt(0);
            
            if(repeat == 'Y' || repeat == 'y')
                bool_repeat = true;
            
        }while((p2.get_points() > 0) && bool_repeat);
        
        Player p3 = new Player("Steve");
        do
        {
            
            bool_repeat = false;
            p3.draw();
            System.out.println("Would you like to draw again?\nType \'Y\' for yes and \'N\' for no: " );
            repeat = scan.next().charAt(0);
            
            if(repeat == 'Y' || repeat == 'y')
                bool_repeat = true;
            
        }while((p3.get_points() > 0) && bool_repeat);
        Player p4 = new Player("Frank");
        do
        {
            
            bool_repeat = false;
            p4.draw();
            System.out.println("Would you like to draw again?\nType \'Y\' for yes and \'N\' for no: " );
            repeat = scan.next().charAt(0);
            
            if(repeat == 'Y' || repeat == 'y')
                bool_repeat = true;
            
        }while((p4.get_points() > 0) && bool_repeat);
    
    }
    
    
}
