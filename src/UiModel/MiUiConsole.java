package UiModel;

import Appointments.AppointmentNurse;
import Appointments.AppointmetDoctor;
import Appointments.Appoitment;
import Users.Doctor;
import Users.Nurse;
import Users.Pasient;
import Users.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DateFormatSymbols;

public class MiUiConsole
{

    private static ArrayList<User> users;
    private static ArrayList<AppointmetDoctor> appointmetDoctors = new ArrayList<>();
    private static ArrayList<AppointmentNurse> appointmentNurses = new ArrayList<>();



    public static void createUser()
    {
               users = new ArrayList();
               Calendar calendar = Calendar.getInstance();
                //doctor
               users.add(new Doctor(1L,"Cristian C","cc@na.com","calle falsa 123","12345","Optometria"));
               users.add(new Doctor(2L,"Javier C","jc@na.com","calle falsa 1235","1482345","Cardiologia"));
               users.add(new Doctor(3L,"Marta P","mpc@na.com","calle falsa 1235","14823455","Cancerologia"));

                //Nurses
               users.add(new Nurse(9L,"Fabiola Mendez","fb@hshsh.com","cll 99 # 55-88","1231231","Optometria"));
               users.add(new Nurse(8L,"Natalia Pelaes","np@hshsh.com","cll 99 # 55-78","1231248","cardiologia"));
               users.add(new Nurse(7L,"Duban Ovalle","do@hshsh.com","cll 55 # 55-78","1241248","Cancerologia"));

               //Pasient
               calendar.set(1996,05,27);
               users.add(new Pasient(10L,"Luis Manrique","lm@pasient.com","dg 59 # 55 - 33","5555555",calendar.getTime(),90.3,189.2,"O-", users.get(1)));
               calendar.set(1985,11,27);
               users.add(new Pasient(11L,"Dora Manrique","dm@pasient.com","dg 88 # 55 - 33","6555555",calendar.getTime(),55.3,189.2,"A-", users.get(4)));
               calendar.set(1975,0,27);
               users.add(new Pasient(12L,"Ivan Obando","io@pasient.com","cll 88 # 55 - 33","8955555",calendar.getTime(),70.3,167.2,"A+", users.get(3)));


    }

    private static User authUser(String email)
    {
        for (User user :users)
        {
           if(user.getEmail().equals(email.trim()))
           {
               return user;
           }
        }

        return null;

    }

    private static ArrayList<User> authUser(Byte ops)
    {
        ArrayList<User> multiple = new ArrayList<>();
        switch (ops)
        {
            case 1:
                for (User user :users)
                {
                    if(user.getType() == 3)
                    {
                        multiple.add(user);
                    }
                }
                break;
            case 2:
                for (User user :users)
                {
                    if(user.getType() == 1 || user.getType() == 2)
                    {
                        multiple.add(user);
                    }
                }
                break;

        }


        return multiple;

    }

    public static void myMenu()
    {

        User recibido;
        String email;
        byte ops;

        Scanner value = new Scanner(System.in);
        do{

            System.out.print("Escribe el correo [aa@aaa.com]: ");
            email = value.next();
            recibido = MiUiConsole.authUser(email);
            System.out.flush();

        }while (recibido == null);

        switch (recibido.getType())
        {
            case 1:
               do{
                   System.out.print(
                           "Hola Doctor@: "+recibido.getName() + "\n" +
                            MiUiConsole.menu(1)
                   );
                   System.out.print("Elige Opcion: ");
                   ops = value.nextByte();
                   if(ops == 1)
                   {
                       System.out.flush();
                       MiUiConsole.showAddAvalaibleAppoimentMenu("Hola Doctor@: "+recibido.getName() + "\n",recibido);
                   }else if (ops == 3)
                   {
                       for (AppointmetDoctor app:appointmetDoctors)
                       {
                           if(app.getDoctor().getEmail().equals(recibido.getEmail()))
                           {
                               System.out.println(app);
                               System.out.print(
                                       "----------------------------------\n"+
                                       "-----------------------------------\n"
                               );
                           }
                       }
                   }

               }while (ops != 0);
                MiUiConsole.myMenu();
                break;
            case 2:
                do{
                System.out.print(
                        "Hola Enfermer@: "+recibido.getName() + "\n" +
                         MiUiConsole.menu(1)
                );
                System.out.print("Elige Opcion: ");
                ops = value.nextByte();
                if(ops == 1)
                {
                    MiUiConsole.showAddAvalaibleAppoimentMenu("Hola Enfermer@: "+recibido.getName() + "\n",recibido);
                }else if (ops == 3)
                {
                    for (AppointmentNurse app:appointmentNurses)
                    {
                        if(app.getNurse().getEmail().equals(recibido.getEmail()))
                        {
                            System.out.println(app);
                            System.out.print(
                                    "----------------------------------\n" +
                                    "-----------------------------------\n"
                            );
                        }
                    }
                }


                }while (ops != 0);
                MiUiConsole.myMenu();
                break;
            case 3:
                do{
                    System.out.print(
                            "Hola Pasiente: "+recibido.getName() + "\n" +
                                    MiUiConsole.menu(3)
                    );
                    System.out.print("Elige Opcion: ");
                    ops = value.nextByte();
                    if (ops == 1)
                    {
                        System.out.println("Citas Agendadas Doctor@");
                        for (AppointmetDoctor app:appointmetDoctors)
                        {
                            if(app.getPasient().getEmail().equals(recibido.getEmail()))
                            {
                                System.out.println(app.getDoctor());
                                System.out.println("Fecha: "+app.getDate()+" Hora: "+app.getTime());
                                System.out.print(
                                        "----------------------------------\n"+
                                                "-----------------------------------\n"
                                );
                            }
                        }

                        System.out.println();
                        System.out.println("Citas Agendadas Enfermer@");
                        for (AppointmentNurse app:appointmentNurses)
                        {
                            if(app.getPasient().getEmail().equals(recibido.getEmail()))
                            {
                                System.out.println(app.getNurse());
                                System.out.println("Fecha: "+app.getDate()+" Hora: "+app.getTime());
                                System.out.print(
                                        "----------------------------------\n" +
                                                "-----------------------------------\n"
                                );
                            }
                        }

                    }


                }while (ops != 0);
                MiUiConsole.myMenu();
                break;
        }

    }

