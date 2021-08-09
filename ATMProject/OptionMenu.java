package Projects.Atm_Project;


import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account{
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'Rs.'#,##,##0.00"); //Denote what kind of money format you have.

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>(); // It will store data of customer no and PIN.


//  GET LOGIN() METHOD
    // Enter customer no and pin
    public void getLogin() throws IOException{
        int x = 1;
        do {
            try {
                data.put(984725, 483746); // (Customer No, PIN)
                data.put(984726, 845294);

                System.out.println("Welcome to the Atm");
                System.out.print("Enter your Customer No: ");
                setCustomerNumber(menuInput.nextInt()); // setCustomerNumber

                System.out.print("Enter PIN No: ");
                setPinNumber(menuInput.nextInt()); // setPinNumber
            } catch (Exception e){
                System.out.println("\n" + "Invalid Character(s). Only Numbers." + "\n");
                x = 2;
            }

            int cn = getCustomerNumber();
            int pn = getPinNumber();

            if (data.containsKey(cn) && data.get(cn) == pn){ // When cn == pn
                getAccountType();
            }else{
                System.out.println("\n" + "Wrong Customer No or PIN No" + "\n");
            }


        }while (x==1);
    }

// GET ACCOUNT() TYPE
    // which ac? checking or saving
    public void getAccountType(){
        System.out.println("Select the Account you want to Access: ");
        System.out.println("Type-1: Checking Account");
        System.out.println("Type-2: Saving Account");
        System.out.println("Type-3: Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank you for using this ATM, bye.  \n");
                break;

            default:
                System.out.println("\n" + "Invalid Choice" + "\n");
                getAccountType();
        }


    }

// Get Checking ACCOUNT()
    public void getChecking(){
        System.out.println("Checking Account: ");
        System.out.println("Type-1: View Balance");
        System.out.println("Type-2: Withdraw Fund");
        System.out.println("Type-3: Deposit Funds");
        System.out.println("Type-4: BACK");
        System.out.println("Type-5: Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getChecking();
                break;

            case 2:
                getCheckingWithdrawInput();
                getChecking();
                break;

            case 3:
                getCheckingDepositInput();
                getChecking();
                break;

            case 4:
                getAccountType();

            case 5:
                System.out.println("Thank you for using this ATM, bye.");
                break;

            default:
                System.out.println("\n" + "Invalid Choice" + "\n");
                getChecking();

        }


    }

// Get Saving ACCOUNT()
public void getSaving(){
    System.out.println("Checking Account: ");
    System.out.println("Type-1: View Balance");
    System.out.println("Type-2: Withdraw Fund");
    System.out.println("Type-3: Deposit Funds");
    System.out.println("Type-4: BACK");
    System.out.println("Type-5: Exit");
    System.out.print("Choice: ");

    int selection = menuInput.nextInt();

    switch (selection){
        case 1:
            System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
            getSaving();
            break;

        case 2:
            getSavingWithdrawInput();
            getSaving();
            break;

        case 3:
            getSavingDepositInput();
            getSaving();
            break;

        case 4:
            getAccountType();

        case 5:
            System.out.println("Thank you for using this ATM, bye.");
            break;

        default:
            System.out.println("\n" + "Invalid Choice" + "\n");
            getSaving();

    }

}

}
