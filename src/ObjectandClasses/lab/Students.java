package ObjectandClasses.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    static class Student {
        private String firstName;
        private String lastName;
        private int age;
        private String homeTown;

        public Student (String firstName, String lastName, int age, String homeTown){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;

        }

        public void setHomeTown(String homeTown) {
            this.homeTown = homeTown;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public String getHomeTown() {
            return homeTown;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Student> studentList = new ArrayList<>();

        while (!input.equals("end")){
            String firstName = input.split(" ")[0];
            String lastName = input.split(" ")[1];
            int age = Integer.parseInt(input.split(" ")[2]);
            String homeTown = input.split(" ")[3];

            Student currentStudent = new Student(firstName, lastName, age, homeTown);

            int existingIndex = getExistingIndex(studentList, firstName, lastName);

            if(existingIndex != -1){
                studentList.get(existingIndex).setAge(currentStudent.age);
                studentList.get(existingIndex).setHomeTown(currentStudent.homeTown);
            }else {
            studentList.add(currentStudent);
            }

            input = scanner.nextLine();
        }

        String town = scanner.nextLine();

        for (Student student: studentList) {
            if (town.equals(student.getHomeTown())){
                System.out.printf("%s %s is %d years old%n",student.getFirstName(), student.getLastName(),
                        student.getAge());
            }

        }
    }

    private static int getExistingIndex(List<Student> studentList, String firstName, String lastName) {
        for (int i = 0; i < studentList.size(); i++) {
            String first = studentList.get(i).getFirstName();
            String last = studentList.get(i).getLastName();
            if (firstName.equals(first) && lastName.equals(last)){
                return i;
            }


        }
        return -1;
    }
}
