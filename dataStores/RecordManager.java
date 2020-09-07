package dataStores;

import java.util.*;
import java.io.*;

public class RecordManager{
    private String filename;
    private ArrayList<Record> records;
    private File file;
    private FileReader fRead;
    private FileWriter fWrite;

    Scanner scan;

    public RecordManager(){
        scan = new Scanner(System.in);
        System.out.println("Enter file path: ");
        filename = scan.next();
        file = new File(filename);
        openFile();
    }

    void openFile(){
        if(file.exists()){
            try{
                fRead = new FileReader(file);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            try{
                file.createNewFile();
                fRead = new FileReader(file);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
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
            if(record.getKey().equals(k)){
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
            if(record.getKey().equals(k)){
                System.out.println(record);
                System.out.println("Would you like to update(yes/no): ");
                String c = scan.next();
                if(c.equals("yes")){
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
            if(record.getKey().equals(k)){
                System.out.println(record);
            }
        }
    }
    void displayAllRecords(){
        for(Record record: records){
            System.out.println(record);
        }
    }
    static void viewMenu(){
        System.out.println("Menu:\n1.Open a file.\n2.Create a new input.\n2.Delete a row of data.\n3.Update an existing row.\n"
            +"4.Display a record.\n5.Display all record.\n6.Exit.\n7.View Menu.");
    }
    ArrayList<Record> readFile(){

        return new ArrayList<Record>();
    }
    void writeFile(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("records"));
            bw.write(records.toString());
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    void exit(){
        scan.close();
        try{
            fRead.close();
            fWrite.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}