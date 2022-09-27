package Appointments;

import Users.Doctor;
import Users.Pasient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class AppointmetDoctor extends Appoitment implements IShedulable
{
    @Getter @Setter
    private Doctor doctor;

    public AppointmetDoctor(Date date, LocalTime time, Pasient pasient, Doctor doctor)
    {
        super(date, time, pasient);
        this.doctor = doctor;
    }

    @Override
    public void shedulable(Date date, LocalTime time)
    {

    }

    @Override
    public String toString() {
        return "AppointmetDoctor{\n" +
                "Data = "+ super.toString() + "\n" +
                '}';
    }
}
