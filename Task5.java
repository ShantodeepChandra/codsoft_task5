package Internship.projects;

import java.util.ArrayList;
import java.util.Scanner;


class Student {
    String name;
    private int Roll_No;
    private String grade;
    private String Email;
    public Student(String name, int Roll_No, String grade, String Email){
        this.name=name;
        this.Roll_No =Roll_No;
        this.grade=grade;
        this.Email=Email;
    }
    public String getName(){
        return name;

    }
    public void setName(String name){
        this.name=name;
    }
    public int getRoll_No(){
        return Roll_No;
    }
    public void setRoll_No(int Roll_No){
        this.Roll_No =Roll_No;

    }
    public String getGrade(){
        return grade;
    }
    public void setGrade(String grade){
        this.grade=grade;
    }
    public String getEmail(){
        return Email;
    }
    public void setEmail(String Email){
        this.Email=Email;
    }

    @Override
    public String toString(){
        return "Student[Name="+name+",  Roll Number="+Roll_No+",  Grade="+grade+",  Email="+Email+"]";
    }
}

class Student_Management_System{
    private ArrayList<Student>students=new ArrayList<>();
    private Scanner Sc=new Scanner(System.in);
    public void Add_Student(){
        System.out.println("Name of student: -  ");
        String name=Sc.nextLine();
        System.out.println(" Grade:  -  ");
        String grd=Sc.nextLine();
        System.out.println("Roll Number: -   ");
        int Roll_No=Sc.nextInt();
        Sc.nextLine();
        System.out.println("Email ID: -   ");
        String Email=Sc.nextLine();
        Student Std=new Student(name, Roll_No, grd, Email);
        students.add(Std);
        System.out.println("Student Added Successfully!");
    }

    public void Remove_Student(){
        System.out.println("Roll No of student to be removed: -   ");
        int Roll_No=Sc.nextInt();
        Student std_remove=Search_Std(Roll_No);
        if(std_remove!=null){
            students.remove(std_remove);
            System.out.println("Student removed successfully");

        }
        else{
            System.out.println("Student does not exist.");
        }

    }

    public Student Search_Std(int Roll_No){
        for(Student Std: students){
            if(Std.getRoll_No()==Roll_No){
                return Std;
            }
        }
        return null;
    }

    public void display_Students(){
        if(students.isEmpty()){
            System.out.println("Not found");

        }else{
            for(Student Std: students){
                System.out.println(Std);
            }
        }
    }
}

public class Task5{
    public static void main(String[] args) {
        Student_Management_System SMS=new Student_Management_System();
        Scanner in=new Scanner(System.in);
        int choice;
         do{
             System.out.println("\t------------Welcome to Student Database-----------\n");
             System.out.println("1. Add Student..");
             System.out.println("2. Remove Student..");
             System.out.println("3. Search Student..");
             System.out.println("4. Display all Students...");
             System.out.println("5. Exit..");
             System.out.println("Enter your choice: -   ");
             choice=in.nextInt();

             switch(choice){
                 case 1:
                     SMS.Add_Student();
                     break;
                 case 2:
                     SMS.Remove_Student();
                     break;
                 case 3:
                     System.out.println("Roll Number: -   ");
                     int Roll_no=in.nextInt();
                     Student Std=SMS.Search_Std(Roll_no);
                     if(Std!=null){
                         System.out.println(Std);
                     }else{
                         System.out.println("Student Not exist");
                     }
                     break;
                 case 4:
                     SMS.display_Students();
                     break;
                 case 5:
                     System.out.println("Exiting......");
                     break;
                 default:
                     System.out.println("Invalid choice, please enter valid choice.");
             }
         }while(choice!=5);

         in.close();
    }
}
