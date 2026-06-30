package Demo;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student ID :");
        String r =sc.nextLine();
        int rn= Integer.parseInt(r);
         System.out.println("Enter Student Name :");
        String n =sc.nextLine();
         System.out.println("Enter Student Mark1 :");
        String m =sc.nextLine();
        int m1= Integer.parseInt(m);
        System.out.println("Enter Student Mark2 :");
        String p = sc.nextLine();
        int m2= Integer.parseInt(p);
        System.out.println("Enter Student Mark3 :");
        String o =sc.nextLine();
        int m3= Integer.parseInt(o);
        int total=m1+m2+m3;
        int avg =total/3;
        char grade;
        String result;
        if(m1>=35 && m2>=35&& m3>=35){
            result="Pass";

        }
        else{
            result="Fail";
        }
        if(avg>= 90){
            grade='A';
            
        }else if (avg>=80 && avg<90) {
            grade='B';
            
        }       
        else if (avg>=70 && avg<80) {
            grade='C';
            
        }
         else if (avg>=60 && avg<70) {
            grade='D';
            
        }
        else{
            grade='E';
        }
        System.out.println(" ------Student ID---------");
        System.out.println("Student ID   :"+rn);
        System.out.println("Student Name :"+n);        
        System.out.println(n+"'s Mark 1  :"+m1);
        System.out.println(n+"'s Mark 2  :"+m2);
        System.out.println(n+"'s Mark 3  :"+m3);
        System.out.println(n+"'s Total   :"+total);
        System.out.println(n+"'s Average :"+avg);
        System.out.println(n+"'s Grade   :"+grade);
        System.out.println(n+"'s Result  :"+result);

    }
    
}
