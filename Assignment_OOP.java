/******************************************************************************
| Author 1 : Lee Xian Yang (SW01081013)                                        |
| Author 2 : Amirul Fikri bin Azman Zafri (CS01081173)                         |
| Author 3 : Vyner Nicholas Kayang (CS01081043)                                |
| Lang : java                                                                  |
| Date Created : 30/11/2022                                                    |
*******************************************************************************/
package assignment_oop;
import java.util.*;
import java.util.regex.*;

// super class 
abstract class BankAccount
{
    // data members - shared with subclass
    protected String bank_name;
    protected String full_name;
    protected int account_number;
    protected String account_type;
    protected double balance;
    protected double interest_rate;
    
    // obj. init
    Random random = new Random();
    
    // superclass construc.
    public BankAccount()
    {
        bank_name = "ABC BANK";
        full_name = "nil";
        account_number = random.nextInt(9999-1001+1)+1001;
        account_type = "nil";
        balance = 0.0;
        interest_rate = 0.0;
    }

    // getter for bank_name
    public String getBank_name()
    {
        return bank_name;
    }

    // setter for bank_name
    public void setBank_name(String bank_name)
    {
        this.bank_name = bank_name;
    }

    // getter for full_name
    public String getFull_name()
    {
        return full_name;
    }

    // setter for full_name
    public void setFull_name(String full_name)
    {
        this.full_name = full_name;
    }

    // getter for account_number
    public int getAccount_number()
    {
        return account_number;
    }

    // setter for full_name
    public void setAccount_number(int account_number)
    {
        this.account_number = account_number;
    }

    // getter for account_type
    public String getAccount_type()
    {
        return account_type;
    }

    // setter for account_type
    public void setAccount_type(String account_type)
    {
        this.account_type = account_type;
    }

    // getter for balance
    public double getBalance()
    {
        return balance;
    }

    // setter for balance
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    // getter for interest_rate
    public double getInterest_rate()
    {
        return interest_rate;
    }

    // setter for balance
    public void setInterest_rate(double interest_rate)
    {
        this.interest_rate = interest_rate;
    }

    // toString() funct.
    public String toString()
    {
        return "\n+++++  ACCOUNT INFORMATION  +++++"
                + "\nName: " + full_name
                + "\nAccount No: " + account_number
                + "\nAccount Type: " + account_type
                + "\nBalance: RM" + String.format("%.2f", balance)
                + "\nInterest Rate: " + interest_rate + "%"
                + "\n+++++++++++++++++++++++++++++++++\n\n";
    }
}

// subclass - BankAccount -> SavingAccount
class SavingAccount extends BankAccount
{
    // subclass construc.
    // ? call superclass's construc. and overwrite
    public SavingAccount()
    {
        super();
        account_type = "Saving Acccount";
        balance = 50;
        interest_rate = 0.05;
    }
}

// subclass - BankAccount -> CurrentAccount
class CurrentAccount extends BankAccount
{
    // subclass construc.
    // ? call superclass's construc. and overwrite
    public CurrentAccount()
    {
        super();
        account_type = "Current Account";
        balance = 200;
        interest_rate = 0.01;
    }
}

// main class
public class Assignment_oop
{
    // main menu funct.
    static void menu()
    {
        System.out.println("==============  Welcome To ABC Bank System  ==============");
        System.out.println("1. Create Account");
        System.out.println("2. Make a Transaction");
        System.out.println("0. End");
        System.out.print("Your Input : ");
    }
    
    // transaction menu funct.
    static void transaction_menu()
    {
        System.out.println("==============  TRANSACTION  ==============");
        System.out.println("1. Display");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.print("Your Input : ");
    }
    
    // account type menu funct.
    static void question_accountType()
    {
        System.out.println("\nChoose your bank account type -");
        System.out.println("1. Saving Account");
        System.out.println("2. Current Account");
        System.out.print("Your Input : ");
    }
    
    // full name menu funct.
    static void question_name()
    {
        System.out.println("\nPlease enter your full name : ");
        System.out.print("Your Input : ");
    }
    
    // account num. menu funct.
    static void question_accountNumber()
    {
        System.out.println("\nPlease enter your account number : ");
        System.out.print("Your Input : ");
    }
    
    // find account funct.
    static int find_account(int accnum, BankAccount[] account)
    {
        int i = 0;
        while(account[i]==null)
        {
            if(account[i].getAccount_number() == accnum)
            {
                return i;
            }
        }
        return -99;
    }
    
