/**
* Software Technology 1
* Assignment 2
* Name: Haoran Cui
* 1/11/2020
*/
import java.util.Scanner; // Import the Scanner class
import java.util.Arrays;
import java.io.File;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
public class Main{
    public double finalMarks;
    public String finalGrades;
    private  String[] calculation = {"sID", "fm", "s1", "s2","s3","s4","s5","s6","a1","a2","a3","a4","a5","a6","a7","a8","a9","a10","a11","a12","a13","a14","a15","a16"};
    public String[] unitName = {"Math","Biology","Information technology","Painting","History","Ecology","Accounting","Chief","Spanish"};
    public String[] unitList1 = {"============================","Unit Code Unit Name","4483: Math", "4485: Biology","4486: Information Technology","4487: Painting4", "4488: History", "4489: Ecology", "8873: Accounting", "8872: Chief", "8871: Spanish"};
    public String[] unitList2 = {"============================","Unit Code Unit Name","4483: Math", "4487: Painting4", "4488: History", "4489: Ecology", "8873: Accounting", "8872: Chief", "8871: Spanish"};
    public String[] tomInfo = new String[] {"Math: 48", "Biology: 52",  "IT: 53", "Painting: 45", "History: 38",  "Final grade: F"};
    public String studentAccount = "u123";
    public String studentPassword = "u123";
    public String adminAccount = "s43123";
    public String adminPassword = "-North2020/";
    public String[] collection = {"answer", "identity", "sAccount", "sPassword","aAccount","aPassword"};
    public String answer="";
    String studentID;
    public  ArrayList<String> marks;
    public  ArrayList<String> tomMarks;
    public ArrayList<String> newStudentEnroll = new ArrayList<String>();
    public ArrayList<String> existingStudentEnroll = new ArrayList<String>();
    public ArrayList<String> newStudentInfo = new ArrayList<String>();
    public ArrayList<String> inputUnit = new ArrayList<String>(4);
    public int totalfee =0;
    String choice = null;
      public  Main() throws IOException{
            System.out.print("\u000c");
            mainMenu();
        }
      public void mainMenu() throws IOException{
          // display the main menu to student and admin
          Scanner object = new Scanner(System.in);
          System.out.println("Welcome to Garden School mark calculation system!\n-------------------\nPlease login first|\n-------------------");
         do{
                System.out.println("Select 1 / 2 / 3 to continue");
                System.out.println("1) Administrator Login\n2) Student Login\n3) Student register\n4) EXIT");
                System.out.print("Your Selected:");
                choice = object.nextLine();
                switch (choice)
                    {
                        case "1":
                        System.out.println("===Administrator login===");
                        adminLogin();
                        break;
                    
                        case "2":
                        System.out.println("===Student login===");
                        studentLogin();
                        break;
                    
                        case "3":
                        System.out.println("===Student Register==");
                        studentRegister();
                        break;
                    
                        case "4":
                        System.out.println("***PROGRAM TERMINATED***");
                        System.exit(0);
                        break;
                    
                        default:
                        System.out.println("Invalid menu choice, please try again");
                        break;
                }
                }while(!choice.equals("3") || !choice.equals("2") || !choice.equals("1"));
     }
        public void studentLogin() throws IOException{
             // let the student to login
            do{
                Scanner input1 = new Scanner(System.in);
                System.out.print("Enter student account: ");
                collection[2] = input1.nextLine();
                Scanner input2 = new Scanner(System.in);
                System.out.print("Enter student password: ");
                collection[3] = input2.nextLine();
                if (collection[2].equals(studentAccount) && collection[3].equals(studentPassword)){
                    System.out.println("Student Login sucessful!\n============================");
                    studentOption();
                }
                if (collection[2].equals(studentAccount)){
                    System.out.println("Incorrect student password!");
                }
                if (collection[3].equals(studentPassword)){
                    System.out.println("Incorrect student account!");
                }
                if(!collection[2].equals(studentAccount) && !collection[3].equals(studentPassword)){
                    System.out.println("Incorrect student account and password");
                }
             }while(!collection[2].equals(studentAccount) || !collection[3].equals(studentPassword));
       }
       public void adminLogin() throws IOException{
           //let admin to login
         do{
            Scanner input3 = new Scanner(System.in);
            System.out.print("Enter admin account: ");
            collection[4] = input3.next();
            Scanner input4 = new Scanner(System.in);
            System.out.print("Enter admin password: ");
            collection[5] = input4.next();
            if (collection[4].equals(adminAccount) && collection[5].equals(adminPassword)){
                System.out.println("Admin Login sucessful!");
                adminOption();
            }
            else if (collection[4].equals(adminAccount) && !collection[5].equals(adminPassword)){
                System.out.println("Incorrect admin password!");
            }
            else if (!collection[4].equals(adminAccount)&& collection[5].equals(adminPassword)){
                System.out.println("Incorrect admin account!");
            }
            else{
                System.out.println("Incorrect admin account and password");
            }
         }while(!collection[4].equals(adminAccount) || !collection[5].equals(adminPassword));
    }
      public  void adminOption(){
          //options for admin
        int choice;
        do{
             System.out.println("============================\nPlease select 1 / 2 / 3");
            System.out.println("1) Calculate student marks\n2) Find student's details\n3) Back to Menu");
            System.out.print("Selection:");
            Scanner object = new Scanner(System.in);
            
            choice = object.nextInt();
            
            switch(choice)
            {
                case 1:
                markCollection();
                break;
            
                case 2:
                System.out.print("============================\nPlease enter student ID:");
                answer = object.next();
            
                if(answer.equals("u123")){
                    readTomMarks(answer);
                }
                if (answer.equals(studentID)){
                    readStudentMarksFile(answer);
                }
            
                break;
            
                case 3:
                System.out.println("You have back to Menu\n============================");
                break;
            
                default:
                System.out.println("Invalid menu choice, please try again");
                break;
            }
        }while(choice !=3 && choice !=1 && choice != 2);
    }
    public  void markCollection(){
            // collect the mark information to process calculation
            tomMarks = new ArrayList<String>();
            tomMarks.add("Student Name: Tom");
            tomMarks.add("Student ID : u123");
            tomMarks.add("Math marks: 48");
            tomMarks.add("Biology marks: 52");
            tomMarks.add("IT marks: 53");
            tomMarks.add("Painting marks: 45");
            tomMarks.add("History marks: 48");
            tomMarks.add("Final grade: F");
            tomMarks.add("The student needs to enroll math, painting, history next semester.  ");
            
            Scanner object = new Scanner(System.in);
          do{
            marks = new ArrayList<String>();
            System.out.print("Please enter student ID:");
            studentID = object.next();
            marks.add("Student ID: "+studentID);
            
            System.out.print("Please enter Math marks:");
            int mathMarks = object.nextInt();
            String mathString = Integer.toString(mathMarks);
            marks.add("Math marks:"+mathString);
            
            System.out.print("Please enter It marks:");
            int itMarks = object.nextInt();
            String itString = Integer.toString(itMarks);
            marks.add("IT marks:"+itString);
            
            System.out.print("Please enter Biology marks:");
            int bioMarks = object.nextInt();
            String bioString = Integer.toString(bioMarks);
            marks.add("Biology marks:"+bioString);
            
            System.out.print("Please enter Painting marks:");
            int paintingMarks = object.nextInt();
            String paintingString = Integer.toString(paintingMarks);
            marks.add("Painting marks:"+paintingString);
            
            System.out.print("Please enter History marks:");
            int historyMarks = object.nextInt();
            String historyString = Integer.toString(historyMarks);
            marks.add("History marks:"+historyString);
            
            //System.out.println(marks);
            
            System.out.println("=============================================");
            //calculation[0] = String.format("Student ID:          :"+studentID);
            //System.out.println(calculation[0]);
            
            marks.add(String.valueOf(getMarks(mathMarks,itMarks,bioMarks,paintingMarks,historyMarks,finalMarks)));
            writer();
            System.out.println("Do you want to check other student's marks? : yes / no");
             answer = object.next();
         }while(answer.equals("yes"));
    }   
    public void writer(){
        //write student marks information into file
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(studentID+".txt"));
            for (int i=0; i< marks.size(); i++){
                out.write(marks.get(i));
                out.newLine();
            }
            out.close();
            System.out.println("File created!");
            } catch (IOException e) {
        }
            try {
            BufferedWriter out = new BufferedWriter(new FileWriter("u123.txt"));
            for (int i=0; i< tomMarks.size(); i++){
                out.write(tomMarks.get(i));
                out.newLine();
            }
            out.close();
            //System.out.println("File created!");
            } catch (IOException e) {
        }
}
public  void studentOption() throws IOException{
    //options ofr student
        do{
        System.out.println("Please select 1 / 2 / 3 to continue");
        System.out.println("1) Check Marks\n2) Enroll Units\n3) Log Out");
        System.out.print("Selection: ");
        Scanner object = new Scanner(System.in);
        int choice = object.nextInt();
      //  do{    
        switch(choice){
            
            case 1:
            checkMarks();
            break;
            
            case 2:
            existingStudentEnroll();
            break;
            
            case 3:
            System.out.println("You have log out");
            mainMenu();
            break;
            
            default:
            System.out.println("Invalid menu choice, please try again");
            break;
        }
    }while(!choice.equals(1) && !choice.equals(2) && !choice.equals(3));
}
public void checkMarks() throws IOException{
    Scanner object = new Scanner(System.in);
    System.out.print("============================\nPlease enter student ID:");    
    answer = object.next();
  if(answer.equals("u123")){
        System.out.println("============================\nYour marks result given below:"); 
        readTomMarks(answer);
        System.out.println("1) Enroll Units\n2) Log Out");
        do{
        int choice = object.nextInt();
        switch(choice){

            case 1:
            existingStudentEnroll();
            break;
            
            case 2:
            System.out.println("You have log out");
            mainMenu();
            break;
            
            default:
            System.out.println("Invalid menu choice, please try again");
            break;
        }
    }while(!choice.equals(1) && !choice.equals(2));
    }
  else if (answer.equals(studentID)){
        System.out.println("============================\nYour marks result given below:");
        readStudentMarksFile(studentID);
        System.out.println("1) Enroll Units\n2) Log Out");
        do{
                 int choice = object.nextInt();
            switch(choice){
    
                case 1:
                existingStudentEnroll();
                break;
                
                case 2:
                System.out.println("You have log out");
                mainMenu();
                break;
                
                default:
                System.out.println("Invalid menu choice, please try again");
                break;
            }
       }while(!choice.equals(1) && !choice.equals(2));
  }
  else{
      System.out.println("Cannot find this studentID, please try another one!");
      checkMarks();
    }
}
    public void studentRegister() throws IOException{
        //let new student to register into system
        Scanner object=new Scanner(System.in);
        System.out.print("Plase type your First Name:");
        newStudentInfo.add(object.next());
        System.out.print("Plase type your Last Name:");
        newStudentInfo.add(object.next());
        newStudentEnroll();
    }

    public void existingStudentEnroll()throws IOException {
          String option;
        Scanner object = new Scanner(System.in);
        System.out.println("================================\nWhat units do you want to enroll?\nYou can enroll these units:");
        do{
        if(!newStudentInfo.isEmpty()){
            for(int i=0; i<unitList1.length; i++){
                System.out.println(unitList1[i]);
                }
        }
        System.out.println("================================");
               for (int a =1 ; a<5; a++){
        
               System.out.print("Ehter the "+a+" unit to enroll: ");
        
               inputUnit.add(object.next());
            }

        String response="";
        if (inputUnit.contains("4483")){
            System.out.println("You enrolled 4483 Math sencond time. The fee is 1200.");
            existingStudentEnroll.add("You enrolled 4483 Math second time. The fee is 1200.");
            totalfee = totalfee +1200;
        }
        if (inputUnit.contains("4485")){
                System.out.println("You have passed Biology!");
        }
        if (inputUnit.contains("4486")){
                System.out.println("You have passed Information Technology!");
        }
        if (inputUnit.contains("4487")){
                System.out.println("You enrolled 4487 Painting second time. The fee is 1780");
                existingStudentEnroll.add("You enrolled 4487 Painting second time. The fee is 1780");
                totalfee = totalfee +1780;
        }
        if (inputUnit.contains("4488")){
            System.out.println("You enrolled 4488 History second time. The fee is 1200");
            existingStudentEnroll.add("You enrolled 4488 History second time. The fee is 1200");
            totalfee = totalfee +1200;
        }
        if (inputUnit.contains("4489")){
                System.out.println("You enrolled 4489 Ecology first time. The fee is 1000");
                existingStudentEnroll.add("You enrolled 4489 Ecology first time. The fee is 1000");
                totalfee = totalfee +1000;
        }
        if (inputUnit.contains("8873")){
                System.out.println("You enrolled 8873 Accounting first time. The fee is 1000");
                existingStudentEnroll.add("You enrolled 8873 Accounting first time. The fee is 1000");
                totalfee = totalfee +1000;
        }
        if (inputUnit.contains("8872")){
                System.out.println("You enrolled 8872 Chief first time. The fee is 1000");
                existingStudentEnroll.add("You enrolled 8872 Chief first time. The fee is 1000");
                totalfee = totalfee +1000;
        }
        if (inputUnit.contains("8871")){
                System.out.println("You enrolled 8871 Spanish first time. The fee is 1200");
                existingStudentEnroll.add("You enrolled 8871 Spanish first time. The fee is 1200");
                totalfee = totalfee +1200;
        }
            System.out.println(" You have to enter a valid unit code to enroll untis. Please try again!");
        }while(!inputUnit.contains("4483") || !inputUnit.contains("4485") || !inputUnit.contains("4486") || !inputUnit.contains("4487") 
        && !inputUnit.contains("4488") || !inputUnit.contains("4489") || !inputUnit.contains("8873") || !inputUnit.contains("8872") || !inputUnit.contains("8871") );
        System.out.println("Your total fee of unit(s) are:"+totalfee);
        existingStudentEnroll.add("Your total fee of unit(s) are:"+String.valueOf(totalfee));
        writeExistingStudentenrollFile();
        studentOption();
    }
