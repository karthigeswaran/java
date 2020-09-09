package deleteContent;

import java.io.*;

public class DeleteContent {
    String filepath;

    public DeleteContent(String path) {
        filepath = path;
    }

    String run(){
        return isValid();
    }

    String isValid(){
        if(new File(filepath).isFile()){
            return setup();
        }
        return "Invalid File Path";
    }

    String setup(){
        try{
            File file = new File(filepath+"temp");
            RandomAccessFile newFile = new RandomAccessFile(file, "rw");
            return createValidCopy(newFile,file);
        }catch(IOException e){
            e.printStackTrace();
        }
        return "Unable to open given file.";
    }

    String createValidCopy(RandomAccessFile newFile,File file){
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
            return renameFile(file);
        }catch(IOException e){
            e.printStackTrace();
        }
        return "unable to create a valid file";
    }

    String renameFile(File newFile){
        File oldFile = new File(filepath);
        oldFile.delete();
        if(newFile.renameTo(new File(filepath))){
            return "Delete Sucessfull";
        }
        return "Unable to rename";
    }
}
