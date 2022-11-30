package assignment_oop;
import java.util.*;
import sun.management.counter.ByteArrayCounter;

abstract class BankAccount{
    protected String bank_name;
    protected String full_name;
    protected int account_number;
    protected String account_type;
    protected double balance;
    protected double interest_rate;
    
    Random random = new Random();
    
    public BankAccount() {
        
        bank_name = "ABC BANK";
        full_name = "nil";
        account_number = random.nextInt(9999-1001+1)+1001;
        account_type = "nil";
        balance = 0.0;
        interest_rate = 0.0;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }

    
    
}

class SavingAccount extends BankAccount{

    public SavingAccount() {
        super();
        account_type = "Saving Acccount";
        balance = 50;
        interest_rate = 0.05;
        
    }
}

class CurrentAccount extends BankAccount{

    public CurrentAccount() {
        super();
        account_type = "Current Account";
        balance = 200;
        interest_rate = 0.01;
        System.out.println("Created Current Account!");
    }
    
}

public class Assignment_OOP {
    
    static void menu(){
        System.out.println("==============Welcome!==============");
        System.out.println("1. Create Account");
        System.out.println("2. Make a Transaction");
        System.out.println("0. End");
        System.out.print("Your Input : ");
    }
    
    static void transac_menu(){
        System.out.println("==============TRANSACTION==============");
        System.out.println("1. Display");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.print("Your Input : ");
    }
    
    static void question_acc(){
        System.out.println("\nChoose ur bank account type");
        System.out.println("1. Saving Account");
        System.out.println("2. Current Account");
        System.out.print("Your Input : ");
    }
    
    static void question_name(){
        System.out.println("\nPlease enter your name:");
        System.out.print("Your Input : ");
    }
    
    static void question_accnum(){
        System.out.println("\nPlease enter your account number:");
        System.out.print("Your Input : ");
    }
    
    static int find_acc(int accnum,BankAccount[] account){
        for(int i=0;i<account.length;i++){
            if(account[i]==null)
            {
                System.out.println("Bank Account not found");
                return -99;
            }
            
            if(account[i].getAccount_number() == accnum){
                System.out.println("Welcome Mr./Mrs."+account[i].getFull_name());
                return i;
            }
        }
        return -99;
    }
    
    static void display_acc(int i,BankAccount[] account){
        System.out.println("\n+++++ACCUNT INFOMATION+++++");
        System.out.println("Name: "+account[i].getFull_name());
        System.out.println("Account No: "+account[i].getAccount_number());
        System.out.println("Account Type: "+account[i].getAccount_type());
        System.out.println("Balance: "+account[i].getBalance());
        System.out.println("Interest Rate: "+account[i].getInterest_rate());
        System.out.println("+++++++++++++++++++++++++++\n");
        return;      
    }
    
    static void question_dep(){
        System.out.println("\nPlease enter deposit amount:");
        System.out.print("Your Input : ");
    }
    
    static void deposit_func(int i,double amount,BankAccount[] account){
        account[i].setBalance(amount + account[i].getBalance());
    }
    
    public static void main(String[] args) {
        
            int loop = 0;
            int choice;
            int type;
            int account_num;
            int valueInput;
            int arrayPlace;
            BankAccount[] account;
            account = new BankAccount[10];
            
        do{ 
            //System.out.println("Loop:"+loop);
            Scanner input = new Scanner(System.in);
            
            menu();
            choice = input.nextInt();
            input.skip("\n");//remove \n after the nextInt input

            switch(choice){
                case 1:
                    question_acc();
                    type = input.nextInt();  
                    input.skip("\n"); 
                 
                    switch(type){
                        case 1:
                            account[loop] = new SavingAccount();
                            break;
                        case 2:
                            account[loop] = new CurrentAccount();
                            break;
                    }           
                    question_name();
                    account[loop].setFull_name(input.nextLine());
                    
                    
                    System.out.println("\n+++++ACCUNT INFOMATION+++++");
                    System.out.println("Name: "+account[loop].getFull_name());
                    System.out.println("Account No: "+account[loop].getAccount_number());
                    System.out.println("Account Type: "+account[loop].getAccount_type());
                    System.out.println("+++++++++++++++++++++++++++\n");
                    loop++;
                    break;
                case 2:
                    question_accnum();
                    account_num = input.nextInt();  
                    input.skip("\n"); 
                    arrayPlace = find_acc(account_num, account);
                    
                    if(arrayPlace==-99){
                        break;
                    }
                    
                    transac_menu();
                    type = input.nextInt();  
                    input.skip("\n"); //remove \n after the nextInt input
                    switch(type){
                        case 1:
                            display_acc(arrayPlace, account);
                            break;
                        case 2:
                            question_dep();
                            valueInput = input.nextInt();
                            input.skip("\n");
                            
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        default:
                            break;
                    }           
                    
                    break;
                case 0: 
                    break;
                default:
                    break;
            }
        }while(choice!=0);
    }       
}
