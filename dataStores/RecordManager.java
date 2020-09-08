package dataStores;

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
        if(this.search(rec)==-1){
            return this.writeRecord(rec);
        }
        return false;
    }

    private long search(Record rec){
        long offset = -1;
        try{
            while(file.getFilePointer()!=file.length()){
                if(file.readBoolean()==false){
                    offset = file.getFilePointer();
                    if(rec.getKey().equals(file.readUTF())){
                        break;
                    }
                    file.readUTF();
                }else{
                    file.readUTF();
                    file.readUTF();
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return offset;
    }

    private boolean writeRecord(Record rec){
        try{
            file.seek(file.length());
            file.writeBoolean(false);
            file.writeUTF(rec.getKey());
            file.writeUTF(rec.getValue());
            return true;
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;  
    }

    
    boolean deleteRecord(Record rec){
        long offset = search(rec);
        boolean flag = false;
        if(offset>0){
            try{
                file.seek(offset-1);
                file.writeBoolean(true);
                flag = true;
            }catch(IOException e){
                flag = false;
            }
        }
        return flag;
    }

    boolean updateRecord(Record rec){
        long offset = this.search(rec);
        boolean flag = false;
        if(offset>0){
            try{
                file.seek(offset-1);
                file.writeBoolean(true);
                flag = writeRecord(rec);
            }catch(IOException e){
                flag = false;
            }
        }
        return flag;
    }

}