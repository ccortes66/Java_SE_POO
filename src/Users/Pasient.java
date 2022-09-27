package Users;

import Users.Doctor;
import Users.User;
import lombok.*;
import java.util.Date;

@Setter @Getter
public class Pasient extends User
{

    private Date birthday;
    private Double weight;
    private Double height;
    private String blood;

    private Object object;

    public Pasient(
            Long id,
            String name,
            String email,
            String address,
            String phoneNumber,
            Date birthday,
            Double weight,
            Double height,
            String blood,
            Object object
    ){
        super(id,name,email,address,phoneNumber,(byte) 3);
        this.birthday = birthday;
        this.weight = weight;
        this.height = height;
        this.blood = blood;
        this.object = object;

    }

    @Override
    public String toString() {
        return "Users.Pasient{" + "\n" +
                "       Users.Pasient =" + super.toString() + "\n" +
                "       birthday= " + birthday + "\n" +
                "       weight= " + weight + " Kg  \n" +
                "       height= " + height + " Mts \n" +
                "       blood= " + blood + "\n" +
                '}';
    }

    @Override
    public String showDateUser()
    {
        return  null;
    }
}
