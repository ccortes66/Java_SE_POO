package Appointments;

import Users.Pasient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalTime;
import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@ToString
public abstract class Appoitment
{

    private Date date;
    private LocalTime time;
    private Pasient pasient;
}
