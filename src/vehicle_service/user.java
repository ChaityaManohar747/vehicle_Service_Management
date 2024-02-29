package vehicle_service;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class user {
    String username;
    String password;
    String address;
    String phoneno;


    public user()
    {
        username="Chaitya";
        password="123456";
        phoneno="1234567899";
        address="RamColony";
    }

    public void getuserinflo()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("enter username");
        username=s.nextLine();
        System.out.println("enter Password");
        password=s.nextLine();
        System.out.println("enter phone number");
        phoneno=s.nextLine();
        System.out.println("enter address");
        address=s.nextLine();

    }

}
