package Interface;

public class ABank implements IBank{
    private String bankName;
    private String terminalId;
    private String password;

    //burada interfacede tanimlanan metotlarn ici dolduruldu.
    //istenilen kadar interface implement edilebilir.
    @Override
    public boolean connect(String ipAdress) {
        System.out.println(this.bankName+" Baglanildi...");
        return true;
    }

    @Override
    public boolean payment(double price, String cardNumber, String date, String cvc) {
        System.out.println("Bankadan yanit beleniyor...");
        System.out.println("İslem basarili oldu...");
        return true;
    }
}
