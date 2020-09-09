package dataStores;

import java.io.*;

public class RecordManager{
    private RandomAccessFile file;
    //private final String extension = ".recd";
    
    public RecordManager(String filepath){
        File f = new File(filepath);
        try{
            file = new RandomAccessFile(f,"rw");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }  
    }
    
    boolean createNewRecord(Record rec){
        if(this.search(rec.getKey())==-1){
            return this.appendRecord(rec);
        }
        return false;
    }

    Record fetchRecord(String key){
        long offset = this.search(key);
        try{
            if(offset>-1) {
                file.seek(offset);
                file.readBoolean();
                file.readUTF();
                String value = file.readUTF();
                return new Record(key,value);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    private long search(String key){
        long offset = -1;
        try{
            file.seek(0);
            while(file.getFilePointer()<file.length()){
                long pos = file.getFilePointer();
                boolean deleteFlag = file.readBoolean();
                String currentkey = file.readUTF();
                file.readUTF();
                if(!deleteFlag&&key.equals(currentkey)){
                    offset = pos;
                    break;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return offset;
    }

    private boolean appendRecord(Record rec){
        boolean flag = false;
        try{
            file.seek(file.length());
            file.writeBoolean(false);
            file.writeUTF(rec.getKey());
            file.writeUTF(rec.getValue());
            flag = true;
        }catch(IOException e){
            e.printStackTrace();
            flag = false;
        }
        return flag;  
    }

    
    boolean deleteRecord(String key){
        long offset = this.search(key);
        boolean flag = false;
        if(offset>-1){
            try{
                file.seek(offset);
                file.writeBoolean(true);
                flag = true;
            }catch(IOException e){
                e.printStackTrace();
                flag = false;
            }
        }
        return flag;
    }

    boolean updateRecord(Record rec){
        long offset = this.search(rec.getKey());
        boolean flag = false;
        if(offset>0){
            flag = this.deleteRecord(rec.getKey());
            flag = this.appendRecord(rec);
        }
        return flag;
    }

}