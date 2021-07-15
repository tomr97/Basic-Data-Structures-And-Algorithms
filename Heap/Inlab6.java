/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inlab6;

/**
 *
 * @author g89h939
 */
public class Inlab6 {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(15);
        heap.insert(5);
        heap.insert(8);
        heap.insert(4);
        heap.insert(9);
        heap.insert(22);
        heap.insert(17);
        heap.insert(6);
        heap.insert(14);
        heap.print();
        
        heap.remove();
        heap.remove();
        heap.print();
        
        heap.insert(18);
        heap.insert(12);
        heap.print();
        
        heap.remove();
        heap.remove();
        heap.remove();
        heap.print();
    }
}
