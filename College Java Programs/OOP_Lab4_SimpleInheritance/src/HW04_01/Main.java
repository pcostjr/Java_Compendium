package HW04_01;

public class Main
{
    public static void main(String[] args)
    {
        LabClass l1 = new LabClass(10);
        Student p1 = new Student("Drake Parker", "13340");
        Student p2 = new Student("Josh Peck", "143323");
        Instructor p3 = new Instructor("Larry Fishwald", "1435", "609-555-5555");
        l1.enrollStudent(p1);
        l1.enrollStudent(p2);
        l1.setInstructor(p3);
        l1.printList();


    }
}
