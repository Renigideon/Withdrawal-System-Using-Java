package exceptionhandling;
class account_information {
    String account_name;
    int account_number;
    String IFSC_CODE;
   final private int balance = 1500;
    account_information(String account_name,int account_number,String IFSC_CODE){
        this.account_name=account_name;
        this.account_number=account_number;
        this.IFSC_CODE=IFSC_CODE;
    }
    public void setBalance(){
        System.out.println("BALANCE: "+this.balance);
    }
    public int getbalance(){
        return this.balance;
    }
}
    class clerk extends account_information{

    int withdrawal;
    clerk(String account_name,int account_number,String IFSC_CODE,int withdrawal){
        super(account_name,account_number,IFSC_CODE);
        this.withdrawal=withdrawal;
    }
    public int withdrawal_amount(int withdrawal){
        int temp=super.getbalance();
        int availble_bal=0;
        try{

            if(temp > withdrawal){
                availble_bal=temp-withdrawal;
                System.out.println("withdrwal is successfully");

            }
           else if(temp<withdrawal){
                throw new INSUFFICIENTFUNDINYOURACCOUNT(temp);
            }
        }catch (INSUFFICIENTFUNDINYOURACCOUNT e){
            System.out.println("Insufficient balance in your account");
        }
        finally {
            System.out.println("Successfully withdrawal from our bank");
        }
        System.out.print("Remaining balance: ");
        return availble_bal;
    }
    public void account_information(){
        System.out.println("Account name: "+this.account_name);
        System.out.println("Account number: "+this.account_number);
        System.out.println("IFSC CODE: "+this.IFSC_CODE);
    }

    }

public class exception_handling {
    public static void main(String[] args) {
        System.out.println("---------------------------ACCOUNT WITHDRAWAL SYSTEM------------------------------------------");
        account_information in=new account_information("Reni gideon",640154546,"IOB94201");
        clerk account_holder=new clerk("Reni gideon",640154545,"IOB94201",100);
        in.setBalance();
        System.out.println(account_holder.withdrawal_amount(account_holder.withdrawal));
        account_holder.account_information();

    }
}
