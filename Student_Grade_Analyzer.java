import java.util.Scanner;
public class Student_Grade_Analyzer {

   public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the student name:");
    String name=sc.nextLine();

    // Input marks
    System.out.println("Enter Marks for Math: ");
    int math=sc.nextInt();

    System.out.println("Enter Marks for English: ");
    int english=sc.nextInt();

    System.out.println("Enter Marks for Science:");
    int science=sc.nextInt();

    //  Calculate total and average
    int total=math+english+science;
    double average=total/3.0;

   
        // Determine grade
        String grade;
        if (average >= 85) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 50) {
            grade = "C";
        } else {
            grade = "Fail";
        }

    //Output report using string formatting
    System.out.println("\n--- Grade Report ---");
        System.out.println("Name: " + name.toUpperCase());
        System.out.println("Total Marks: " + total);
        System.out.printf("Average: %.2f\n", average);
        System.out.println("Grade: " + grade);
         
   }    
}
