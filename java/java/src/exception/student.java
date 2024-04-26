//package exception;
//
//import java.util.Objects;
//
//public class student {
//    private String id;
//    private String ten;
//    private String email;
//    private int tuoi;
//
//    public student(String id, String ten, String email, int tuoi) {
//        this.id = id;
//        this.ten = ten;
//        this.email = email;
//        this.tuoi = tuoi;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getTen() {
//        return ten;
//    }
//
//    public void setTen(String ten) {
//        this.ten = ten;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getTuoi() {
//        return tuoi;
//    }
//
//    public void setTuoi(int tuoi) {
//        this.tuoi = tuoi;
//    }
//
//    @Override
//    public String toString() {
//        return "student{" +
//                "id=" + id +
//                ", ten='" + ten + '\'' +
//                ", email='" + email + '\'' +
//                ", tuoi=" + tuoi +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        student student = (student) o;
//        return id == student.id && tuoi == student.tuoi && Objects.equals(ten, student.ten) && Objects.equals(email, student.email);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, ten, email, tuoi);
//    }
//}
