package dataStores.deleteContent;

import java.io.*;

public class DeleteContent {
    String filepath;

    public DeleteContent(String path) {
        filepath = path;
    }

    String run(){
        File newFile = new File(filepath+"temp");
        if(!isValid()){
            return "Invalid File Path";
        }
        RandomAccessFile newRAFile = setup(newFile);
        if(!createValidCopy(newRAFile)){
            return "Unable to create a valid Copy";
        }
        if(!renameFile(newFile)){
            return "Unable to Rename to old File";
        }
        return "Delete Successfull";
    }

    boolean isValid(){
        if(new File(filepath).isFile()){
            return true;
        }
        return false;
    }

    RandomAccessFile setup(File newFile){
        try{
            RandomAccessFile newRAFile = new RandomAccessFile(newFile, "rw");
            return newRAFile;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    boolean createValidCopy(RandomAccessFile newFile){
        try{
            RandomAccessFile oldFile = new RandomAccessFile(filepath,"rw");
            oldFile.seek(0);
            newFile.seek(0);
            while(oldFile.getFilePointer()<oldFile.length()){
                boolean deletedFlag = oldFile.readBoolean();
                String key = oldFile.readUTF();
                String value = oldFile.readUTF();
                if(!deletedFlag){
                    newFile.writeBoolean(deletedFlag);
                    newFile.writeUTF(key);
                    newFile.writeUTF(value);
                }
            }
            oldFile.close();
            newFile.close();
            return true;
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }

    boolean renameFile(File newFile){
        File oldFile = new File(filepath);
        oldFile.delete();
        if(newFile.renameTo(new File(filepath))){
            return true;
        }
        return false;
    }
}
