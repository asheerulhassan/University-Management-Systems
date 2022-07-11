
package university.management.system;
import java.io.Serializable;
import java.io.*;
import java.util.Scanner;
import java.util.Iterator;
import java.util.*;
import java.util.Collections;
import java.util.Stack;


public class Student implements Serializable  {
  public   int id;
  public  String name;
  public  String F_name;
  public  String DOB;
  public   int   age; 
  public   String dept;
  public   String Address;
  public   String Batch;
  public   String Email;
  public String CourseName;
  
  
 public Student(int id, String name, String F_name, int age, String DOB, String dept, String Address, String Email, String Batch){
  
   this.Address=Address;
   this.Batch=Batch;
   this.DOB=DOB;
   this.Email=Email;
   this.F_name=F_name;
   this.age=age;
   this.dept=dept;
   this.id=id;
   this.name=name;
 }

    
   public int getid(){
       return id;
   }
   public String getname(){
       return name;
   }
   public String getF_name(){
       return F_name;
   }
   public int getage(){
       return age;
   }
   public String getDOB(){
       return DOB;
   }
   public String getdept(){
       return dept;
   }
   public String getAddress(){
       return Address;
   }
   public String getEmail(){
       return Email;
   }
    @Override
   public String toString(){
    return id+""+name+""+F_name+""+dept+""+Email+""+Address+""+age+""+DOB;   
   }

 
   
   
   Stack<Student> list=new Stack<Student>();

   File file=new File("Student.txt");
          ObjectOutputStream oos=null;
         ObjectInputStream ois=null;
         ListIterator it=null;
            

        public void Add() throws Exception{
            try{
          Scanner sc = new Scanner(System.in);
          Scanner sc1=new Scanner (System.in);
          
            System.out.println("Enter the Student id: ");
            id=sc.nextInt();
           
            System.out.println("Enter the Student name: ");
            name=sc1.next();
            System.out.println("Enter the Student Father name: ");
            F_name=sc1.next();
            System.out.println("Enter the Student Date of Birth: ");
            DOB=sc1.next();
            System.out.println("Enter the Student Age: ");
            age=sc.nextInt();
            System.out.println("Enter the Student Department: ");
            dept=sc1.next();
            System.out.println("Enter the Student Address: ");
            Address=sc1.next();
            System.out.println("Enter the Student Batch: ");
            Batch=sc1.next();
            System.out.println("Enter the Student Email: ");
            Email=sc1.next();
        
    list.push(new Student(id,name, F_name, age, DOB, dept, Address, Email, Batch));
          
    oos=new ObjectOutputStream(new FileOutputStream(file));
    oos.writeObject(list);
    oos.close();
            }catch(Exception e){
                System.out.println("Record is Not Found");
            }
     } 
        
            
        public void ShowStudentDetail() throws Exception{
            try{
            if(file.isFile()){
             ois=new ObjectInputStream(new FileInputStream(file));
             list=(Stack<Student>)ois.readObject();
             ois.close();

            System.out.println("------------------");
            
            Iterator<Student> it=list.iterator();
            while(it.hasNext()){
                Student s=it.next(); 
            System.out.println("Student id is: "+s.id);
            System.out.println("Student name is: "+s.name);
            System.out.println("Student F_name is: "+s.F_name);
            System.out.println("Student age is: "+s.age);
            System.out.println("Student Date of Birth is: "+s.DOB);
            System.out.println("Student Department is: "+s.dept);
            System.out.println("Student Address is: "+s.Address);
            System.out.println("Student Email is: "+s.Email);
            System.out.println("Student Batch is: "+s.Batch);
            System.out.println("------------------");
            }
           
            System.out.println("------------------");
            
          }else{
                System.out.println("File is not Found");
              }
            }catch(Exception e){
                 System.out.println("Record in Not Found");
            }
             
        }
        