public void newStudentEnroll() throws IOException{
        String option;
        Scanner object = new Scanner(System.in);
        do{
        System.out.println("================================\nWhat units do you want to enroll?\nYou can enroll these units:");
        if(!newStudentInfo.isEmpty()){
            for(int i=0; i<unitList1.length; i++){
                System.out.println(unitList1[i]);
                }
        }
        ArrayList<String> inputUnit = new ArrayList<String>(4);
        System.out.println("================================");
               for (int a =1 ; a<5; a++){
        
               System.out.print("Ehter the "+a+" unit to enroll: ");
        
               inputUnit.add(object.next());
            }
        int totalfee =0;
        String response="";
        if (inputUnit.contains("4483")){
                System.out.println("You enrolled 4483 Math first time. The fee is 1000.");
                newStudentEnroll.add("You enrolled 4483 Math first time. The fee is 1000.");
                totalfee = totalfee +1000;
        }
        if (inputUnit.contains("4485")){
                System.out.println("You enrolled 4485 Biology first time. The fee is 1580.");
                newStudentEnroll.add("You enrolled 4485 Biology first time. The fee is 1580.");
                totalfee = totalfee +1580;
        }
        if (inputUnit.contains("4486")){
                System.out.println("You enrolled 4486 Information Technology first time. The fee is 1580");
                newStudentEnroll.add("You enrolled 4485 Biology first time. The fee is 1580");
                totalfee = totalfee +1580;
        }
        if (inputUnit.contains("4487")){
                System.out.println("You enrolled 4487 Painting first time. The fee is 1580");
                newStudentEnroll.add("You enrolled 4483 Math first time. The fee is 1580");
                totalfee = totalfee +1580;
        }
        if (inputUnit.contains("4488")){
                System.out.println("You enrolled 4488 History first time. The fee is 1000");
                newStudentEnroll.add("You enrolled 4488 History first time. The fee is 1000");
                totalfee = totalfee +1000;
        }
        if (inputUnit.contains("4489")){
                System.out.println("You enrolled 4489 Ecology first time. The fee is 1000");
                newStudentEnroll.add("You enrolled 4489 Ecology first time. The fee is 1000");
                totalfee = totalfee +1000;
        }
        if (inputUnit.contains("8873")){
                System.out.println("You enrolled 8873 Accounting first time. The fee is 1000");
                newStudentEnroll.add("You enrolled 8873 Accounting first time. The fee is 1000");
                totalfee = totalfee +1000;
        }
        if (inputUnit.contains("8872")){
                System.out.println("You enrolled 8872 Chief first time. The fee is 1000");
                newStudentEnroll.add("You enrolled 8872 Chief first time. The fee is 1000");
                totalfee = totalfee +1000;
        }
        if (inputUnit.contains("8871")){
                System.out.println("You enrolled 8871 Spanish first time. The fee is 1200");
                newStudentEnroll.add("You enrolled 8871 Spanish first time. The fee is 1200");
                totalfee = totalfee +1200;
        }
        System.out.println(" You have to enter a valid unit code to enroll untis. Please try again!");
        }while(!inputUnit.contains("4483") || !inputUnit.contains("4485") || !inputUnit.contains("4486") || !inputUnit.contains("4487") 
        && !inputUnit.contains("4488") || !inputUnit.contains("4489") || !inputUnit.contains("8873") || !inputUnit.contains("8872") || !inputUnit.contains("8871") );
        System.out.println("Your total fee of unit(s) are:"+totalfee);
        newStudentEnroll.add("Your total fee of unit(s) are:"+String.valueOf(totalfee));
        writeNewStudentenrollFile();
        //After new student enroll, program will terminate
        System.out.println("You have successful enrolled!\n You have exit the program!!!");
        System.exit(0);
}

    public void writeExistingStudentenrollFile() throws IOException{
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("ExistingStudentenrollment.txt"));
            for (int i=0; i< existingStudentEnroll.size(); i++){
                out.write(existingStudentEnroll.get(i));
                out.newLine();
            }
            out.close();
            System.out.println("File created!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void writeNewStudentenrollFile() throws IOException{
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("NewStudentenrollment.txt"));
            for (int i=0; i< newStudentEnroll.size(); i++){
                out.write(newStudentEnroll.get(i));
                out.newLine();
            }
            out.close();
            System.out.println("File created!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public  void writeTomMarksFile() throws IOException{
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("StudentMarks.txt"));
            for (int i=0; i< tomInfo.length; i++){
                out.write(tomInfo[i]);
                out.newLine();
            }
            out.close();
            //System.out.println("File created!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public  void readStudentMarksFile( String studentID){
        try {
        //System.out.println(studentID);
        File myObj = new File(studentID+".txt");
        File dir = new File("/home");
        String[] list = dir.list(new FilenameFilter() 
        {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
        }
        myReader.close();
        } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        
        }
    }
    public void readTomMarks(String answer){
        try {
        //System.out.println(studentID);
        File myObj = new File("u123.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
        } 
        catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
    }

public  double getMarks(double mathMarks, double itMarks, double bioMarks, double paintingMarks, double historyMarks, double finalMarks){    
        finalMarks = (mathMarks * 0.3) + (bioMarks * 0.2) + (itMarks * 0.2) + (paintingMarks * 0.1) + (historyMarks * 0.2);
        int intFinalMarks = (int) finalMarks;
        System.out.println("Final marks is                  :"+intFinalMarks);
        //final marks
        if (finalMarks >= 85){
            calculation[2] = String.format("Final grade: HD");
            System.out.println(calculation[2]);
            marks.add(calculation[2]);
        }
        else if (finalMarks<85 && finalMarks >=75){
            calculation[3] = String.format("Final grade: D");
            System.out.println(calculation[3]);
            marks.add(calculation[3]);
        }
        else if (finalMarks<75 && finalMarks >=65){
            calculation[4] = String.format("Final grade: C");
            System.out.println(calculation[4]);
            marks.add(calculation[4]);
        }
        else if (finalMarks<65 && finalMarks >=50){
            calculation[5] = String.format("Final grade: P");
            System.out.println(calculation[5]);
            marks.add(calculation[5]);
        }
        else if (finalMarks <50 && finalMarks>0){
            calculation[6] = String.format("Final grade: F");
            System.out.println(calculation[6]);
            marks.add(calculation[6]);
        }
        else if (finalMarks == 0){
            calculation[7] = String.format("Final Grade: Not attend");
            System.out.println(calculation[7]);
            marks.add(calculation[7]);
        }
        // Math marks
        if(mathMarks >= 90){
        
            calculation[8] = String.format("Student can attend math contest");
            System.out.println(calculation[8]);
            marks.add(calculation[8]);
        }
        else if (mathMarks<50 && mathMarks >0){
            calculation[9] = String.format("Student needs to enroll Math next semester. ");
            System.out.println(calculation[9]);
            marks.add(calculation[9]);
        }
        else if (mathMarks == 0){
            calculation[10] = String.format("Student needs to explain their absence and enroll Math next semester.  ");
            System.out.println(calculation[10]);
            marks.add(calculation[10]);
        }
        // bio
        if(bioMarks >=75){
            calculation[11] = String.format("Student can apply the unit Ecology");
            System.out.println(calculation[11]);
            marks.add(calculation[11]);
        }
        else if (bioMarks < 50 && bioMarks>0){
            calculation[12] = String.format("Student needs to Biology unit next semester. ");
            System.out.println(calculation[12]);
            marks.add(calculation[12]);
        }
        else if (bioMarks == 0){
            calculation[13] = String.format("Student needs to explain their absence and enroll Biology next semester.  ");
            System.out.println(calculation[13]);
            marks.add(calculation[13]);
        }
        
        if(itMarks >=85){
            calculation[14] = String.format("Student can get a Microsoft certificate ");
            System.out.println(calculation[14]);
            marks.add(calculation[14]);
        }
        else if (itMarks < 50 && itMarks >0){
            calculation[15] = String.format("Student needs to IT unit next semester. ");
            System.out.println(calculation[15]);
            marks.add(calculation[15]);
        }
        else if (itMarks == 0){
            calculation[16] = String.format("Student needs to explain their absence and enroll Informaiton Technology next semester.  ");
            System.out.println(calculation[16]);
            marks.add(calculation[16]);
        }
        
        if(paintingMarks >=85){
            calculation[17] = String.format("Student productions can be displayed on the school website");
            System.out.println(calculation[17]);
            marks.add(calculation[17]);
        }
        else if (paintingMarks < 50 && paintingMarks > 0){
            calculation[18] = String.format("Student needs to enroll Painting next semester. ");
            System.out.println(calculation[18]);
            marks.add(calculation[18]);
        }
        else if (paintingMarks == 0){
            calculation[19] = String.format("Student needs to explain their absence and enroll painting next semester.  ");
            System.out.println(calculation[19]);
            marks.add(calculation[19]);
        }
        
        if(historyMarks >=85){
            calculation[20] = String.format("Student productions can be displayed on the school website");
            System.out.println(calculation[20]);
            marks.add(calculation[20]);
        }
        else if (historyMarks < 50 && historyMarks > 0){
            calculation[21] = String.format("Student needs to enroll History next semester. ");
            System.out.println(calculation[21]);
            marks.add(calculation[21]);
        }
        else if (historyMarks == 0){
            calculation[22] = String.format("Student needs to explain their absence and enroll History next semester.  ");
            System.out.println(calculation[22]);
            marks.add(calculation[22]);
        }
        
        if (finalMarks >=85){
            calculation[23] = String.format("The student has the opportunity to apply for a scholarship");
            System.out.println(calculation[23]);
            marks.add(calculation[23]);
        }
    return finalMarks;
}
}