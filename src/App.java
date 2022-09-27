import UiModel.MiUiConsole;
import Users.Doctor;
import Users.Nurse;
import Users.Pasient;
import Users.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class App
{
    public static void main(String[] args)
    {


        /**
        doctor.addAvailableAppointer(LocalDate.now(), LocalTime.now());
        doctor.addAvailableAppointer(LocalDate.now(), LocalTime.now());
        doctor.addAvailableAppointer(LocalDate.now(), LocalTime.now());
        System.out.println(doctor);

        for(Users.Doctor.AvailableAppointer availableAppointer : doctor.getAvailableAppointers())
        {
            System.out.println(availableAppointer);
        }
        **/


        /**
        int [] Array = {1,5,5};
        System.out.println(Doctor.suma(Array));

        Float [] Array2 = {1.0f,2.5f,33.3f};
        System.out.println(Doctor.suma(Array2));

        Double [] Array3 = {1.0,2.5,33.3,5.33};
        System.out.println(Doctor.suma(Array3));

        **/

        MiUiConsole.createUser();
        MiUiConsole.myMenu();



    }



}
