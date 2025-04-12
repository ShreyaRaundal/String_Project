import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class StudentReportGeneratorUpdated {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Input name
        System.out.print("Enter your full name: ");
        String name = sc.nextLine();

        // 2. Extract initials
        String[] parts = name.split(" ");
        String initials = "";
        for (String part : parts) {
            initials += part.charAt(0) + ".";
        }

        // 3. Vowel/consonant check
        char firstChar = Character.toLowerCase(name.charAt(0));
        if ("aeiou".indexOf(firstChar) != -1) {
            System.out.println("Your name starts with a vowel.");
        } else {
            System.out.println("Your name starts with a consonant.");
        }

        // 4. Enter marks for 5 subjects
        System.out.print("Enter marks for Math: ");
        int math = sc.nextInt();

        System.out.print("Enter marks for English: ");
        int english = sc.nextInt();

        System.out.print("Enter marks for Science: ");
        int science = sc.nextInt();

        System.out.print("Enter marks for History: ");
        int history = sc.nextInt();

        System.out.print("Enter marks for Computer: ");
        int computer = sc.nextInt();

        int total = math + english + science + history + computer;
        double average = total / 5.0;
        double percentage = (total / 500.0) * 100;

        // 5. Grade logic
        String grade;
        if (percentage >= 85) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 50) {
            grade = "C";
        } else {
            grade = "Fail";
        }

        // 6. Switch for motivational message
        String message;
        switch (grade) {
            case "A":
                message = "Excellent work! Keep it up!";
                break;
            case "B":
                message = "Good job! Aim higher next time!";
                break;
            case "C":
                message = "You can do better! Keep practicing.";
                break;
            default:
                message = "Don't give up! Learn from mistakes and try again.";
        }

        // 7. Build report
        StringBuilder report = new StringBuilder();
        report.append("\n----- Grade Report -----\n");
        report.append("Name        : ").append(name.toUpperCase()).append("\n");
        report.append("Initials    : ").append(initials.toUpperCase()).append("\n");
        report.append("Total Marks : ").append(total).append("/500\n");
        report.append(String.format("Average     : %.2f\n", average));
        report.append(String.format("Percentage  : %.2f%%\n", percentage));
        report.append("Grade       : ").append(grade).append("\n");
        report.append("Message     : ").append(message).append("\n");

        // 8. Print report
        System.out.println(report.toString());

        // 9. Save to file (optional)
        try {
            FileWriter writer = new FileWriter("StudentReport.txt");
            writer.write(report.toString());
            writer.close();
            System.out.println("Report saved to 'StudentReport.txt'");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }

        sc.close();
    }
}
