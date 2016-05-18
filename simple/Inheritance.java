/*Using Inheritance paradigm in java*/
import java.lang.Math;
import java.util.Scanner;

class student {
	int marks1,marks2,marks3,marks4,marks5,marks6;
    int min,max;
    double avg;
    String Pass = "Fail";
    student(int sub1, int sub2, int sub3, int sub4)
    {
        marks1 = sub1;
        marks2 = sub2;
        marks3 = sub3;
        marks4 = sub4;
    }
    
    void minMarks(){
        min = Math.min((Math.min(marks3, marks4)),(Math.min(marks1,marks2)));
    }
    
    void maxMarks(){
        max = Math.max((Math.max(marks3, marks4)),(Math.max(marks1,marks2)));
    }
    
    void average(){
        avg = (marks1+marks2+marks3+marks4)/4.0;
    }
    
    void passed(){
        if((min >= 40) && (avg) >= 40)
            Pass = "Pass";
    }
    
    void print(){
    	System.out.println(max);
    	System.out.println(min);
    	System.out.println(Math.round(avg));
    	System.out.print(Pass);
    }
}

class MCA extends student{
	MCA(int sub1, int sub2, int sub3, int sub4)
    {
        super(sub1, sub2, sub3, sub4);
    }
}

class IMtech extends student{
    IMtech(int sub1, int sub2, int sub3, int sub4, int sub5, int sub6)
    {
        super(sub1, sub2, sub3, sub4);
        marks5 = sub5;
        marks6 = sub6;
    }
    
    void minMarks(){
        min = Math.min((Math.min(marks5,marks6)),Math.min((Math.min(marks3, marks4)),(Math.min(marks1,marks2))));
    }
    
    void maxMarks(){
        max = Math.max((Math.max(marks5,marks6)),Math.max((Math.max(marks3, marks4)),(Math.max(marks1,marks2))));
    }
    
    void average(){
        avg = (marks1+marks2+marks3+marks4+marks5+marks6)/6.0;
    }
    
    void passed(){
        if((min >= 33) && (avg) >= 33)
            Pass = "Pass";
    }
}

class Mtech extends student{
    Mtech(int sub1, int sub2, int sub3, int sub4,int sub5)
    {
    	super(sub1, sub2, sub3, sub4);
        marks5 = sub5;
    }
    
    void minMarks(){
        min = Math.min(marks5,Math.min((Math.min(marks3, marks4)),(Math.min(marks1,marks2))));
    }
    
    void maxMarks(){
        max = Math.max(marks5,Math.max((Math.max(marks3, marks4)),(Math.max(marks1,marks2))));
    }
    
    void average(){
        avg = (marks1+marks2+marks3+marks4+marks5)/5.0;
    }
    
    void passed(){
        if((min >= 50) && (avg) >= 50)
            Pass = "Pass";
    }
}

public class Inheritance{
    static Scanner Sc = new Scanner(System.in);
    public static void main(String arg[]){
        String s = Sc.nextLine();
        int sub1 =Sc.nextInt();
        int sub2 =Sc.nextInt();
        int sub3 =Sc.nextInt();
        int sub4 =Sc.nextInt();
        student m = new student(sub1, sub2, sub3, sub4);
        switch(s){
            case "MCA":
            {
                m = new MCA(sub1, sub2, sub3, sub4);
            }
            break;
            case "Mtech":
            {
                int sub5 = Sc.nextInt();
                m = new Mtech(sub1, sub2, sub3, sub4,sub5);
            }
            break;
            case "IMtech":
            {
            	int msub5= Sc.nextInt(); 
                int sub6 = Sc.nextInt();
                m = new IMtech(sub1, sub2, sub3, sub4,msub5,sub6);
            }
		break;
        }
        m.maxMarks();
        m.minMarks();
        m.average();
        m.passed();
        m.print();
    }
}



