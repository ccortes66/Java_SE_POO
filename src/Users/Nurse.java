package Users;

public class Nurse extends User
{
    private String specility;

    public Nurse(Long id, String name, String email, String address, String phoneNumber,String specility)
    {
        super(id, name, email, address, phoneNumber,(byte) 2);
        this.specility = specility;
    }

    @Override
    public String toString() {
        return "Nurse{\n" +
                "Data =" + super.toString()  + "\n" +
                "specility =" + specility  + "\n" +
                "Employer{ \n" +
                "      " + this.showDateUser() + "\n" +
                "  }\n" +
                '}';
    }

    @Override
    public String showDateUser()
    {

        return "Hospital: Cruz Verde" + "\n" +
                "      Departamento: Cancerologia,Pediatria," ;

    }
}
