package dataStores;

import java.util.*;
//import java.io.*;
//import java.nio.file.Files;
import java.awt.*;

public class DataStores{
    private ArrayList<Record> records = new ArrayList<Record>();
    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        DataStores dt = new DataStores();
        /* File records = new File("Records");
        try{
            BufferedReader br = new BufferedReader(new FileReader(records));
            if(br.readLine()!=""){
                Files.readAllLines(records);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        */
        System.out.println("Data Stores Inc.");
        dt.viewMenu();
        boolean flag = true;
        do{
            int opt = dt.scan.nextInt();
            switch(opt){
                case 1:
                    dt.createNewRecord();
                    break;
                case 2:
                    if(dt.deleteRecord()){
                        System.out.println("Successfully deleted");
                    }else{
                        System.out.println("Requested entry does not exist");
                    }
                    break;
                case 3:
                    dt.updateRecord();
                    break;
                case 4:
                    dt.displayRecord();
                    break;
                case 5:
                    dt.displayAllRecords();
                    break;
                case 6:
                    flag = false;
                    break;
                case 7:
                    dt.viewMenu();
                    break;
                default:
                    Toolkit.getDefaultToolkit().beep();
                    System.out.println("Enter correct option!!");
            }
            System.out.println("Enter option number: ");   
        }while(flag);
        dt.scan.close();
    }
    void createNewRecord(){
        Record rec = new Record(askKey(),askValue());
        if(records.contains(rec)){
            System.out.println("Unable to add key, value match to existing record");
        }else{
            records.add(rec);
        }
    }
    boolean deleteRecord(){
        String k = askKey();
        for(Record record : records){
            if(record.getkey()==k){
                records.remove(record);
                return true;
            }
        }
        return false;
    }
    String askKey(){
        System.out.print("Enter key: ");
        String key = scan.next();
        return key;            
    }
    String askValue(){
        System.out.print("Enter value: ");
        String value = scan.next();
        return value;            
    }
    void updateRecord(){
        String k = askKey();
        for(Record record : records){
            if(record.getkey()==k){
                System.out.println(record);
                System.out.println("Would you like to update(yes/no): ");
                String c = scan.next();
                if(c=="yes"){
                    String v = askValue();
                    record.setValue(v);
                }else{
                    System.out.println("Record not updated");
                }
            }
        }
    }
    void displayRecord(){
        String k = askKey();
        for(Record record: records){
            if(record.getkey()==k){
                System.out.println(record);
            }
        }
    }
    void displayAllRecords(){
        for(Record record: records){
            System.out.println(record);
        }
    }
    void viewMenu(){
        System.out.print("Menu:\n1.Create a new input.\n2.Delete a row of data.\n3.Update an existing row.\n"
            +"4.Display a record.\n5.Display all record.\n6.Exit.\nEnter option number: ");
    }
}