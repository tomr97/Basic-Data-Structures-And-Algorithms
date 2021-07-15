/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author g89h939
 */
package Inlab6;

public class Heap {
    private int[] heap;
   
    public Heap(){
        heap = new int[25];
        
    }
    
    public void insert(int inNum){
        //  Set an emptyIndex which will find the first index that has not been used yet.
        int emptyIndex = 0;
        while(heap[emptyIndex] != 0){
            emptyIndex++;
        }
        //  Set inNum to the first index that has not been used.
        heap[emptyIndex] = inNum;
        
        boolean finished = false;
        
        while(emptyIndex > 0 && finished == false){
            //  Campares inNum to parent. If parent is greater than inNum, switch.
            //  Then set emptyIndex to parent index.
            if(heap[emptyIndex] < heap[(emptyIndex - 1)/2]){
                int temp = heap[emptyIndex];
                heap[emptyIndex] = heap[(emptyIndex - 1)/2];
                heap[(emptyIndex - 1)/2] = temp;
                emptyIndex = (emptyIndex-1)/2;
            //  Finished is true if inNum is greater than parent.
            }else{
                finished = true;
            }
        }
    }
    
    public void print()
    {
        for(int i=0; heap[i] != 0; i++)
        {
            System.out.println(heap[i]);
        }
        System.out.println();
    }
    
    public int remove(){
        //  Remember value that is being removed for later reference.
        int returnVal = heap[0];
        
        //  lastIndex finds the last index that was used
        int lastIndex = 0;
        while(heap[lastIndex] != 0){
            lastIndex++;
        }
        lastIndex--;
        
        //  Switch the first index with the last index to remove the value in the first index.
        heap[0] = heap[lastIndex];
        heap[lastIndex] = 0;
        
        //  Create a counter variable and call it i so that we can progress through the heap
        int i = 0;
        boolean success = false;
        //  i must be less than the lastIndex.
        while(success == false && i < lastIndex){
            //  Check parent with the child on the left first as long as child != 0
            if(heap[i] > heap[(2*i)+1] && heap[(2*i)+1] != 0){
                //  Switch parent with child
                int temp = heap[i];
                heap[i] = heap[(2*i)+1];
                heap[(2*i)+1] = temp;
                
                //  Check if parent is now greater than child on the right and switch
                if(heap[i] > heap[(2*i)+2] && heap[(2*i)+2] != 0){
                    int temp2 = heap[i];
                    heap[i] = heap[(2*i)+2];
                    heap[(2*i)+2] = temp2;
                }
                //  Increment i;
                i = (2*i)+1;
            //  Chack parent with the child on the right
            }else if(heap[i] > heap[(2*i)+2] && heap[(2*i)+2] != 0){
                int temp = heap[i];
                heap[i] = heap[(2*i)+2];
                heap[(2*i)+2] = temp;
                i = (2*i)+2;
            }
            //  If parent is less than children, success = true
            else{
                success = true;
            }
        }
        //  Returns the value that was removed.
        return returnVal;
    }
    
    
    
    
    
}
