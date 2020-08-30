package dataStores;

import java.util.Scanner;
import java.io.File;
import java.awt.*;

public class DataStores{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        File records = new File("Records.txt");
        System.out.println("Data Stores Inc.");
        boolean flag = true;
        do{
            System.out.println("Menu:\n1.Create a new input.\n2.Delete a row of data.\n3.Update an existing row.\n"
            +"4.Display a record.\n5.Display all record.\n6.Exit.\nEnter option number: ");
            int opt = scan.nextInt();
            switch(opt){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    Toolkit.getDefaultToolkit().beep();
                    System.out.println("Enter correct option!!");
            }
        }while(flag);
        scan.close();
    }

}