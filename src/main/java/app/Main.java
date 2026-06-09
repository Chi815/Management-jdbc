package app;

import model.Student;
import model.Teacher;
import service.StudentService;
import service.TeacherService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService studentService =
                new StudentService();

        TeacherService teacherService =
                new TeacherService();

        try {

            studentService.createTable();
            teacherService.createTable();

            while (true) {

                System.out.println("\n=================================");
                System.out.println(" MANAGEMENT SYSTEM");
                System.out.println("=================================");
                System.out.println("1. Student Management");
                System.out.println("2. Teacher Management");
                System.out.println("3. Exit");

                System.out.print("Enter Choice: ");

                int mainChoice = sc.nextInt();
                sc.nextLine();

                switch (mainChoice) {

                    case 1:

                        studentMenu(sc, studentService);
                        break;

                    case 2:

                        teacherMenu(sc, teacherService);
                        break;

                    case 3:

                        System.out.println(
                                "Thank you for using the system."
                        );

                        System.exit(0);

                    default:

                        System.out.println(
                                "Invalid Choice!"
                        );
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private static void studentMenu(
            Scanner sc,
            StudentService service
    ) throws Exception {

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Find Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Update Student");
            System.out.println("5. Back");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Address: ");
                    String address = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    Student student =
                            new Student(
                                    name,
                                    email,
                                    address,
                                    phone
                            );

                    service.addStudent(student);

                    break;

                case 2:

                    System.out.print("Enter ID: ");

                    int id = sc.nextInt();

                    Student found =
                            service.getStudentById(id);

                    System.out.println(found);

                    break;

                case 3:

                    System.out.print("Enter ID: ");

                    int deleteId = sc.nextInt();

                    service.deleteStudent(deleteId);

                    break;

                case 4:

                    System.out.print("ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("New Email: ");
                    String newEmail = sc.nextLine();

                    System.out.print("New Address: ");
                    String newAddress = sc.nextLine();

                    System.out.print("New Phone: ");
                    String newPhone = sc.nextLine();

                    Student updated =
                            new Student(
                                    updateId,
                                    newName,
                                    newEmail,
                                    newAddress,
                                    newPhone
                            );

                    service.updateStudent(updated);

                    break;

                case 5:

                    return;

                default:

                    System.out.println(
                            "Invalid Choice!"
                    );
            }
        }
    }

    private static void teacherMenu(
            Scanner sc,
            TeacherService service
    ) throws Exception {

        while (true) {

            System.out.println("\n===== TEACHER MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Teacher");
            System.out.println("2. Find Teacher");
            System.out.println("3. Delete Teacher");
            System.out.println("4. Update Teacher");
            System.out.println("5. Back");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Subject: ");
                    String subject = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Employment Type (Full Time / Part Time): ");
                    String employment_type = sc.nextLine();

                    Teacher teacher =
                            new Teacher(
                                    name,
                                    email,
                                    subject,
                                    phone,
                                    employment_type
                            );

                    service.addTeacher(teacher);

                    break;

                case 2:

                    System.out.print("Enter ID: ");

                    int id = sc.nextInt();

                    Teacher found =
                            service.getTeacherById(id);

                    System.out.println(found);

                    break;

                case 3:

                    System.out.print("Enter ID: ");

                    int deleteId = sc.nextInt();

                    service.deleteTeacher(deleteId);

                    break;

                case 4:

                    System.out.print("ID: ");

                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("New Email: ");
                    String newEmail = sc.nextLine();

                    System.out.print("New Subject: ");
                    String newSubject = sc.nextLine();

                    System.out.print("New Phone: ");
                    String newPhone = sc.nextLine();

                    System.out.print("Employment Type: ");
                    String newemployment_type = sc.nextLine();

                    Teacher updated =
                            new Teacher(
                                    updateId,
                                    newName,
                                    newEmail,
                                    newSubject,
                                    newPhone,
                                    newemployment_type
                            );

                    service.updateTeacher(updated);

                    break;

                case 5:

                    return;

                default:

                    System.out.println(
                            "Invalid Choice!"
                    );
            }
        }
    }
}