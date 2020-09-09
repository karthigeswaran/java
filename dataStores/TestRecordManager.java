package dataStores;

import java.util.Scanner;
import java.awt.Toolkit;

public class TestRecordManager{
    private RecordManager recordManager;
    Scanner scan;
    public static void main(String[] args) {
        TestRecordManager trm = new TestRecordManager();
        trm.scan = new Scanner(System.in);
        System.out.println("DataStores.app");
        boolean flag = true;
        while(flag){
            System.out.print("Menu\n1.Open file.\n2.exit.\nEnter option: ");
            int opt = trm.scan.nextInt();
            switch(opt){
                case 1:
                    String filename = "C:\\Users\\karthigeswaran\\Desktop\\practise\\java\\dataStores\\Test";
                    trm.recordManager = new RecordManager(filename);
                    boolean f = true;
                    while(f){
                        System.out.print("Menu\n1.create record.\n2.delete record.\n3.update record.\n4.fetch Record.\n5.exit.\nEnter option: ");
                        int option = trm.scan.nextInt();
                        String key,value;
                        Record rec;
                        switch(option){
                            case 1:
                                key = trm.askKey();
                                value = trm.askValue();
                                rec = new Record(key,value);
                                if(trm.recordManager.createNewRecord(rec)){
                                    System.out.println("Record Successfully Created!!");
                                }else{
                                    System.out.println("Unable to Create.");
                                }
                                break;
                            case 2:
                                key = trm.askKey();
                                if(trm.recordManager.deleteRecord(key)){
                                    System.out.println("Delete successfull!!");
                                }else{
                                    System.out.println("Unable to delete.");
                                }
                                break;
                            case 3:
                                key = trm.askKey();
                                value = trm.askValue();
                                rec = new Record(key,value);
                                if(trm.recordManager.updateRecord(rec)){
                                    System.out.println("Update successfull!!");
                                }else{
                                    System.out.println("Unable to update.");
                                }
                                break;
                            case 4:
                                key =trm.askKey();
                                rec = trm.recordManager.fetchRecord(key);
                                if(rec == null) {
                                    System.out.println("No record found");
                                    break;
                                }
                                System.out.println(rec.getValue());
                                break;
                            case 5:
                                f = false;
                                break;
                            default:
                                Toolkit.getDefaultToolkit().beep();
                        }
                    }
                    break;
                case 2:
                    flag = false;
                    break;
                default:
                    Toolkit.getDefaultToolkit().beep();
            }
        }
        System.out.print("Exiting application.");
        trm.scan.close();
    }

    String askKey(){
        System.out.print("Enter record key: ");
        return scan.next();
    }

    String askValue(){
        System.out.print("Enter record value: ");
        return scan.next();
    }
    
}