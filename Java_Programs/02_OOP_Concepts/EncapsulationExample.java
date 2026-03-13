class Student {
    private int rollNo;
    private String name;
    public void setRollNo(int r) {
        rollNo = r;
    }
    public void setName(String n) {
        name = n;
    }
    public int getRollNo() {
        return rollNo;
    }
    public String getName() {
        return name;
    }
}
public class EncapsulationExample {
    public static void main(String[] args) {
        Student s = new Student();
        s.setRollNo(302);
        s.setName("Ananya");
        System.out.println("Roll No: " + s.getRollNo());
        System.out.println("Name: " + s.getName());
    }
}
