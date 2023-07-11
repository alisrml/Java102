package Fikstur;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> teams = new ArrayList<>();
        teams.add("Takım1");
        teams.add("Takım2");
        teams.add("Takım3");
        teams.add("Takım4");
        teams.add("Takım5");
        teams.add("Takım6");

        FiksturOlusturucu fikstur = new FiksturOlusturucu(teams);
        List<String> fiksturr = fikstur.generateFixture();

        for (String match : fiksturr) {
            System.out.println(match);
        }
    }
}
