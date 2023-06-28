package Interface;

public interface IBank {
    //burada yalnizca final tipinde sabit variable tanimlayabiliriz.
    boolean connect(String ipAdress);

    boolean payment(double price, String cardNumber, String date, String cvc);
}

