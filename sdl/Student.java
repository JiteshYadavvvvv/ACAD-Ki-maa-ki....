
import java.util.*;

class Student {
    int id, sem;
    String name, dept, grade;
    double m1, m2, m3, total, per;
    static int count = 0;

    Student() {
        count++;
    }

    Student(int i, String n, String d, int s, double a, double b, double c) {
        id = i; name = n; dept = d; sem = s;
        m1 = a; m2 = b; m3 = c;
        count++;
        calculateResult();
    }

    void calculateResult() {
        total = m1 + m2 + m3;
        per = total / 3;

        if (per >= 90) grade = "A";
        else if (per >= 75) grade = "B";
        else if (per >= 60) grade = "C";
        else grade = "F";
    }

    void displayStudent() {
        System.out.println(id + " " + name + " " + dept);
        System.out.println("Semester: " + sem);
        System.out.println("Total: " + total + " Percentage: " + per);
        System.out.println("Grade: " + grade);
    }

    void updateMarks(double a, double b, double c) {
        m1 = a; m2 = b; m3 = c;
        calculateResult();
    }

    void updateMarks(double a, double b, double c, int s) {
        updateMarks(a, b, c);
        sem = s;
    }

    static int getStudentCount() {
        return count;
    }

    static double calculateClassAverage(Student s[]) {
        double sum = 0;
        for (Student x : s)
            sum += x.per;
        return sum / s.length;
    }

    static Student findTopper(Student s[]) {
        Student t = s[0];
        for (Student x : s)
            if (x.per > t.per) t = x;
        return t;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        Student s[] = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter ID, Name, Dept, Semester: ");
            int id = sc.nextInt();
            String name = sc.next(), dept = sc.next();
            int sem = sc.nextInt();

            System.out.print("Enter 3 marks: ");
            double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();

            s[i] = new Student(id, name, dept, sem, a, b, c);
        }

        for (Student x : s)
            x.displayStudent();

        System.out.println("Topper:");
        findTopper(s).displayStudent();

        System.out.println("Class Average: " + calculateClassAverage(s));
        System.out.println("Student Count: " + getStudentCount());
        sc.close();
    }
}
