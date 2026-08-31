
class Student {

    private String stuid;
    private String name;
    private String course;
    private int year;
    private double fees;

    private Student(StudentBuilder builder) {
        stuid = builder.stuid;
        name = builder.name;
        course = builder.course;
        year = builder.year;
        fees = builder.fees;
    }

    public void display() {
        System.out.println(stuid + " - " + name + " - " + course + " - " + year + " - " + fees);
    }

    static class StudentBuilder {

        private String stuid;
        private String name;
        private String course;
        private int year;
        private double fees;

        public StudentBuilder setStudentId(String stuid) {
            this.stuid = stuid;
            return this;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setCourse(String course) {
            this.course = course;
            return this;
        }

        public StudentBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public StudentBuilder setFees(double fees) {
            this.fees = fees;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}

public class StudentRegisterationbuilder {

    public static void main(String[] args) {
        Student student = new Student.StudentBuilder().setStudentId("CS101").setName("Raja").setCourse("CSE").setYear(3).setFees(59999).build();
        student.display();
    }
}
