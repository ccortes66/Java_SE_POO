package Users;

import Users.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Doctor extends User
{

    private String specility;

    //constructor
    public Doctor(
            Long id,
            String name,
            String email,
            String address,
            String phoneNumber,
            String specility
    )
    {
        super(id,name,email,address,phoneNumber, (byte) 1);
        this.specility = specility;
    }

    @Override
    public String toString() {
        return "Users.Doctor{" + "\n" +
                 super.toString() + "\n" +
                "specility= " + specility  + "\n" +
                "Employer{ \n" +
                "      " + this.showDateUser() + "\n" +
                "  }\n" +
                '}';
    }

    @Override
    public String showDateUser()
    {

        return "Hospital: Cruz Roja" + "\n" +
                "      Departamento: Cancerologia" ;

    }

    /**
    //overload method
    public static int suma(int Array[])
    {
        int min = 0;
        int max = Array.length - 1;
        int result = 0;

        while (min<=max)
        {
            result += Array[min];
            min++;
        }

        return result;
    }

    public static Float suma(Float Array[])
    {
        int min = 0;
        int max = Array.length - 1;
        Float result = 0f;

        while (min<=max)
        {
            result += Array[min];
            min++;
        }

        return result;
    }

    public static Double suma(Double Array[])
    {
        int min = 0;
        int max = Array.length - 1;
        Double result = 0D;

        while (min<=max)
        {
            result += Array[min];
            min++;
        }

        return result;
    }
    **/

    /**
    //Nested Class

    ArrayList<AvailableAppointer> availableAppointers = new ArrayList<>();

    public ArrayList<AvailableAppointer> getAvailableAppointers()
    {
        return availableAppointers;
    }
    public void addAvailableAppointer(LocalDate date, LocalTime time)
    {
        availableAppointers.add(new AvailableAppointer(date,time));
    }

    public static class AvailableAppointer
    {

        private LocalDate date;
        private LocalTime localTime;


        public AvailableAppointer()
        {

        }

        public AvailableAppointer(
                LocalDate date,
                LocalTime time

        ){
            this.date = date;
            this.localTime = time;

        }

        @Override
        public String toString() {
            return "AvailableAppointer{" + "\n" +
                    "date= " + date + "\n" +
                    "localTime= " + localTime + "\n" +
                    '}';
        }
    }
   **/


}
