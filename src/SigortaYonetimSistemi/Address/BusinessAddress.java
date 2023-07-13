package SigortaYonetimSistemi.Address;

public class BusinessAddress implements Address{
    private String address;

    public BusinessAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddressInfo() {
        return "İş Adresi: " + address;
    }
}
