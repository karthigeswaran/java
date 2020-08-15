import java.util.Scanner;
import java.lang.Math;

class ColumnCounter{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        ColumnCounter col = new ColumnCounter();
        for(int i = 0; i < t; i++){
            char[] name =scan.next().toCharArray();
            System.out.println(col.counterCol(name));
        }
        scan.close();
    }
    private int counterCol(char[] name){
        int sum = 0;
        for (int j = 0; j < name.length; j++) {
            sum += ((Math.pow(26,name.length-j-1))*(name[j]-64));
        }
        return sum;
    }
}