        public void Search()throws Exception{
            try{
            Scanner sc = new Scanner(System.in);
            if(file.isFile()){
              ois=new ObjectInputStream(new FileInputStream(file));
             list=(Stack<Student>)ois.readObject();
             ois.close();

            boolean found=false;
            System.out.println("Enter Student id to Search");
            id=sc.nextInt();
            if(getid()==id){
            ShowStudentDetail();
            found=true;
            }
            if(!found){
                System.out.println("Record Not Found!.....");
            }
        }else{
                System.out.println("File is not Found");
              }
            }catch(Exception e){
                System.out.println("Record Not Found");
            }
        }  
        
        
        public void Delete() throws Exception{
            try{
            Scanner sc = new Scanner(System.in); 
            if(file.isFile()){
              ois=new ObjectInputStream(new FileInputStream(file));
             list=(Stack<Student>)ois.readObject();
             ois.close();
              boolean found=false;
              Iterator<Student> it=list.iterator();
            System.out.println("Enter Student id to Delete");
            id=sc.nextInt();
            System.out.println("------------------");
            it=list.iterator();
            while(it.hasNext()){
            Student s =it.next();
            if(s.getid()==id){
            it.remove();
            found=true;
            }
            }
            if(found){
               
               oos=new ObjectOutputStream(new FileOutputStream(file));
               oos.writeObject(list);
               oos.close();
             System.out.println("Rcord is Deleted Successfully!....");
            }else{
               System.out.println("Record in Not Found");
                     }
             System.out.println("------------------");
            }else{
                System.out.println("File is not Found");
              }
           
            }catch(Exception e){
                System.out.println("Record Not Found");
            }
        }
           

      public void Update() throws Exception{
          try{
          Scanner sc = new Scanner(System.in);
          Scanner sc1=new Scanner (System.in);
          if(file.isFile()){
              ois=new ObjectInputStream(new FileInputStream(file));
             list=(Stack<Student>)ois.readObject();
             ois.close();
          boolean found=false;
            System.out.println("Enter Student id to Update");
            id=sc.nextInt();
            System.out.println("------------------");
            ListIterator<Student> li=list.listIterator();
            while(li.hasNext()){
            Student s =li.next();
            if(s.getid()==id){
            System.out.println("Enter New Student id: ");
            id=sc.nextInt();
            System.out.println("Enter New Student name: ");
            name=sc1.next();
            System.out.println("Enter New Student Father name: ");
            F_name=sc1.next();
            System.out.println("Enter New Student Date od Birth: ");
            DOB=sc1.next();
            System.out.println("Enter New Student Age: ");
            age=sc.nextInt();
            System.out.println("Enter New Student Department: ");
            dept=sc1.next();
            System.out.println("Enter New Student Address: ");
            Address=sc1.next();
            System.out.println("Enter New Student Batch: ");
            Batch=sc1.next();
            System.out.println("Enter New Student Email: ");
            Email=sc1.next();
            li.set(new Student(id,name,F_name,age,DOB,dept,Address,Email,Batch));
            found=true;
            }
            }
            if(found){
                 oos=new ObjectOutputStream(new FileOutputStream(file));
               oos.writeObject(list);
               oos.close();
                System.out.println("Rcord is Update Successfully!....");
            }else{
                System.out.println("Record is Not Found");
            }
            System.out.println("------------------");
            }else{
                System.out.println("File is not Found");
              }
            
          }catch(Exception e){
              System.out.println("Record not Found");
          }
    }
                public void SortStudentID()throws Exception{
                    try{
                     if(file.isFile()){
              ois=new ObjectInputStream(new FileInputStream(file));
             list=(Stack<Student>)ois.readObject();
             ois.close();
                    Collections.sort(list, new Comparator<Student>(){
                        @Override
                        public int compare(Student s1, Student s2){
                            return s1.id - s2.id;
                        }
                    });
                    oos=new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(list);
                    oos.close();
                   ShowStudentDetail();
            }else{
                System.out.println("File is not Found");
              }
                    }catch(Exception e){
                        System.out.println("Record Not Found");
                    }
            }
                public void SortStudentName()throws Exception{
                    try{
                    if(file.isFile()){
              ois=new ObjectInputStream(new FileInputStream(file));
             list=(Stack<Student>)ois.readObject();
             ois.close();
                    Collections.sort(list, new Comparator<Student>(){
                        @Override
                        public int compare(Student s1, Student s2){
                            return s1.name.compareTo(s2.name);
                        }
                    });
                oos=new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(list);
                    oos.close();
               ShowStudentDetail();
            }else{
                System.out.println("File is not Found");
              }
            
                }catch(Exception e){
    System.out.println("Rcord Not Found");
}
                }    
            }
                
   
    

   
    
    

      
    
    
        
    
