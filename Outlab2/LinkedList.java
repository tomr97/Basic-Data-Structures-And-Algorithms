/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlist;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Tom
 */
public class LinkedList {
    Node first, last;//creates first and last refernce nodes
    PrintWriter writer;//Declares a PrintWriter
    
    Scanner scan;//declares a scanner
    public LinkedList(){
        try{
        writer = new PrintWriter("LinkedListProgram.txt", "UTF-8");//creates file to write output to
        } catch (IOException e) {
   // do something
        }
    }
           
    public void call(){
        int N=0, k=0, m=0;
        
        Scanner scan1 = new Scanner(System.in);//Initializes scanner for user input
        File file;//declares file
        
        writer.println("Program 4");//Prints out begininning of output
        writer.println("---------");
        writer.println();
        
        int n = 0;//variable to keep track of whether the loop has been run before
        do{
            if(n>0)//checks to see if loop has been run before
                System.out.println("Error. Invalid file name. Try again.\n");//gives error statement
            
            System.out.println("Enter the name of your file: ");//asks for file name
        
            String file_name = scan1.nextLine();//reads in file name
        
            file = new File(file_name);//initializes file
            
            n++;
        }while(!file.exists());  //checks existence of file
        try{
                scan = new Scanner(file);//initializes scanner for file
        }catch(FileNotFoundException e)
            {
                System.out.println("Error. File does not exist please try again.\n\n");
            }
        
        
        //Scans in N, k, m
        N = scan.nextInt();
        k = scan.nextInt();
        m = scan.nextInt();
        
        
                    
                writer.println("N = " + N + ", k = " + k + ", m = " + m);//prints variable values
                writer.println();
            
                for(int i = 0; i < N; i++)
                {
                    addItem(i+1);//adds N number of nodes
                }
                        
                Node iter_k = first;//declares to reference nodes to traverse the linked list
                Node iter_m = first.getPrev();
            
                writer.println("Output");
                writer.println("------");
            
                do{                
                    for(int i =0; i< k; i++)
                    {
                        iter_k = iter_k.getNext();//sends value counter clockwise to the kth place
                    }
                
                
                
                    for(int j=0; j<m; j++)
                    {
                        iter_m = iter_m.getPrev();//goes clockwise to mth place
                    }
                
                
                
                    if( iter_k.getPrev().getName() != iter_m.getPrev().getName() )//checks if values are equal
                    {
                        writer.println(iter_k.getPrev().getName() + "\t" + iter_m.getNext().getName() );//if not, prints values
                        deleteItem(iter_k.getPrev());//deletes values
                        deleteItem(iter_m.getNext());
                    }
                    else
                    {
                        writer.println(iter_m.getName());//prints out last value to be deleted
                        deleteItem(iter_m);//deletes last value
                    }
                
                    
                
                }while( (iter_k.getName() != iter_m.getName()));
            
                writer.println(first.getName());//prints last remaining value
                writer.println();//adds a new line
            
            
        writer.println("\nEnd of Program 4");
        writer.close();//closes file
        
    }
    
    public void addItem(int name){//adds item
        Node temp = new Node(name);//creates temporary node
        
        if (first == null)//checks if node is first node
        {
            first=temp;
            first.setNext(first);
            first.setPrev(first);
            last = first;
        }   
        else
        {
            temp.setNext(first);
            temp.setPrev(first.getPrev());
            first.getPrev().setNext(temp);
            first.setPrev(temp);
        }
    }
    
    
    
    public void deleteItem(Node nom){//deletes node from list
        //Node iter = first;
        //Node next;
        
        if(nom == first)//checks if value is first
            first=nom.getPrev();
        nom.getPrev().setNext(nom.getNext());
        
        nom.getNext().setPrev(nom.getPrev());
        
    }
    
}
