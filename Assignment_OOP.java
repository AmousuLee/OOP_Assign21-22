package assignment_oop;
import java.util.*;

/*
    // - done
    ! - need help
    ? - question

    // TODO : superclass - BankAccount
            // data mem., super construc., getter & setter
        // TODO : subclass - SavingAccount
            // sub construc.
        // TODO : subclass - CurrentAccount
            // sub construc.

    TODO : main class
        // display
        // deposit
        // withdraw
        // transfer
        
    ! err. handling and valid.
        - check user_choice input val below for ref.
    ! refactoring and comment

    ? input.skip() not working on VSC , skill issue?
    ? ByteArrayCounter looks like not used, remove?
    ? change snake_case to camelCase?
 */

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
                + "\nBalance: RM" + balance
                + "\nInterest Rate: " + interest_rate + "%"
                + "\n+++++++++++++++++++++++++++\n\n";
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
public class Assignment_OOP
{
    // main menu funct.
    static void menu()
    {
        System.out.println("==============  Welcome!  ==============");
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
        System.out.println("\nPlease enter your name : ");
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
        for(int i=0;i<account.length;i++)
        {
            if(account[i]==null)
            {
                System.out.println("Bank Account not found !");
                return -99;
            }
            
            if(account[i].getAccount_number() == accnum){
                System.out.println("Welcome Mr./Mrs. " + account[i].getFull_name() + "\n");
                return i;
            }
        }
        return -99;
    }
    
    // ! changed to toString - retr0
    // ! moved display from main to here - retr0
    static void display_account(int loop,BankAccount[] account)
    {
        System.out.println("\n+++++  ACCOUNT INFOMATION  +++++");
        System.out.println("Name : " + account[loop].getFull_name());
        System.out.println("Account No : " + account[loop].getAccount_number());
        System.out.println("Account Type : " + account[loop].getAccount_type());
        System.out.println("+++++++++++++++++++++++++++\n");
    }
    
    // deposit menu funct.
    static void question_deposit()
    {
        System.out.println("\nPlease enter deposit amount : ");
        System.out.print("Your Input : ");
    }
    
    // deposit funct.
    static void deposit_function(int i,double amount,BankAccount[] account)
    {
        account[i].setBalance(amount + account[i].getBalance());
        System.out.println("Money Deposited!");
    }
    // withdraw menu funct.
    static void question_withdraw()
    {
        System.out.println("\nPlease enter withdraw amount : ");
        System.out.print("Your Input : ");
    }
    
    // withdraw funct.
    static void withdraw_function(int i, double withdraw, BankAccount[] account)
    {
        //here try catch exception if possible
        double bal = account[i].getBalance();
        bal = bal - withdraw;
        System.out.println("Money Withdrawn!");
        account[i].setBalance(bal);
    }
    
    // transfer menu funct.
    static void question_transfer_amount()
    {
        System.out.println("\nPlease enter the amount you want to transfer : ");
        System.out.print("Your Input : ");
    }
    
    // transfer funct.
    static void question_transfer_receiver()
    {
        System.out.println("\nPlease enter the receiver account number : ");
        System.out.print("Your Input : ");
    }
    
    // psvm for main class
    public static void main(String[] args)
    {
        // Local var and obj init.
        // ! init all vars that need to pass valid. first
        int loop = 0;
        int user_choice = 1;
        int account_type = 1;
        int account_number;
        int valueInput;
        int userPlaceInArray;
        int receiverPlaceInArray;
        
        BankAccount[] account;
        account = new BankAccount[10];
        Scanner input = new Scanner(System.in);
        
        boolean error = false;
        
        // do... while input is not 0
        do
        {
            // user_choice input for user
            // ! input validation for user_choice
            do
            {
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
                        //proper way to throw exception
                        throw new InputMismatchException("Please enter correct input!");
                    }
                    else
                    {
                        error = false;
                    }
                }
                catch (InputMismatchException user_choice_err)
                {
                    error = true;
                    System.out.println("Error! : "+user_choice_err.getMessage()); 
                }
                input = new Scanner(System.in); //clean the input
                
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
                    error = false;

                    do
                    {
                        question_accountType();
                        try
                        {
                        // start of except. cause
                            account_type = input.nextInt();
                        // end of except. cause

                            // if no except. raised but not within range 1-2; else cont.
                            if (account_type < 1 || account_type > 2)
                            {
                                error = true;
                                System.out.println("Error! Please enter correct input!\n");
                            }
                            else
                            {
                                error = false;
                            }
                        }
                        catch (InputMismatchException account_type_err)
                        {
                            error = true;
                            System.out.println("Error! Please enter correct input!\n");
                        }
                        input.nextLine();   // clear buffer

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
                    question_name();
                    account[loop].setFull_name(input.nextLine());
                    
                    // ! input validation for full_name
                    // if return null go to do... while
                    if (account[loop].getFull_name().length() == 0)
                    {
                        do
                        {
                            System.out.println("Your name cannot be empty!");
                            question_name();
                            account[loop].setFull_name(input.nextLine());

                        } while (account[loop].getFull_name().length() == 0);
                    }
                    
                    // moved to funct - retr0
                    // display_acc() funct. call
                    display_account(loop, account);
                    loop++;
                    break;

                } // Case 1 ends
                
                // if make transaction
                case 2:
                {
                    // user input for acc_num
                    question_accountNumber();
                    account_number = input.nextInt();  
                    input.skip("\n");
                    // ! input val here
                    
                    // find_account() funct. call
                    userPlaceInArray = find_account(account_number, account);
                    
                    // if acc is not found 
                    if(userPlaceInArray==-99)
                        break;
                    
                    // user input for transaction type
                    transaction_menu();
                    user_choice = input.nextInt();  
                    input.skip("\n"); //remove \n after the nextInt input
                    // ! input val here
                    
                    // switch... on user_choice
                    //! deposit,withdraw,transaction all need validation
                    //! the 3 above function after done need to display the updated balance
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
                            question_deposit();
                            valueInput = input.nextInt();
                            input.skip("\n");
                            deposit_function(userPlaceInArray, valueInput, account);
                            System.out.println("\nYour updated balance : ");
                            System.out.print(account[userPlaceInArray]);
                            break;
                        }
                        // if withdraw
                        case 3:
                        {
                            question_withdraw();
                            valueInput = input.nextInt();
                            input.skip("\n");
                            withdraw_function(userPlaceInArray, valueInput, account);
                            System.out.println("\nYour updated balance : ");
                            System.out.print(account[userPlaceInArray]);
                            break;
                        }
                        // if transfer
                        case 4:
                        {
                            question_transfer_amount();
                            valueInput = input.nextInt();
                            input.skip("\n");
                            
                            question_transfer_receiver();
                            account_number = input.nextInt();
                            input.skip("\n");
                            
                            receiverPlaceInArray = find_account(account_number, account);
                            System.out.print(account[userPlaceInArray]); //this change to getter bcuz only want certain output not the entire data
                            System.out.println("|");
                            System.out.println("V");
                            System.out.println(account[receiverPlaceInArray]);//this change to getter bcuz only want certain output not the entire data
                            
                            
                            withdraw_function(userPlaceInArray, valueInput, account);
                            deposit_function(receiverPlaceInArray, valueInput, account);
                            System.out.println("Transaction Success!");
                            break;
                        }
                        // default - break;
                        default:
                            break;
                            
                    } // Transaction Menu End 
                    
                    break;

                } // Case 2 End
                
                // if exit from main menu, break
                case 0: 
                    break;
                
                // default - break
                default:
                    break;
                    
            } // Main Menu Switch Case End
        } while (user_choice != 0);
    }  
}