import java.io.FileReader;
import java.io.FileWriter; 
import java.io.IOException; 

class DemoFileWriter{ 
    public static void main(String[] args) throws IOException{ 
        // Accept a string  
        String str = "File Handling in Java using "+ 
                " FileWriter and FileReader"; 
  
        // attach a file to FileWriter  
        FileWriter fw=new FileWriter("output.txt"); 
  
        // read character wise from string and write  
        // into FileWriter  
        for (int i = 0; i < str.length(); i++) 
            fw.write(str.charAt(i)); 
  
        System.out.println("Writing successful"); 
        //close the file  
        fw.close(); 
        FileReader fr = null;
        try{
            fr = new FileReader("output.txt");
            int ch;
            while((ch=fr.read())!=-1){
                System.out.print((char)ch);
            }
        }finally{
            fr.close();
        }
    } 
}