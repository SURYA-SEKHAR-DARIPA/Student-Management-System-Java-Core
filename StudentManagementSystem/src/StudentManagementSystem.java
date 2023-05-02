import java.util.*;

public class StudentManagementSystem {
    
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View Students");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            
            if (choice == 1) {
                System.out.print("\nEnter student name: ");
                scanner.nextLine(); // consume the newline character
                String name = scanner.nextLine();
                System.out.print("Enter student roll number: ");
                int rollNo = scanner.nextInt();
                System.out.print("Enter student department: ");
                scanner.nextLine(); // consume the newline character
                String department = scanner.nextLine();
                
                Student student = new Student(name, rollNo, department);
                students.add(student);
                System.out.println("\nStudent added successfully!");
            } else if (choice == 2) {
                System.out.print("\nEnter student roll number to update: ");
                int rollNo = scanner.nextInt();
                int index = findStudent(students, rollNo);
                if (index != -1) {
                    System.out.print("Enter new student name: ");
                    scanner.nextLine(); // consume the newline character
                    String name = scanner.nextLine();
                    System.out.print("Enter new student department: ");
                    String department = scanner.nextLine();
                    
                    Student student = students.get(index);
                    student.setName(name);
                    student.setDepartment(department);
                    System.out.println("\nStudent updated successfully!");
                } else {
                    System.out.println("Student not found!");
                }
            } else if (choice == 3) {
                System.out.print("\nEnter student roll number to delete: ");
                int rollNo = scanner.nextInt();
                int index = findStudent(students, rollNo);
                if (index != -1) {
                    students.remove(index);
                    System.out.println("Student deleted successfully!");
                } else {
                    System.out.println("Student not found!");
                }
            } else if (choice == 4) {
                System.out.println("\nList of students:");
                for (Student student : students) {
                    System.out.println(student.getName() + " - " + student.getRollNo() + " - " + student.getDepartment());
                }
            } else if (choice == 5) {
                System.out.println("\nExiting...");
                break;
            } else {
                System.out.println("\nInvalid choice!");
            }
        }
        scanner.close();
    }
    
    public static int findStudent(ArrayList<Student> students, int rollNo) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNo() == rollNo) {
                return i;
            }
        }
        return -1;
    }
}

class Student {
    private String name;
    private int rollNo;
    private String department;
    
    public Student(String name, int rollNo, String department) {
        this.name = name;
        this.rollNo = rollNo;
        this.department = department;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getRollNo() {
        return rollNo;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
}