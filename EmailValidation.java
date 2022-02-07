package com.my.project2;
import java.util.Scanner;

class EmailValidation {
    public static void main(String[] args) {
        String result = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Email Id: ");
        String emailid = sc.nextLine();
        String[] app = {
                "first@gmail.com",
                "Second22@gmail.com",
                "third1234@gmail.org",
                "1242@gmail.com",
                "d6@gmail.com" };
        String regex = "([A-Za-z0-9]+)[@]([a-z]+)[.](com|in|org)";

        for (int i = 0; i < app.length; i++) {
            if (app[i].matches(regex)) {

                if (app[i].matches(emailid)) {
                    result = "Email Entered:  " + app[i] + " is Valid";
                    break;
                }
                } else
                    result = "Email id is not  valid ";
        }
        System.out.println(result);

        sc.close();
    }
}
