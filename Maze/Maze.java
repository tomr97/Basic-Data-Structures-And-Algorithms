/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;
import java.util.Scanner;
/**
 *
 * @author Tom
 */
public class Maze {
    
    final static char[][] maze = new char[][] {//Sets up the map as a 2d matrix
        { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },//row 1
        { '#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#' },//row 2
        { '.', '.', '#', '.', '#', '.', '#', '#', '#', '#', '.', '#' },//row 3
        { '#', '#', '#', '.', '#', '.', '.', '.', '.', '#', '.', '#' },//row 4
        { '#', '.', '.', '.', '.', '#', '#', '#', '.', '#', '.', '#' },//row 5 
        { '#', '#', '#', '#', '.', '#', 'F', '#', '.', '#', '.', '#' },//row 6
        { '#', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#' },//row 7
        { '#', '#', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#' },//row 8
        { '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#' },//row 9
        { '#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '.', '#' },//row 10
        { '#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#' },//row 11
        { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' }//row 12
    };
    
    private static void print(char[][] _maze, int rLoc, int cLoc)//function to print out maze
            {
               for(int i = 0; i<12; i++)//cycles through all of the rows
               {
                   for(int j=0; j<12; j++)//cycles through all of the columns
                   {
                        if(i==rLoc && j==cLoc)//if at location of person in maze
                        {
                            if(_maze[i][j]!='F')//if not at the finish
                            {
                                _maze[i][j] = 'X';//change current location from '.' to 'X'
                            }
                            System.out.print("O ");//print out where the person is
                        }
                        else//if not at person's location
                        {
                            System.out.print((char)(_maze[i][j]) + " " );//Print out character at index                        
                        }    
                   }
                   System.out.println();//go to the next line before next row prints
               }
            }
    
    private static void traverse(char[][] _maze, int row, int col, int rh_row, int rh_col)//recursive function to traverse maze
    {
        Scanner scan = new Scanner(System.in);//sets up scanner so maze can move step by step
        print(_maze, row, col);//prints maze and gives current location
        scan.nextLine();//makes user press the "ENTER" key to continue
        char direction;//has a char showing direction
        direction = get_dir(row, col, rh_row, rh_col);//gets direction person is facing 
        
        if(_maze[row][col] == 'F')//checks if person is at finish
        {
            System.out.println("You reached the finish!");//if so, tells user
        }
        else//if not, call the function again depending on location facing and surroundings
        {
            switch(direction)//has a switch case for movement depending on direction facing
            {
                case 'N'://If facing north(up)
                    if(_maze[rh_row][rh_col] != '#')//if right hand is not on a '#', turns right
                    {
                        traverse(_maze, row, col+1, row+1, col+1);
                    }
                    else if( _maze[row-1][col]!='#' )//else if one space ahead is not a '#'
                    {
                        traverse(_maze, row-1, col, row-1, col+1);
                    }
                    else//else turns left
                    {
                        traverse(_maze, row, col, row-1, col);
                    }
                    break;
                case 'E': // If facing East(right)
                    if(_maze[rh_row][rh_col] != '#')//if right hand is not on a '#', turns right
                    {
                        traverse(_maze, row+1, col, row+1, col-1);
                    }
                    else if( _maze[row][col+1]!='#' )//else if one space ahead is not a '#'
                    {
                        traverse(_maze, row, col+1, row+1, col+1);
                    }
                    else//else turns left
                    {
                        traverse(_maze, row, col, row, col+1);
                    }
                    break;
                case 'S'://If facing south(down)
                    if(_maze[rh_row][rh_col] != '#')//if right hand is not on a '#', turns right
                    {
                        traverse(_maze,row, col-1, row-1, col-1);
                    }
                    else if( _maze[row+1][col]!='#' )//else if one space ahead is not a '#'
                    {
                        traverse(_maze, row+1, col, row+1, col-1);
                    }
                    else//else turns left
                    {
                        traverse(_maze, row, col, row+1, col);
                    }
                    break;                
                case 'W'://if facing west(left)
                    if(_maze[rh_row][rh_col] != '#')//if right hand is not on a '#', turns right
                    {
                        traverse(_maze, row-1, col, row-1, col+1);
                    }
                    else if( _maze[row][col-1]!='#' )//else if one space ahead is not a '#'
                    {
                        traverse(_maze, row, col-1, row-1, col-1);
                    }
                    else//else turns left
                    {
                        traverse(_maze, row, col, row, col-1);
                    }
                    break;
            }                    
        }
    }  
    
    
    private static char get_dir(int row, int col, int rh_row, int rh_col )//function to get direction
    {
        int col_diff, row_diff;//variables to keep the difference between the rows and columns from location and right hand
        
        col_diff = rh_col - col;//gets difference of the column of the right hand and the column of the location
        row_diff = rh_row - row;//gets difference of the row of the right hand and the row of the location
        char r_val = 'E';//declares return value with initial value 'E' for east
        
        switch(row_diff)//switch case for direction
        {
            case -1://if rh_row < row, sets return val to 'W' for west
                r_val = 'W';
                break;
            case 0://if rh_row == row, checks if north or south
                switch(col_diff)
                {
                    case -1://if rh_col < col, sets return val to 'S' for south
                        r_val = 'S';
                        break;
                    case 1://if > col, sets return val to 'N' for north
                        r_val = 'N';
                        break;
                }
                break;
            case 1://if rh_row > row, sets return val to 'E' for east
                r_val = 'E';
                break;                    
        }
        
        return r_val;//returns return val
    }
    
    public static void main(String[] args) {        
        traverse(maze, 2, 0, 3, 0);//calls traverse with initial conditions        
    }    
}
