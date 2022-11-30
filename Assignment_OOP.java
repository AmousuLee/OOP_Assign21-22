package assignment_oop;
import java.util.*;
//import sun.management.counter.ByteArrayCounter;

/* 
    TODO : superclass - BankAccount
            ? data mem., super construc., getter & setter
        TODO : subclass - SavingAccount
            ? sub construc.
        TODO : subclass - CurrentAccount
            ? sub construc.

    TODO : main class
        ? display
        ? deposit
        ! withdraw
        ! transfer
        
    ! err. handling and valid.
    ! refactoring and comment

    ? input.skip() not working on VSC , skill issue?
    ? ByteArrayCounter looks like not used, remove?
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
        return "\n+++++ACCUNT INFOMATION+++++\nName: " + full_name
                + "\nAccount No: " + account_number
                + "\nAccount Type: " + account_type
                + "\nBalance: " + balance
                + "\nInterest Rate: " + interest_rate
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
        System.out.println("Created Current Account!");
    }
}

// main class
public class Assignment_OOP
{
    // main menu funct.
    static void menu()
    {
        System.out.println("==============Welcome!==============");
        System.out.println("1. Create Account");
        System.out.println("2. Make a Transaction");
        System.out.println("0. End");
        System.out.print("Your Input : ");
    }
    
    // transaction menu funct.
    static void transac_menu()
    {
        System.out.println("==============TRANSACTION==============");
        System.out.println("1. Display");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.print("Your Input : ");
    }
    
    // account type menu funct.
    static void question_acc()
    {
        System.out.println("\nChoose ur bank account type");
        System.out.println("1. Saving Account");
        System.out.println("2. Current Account");
        System.out.print("Your Input : ");
    }
    
    // full name menu funct.
    static void question_name()
    {
        System.out.println("\nPlease enter your name:");
        System.out.print("Your Input : ");
    }
    
    // account num. menu funct.
    static void question_accnum()
    {
        System.out.println("\nPlease enter your account number:");
        System.out.print("Your Input : ");
    }
    
    // find account funct.
    static int find_acc(int accnum, BankAccount[] account)
    {
        for(int i=0;i<account.length;i++)
        {
            if(account[i]==null)
            {
                System.out.println("Bank Account not found");
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
    static void display_acc(int loop,BankAccount[] account)
    {
        System.out.println("\n+++++ACCUNT INFOMATION+++++");
        System.out.println("Name: "+account[loop].getFull_name());
        System.out.println("Account No: "+account[loop].getAccount_number());
        System.out.println("Account Type: "+account[loop].getAccount_type());
        System.out.println("+++++++++++++++++++++++++++\n");
        return;      
    }
    
    
    // deposit menu funct.
    static void question_dep()
    {
        System.out.println("\nPlease enter deposit amount:");
        System.out.print("Your Input : ");
    }
    
    // deposit funct.
    static void deposit_func(int i,double amount,BankAccount[] account)
    {
        account[i].setBalance(amount + account[i].getBalance());
    }
    
    // psvm for main class
    public static void main(String[] args)
    {
        // Local var and obj init.
        int loop = 0;
        int choice;
        int type;
        int account_num;
        int valueInput;
        int arrayPlace;
        BankAccount[] account;
        account = new BankAccount[10];
        Scanner input = new Scanner(System.in);
        
        // do... while input is not 0
        do
        {
            // user input for choice
            menu();
            choice = input.nextInt();
            input.skip("\n"); //remove \n after nextInt
            // ! input val here

            // switch... on choice
            switch(choice)
            {
                // if create account
                case 1 :
                {
                    // user input for acc_type
                    question_acc();
                    type = input.nextInt();  
                    input.skip("\n");
                    // ! input val here
                 
                    // switch... on type
                    switch(type)
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
                    // ! input val here
                    
                    // moved to funct - retr0
                    // display_acc() funct. call
                    display_acc(loop, account);
                    loop++;
                    break;
                }
                
                // if make transaction
                case 2:
                {
                    // user input for acc_num
                    question_accnum();
                    account_num = input.nextInt();  
                    input.skip("\n");
                    // ! input val here
                    
                    // find_acc() funct. call
                    arrayPlace = find_acc(account_num, account);
                    
                    // if acc is not found 
                    if(arrayPlace==-99)
                        break;
                    
                    // user input for transaction type
                    transac_menu();
                    type = input.nextInt();  
                    input.skip("\n"); //remove \n after the nextInt input
                    // ! input val here
                    
                    // switch... on type
                    switch(type)
                    {
                        // if display
                        case 1:
                        {
                            // - changed to toString - retr0
                            System.out.print(account[arrayPlace]);
                            break;
                        }
                        // if deposit
                        // ! WIP
                        case 2:
                        {
                            question_dep();
                            valueInput = input.nextInt();
                            input.skip("\n");
                            break;
                        }
                        // if withdraw
                        // ! WIP
                        case 3:
                            break;
                            
                        // if transfer
                        // ! WIP
                        case 4:
                            break;
                            
                        // default - break;
                        default:
                            break;
                            
                    } 
                    break;
                }
                // if exit from main menu, break
                case 0: 
                    break;
                
                // default - break
                default:
                    break;
                    
            }
        } while (choice != 0);
    }  
}