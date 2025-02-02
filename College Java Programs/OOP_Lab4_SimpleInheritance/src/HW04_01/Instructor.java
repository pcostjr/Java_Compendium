package HW04_01;

public class Instructor extends Person
{
    private String contactInfo;

    public Instructor(String fullName, String id, String contact)
    {
        super(fullName, id); //adds to the fullName
        contactInfo = contact; //adds to the contact
    }

    public String getContactInfo()
    {
        return contactInfo; //returns the contact info
    }


}
