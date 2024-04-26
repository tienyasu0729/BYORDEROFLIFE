/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC
 */


public abstract class Menu<T> {
   protected String title;
   protected ArrayList<T> mChon;
   
   public Menu(){}
   
   public Menu (String td,String[] mc){
       title = td;
       mChon = new ArrayList<>();
       for(String s:mc) mChon.add((T) s );
   }
   //----------------------------------------------
   public void display(){
       System.out.println(title);
       System.out.println("------------------------");
       for(int i=0; i<mChon.size(); i++){
           System.out.println((i+1)+"."+mChon.get(i));
           
       }
       System.out.println("-------------------------------");
   } 
      public int getSelected (){
          display();
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter slection");
          return enterValidInteger(sc);
      }
  //------------------------------------------------ 
    public abstract void execute(int choice);
    //------------------------------------------------
    public void run() {
        while(true){
            int n = getSelected();
            execute(n);
            if(n>=mChon.size()) break;
    }
    }
    public int enterValidInteger(Scanner input) {
    int value;
    do {
        String userInput = input.nextLine().trim();
        if (userInput.isEmpty()) {
            System.out.println(" không được để trống. Vui lòng nhập lại:");
        } else {
            try {
                value = Integer.parseInt(userInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println(" không hợp lệ. Vui lòng nhập lại:");
            }
        }
    } while (true);
    return value;
}
}
