import java.io.File;
import java.io.RandomAccessFile;

class DemoRandomAccessFile{ 
    public static void main(String[] args){ 
        try{
            RandomAccessFile raf = new RandomAccessFile(new File("temp"), "rw");
            raf.seek(9);
            raf.writeUTF("a Δ a ,kjbihfbvi sud fuhs iuhug ugwr8afgwg of8aywfkau wkuyqg wkhbe 9g suf ho87 ow er gw8og8 seujuwh bk8qw eqywg 8q7w o8fqu hkit erfuhekiuh wei h8ky mwehnku hlij fgn9d tl o3ubo7 hiuw ");
            raf.seek(9);
            System.out.println(raf.readUTF());    
        }catch(Exception e){
            e.printStackTrace();
        }
    } 
}