    // ! changed to toString - retr0
    // ! moved display from main to here - retr0
    static void display_account(int i,BankAccount[] account)
    {
        System.out.println("\n+++++  ACCOUNT INFOMATION  +++++");
        System.out.println("Name : " + account[i].getFull_name());
        System.out.println("Account No : " + account[i].getAccount_number());
        System.out.println("Account Type : " + account[i].getAccount_type());
        System.out.println("+++++++++++++++++++++++++++\n");
    }

    // display balance funct.
    static void display_transac(int i, BankAccount[] account)
    {
        System.out.println("Name : " + account[i].getFull_name());
        System.out.println("Account No : " + account[i].getAccount_number());
        System.out.println("Balance : RM"+ String.format("%.2f",account[i].getBalance()));
    }
    
    // deposit menu funct.
    static void question_deposit()
    {
        System.out.println("\nPlease enter deposit amount : ");
        System.out.print("Your Input : RM");
    }
    
    // deposit funct.
    static void deposit_function(int i,double amount,BankAccount[] account)
    {
        account[i].setBalance(amount + account[i].getBalance());
    }
    
    // withdraw menu funct.
    static void question_withdraw()
    {
        System.out.println("\nPlease enter withdraw amount : ");
        System.out.print("Your Input : RM");
    }
    
    // withdraw funct.
    static void withdraw_function(int i, double withdraw, BankAccount[] account)
    {
        account[i].setBalance(account[i].getBalance() - withdraw);
    }
    
    // transfer menu funct.
    static void question_transfer_amount()
    {
        System.out.println("\nPlease enter the amount you want to transfer : ");
        System.out.print("Your Input : RM");
    }
    
    // transfer funct.
    static void question_transfer_receiver()
    {
        System.out.println("\nPlease enter the receiver account number : ");
        System.out.print("Your Input : ");
    }

    static void transaction_success(int userPlaceInArray,int receiverPlaceInArray, double valueInput,BankAccount[] account)
    {
        System.out.print("\n");
        display_transac(userPlaceInArray, account);
        System.out.println("\n-------Transfering RM" + String.format("%.2f", valueInput) + "-------\n");
        display_transac(receiverPlaceInArray, account);
        System.out.print("\n");
        System.out.println("======================================");
        withdraw_function(userPlaceInArray, valueInput, account);
        deposit_function(receiverPlaceInArray, valueInput, account);
        System.out.println("Transaction Successful!");
        System.out.println("======================================");
        System.out.print("\n");
        
        //Display after transfer done
        display_transac(userPlaceInArray, account);
        System.out.println("\n------- RM" + String.format("%.2f", valueInput) + " Transfered-------\n");
        display_transac(receiverPlaceInArray, account);
        System.out.print("\n");
    }

