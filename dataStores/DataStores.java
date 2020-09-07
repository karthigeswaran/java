package dataStores;

import java.util.Scanner;
import java.awt.Toolkit;

public class DataStores{
    RecordManager rm = new RecordManager();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Data Stores Inc.");
        RecordManager.viewMenu();
        boolean flag = true;
        do{
            System.out.print("Enter option number: ");
            int opt = scan.nextInt();
            switch(opt){
                case 1:
                    rm.openFile();
                case 2:
                    rm.createNewRecord();
                    break;
                case 3:
                    if(rm.deleteRecord()){
                        System.out.println("Successfully deleted");
                    }else{
                        System.out.println("Requested entry does not exist");
                    }
                    break;
                case 4:
                    rm.updateRecord();
                    break;
                case 5:
                    rm.displayRecord();
                    break;
                case 6:
                    rm.displayAllRecords();
                    break;
                case 7:
                    flag = false;
                    rm.exit();
                    break;
                case 8:
                    rm.viewMenu();
                    break;
                default:
                    Toolkit.getDefaultToolkit().beep();
            }   
        }while(flag);
        scan.close();
    }
}