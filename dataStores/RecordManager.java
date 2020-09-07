package dataStores;

import java.util.*;
import java.io.*;

public class RecordManager{
    private RandomAccessFile file;
    
    public RecordManager(String filename){
        File f = new File(filename);
        try{
            file = new RandomAccessFile(f,"rw");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }  
    }
    
    boolean createNewRecord(Record rec){
        if(this.getRecordOffset(rec)==-1){
            return this.writeRecord(rec);
        }
        return false;
    }

    long getRecordOffset(Record rec){
        long offset = -1;
        int kl = rec.getKey().length();
        try{
            while(file.getFilePointer()!=file.length()){
                offset = file.getFilePointer();
                int recKL = (int)((char)file.read()+(char)file.read());
                if(kl==recKL){
                    StringBuilder recKey = new StringBuilder("") ;
                    while(recKL>0){
                        recKey.append((char)file.read());
                        recKL--;
                    }
                    if(rec.getKey().equals(recKey.toString())){
                        return offset;
                    }
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return offset;
    }

    private boolean writeRecord(Record rec){
        try{
            
            int kl = rec.getKey().length();
            int vl = rec.getValue().length();
            String s = kl+rec.getKey()+vl+rec.getValue()+'0';
            fw.append(s);
            fw.close();
        }catch(IOException e){
            return false;
        }
        return true;
    }

    
    boolean deleteRecord(Record rec){
        if(!this.search(rec.getKey())){
            return false;
        }
        int kl = rec.getKey().length();
        try{
            FileReader fr = new FileReader(file);
            read:
            while(true){
                int recKl = (int)((char)fr.read()+(char)fr.read());
                if(recKl == kl){
                    while(recKl>0){
                        fr.read();
                        recKL--;
                    }
                }
                break read;
            }
            fr.close();
        }catch(IOException e){
            return false;
        }
        return true;
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
        System.out.println("Menu:\n1.Open a file.\n2.Create a new Record.\n2.Delete a record.\n3.Update an existing record.\n"
            +"4.Display a record.\n5.Display all record.\n6.View Menu.\n7.Exit");
    }

    ArrayList<Record> readFile(){
         return new ArrayList<Record>();
    }

    void writeFile(){
        try{
            
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

    boolean search(String key){
        //fRead.
        return false;
    }
}