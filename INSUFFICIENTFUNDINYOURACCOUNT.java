package exceptionhandling;

public class INSUFFICIENTFUNDINYOURACCOUNT extends Exception{
    int amount;
    INSUFFICIENTFUNDINYOURACCOUNT(int amount){
        this.amount=amount;
    }
}
