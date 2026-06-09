package service;

import dao.StudentDao;
import model.Student;

public class StudentService {

    private final StudentDao studentDao =
            new StudentDao();

    public void createTable() throws Exception {
        studentDao.createTable();
    }

    public void addStudent(Student student)
            throws Exception {

        studentDao.addStudent(student);
    }

    public Student getStudentById(int id)
            throws Exception {

        return studentDao.getStudentById(id);
    }

    public void deleteStudent(int id)
            throws Exception {

        studentDao.deleteStudent(id);
    }

    public void updateStudent(Student student)
            throws Exception {

        studentDao.updateStudent(student);
    }
}