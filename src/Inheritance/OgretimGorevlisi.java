package Inheritance;

public class OgretimGorevlisi extends Akademisyen {
    private String kapiNo;

    public OgretimGorevlisi(String adSoyad,String telefon,String ePosta,String bolum,String unvan,String kapiNo){
        super(adSoyad, telefon, ePosta, bolum, unvan);
        this.kapiNo = kapiNo;
    }




}
