package HW04_01;

public class Person
{
    // the student's full name
    protected String name;
    // the student ID
    protected String id;

    /**
     * Create a new student with a given name and ID number.
     */
    public Person(String fullName, String personID)
    {
        name = fullName;
        id = personID;
    }

    /**
     * Return the full name of this student.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set a new name for this student.
     */
    public void changeName(String replacementName)
    {
        name = replacementName;
    }

    /**
     * Return the student ID of this student.
     */
    public String getID()
    {
        return id;
    }

    /**
     * Add some credit points to the student's accumulated credits.
     */

}
