package Demo;

import java.util.*;

class Course {

    int courseId;
    String courseName;
    String trainerName;
    double courseFee;

    public Course(int id, String cName, String tName, double fee) {

        if (fee <= 0) {
            throw new IllegalArgumentException("Invalid Course Fee");
        }

        courseId = id;
        courseName = cName;
        trainerName = tName;
        courseFee = fee;
    }

    public int getCourseId() {
        return courseId;
    }

    public void display() {
        System.out.println("Course ID : " + courseId);
        System.out.println("Course Name : " + courseName);
        System.out.println("Trainer Name : " + trainerName);
        System.out.println("Course Fee : " + courseFee);
        System.out.println();
    }
}

public class Institutionmanagementsystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Course> courseList = new ArrayList<Course>();
        HashMap<Integer, Course> courseMap = new HashMap<Integer, Course>();

        System.out.print("Enter Number of Courses : ");
        int noOfCourses = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= noOfCourses; i++) {

            try {

                System.out.println("\nCourse " + i);

                System.out.print("Enter Course ID : ");
                int id = Integer.parseInt(sc.nextLine());

                System.out.print("Enter Course Name : ");
                String name = sc.nextLine();

                System.out.print("Enter Trainer Name : ");
                String trainer = sc.nextLine();

                System.out.print("Enter Course Fee : ");
                double fee = Double.parseDouble(sc.nextLine());

                Course c = new Course(id, name, trainer, fee);

                courseList.add(c);
                courseMap.put(id, c);

            } catch (IllegalArgumentException e) {

                System.out.println(e.getMessage());
                i--;
            }
        }

        System.out.println("\n===== ALL COURSES =====");

        for (Course c : courseList) {
            c.display();
        }

        System.out.print("Enter Course ID to Search : ");
        int searchId = Integer.parseInt(sc.nextLine());

        if (courseMap.containsKey(searchId)) {

            System.out.println("\nCourse Found");
            courseMap.get(searchId).display();

        } else {

            System.out.println("Course Not Found");
        }

        System.out.print("Enter Course ID to Remove : ");
        int removeId = Integer.parseInt(sc.nextLine());

        if (courseMap.containsKey(removeId)) {

            courseMap.remove(removeId);

            // Remove from ArrayList also
            Iterator<Course> iterator = courseList.iterator();
            while (iterator.hasNext()) {
                Course c = iterator.next();
                if (c.getCourseId() == removeId) {
                    iterator.remove();
                    break;
                }
            }

            System.out.println("Course Removed Successfully");

        } else {

            System.out.println("Course Not Found");
        }

        // TECHNOLOGIES SECTION
        HashSet<String> technologies = new HashSet<String>();

        System.out.print("\nEnter Number of Technologies : ");
        int noOfTechnologies = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= noOfTechnologies; i++) {
            System.out.print("Enter Technology " + i + " : ");
            technologies.add(sc.nextLine());
        }

        System.out.println("\n===== TECHNOLOGIES =====");

        for (String tech : technologies) {
            System.out.println(tech);
        }

        System.out.print("\nEnter Technology to Remove : ");
        String removeTech = sc.nextLine();

        if (technologies.remove(removeTech)) {
            System.out.println(removeTech + " Removed Successfully");
        } else {
            System.out.println(removeTech + " Not Found");
        }

        System.out.println("\n===== UPDATED TECHNOLOGIES =====");

        for (String tech : technologies) {
            System.out.println(tech);
        }

        System.out.println("Total Technologies : " + technologies.size());

        ArrayList<Integer> scores = new ArrayList<Integer>();

        System.out.print("\nEnter Number of Students : ");
        int noOfStudents = Integer.parseInt(sc.nextLine());

        System.out.println("Enter Student Scores");

        for (int i = 1; i <= noOfStudents; i++) {

            System.out.print("Score " + i + " : ");
            scores.add(Integer.parseInt(sc.nextLine()));
        }

        int total = 0;

        for (Integer score : scores) {
            total += score;
        }

        double average = (double) total / scores.size();

        int highest = Collections.max(scores);
        int lowest = Collections.min(scores);

        System.out.println("\n===== STUDENT SCORE ANALYSIS =====");

        System.out.print("Scores : ");
        for (Integer score : scores) {
            System.out.print(score + " ");
        }

        System.out.println("\nTotal Score : " + total);
        System.out.println("Average Score : " + average);
        System.out.println("Highest Score : " + highest);
        System.out.println("Lowest Score : " + lowest);

        sc.close();
    }
}
