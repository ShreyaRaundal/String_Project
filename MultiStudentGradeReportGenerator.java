import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class MultiStudentGradeReportGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int studentCount = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 1; i <= studentCount; i++) {
            System.out.println("\n--- Enter details for Student " + i + " ---");

            // 1. Name Input
            System.out.print("Full Name: ");
            String name = sc.nextLine();

            // 2. Initials
            String[] parts = name.split(" ");
            String initials = "";
            for (String part : parts) {
                initials += part.charAt(0) + ".";
            }

            // 3. Vowel Check
            char firstChar = Character.toLowerCase(name.charAt(0));
            boolean isVowel = "aeiou".indexOf(firstChar) != -1;

            // 4. Subject Marks
            System.out.print("Math Marks: ");
            int math = sc.nextInt();
            System.out.print("English Marks: ");
            int english = sc.nextInt();
            System.out.print("Science Marks: ");
            int science = sc.nextInt();
            System.out.print("History Marks: ");
            int history = sc.nextInt();
            System.out.print("Computer Marks: ");
            int computer = sc.nextInt();
            sc.nextLine(); // consume newline

            int total = math + english + science + history + computer;
            double average = total / 5.0;
            double percentage = (total / 500.0) * 100;

            // 5. Grade
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

            // 6. Message
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
            report.append("----- Grade Report for Student ").append(i).append(" -----\n");
            report.append("Name        : ").append(name.toUpperCase()).append("\n");
            report.append("Initials    : ").append(initials.toUpperCase()).append("\n");
            report.append("Starts With : ").append(isVowel ? "Vowel" : "Consonant").append("\n");
            report.append("Total Marks : ").append(total).append("/500\n");
            report.append(String.format("Average     : %.2f\n", average));
            report.append(String.format("Percentage  : %.2f%%\n", percentage));
            report.append("Grade       : ").append(grade).append("\n");
            report.append("Message     : ").append(message).append("\n");

            // 8. Print report to console
            System.out.println(report.toString());

            // 9. Save to a file
            try {
                String fileName = "StudentReport_" + i + "_" + name.replaceAll(" ", "_") + ".txt";
                FileWriter writer = new FileWriter(fileName);
                writer.write(report.toString());
                writer.close();
                System.out.println("Report saved to '" + fileName + "'\n");
            } catch (IOException e) {
                System.out.println("Error saving report: " + e.getMessage());
            }
        }

        System.out.println(" All reports generated successfully!");
        sc.close();
    }
}
