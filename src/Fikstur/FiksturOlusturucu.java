package Fikstur;

import java.util.ArrayList;
import java.util.Collections;

public class FiksturOlusturucu {
    private ArrayList<String> teams;

    public FiksturOlusturucu(ArrayList<String> teams) {
        this.teams = teams;
    }

    public ArrayList<String> generateFixture() {
        ArrayList<String> fixture = new ArrayList<>();

        if (teams.size() % 2 != 0) {
            teams.add("Bay");
        }

        int totalRound = teams.size() - 1;
        int matchesPerRound = teams.size() / 2;

        Collections.shuffle(teams);

        for (int round = 0; round < totalRound; round++) {
            fixture.add("Round " + (round + 1));

            for (int match = 0; match < matchesPerRound; match++) {
                String homeTeam = teams.get(match);
                String awayTeam = teams.get(teams.size() - 1 - match);

                if (!homeTeam.equals("Bay") && !awayTeam.equals("Bay")) {
                    fixture.add(homeTeam + " vs " + awayTeam);
                }
            }

            rotateTeams();
        }

        // Rövanş karşılaşmalarını ekleme
        for (int round = 1; round <= totalRound; round++) {
            fixture.add("Round " + (totalRound + round));

            for (int match = 0; match < matchesPerRound; match++) {
                String homeTeam = teams.get(teams.size() - 1 - match);
                String awayTeam = teams.get(match);

                if (!homeTeam.equals("Bay") && !awayTeam.equals("Bay")) {
                    fixture.add(homeTeam + " vs " + awayTeam);
                }
            }
        }
        return fixture;
    }

    private void rotateTeams() {
        String lastTeam = teams.remove(teams.size() - 1);
        teams.add(1, lastTeam);
    }
}
