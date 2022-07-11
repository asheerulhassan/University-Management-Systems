
package university.management.system;


import java.util.Iterator;
import java.util.*;
import java.io.Serializable;
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Collections;
public class Faculty implements Serializable{
  public  int id;
  public  String name;
  public  String DOB;

  public  String dept;
  public  String Course;
  public  String Email;
  
  public Faculty(int id, String name, String DOB, String dept, String Email,String Course){
  
   this.DOB=DOB;
   this.Email=Email;
  
   this.dept=dept;
   this.id=id;
   this.name=name;
   this.Course=Course;
 }
  public int getid(){
       return id;
   }
   public String getname(){
       return name;
   }
 
  
   public String getDOB(){
       return DOB;
   }
   public String getdept(){
       return dept;
   }
   public String getCourse(){
       return Course;
   }
   public String getEmail(){
       return Email;
   }
   
  
   
    LinkedList<Faculty> list=new LinkedList<Faculty>();
    File file=new File("Faculty.txt");
          ObjectOutputStream oos=null;
         ObjectInputStream ois=null;
         ListIterator it=null;
   
        public void Add()throws Exception{
            try{
                 Scanner sc = new Scanner(System.in);
                 Scanner sc1=new Scanner (System.in);
            System.out.println("Enter the Faculty id: ");
            id=sc.nextInt();
           
            System.out.println("Enter the Faculty name: ");
            name=sc1.next();
            System.out.println("Enter the Faculty Date od Birth: ");
            DOB=sc1.next();
          
            System.out.println("Enter the Faculty Department: ");
            dept=sc1.next();
            System.out.println("Enter the Faculty Course: ");
            Course=sc1.next();
            System.out.println("Enter the Faculty Email: ");
            Email=sc1.next();
        
    list.add(new Faculty(id,name,  DOB, dept,Course, Email));
    oos=new ObjectOutputStream(new FileOutputStream(file));
    oos.writeObject(list);
    oos.close();
            }catch(Exception e){
                System.out.println("Record is Not Found");
            }
     } 
        
            
        public void ShowFacultyDetail()throws Exception{
            try{
             if(file.isFile()){
             ois=new ObjectInputStream(new FileInputStream(file));
             list=( LinkedList<Faculty>)ois.readObject();
             ois.close();
            System.out.println("------------------");
            
            Iterator<Faculty> it=list.iterator();
            while(it.hasNext()){
                Faculty f=it.next(); 
            System.out.println("Faculty id is: "+f.id);
            System.out.println("Faculty name is: "+f.name);
            
            System.out.println("Faculty Date of Birth is: "+f.DOB);
            System.out.println("Faculty Department is: "+f.dept);
            System.out.println("Faculty Course is: "+f.Course);
            System.out.println("Faculty Email is: "+f.Email);
            System.out.println("------------------");
         
            
            }
            System.out.println("------------------");
             }else{
                System.out.println("File is not Found");
              }
            }catch(Exception e){
                System.out.println("Record is Not Found");
            }
             }
        
        public void Search()throws Exception{
            try{
            Scanner sc=new Scanner(System.in);
             
            if(file.isFile()){
              ois=new ObjectInputStream(new FileInputStream(file));
             list=( LinkedList<Faculty>)ois.readObject();
             ois.close();
            boolean found=false;
            System.out.println("Enter Faculty id to Search");
            id=sc.nextInt();
            if(getid()==id){
            ShowFacultyDetail();
            found=true;
            }
            if(!found){
                System.out.println("Record Not Found!.....");
            }
             }else{
                System.out.println("File is not Found");
              }
            }catch(Exception e){
                System.out.println("Record is Not Found");
            }
        }  
        public void Delete()throws Exception{
            try{
             Scanner sc = new Scanner(System.in); 
            if(file.isFile()){
              ois=new ObjectInputStream(new FileInputStream(file));
             list=( LinkedList<Faculty>)ois.readObject();
             ois.close();
              boolean found=false;
              Iterator<Faculty> it=list.iterator();
            System.out.println("Enter Faculty id to Delete");
            id=sc.nextInt();
            System.out.println("------------------");
            it=list.iterator();
            while(it.hasNext()){
            Faculty f =it.next();
            if(f.getid()==id){
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
                System.out.println("Record is Not Found");
            }
            System.out.println("------------------");
          }else{
                System.out.println("File is not Found");
              }
            }catch(Exception e){
                System.out.println("Record is not Found");
            }
        }
  public void Update()throws Exception{
      try{
            Scanner sc = new Scanner(System.in); 
            Scanner sc1 = new Scanner(System.in); 
            if(file.isFile()){
              ois=new ObjectInputStream(new FileInputStream(file));
             list=( LinkedList<Faculty>)ois.readObject();
             ois.close();
          boolean found=false;
            System.out.println("Enter Faculty id to Update");
            id=sc.nextInt();
            System.out.println("------------------");
            ListIterator<Faculty> li=list.listIterator();
            while(li.hasNext()){
            Faculty f =li.next();
            if(f.getid()==id){
            System.out.println("Enter New Faculty id: ");
            id=sc.nextInt();
            System.out.println("Enter New Faculty name: ");
            name=sc1.next();
            System.out.println("Enter New Faculty Date od Birth: ");
            DOB=sc1.next();
           
            System.out.println("Enter New Faculty Department: ");
            dept=sc1.next();
            System.out.println("Enter New Faculty Course: ");
            Course=sc1.next();
            System.out.println("Enter New Faculty Email: ");
            Email=sc1.next();
            li.set(new Faculty(id,name,DOB,dept,Course,Email));
            found=true;
            }
            }
            if(found){
                 oos=new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(list);
                    oos.close();
                    System.out.println("Rcord is Update Successfully!....");
            }else{
                System.out.println("Rcord is Not Found");
            }
            System.out.println("------------------");
     }else{
                System.out.println("File is not Found");
              }
      }catch(Exception e){
          System.out.println("Record is not Found");
      }
    }
    
  public void SortFacultyID()throws Exception{
      try{
                     if(file.isFile()){
              ois=new ObjectInputStream(new FileInputStream(file));
             list=( LinkedList<Faculty>)ois.readObject();
             ois.close();
                    Collections.sort(list,new Comparator<Faculty>(){
                        @Override
                        public int compare(Faculty f1, Faculty f2){
                            return f1.id - f2.id;
                        }
                    });
                    oos=new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(list);
                    oos.close();
                   ShowFacultyDetail();
            }else{
                System.out.println("File is not Found");
              }
      }catch(Exception e){
          System.out.println("Record is Not Found");
      }
            }
                public void SortFacultyName()throws Exception{
                    try{
                    if(file.isFile()){
              ois=new ObjectInputStream(new FileInputStream(file));
             list=( LinkedList<Faculty>)ois.readObject();
             ois.close();
                    Collections.sort(list, new Comparator<Faculty>(){
                        @Override
                        public int compare(Faculty f1, Faculty f2){
                            return f1.name.compareTo(f2.name);
                        }
                    });
                oos=new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(list);
                    oos.close();
               ShowFacultyDetail();
            }else{
                System.out.println("File is not Found");
              }
                    }catch(Exception e){
                        System.out.println("Record is Not Found");
                    }
            }
                
            }
  
  

