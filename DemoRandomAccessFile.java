import java.io.File;
import java.io.RandomAccessFile;

class DemoRandomAccessFile{ 
    public static void main(String[] args){ 
        try{
            RandomAccessFile raf = new RandomAccessFile(new File("temp"), "rw");
            raf.writeUTF("I am karthi.");
            raf.writeUTF("I am 25 yrs old.");
            raf.seek(0);
            System.out.println(raf.readUTF()+raf.readUTF());    
        }catch(Exception e){
            e.printStackTrace();
        }
    } 
}