
package university.management.system;

import java.util.Scanner;
public class RegistrationOfCourse extends UniversityManagementSystem{
  
    public void Registeration(){
    System.out.println("....Registeration For Course....");
   System.out.println("");
    Scanner input = new Scanner(System.in);
    
   
    int choice;
    int firstChoice =0, secondChoice = 0, thirdChoice = 0, fourthChoice=0;
    int totalCredit = 0;
    String yesOrNo = "";
    

    
    do {

        choice = getChoice(input);
        
      switch(ValidateChoice(choice, firstChoice, secondChoice, thirdChoice, fourthChoice, totalCredit)) {
           case -1:
               System.out.println("**Invalid** - Your selection of " + choice + " is not a recognized course.");
               break;
           case -2:
               System.out.println("**Invalid** - You have already registerd for this " +  ChoiceToCourse(choice) + " course.");
               
                break;
            case -3:
                System.out.println("**Invalid** - You can not register for more than 12 credit hours.");
                break;
            case 0:
                System.out.println("\nRegistration Confirmed for course:: " + ChoiceToCourse(choice) );
                totalCredit += 3;
                System.out.println("\nTotal Credit Hours is: "+totalCredit);
                if (firstChoice == 0)
                    firstChoice = choice;
                else if (secondChoice == 0)
                    secondChoice = choice;
                else if (thirdChoice == 0)
                    thirdChoice = choice;
                else if (fourthChoice==0)
                    fourthChoice=choice;
                break;
        }

        showCourse(firstChoice, secondChoice, thirdChoice,fourthChoice);
        
        System.out.print("\nDo you want to try again? (Y|N)? : ");
        
        yesOrNo = input.next().toUpperCase();
        
    } while (yesOrNo.equals("Y"));

    System.out.println("Thank you for course registering with us");
    
}
    public  void showCourse(int firstChoice, int secondChoice, int thirdChoice,int fourthChoice) {

    if (firstChoice == 0)
        System.out.println("\nCurrent course registration is:  { none } " );     
    else if (secondChoice == 0)
        System.out.println("\nCurrent course registration is: { " + ChoiceToCourse(firstChoice) + " }" );
    else if (thirdChoice == 0)
        System.out.println("\nCurrent course registration is: { " + ChoiceToCourse(firstChoice) + 
                ", " + ChoiceToCourse(secondChoice) + " }");
    else if (fourthChoice == 0)
        System.out.println("\nCurrent course registration is: { " + ChoiceToCourse(firstChoice) + 
                ", " + ChoiceToCourse(secondChoice) + ", " + ChoiceToCourse(thirdChoice) + " }");
    else
        System.out.println("\nCurrent course registration is:  \n" + ChoiceToCourse(firstChoice) + 
                ", \n" + ChoiceToCourse(secondChoice) + ", \n" + ChoiceToCourse(thirdChoice) + ", \n" + ChoiceToCourse(fourthChoice) +  " ");
    
}



public  int getChoice(Scanner input) {
    System.out.println("Please type the number  to register for a course");
    System.out.println("[1]OOP\n[2]ICT\n[3]DCCN\n[4]PD\n[5]P&CT\n[6]AP\n[7]OP\n[8]Exit");
    System.out.print("Enter your choice : ");
    return (input.nextInt());

}


  public  int ValidateChoice(int choice, int firstChoice, int secondChoice, int thirdChoice, int fourthChoice, int totalCredit) {

  
    int result = 0;  
 
    if (choice <=0 ||choice >7){  
    result = -1; 
    }
 
    if(choice==firstChoice||choice == secondChoice||choice == thirdChoice||choice == fourthChoice) {
    result = -2;  
   }
   if(totalCredit == 3) {            
    result = 0;
   }    
   
   if (totalCredit >9) {        
     result = -3;  
      } 
           
    return result;
}

 
public  String ChoiceToCourse(int choice) {
    
        String course = "";
        switch (choice)
        {
            case 1:
                course = "Object Oriented Programming";
                break;
            case 2:
                course = "Information Communication Tech";
                break;
            case 3:
                course = "Data Communication & Computer Network";
                break;
            case 4:
                course = "Personal Development";
                break;
            case 5:
                course = "Philosphy & Critical Thinking";
                break;
            case 6:
                course = "Applied Physics";
                break;
            case 7:
                course = "Operating System";
                break;
            default:
                break;
        }
        return course;
    }

    
    

}
       

        

