package Polymorphism;

public class Kopek extends Hayvan {
    public Kopek(String isim) {
        super(isim);
    }

    @Override
    public void Konus(){
        System.out.println("Kopek havliyor...");
    }
    /*Burada yaptigimiz isleme polymorphism deniyor. Hayvan classı olusturduk ve oradan Kopek classını miras aldik.
    * Kopek classının Konus methodunu override ederek. Farkli islev göstermesini sağladık. bu isleme polymorphism deniyor.
    * */
}
