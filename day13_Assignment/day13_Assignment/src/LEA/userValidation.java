package LEA;

import java.util.Scanner;
import java.util.regex.Pattern;


public class userValidation {

        final String namePattern = "^[A-Z]{1}[a-z]{2,10}$";
        final String emailpattern = "^[a-z0-9]{3,}(.[0-9a-z]+)*@[a-z]{2,}.(com|edu)(co.in)*$";
        final String mobileNumberPattern = "^\\+[0-9]+\\s[0-9]{10,15}$";
        final String passwordPattern = "^(?=.*[0-9])"+"(?=.*[@#$%^&+=])"+"(?=.*[a-z])(?=.*[A-Z])"+"(?=\\S+$).{8,20}$";
    public void userValidate() {

        validate UR = (checkPattern , givenInput) ->{

            try {
                if (givenInput == null) {
                    throw new userException("give valid input , String is empty");
                }
                else if(!(Pattern.matches(checkPattern, givenInput))) {
                     /*if exception occurs below custom exception will handle it*/
                    throw new userException("give valid input");
                }
                System.out.println("the given User detail is correct :" + givenInput);

            } catch(userException e) {
                String printMessage = e.warning;
                System.out.println(printMessage);
                userValidate();
             }

        };

        
        System.out.println("enter the correct userFirstName");
        Scanner sc = new Scanner(System.in);
        String FirstName = sc.nextLine();
        UR.validateUser(namePattern, FirstName);

        System.out.println("enter the correct userLastName");
        String LastName = sc.nextLine();
        UR.validateUser(namePattern, LastName);

        System.out.println("enter the correct Email");
        String Email = sc.nextLine();
        UR.validateUser(namePattern, Email);

        System.out.println("enter the correct mobileNumber");
        String MobileNumber = sc.nextLine();
        UR.validateUser(namePattern, MobileNumber);

        System.out.println("enter the correct password");
        String password = sc.nextLine();
        UR.validateUser(namePattern, password);

    }
}
