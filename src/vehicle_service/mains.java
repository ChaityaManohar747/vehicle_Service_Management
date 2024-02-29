package vehicle_service;
import java.io.*;
import java.util.*;

public class mains {

    static int i = 0;
    static user user = null;
    static int Total=0;
    static String service;
    static  String Vehicle_type;

    static String vehicle=null;
    public static String centerString (int width, String s) {
        return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }
    public void print_invoice()
    {
            // String line3_l="";
            //String line3_r=a+"|";
            String slashh="//////////////////////////////////////////////////////////////////////////////////////////////////////////////";
            String dashhh="--------------------------------------------------------------------------------------------------------------";
            String str_title=centerString(70,"CAR SERVICING AAJ AUR KAL!!");
            String str_line3_l= String.format("%"+(-70)+"s","INVOICE NO.");
            String str_line4_l= String.format("%"+(-70)+"s","REGISTER NO.");
            String str_line5_l= String.format("%"+(-70)+"s","USERNAME");
            String str_line6_l= String.format("%"+(-70)+"s","PHONE NO.");
            String str_line7_l= String.format("%"+(-70)+"s","VEHICLE TYPE");
            String str_line8_l= String.format("%"+(-70)+"s","SERVICE TYPE");
            String str_line9_l= String.format("%"+(-70)+"s","SERVICE CHARGE");

            //String str_line3_r=String.format("%"+(-70)+"s","|"+a);

            String strl3=str_line3_l+(int)(1000*Math.random());
            String strl4=str_line4_l+vehicle;
            String strl5=str_line5_l+user.username;
            String strl6=str_line6_l+user.phoneno;
            String strl7=str_line7_l+Vehicle_type;
            String strl8=str_line8_l+service;
            String strl9=str_line9_l+Total;

            //System.out.println(String.format("%"+(70)+"s",strl3));
            System.out.println(slashh);
            System.out.println(str_title);
            System.out.println(slashh);
            System.out.println(String.format("%"+(70)+"s",strl3));
            System.out.println(String.format("%"+(70)+"s",strl4));
            System.out.println(String.format("%"+(70)+"s",strl5));
            System.out.println(String.format("%"+(70)+"s",strl6));
            System.out.println(String.format("%"+(70)+"s",strl7));
            System.out.println(String.format("%"+(70)+"s",strl8 ));
            System.out.println(dashhh);
            System.out.println(String.format("%"+(70)+"s",strl9));
            System.out.println(dashhh);

        }

    public static void main(String[] args) throws IOException {
        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("\t\t\t\t\t\t\t\tWelcome!");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        Scanner scc = new Scanner(System.in);

        user = new user();

        char choice = 'u';
        int ch = 0;
        String username;
        String password;
        String address;
        String phno;
        do {
            System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////////");
            System.out.println("\t\t1.Create Account\t2.Start with Service\t3.Get Receipt\t4.Login as an Admin");
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            ch = scc.nextInt();
            switch (ch) {
                case 1:
                    try {
                        FileWriter fw = new FileWriter("users.txt", true);
                        user = new user();
                        user.getuserinflo();
                        username = user.username;
                        password = user.password;
                        address = user.address;
                        phno = user.phoneno;
                        fw.write(username);
                        fw.write("\t");
                        fw.write(password);
                        fw.write("\t");
                        fw.write(address);
                        fw.write("\t");
                        fw.write(phno);
                        fw.write("\n");
                        fw.close();


                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 2:
                    Vehicle v = new Vehicle();
                    v.get_started();
                    Total = v.Totalamount;
                    service = v.servicechosen;
                    Vehicle_type=v.type;
                    vehicle=v.regno;
                    break;

                case 3: mains m = new mains();
                        if(user!=null) {
                            if(Total==0){
                                System.out.println("Please Take a service for Invoice");
                            }
                            else
                            {
                              m.print_invoice();
                            }

                        }
                        else
                        {
                         System.out.println("Please Create Account first");
                        }
                        i++;
                        System.out.println(i);
                        break;

                case 4:
                    String userid = "chaitya";
                    String pass="chaitya";
                    String userrr;
                    String passss;
                    String str;
                    System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////////");
                    System.out.println("Enter admin userid");
                    System.out.println("--------------------------------------------------------------------------------------------------------------");
                    userrr= scc.next();
                    System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////////");
                    System.out.println("Enter admin password");
                    System.out.println("--------------------------------------------------------------------------------------------------------------");
                    passss= scc.next();
                    if(userrr.equals(userid) && passss.equals(pass))
                    {
                        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////////");
                        System.out.println("Login successfullyy ! Here are details of all users");
                        System.out.println("--------------------------------------------------------------------------------------------------------------");
                       try {
                           FileReader fr = new FileReader("users.txt");
                           int i;
                           while ((i = fr.read()) != -1)
                               System.out.print((char) i);
                           fr.close();
                       }catch(Exception e)
                       {
                          System.out.println(e);
                       }
                    }
                    else
                    {
                     System.out.println("Wrong Id or Password");
                    }
                    break;
            }
            System.out.println("Do you want to continue ?");
            choice = scc.next().charAt(0);
        } while (choice == 'Y' || choice == 'y');

    }
}


