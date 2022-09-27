package Appointments;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public interface IShedulable
{
    void shedulable(Date date, LocalTime time);
}
