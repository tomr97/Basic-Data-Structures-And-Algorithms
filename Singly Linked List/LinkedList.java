package inlab3;
import java.util.Scanner;



public class LinkedList {
    Node first;
    
    Scanner scan = new Scanner(System.in);
    public LinkedList(){
        
    }
    
    public void menu(){
        call();
    }
    
    public void call(){
        int end = 0;
        String name;
        while(end != -1){
            System.out.println("What would you like to do?");
            System.out.println("Press 1 to add an item");
            System.out.println("Press 2 to print the list");
            System.out.println("Press 3 to delete an item");
            System.out.println("Press 4 to clear the whole list");
            System.out.println("Press -1 to exit");
            
            end = scan.nextInt();
            switch(end){
                case 1:
                    System.out.println("What is the student's name?");
                    scan.nextLine();//Grabs \n from hitting enter
                    name = scan.nextLine();
                    addItem(name);
                    break;
                case 2:
                    printList();
                    break;
                case 3:
                    System.out.println("What name would you like to delete?");
                    scan.nextLine();
                    String delete = scan.nextLine();
                    deleteItem(delete);
                    break;
                case 4:
                    clearList();
                    break;
                default:
                    break;
            }
        }
    }
    
    public void addItem(String name){
        Node temp = new Node(name);
        if (first == null)
            first=temp;
        else
        {
            temp.setNext(first);
            first = temp;
        }
    }
    
    public void printList(){
        
        Node iter = first;
        while(iter != null)
        {
            System.out.println(iter.toString());
            iter = iter.getNext();
        }        
    }
    
    public void deleteItem(String nom){
        Node iter = first;
        Node next;
        
        
        if (first.getName().equals(nom))
            first = first.getNext();
        
        next = iter.getNext();
        
        while(next != null)
        {   
            if(next.getName().equals(nom))
            {                         
                iter.setNext(next.getNext());
            }
            iter = next;
            next = next.getNext();
        }
        
    }
    
    public void clearList(){
        first = null;
    }
}
