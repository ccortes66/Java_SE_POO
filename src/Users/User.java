package Users;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@Data
public abstract class User
{
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private Byte type;

    public abstract String showDateUser();

}
