// public class MyFirstJavaProgram {
//     public static void main(String[] args) {
//         System.out.println("MPJ");
//     }
// }

// lab 1: take info from students - name roll no. marks for 5 subjects and find avg marks and % 
// then display grade a,b,c
// use class, methods, access specifier and constructor

import java.util.Scanner;

class Student {
    private String name;
    private int roll;
    private int[] marks=new int[5];

    Student(Scanner sc) {
        // name="Anjana";
        // roll=35;
        // marks[0]=90;
        // marks[1]=90;
        // marks[2]=90;
        // marks[3]=90;
        // marks[4]=90;

        // Scanner sc=new Scanner(System.in);
        System.out.println("Enter name: ");
        name=sc.nextLine();
        System.out.println("Roll no.: ");
        roll=sc.nextInt();
        System.out.println("Enter marks for 5 subjects: ");
        for(int i=0; i<5; i++) marks[i]=sc.nextInt();
        // sc.close();
        sc.nextLine();
    }

    void calc() {
        int total=0;
        for(int i=0; i<5; i++) total+=marks[i];
        double avg=total/5.0;
        double perc=(total/500.0)*100;

        System.out.println("Name: "+name);
        System.out.println("Roll no.: "+roll);
        System.out.println("Avg marks: "+avg);
        System.out.println("Percentage: "+perc);

        if(perc>=80) System.out.println("Grade: A");
        else if(perc>=60) System.out.println("Grade: B");
        else System.out.println("Grade: C");
    }
}

public class MPJLab1 {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i+1));
            students[i] = new Student(sc);
        }
        for (int i = 0; i < n; i++) {
            students[i].calc();
        }
        sc.close();
    }
}