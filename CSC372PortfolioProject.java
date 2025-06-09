import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CSC372PortfolioProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Student> students = new LinkedList<>();

        System.out.println("Enter student data. Type 'done' when finished.");

        while (true) {
            System.out.print("Enter student name (or 'done' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) break;

            System.out.print("Enter student address: ");
            String address = scanner.nextLine();

            double gpa = 0;
            boolean validGPA = false;
            while (!validGPA) {
                System.out.print("Enter student GPA: ");
                String gpaInput = scanner.nextLine();
                try {
                    gpa = Double.parseDouble(gpaInput);
                    if (gpa >= 0.0 && gpa <= 4.0) {
                        validGPA = true;
                    } else {
                        System.out.println("GPA must be between 0.0 and 4.0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a numeric GPA.");
                }
            }

            students.add(new Student(name, address, gpa));
        }

        // Sort the list by name
        students.sort(Comparator.comparing(Student::getName));

        // Write to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
            for (Student student : students) {
                writer.write("Name: " + student.getName());
                writer.newLine();
                writer.write("Address: " + student.getAddress());
                writer.newLine();
                writer.write("GPA: " + student.getGPA());
                writer.newLine();
                writer.newLine();
            }
            System.out.println("Student data written to students.txt");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        scanner.close();
    }
}

class Student {
    private String name;
    private String address;
    private double GPA;

    public Student(String name, String address, double GPA) {
        this.name = name;
        this.address = address;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getGPA() {
        return GPA;
    }
}

Add main project class