    private static String menu(int ops)
    {
        switch (ops)
        {
            case 1:
                return  "-----------------------------------\n" +
                        "|         Menu Principal          |\n" +
                        "|                                 |\n" +
                        "----------------------------------\n" +
                        "-----------------------------------\n" +
                        "| 1 . Add Appoiment               |\n" +
                        "| 2 . My Shedule Appoiment        |\n" +
                        "| 3 . Show My Appoiment registred |\n" +
                        "| 0 . Logout                      |\n" +
                        "---------------------------------- \n";
            case 2:
                return
                        "----------------------------------\n" +
                        "| 1 . Add Date                   |\n" +
                        "| 2 . Change Date                |\n" +
                        "| 0 . Logout                     |\n" +
                        "----------------------------------\n";
            case 3:
                return  "-----------------------------------\n" +
                        "|         Menu Principal          |\n" +
                        "|                                 |\n" +
                        "----------------------------------\n" +
                        "-----------------------------------\n" +
                        "| 1 . Show My Appoiment registred |\n" +
                        "| 0 . Logout                      |\n" +
                        "---------------------------------- \n";
        }



        return null;
    }



    public static void showAddAvalaibleAppoimentMenu(String msm,User user)
    {

       Scanner value = new Scanner(System.in);
       DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
       byte data,mes;
       boolean conf = false;
       Calendar calendar = Calendar.getInstance();
       String[] month;
       month = dateFormatSymbols.getMonths();
       System.out.print(
                msm +
                "----------------------------------\n" +
                "|         Add Appoiment          |\n" +
                "----------------------------------\n" +
                "----------------------------------\n"
        );


       for (int i = 0; i<month.length-1 ; i++)
       {

           if(i >= (LocalDate.now().getMonthValue()-1) && i < (LocalDate.now().getMonthValue()+4))
           {
               //calendar.set(Calendar.MONTH,Month.DECEMBER.getValue());
               //int valuee = calendar.get(Calendar.MONTH);
               //String mesEs = mes.getDisplayName(TextStyle.FULL,new Locale("es","CO"));

               System.out.println("|     "+ (i+1)+". "+ month[i].toUpperCase());
           }



       }

        System.out.println("|     0. Return Menu        ".toUpperCase());
        System.out.println("----------------------------------");
        System.out.print("Escribe El Mes Numerico : ".toUpperCase());
        data = value.nextByte();

        if(data >= LocalDate.now().getMonthValue()-1 && data < (LocalDate.now().getMonthValue())+4)
        {
            mes = data;
            try
            {
                System.out.print("Por favor Ingrese Dia: ".toUpperCase());
                data = value.nextByte();
                calendar.set(LocalDate.now().getYear(),(mes-1),data);
                System.out.print(
                        calendar.get(Calendar.DATE)+"/"+mes+"/"+calendar.get(Calendar.YEAR)
                                +" Hora:" + LocalTime.now().getHour()+ ":"+ (LocalTime.now().getMinute())+":"+LocalTime.now().getSecond() +"\n"+
                        MiUiConsole.menu(2)
                );
                System.out.print("Ingrese Opcion: ");
                data = value.nextByte();
                switch (data)
                {
                    case 1:
                      do
                      {
                          System.out.print("----------------------------------\n");
                          for (User rec:MiUiConsole.authUser((byte)1))
                          {
                              System.out.print("|      "+rec.getId()+". "+rec.getName()+"\n");
                          }
                          System.out.print("----------------------------------\n");
                          System.out.print("Escribe Numero del pasiente: ");
                          data = value.nextByte();

                          for(int i=0; i<users.size(); i++)
                          {
                              if(users.get(i).getId() == data)
                              {
                                  conf = true;
                                  if(user.getType() == 1)
                                  {
                                      appointmetDoctors.add(new AppointmetDoctor(calendar.getTime(),LocalTime.now(),(Pasient) users.get(i), (Doctor) user));
                                      break;
                                  }else
                                  {
                                      appointmentNurses.add(new AppointmentNurse(calendar.getTime(),LocalTime.now(),(Pasient) users.get(i), (Nurse) user));
                                      break;
                                  }

                              }
                          }

                      }while (!conf);
                        MiUiConsole.menu(1);
                        break;
                    case 2:
                        MiUiConsole.showAddAvalaibleAppoimentMenu(msm,user);
                        break;
                    case 0:
                        MiUiConsole.menu(1);
                }


            }catch (Exception ex)
            {
                System.out.println("Error!! "+ex.getMessage());
            }

        }else if(data == 0)
        {
            MiUiConsole.menu(1);
        }else
        {
            System.out.println("Error, Mes Erroneo");
            MiUiConsole.showAddAvalaibleAppoimentMenu(msm,user);
        }



    }



}