    static void transaction_fail()
    {
        System.out.print("\n");
        System.out.println("======================================");
        System.out.println("Transaction Failed/Cancelled!");
        System.out.println("======================================");
        System.out.print("\n");
    }
    
    
    // psvm for main class
    public static void main(String[] args)
    {
        // Local var and obj init.
        // ! init all vars that need to pass valid. first
        int loop = 0;
        int user_choice = 0;
        int account_type = 0;
        int account_number = 0;
        int userPlaceInArray = 0;
        int receiverPlaceInArray = 0;

        double valueInput = 0;

        String name = " ";

        boolean error = false;
        
        BankAccount[] account;
        account = new BankAccount[10];
        Scanner input = new Scanner(System.in);
   
        Matcher matcher;
        final String VALID_NAME_PATTERN = "^[a-zA-Z \\-\\.\\']*$";
        Pattern pattern = Pattern.compile(VALID_NAME_PATTERN);
        
        // do... while input is not 0
        do
        {
            // user_choice input for user
            // ! input validation for user_choice
            do
            {
                error = false;
                menu();
                // try... catch for except. handling
                try
                {
                    // start of except. cause
                    user_choice = input.nextInt();
                    // end of except. cause

                    // if no except. raised, but not within 0-2; else cont.
                    if (user_choice < 0 || user_choice > 2)
                    {
                        error = true;
                        throw new Exception("Please enter correct input!\n");
                    }
                }
                catch (InputMismatchException user_choice_err)
                {
                    error = true;
                    System.err.println("Error! : Please enter correct input!\n");
                }
                catch (Exception user_choice_err)
                {
                    error = true;
                    System.err.println("Error! : " + user_choice_err.getMessage());
                }
                input = new Scanner(System.in);     // clean buffer
            } while (error);
            
            // switch... on user_choice
            // Main Menu Switch Case
            switch(user_choice)
            {
                // if create account
                case 1 :
                {
                    // user input for acc_type
                    // ! input validation for account_type
                    do
                    {
                        try
                        {
                            // start of except. cause
                            error = false;
                            question_accountType();
                            account_type = input.nextInt();
                            // end of except. cause

                            // if no except. raised but not within range 1-2; else cont.
                            if (account_type < 1 || account_type > 2)
                            {
                                error = true;
                                throw new Exception("Please enter correct input!\n");
                            }
                        }
                        catch (InputMismatchException account_type_err)
                        {
                            error = true;
                            System.err.println("Error! : Please enter correct input!\n");
                        }
                        catch (Exception account_type_err)
                        {
                            error = true;
                            System.err.println("Error! : " + account_type_err.getMessage());
                        }
                        input = new Scanner(System.in);   // clear buffer

                    } while (error);
                 
                    // switch... on account_type
                    switch(account_type)
                    {
                        // if SavingAccount
                        case 1:
                        {
                            account[loop] = new SavingAccount();
                            break;
                        }
                        // if CurrentAccount
                        case 2:
                        {
                            account[loop] = new CurrentAccount();
                            break;
                        }
                    }
                    
                    // user input for full_name
                    do
                    {
                        try
                        {
                            error = false;
                            question_name();
                            name = input.nextLine();
                            matcher = pattern.matcher(account[loop].getFull_name());

                            if (account[loop].getFull_name().length() == 0)
                            {
                                throw new Exception("Your name cannot be empty!");
                            }
                            // if name inputted does not follow regEx pattern
                            if (!matcher.matches())
                            {
                                throw new Exception("Error! Please enter a valid name!(No special symbol except . - ')");
                            }
                        }
                        catch (Exception account_num_err)
                        {
                            error = true;
                            System.err.println("Error! : " + account_num_err.getMessage());
                        }
                        input = new Scanner(System.in);   // clear buffer
                    } while (error);
                    
                    account[loop].setFull_name(name);                 
                    // display_acc() funct. call
                    display_account(loop, account);
                    loop++;
                    break;
                } // Case 1 ends
                
                // if make transaction
                case 2:
                {

                    // user input for acc_num
                    // ! input validation for acc_num        
                    try
                    {
                        question_accountNumber();
                        account_number = input.nextInt();
                        // find_account() funct. call
                        userPlaceInArray = find_account(account_number, account);
                        
                        // if acc_num is outside range
                        if (account_number < 1001 || account_number > 9999)
                        {
                            
                            throw new Exception("Please enter correct input!");
                        }
                        // if acc is not found 
                        if(userPlaceInArray==-99)
                        {
                            throw new Exception("Account Doesn't Exist!");
                        }
                    }
                    catch (InputMismatchException account_num_err)
                    {
                        
                        System.err.println("Error! : Please enter correct input!\n");
                        transaction_fail();
                        break;
                    }
                    catch (Exception account_num_err)
                    { 
                        System.err.println("Error! : " + account_num_err.getMessage());
                        transaction_fail();
                        break;
                    }
                    input = new Scanner(System.in);   // clear buffer

                    // user input for user_choice
                    // ! input validation for user_choice
                    do
                    {
                        //Welcome user to the transaction menu
                        System.out.println("Welcome Mr./Mrs. " + account[userPlaceInArray].getFull_name() + "\n");
                        transaction_menu();
                        
                        try
                        {
                            // start of except. cause
                            user_choice = input.nextInt();
                            // end of except. cause

                            // if no except. raised but outside range; else cont.
                            if (user_choice < 0 || user_choice > 4)
                            {
                                error = true;
                                throw new Exception("Please enter correct input!");
                            }
                        }
                        catch (InputMismatchException user_choice_err)
                        {
                            error = true;
                            System.err.println("Error! : Please enter correct input!\n");
                        }
                        catch (Exception user_choice_err)
                        {
                            error = true;
                            System.err.println("Error! : " + user_choice_err.getMessage());
                        }
                        input = new Scanner(System.in);   // clear buffer
                    } while (error);
                    
                    // switch... on user_choice
                    switch(user_choice)
                    {
                        // if display
                        case 1:
                        {
                            // - changed to toString - retr0
                            System.out.print(account[userPlaceInArray]);
                            break;
                        }
                        // if deposit
                        case 2:
                        {

                            // ! input validation for valueInput
                            question_deposit();
                            try
                            {
                                valueInput = input.nextDouble();

                                // if no except. raised but less than 0; else cont.
                                if (valueInput < 0)
                                {
                                    throw new Exception("Deposit cannot be less than 0!\n");
                                }
                            }
                            catch (InputMismatchException value_input_err)
                            {
                                System.err.println("Error! : Please enter correct input!\n");
                                transaction_fail();
                                break;
                            }
                            catch (Exception value_input_err)
                            {
                                System.err.println("Error! : " + value_input_err.getMessage());
                                transaction_fail();
                                break;
                            }
                            input = new Scanner(System.in);   // clear buffer

                            deposit_function(userPlaceInArray, valueInput, account);
                            System.out.println("\nYour updated balance : ");
                            display_transac(userPlaceInArray, account);
                            break;
                        }
                        // if withdraw
                        case 3:
                        {
                            // ! input validation for valueInput
                            try
                            {
                                question_withdraw();
                                valueInput = input.nextDouble();

                                // if no except. raised but less than 0; else cont.
                                if (valueInput < 0)
                                {
                                    throw new Exception("Deposit cannot be less than 0!\n");
                                }
                                // if withdraw more than balance
                                if (account[userPlaceInArray].getBalance()<valueInput){
                                    throw new Exception("Withdraw amount can't be more than balance\n");
                                }
                            }
                            catch (InputMismatchException value_input_err)
                            {
                                System.err.println("Error! : Please enter correct input!\n");
                                transaction_fail();
                                break;
                            }
                            catch (Exception value_input_err)
                            {
                                System.err.println("Error! : " + value_input_err.getMessage());
                                transaction_fail();
                                break;
                            }
                            input = new Scanner(System.in);   // clear buffer

                            withdraw_function(userPlaceInArray, valueInput, account);
                            System.out.println("\nYour updated balance : ");
                            display_transac(userPlaceInArray, account);
                            break;
                        }
                        // if transfer
                        case 4:
                        {
                            // ! input validation for valueInput
                            try
                            {
                                question_transfer_amount();
                                valueInput = input.nextDouble();

                                // if no except. raised but less than 0; else cont.
                                if (valueInput < 0)
                                {
                                    throw new Exception("Deposit cannot be less than 0!\n");
                                }
                                //if the transferred amount more than user deposit
                                if (account[userPlaceInArray].getBalance()<valueInput){
                                    throw new Exception("Transfer amount can't be more than balance\n");
                                }
                            }
                            catch (InputMismatchException value_input_err)
                            {
                                System.err.println("Error! : Please enter correct input!\n");
                                transaction_fail();
                                break;
                            }
                            catch (Exception value_input_err)
                            {
                                System.err.println("Error! : " + value_input_err.getMessage());
                                transaction_fail();
                                break;
                            }
                            input = new Scanner(System.in);   // clear buffer
                            
                            // user input for acc_num
                            // ! input validation for acc_num        
                            try
                            {
                                question_transfer_receiver();
                                account_number = input.nextInt();
                                receiverPlaceInArray = find_account(account_number, account);
                                
                                // if acc_num is outside range
                                if (account_number < 1001 || account_number > 9999)
                                {
                                    throw new Exception("Please enter correct input!");
                                }

                                if (receiverPlaceInArray==-99)
                                {
                                    throw new Exception("Receiver Account doesn't exist!");
                                }
                                
                                if(userPlaceInArray==receiverPlaceInArray)
                                {
                                    throw new Exception("You can't transfer money to your own account!");
                                }
                            }
                            catch (InputMismatchException account_num_err)
                            {
                                System.err.println("Error! : Please enter correct input!\n");
                                transaction_fail();
                                break;
                            }
                            catch (Exception account_num_err)
                            {
                                System.err.println("Error! : " + account_num_err.getMessage());
                                transaction_fail();
                                break;
                            }
                            input = new Scanner(System.in);   // clear buffer
                            
                            transaction_success(userPlaceInArray,receiverPlaceInArray,valueInput,account);
                            break;
                        }
                        // default - break;
                        default:
                            break;
                            
                    }   // Transaction Menu End 
                    
                    break;

                }   // Case 2 End
                
                // if exit from main menu, break
                case 0: 
                    break;
                
                // default - break
                default:
                    break;
                    
            }   // Main Menu Switch Case End
        } while (user_choice != 0);
    }  
}