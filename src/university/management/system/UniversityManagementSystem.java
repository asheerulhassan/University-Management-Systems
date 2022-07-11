
package university.management.system;
import java.util.Scanner;


public class UniversityManagementSystem {

   
    public static void main(String[] args) throws Exception  {
     
        
        String yes_NO="";  
       
      do{
        
       Scanner sc2=new Scanner(System.in);
    
 
        System.out.println("    ...Login...   ");
        System.out.println("");
        Login sc= new Login();
        sc.login();
      
           
        
        System.out.println("");
        System.out.println("....Welcome To University Management System.....");
        System.out.println("");
        System.out.println("1 Student");
        System.out.println("2 Faculty");
        System.out.println("3 Registeration OF Course");
        System.out.println("Choose to The Number: ");
        int  choose=sc2.nextInt();
       
        
        switch(choose){
      
     case 1:
           
     String yesORNO=""; 
      Scanner sc3=new Scanner(System.in);
     Student hf=new Student(123,"asheer","scccd",34,"acaacc","acascac","asascac","aac","ascasca");
            do{
             System.out.println(".......Student Registretion.......");
             System.out.println("");
             System.out.println("1 Add Student");
             System.out.println("2 show Student");
             System.out.println("3 Search Student");
             System.out.println("4 Update Student");
             System.out.println("5 Delete Student");
             System.out.println("6 Sort By StudentID");
             System.out.println("7 Sort By StudentName");            
             System.out.println("8 Exit");
             System.out.println("Choose to The Number: ");
             int choose1=sc3.nextInt();
             
             switch(choose1){
                 case 1:
                     hf.Add();
                     break;
                 case 2:
                     hf.ShowStudentDetail();
                     break;
                 case 3:
                    hf.Search();
                     break;
                 case 4:
                     hf.Update();
                     break;
                 case 5:
                     hf.Delete();
                     break;
                     case 6:
                     hf.SortStudentID();
                     break;
                      case 7:
                     hf.SortStudentName();
                     break;
             }
              System.out.print("\nDo you want to try again? (Y|N)? : ");
        
             yesORNO = sc3.next().toUpperCase();
         
            }while(yesORNO.equals("Y"));
            System.out.println("");
            System.out.println("Thank You For Students Registeration");
     
        case 2:
                 String yesOR1NO=""; 
                 Scanner sc4=new Scanner(System.in);
           Faculty hf1=new Faculty(134,"sssd","adsa","DAAD","DdD","dddd");
       do{
            System.out.println(".....Faculty Regitration.....");
            System.out.println("");
             System.out.println("1 Add Faculty");
             System.out.println("2 show Faculty Detail");
             System.out.println("3 Search Faculty");
             System.out.println("4 update Faculty");
             System.out.println("5 Delete Faculty");
             System.out.println("6 Sort By FacultyID");
             System.out.println("7 Sort By FacultyName");      
             System.out.println("8 Exit");
             System.out.println("Choose to The Number: ");
             int choose2=sc4.nextInt();
             switch(choose2){
                 case 1:
                     hf1.Add();
                     break;
                 case 2:
                     hf1.ShowFacultyDetail();
                     break;
                 case 3:
                     hf1.Search();
                     break;
                 case 4:
                     hf1.Update();
                     break;
                 case 5:
                     hf1.Delete();
                     break;
                      case 6:
                     hf1.SortFacultyID();
                     break;
                      case 7:
                     hf1.SortFacultyName();
                     break;
             }
            System.out.print("\nDo you want to try again? (Y|N)? : ");
        
             yesOR1NO = sc4.next().toUpperCase();               
        
            }while(yesOR1NO.equals("Y"));
            System.out.println("");
            System.out.println("Thank You For Faculty Registeration");
           System.out.print("\nDo you want to try again? (Y|N)? : ");
        
             case 3:
                 
                 RegistrationOfCourse hf2 =new RegistrationOfCourse();
                 hf2.Registeration();
                 break;
        }
          System.out.print("\nDo you want to try again? (Y|N)? : ");
         System.out.println("Do You Want to Run Again this Program");
             yes_NO = sc2.next().toUpperCase();
       
            }while(yes_NO.equals("Y"));              
    }
       
}
    

         

   

