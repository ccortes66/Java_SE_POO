package Appointments;

import Users.Nurse;
import Users.Pasient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;

public class AppointmentNurse extends Appoitment implements IShedulable
{
    @Getter
    @Setter
    private Nurse nurse;

    public AppointmentNurse(Date date, LocalTime time, Pasient pasient, Nurse nurse)
    {
        super(date, time, pasient);
        this.nurse = nurse;
    }

    @Override
    public void shedulable(Date date, LocalTime time)
    {

    }
}
