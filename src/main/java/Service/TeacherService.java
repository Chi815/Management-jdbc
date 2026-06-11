package service;

import dao.TeacherDao;
import model.Teacher;

public class TeacherService {

    private final TeacherDao teacherDao =
            new TeacherDao();

    public void createTable()
            throws Exception {

        teacherDao.createTable();
    }

    public void addTeacher(
            Teacher teacher)
            throws Exception {

        teacherDao.addTeacher(teacher);
    }

    public Teacher getTeacherById(
            int id)
            throws Exception {

        return teacherDao.getTeacherById(id);
    }

    public void updateTeacher(
            Teacher teacher)
            throws Exception {

        teacherDao.updateTeacher(teacher);
    }

    public void deleteTeacher(
            int id)
            throws Exception {

        teacherDao.deleteTeacher(id);
    }

}