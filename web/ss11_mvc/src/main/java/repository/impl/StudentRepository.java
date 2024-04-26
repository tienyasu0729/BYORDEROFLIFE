package repository.impl;

import model.Student;
import repository.IStudentRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> studentList = new ArrayList<>();
    private BaseRepository baseRepository = new BaseRepository();

    static {
        studentList.add(new Student(1, "haiTT", "01/01/1000", 1, 6.0));
        studentList.add(new Student(2, "trungdc", "01/01/1000", 1, 7.0));
        studentList.add(new Student(3, "trungdp", "01/01/1000", 1, 8.0));
        studentList.add(new Student(4, "tiennvt", "01/01/1000", 1, 9.0));
        studentList.add(new Student(5, "congnt", "01/01/1000", 1, 10.0));
    }


    @Override
    public void save(Student student) {
        try {
//            Statement statement = this.baseRepository.getConnectionJavaToDB().createStatement();
//            statement.executeUpdate("insert into student(name,date_of_birth,grade) value ("+student.getName()+","+s)
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().
                    prepareStatement("insert into student(name,date_of_birth,gender,grade) value (?,?,?,?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDateOfBirth());
            preparedStatement.setInt(3, student.getGender());
            preparedStatement.setDouble(4, student.getGrade());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnectionJavaToDB().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                int gender = resultSet.getInt("gender");
                double point = resultSet.getDouble("grade");
                students.add(new Student(id, name, dateOfBirth, gender, point));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public Student findById(int id) {
        PreparedStatement statement = null;
        Student student = null;
        try {
            statement = this.baseRepository.getConnectionJavaToDB().
                    prepareStatement("select * from student where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                int gender = resultSet.getInt("gender");
                double point = resultSet.getDouble("grade");
                student = new Student(id, name, dateOfBirth, gender, point);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void deleteById(int id) {
        PreparedStatement statement = null;
        Student student = null;
        try {
            statement = this.baseRepository.getConnectionJavaToDB().
                    prepareStatement("delete from student where id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
