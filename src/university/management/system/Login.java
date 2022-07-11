
package university.management.system;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;


public class Login extends UniversityManagementSystem{
   
    
    private String Uname;
    private String Pass;
    
    public String getUname(){
        return Uname;
    }
    public void setUnanme(String Uname){
        this.Uname=Uname;
    }
    public String getPass(){
        return Pass;
    }
    public void setPass(String Pass){
        this.Pass=Pass;
    }
    public void login()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter User Name: ");
         Uname=sc.nextLine();
   
        System.out.println("Enter Password: ");
         Pass=sc.nextLine();
          String x= Uname+" "+Pass;
         
         
        try {
             
              File f = new File("Registration.txt");
              Scanner content = new Scanner(f);
        
              while (content.hasNextLine()) {
                String data = content.nextLine();
                if(data.equals(x))
                {
                    System.out.println("Login Successful");
                    
                     LocalDate dt = LocalDate.now();
                    dt = LocalDate.now();
                  System.out.println("Current Date is : "+dt);
                    
                }
                else{
                    System.out.println("Login Failed");
                    this.login();
                }
                    
              }
               
             
        }catch (FileNotFoundException e) {    
              System.out.println("Error.");
              e.printStackTrace();
            }
        
    }
}
