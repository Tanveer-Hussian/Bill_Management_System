import java.util.ArrayList;
import java.util.Scanner;
abstract class MainMenu {
    abstract void Interface();
    public void greeting(){
        System.out.println("WELCOME!");
    }

}

 class Intro extends MainMenu{

     @Override
     void Interface() {
         System.out.println("\t 1. Create Customer account");
         System.out.println("\t 2. Electricity Bill");
         System.out.println("\t 3. Gas Bill");
         System.out.println("\t 4. Water Bill");
         System.out.println("\t 5. Exit");
    }
    @Override
    public void greeting(){
        System.out.println();
        System.out.println("\t\t\t_____________________________________");
        System.out.println("\t\t\t| WELCOME TO BILL MANAGEMENT SYSTEM |");
        System.out.println("\t\t\t|___________________________________|");
        System.out.println();
    }

}

  class CustomerAccount {
        Scanner sc = new Scanner(System.in);
        ArrayList <String> accountName = new ArrayList<>();
        ArrayList <Integer> accountNumber = new ArrayList<>();
        private String name;
        private int number;

     void addAccount(){
          System.out.println("Enter your name");
            name = sc.next();
            accountName.add(name);
          System.out.println("Enter your AccountNumber");
            number = sc.nextInt();
            accountNumber.add(number);
     }

}

//-------------------------------------------------------------------
//-------------------------------------------------------------------

  class Bill {
      Scanner sc = new Scanner(System.in);
      CustomerAccount customerAccount;

      public Bill(CustomerAccount customerAccount) {
          this.customerAccount = customerAccount;
          System.out.println("You must have a customer account to Generate bill.");
      }

      public void ElectricityBill(int perUnit,int Units,String name,int number){
          int pricePerUnit = perUnit;
          int TotalBill = (Units * pricePerUnit);
          System.out.println(" Your bill has been generated");
          System.out.println("|-------------------------------------------------|");
          System.out.println("|\t\tName   :     " + name + "            \t\t\t\t|");
          System.out.println("|\t\tAccountNumber : " + number + "          \t\t\t  |");
          System.out.println("|\t\tElectricity Bill : " + TotalBill + " Rs\t\t\t \t  |");
          System.out.println("|                                                 |");
          System.out.println("|-------------------------------------------------|");

      }


      public void GenerateElectricityBill(String name, int number) {
          System.out.println("Enter the number of Electricity units you have consumed in this month");
          int ElectricUnits = sc.nextInt();
          if (ElectricUnits <= 100) {
            ElectricityBill(50,ElectricUnits,name,number);
          }
          if (ElectricUnits>100 && ElectricUnits<=250){
              ElectricityBill(80,ElectricUnits,name,number);
          }
          if (ElectricUnits > 250){
              ElectricityBill(120,ElectricUnits,name,number);
          }

      }

      public void GenerateGasBill(String name, int number) {
          System.out.println("Enter the number of Gas units you have consumed in this month");
          int GasUnits = sc.nextInt();
          int pricePerUnit = 40;
          int TotalBill = (GasUnits * pricePerUnit);
          System.out.println(" Your bill has been generated");
          System.out.println("|-------------------------------------------------|");
          System.out.println("|\t\tName   :     " + name + "          \t\t\t\t  |");
          System.out.println("|\t\tAccountNumber : " + number + "          \t\t\t  |");
          System.out.println("|\t\tGas Bill : " + TotalBill + " Rs      \t\t\t\t   |");
          System.out.println("|                                                 |");
          System.out.println("|-------------------------------------------------|");
      }

      public void GenerateWaterBill(String name, int number) {
          System.out.println("Enter the number of Water Gallons you have used in this month");
          int Gallons = sc.nextInt();
          int pricePerGallon = 200;
          int TotalBill = (Gallons * pricePerGallon);
          System.out.println(" Your bill has been generated");
          System.out.println("|-------------------------------------------------|");
          System.out.println("|\t\tName   :     " + name + "          \t\t\t   |");
          System.out.println("|\t\tAccountNumber : " + number + "          \t\t\t  |");
          System.out.println("|\t\tWater Bill : " + TotalBill + " Rs\t\t\t \t      |");
          System.out.println("|                                                 |");
          System.out.println("|-------------------------------------------------|");

      }

//-------------------------------------------------------------------------
      public void VerifyingAccount1() {

          String name;
          int num;
          System.out.println("Enter your Account name");
          name = sc.next();
          if (customerAccount.accountName.contains(name)) {
              System.out.println("Enter your BankNumber");
              num = sc.nextInt();
              System.out.println();
              if (customerAccount.accountNumber.contains(num)) {
                  GenerateElectricityBill(name, num);
              }else {
                  System.out.println("Enter correct Customer Account Number");
              }
          } else {
              System.out.println("Enter correct Customer Account name");
          }
      }
//------------------------------------------------------------------------------

      public void VerifyingAccount2() {
          String name;
          int num;
          System.out.println("Enter your Account name");
          name = sc.next();
          if (customerAccount.accountName.contains(name)) {
              System.out.println("Enter your BankNumber");
              num = sc.nextInt();
              System.out.println();
              if (customerAccount.accountNumber.contains(num)) {
                  GenerateGasBill(name, num);
              } else {
                  System.out.println("Enter correct Customer Account Number");
              }
          } else {
              System.out.println("Enter correct Customer Account name");
          }
      }

//------------------------------------------------------------------------------

      public void VerifyingAccount3() {
          String name;
          int num;
          System.out.println("Enter your Account name");
          name = sc.next();

          if (customerAccount.accountName.contains(name)) {
              System.out.println("Enter your BankNumber");
              num = sc.nextInt();
              System.out.println();
              if (customerAccount.accountNumber.contains(num)) {
                  GenerateWaterBill(name, num);
              } else {
                  System.out.println("Enter correct Customer Account Number");
              }
          } else {
              System.out.println("Enter correct Customer Account name");
          }
      }
  }


public class Main {


    public static void Demo(CustomerAccount customerAccount, Intro intro){
        Scanner sc = new Scanner(System.in);
        Main m = new Main();

        intro.Interface();

        Bill bill = new Bill(customerAccount);

        System.out.println("Enter an option from above");
        int option = sc.nextInt();
        if (option==1) {
            customerAccount.addAccount();
            System.out.println("Enter");
            System.out.println("1 to go to MainMenu");
            int choice = sc.nextInt();
            if (choice == 1) {
                Demo(customerAccount,intro);
            }else {
           System.exit(0);
            }
        }
        if (option==2){
            bill.VerifyingAccount1();
            System.out.println("Enter");
            System.out.println(" 1 MainMenu");
            int num = sc.nextInt();
            if (num==1){
                Demo(customerAccount,intro);
            }
        }
      if (option==3){
          bill.VerifyingAccount2();
      }
      if (option==4){
          bill.VerifyingAccount3();
          }
      if (option==5){
          System.out.println("You are out of Program now");
            System.exit(0);
        }
    }

    public static void main(String[]args){
        Intro intro = new Intro();
        CustomerAccount customerAccount = new CustomerAccount();
         intro.greeting();

        Demo(customerAccount,intro);

    }
}