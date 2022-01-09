/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodp_as9;

import java.util.Stack;

/**
 *
 * @author User
 */
public class Pattern {
    public static void main(String[] args) {
        Originator originator=new Originator();
        originator.setLocation(20, 20);
        originator.save();
        originator.setLocation(40, 20);
        originator.save();
        originator.setLocation(20, 40);
        originator.save();
        
        int[] i=originator.getLocation();
//        System.out.println(i[0]);
//        System.out.println(i[1]);
        
        originator.undo();
        i=originator.getLocation();
        System.out.println(i[0]);
        System.out.println(i[1]);
        
        originator.undo();
        i=originator.getLocation();
        System.out.println(i[0]);
        System.out.println(i[1]);
        
        originator.undo();
        i=originator.getLocation();
        System.out.println(i[0]);
        System.out.println(i[1]);
    }
}

class Originator{

    private int[] location;
    private final Caretaker caretaker=new Caretaker();
    
    public int[] getLocation() {
        return location;
    }

    public void setLocation(int x, int y) {
        location=new int[]{x,y};
        this.location = location;
    }
    
    public void save(){
        caretaker.addmemento(new Memento(location));
    }
    
    public void undo(){
        this.location=caretaker.getMemento().getLocation();
    }
    
}

class Memento{
    
    private final int[] location;

    public Memento(int[] location) {
        this.location = location;
    }
    
    public int[] getLocation() {
        return location;
    }
    
}

class Caretaker{
    
    Stack<Memento> mementoStack=new Stack<>();
    
    public void addmemento(Memento memento){
        mementoStack.push(memento);
    }
    
    public Memento getMemento(){
        if(mementoStack.isEmpty()){
            return mementoStack.push(new Memento(new int[]{-1,-1}));
        }else{
            return mementoStack.pop();
        }
    }
    
}