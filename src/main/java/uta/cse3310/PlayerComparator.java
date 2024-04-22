package uta.cse3310;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlayerComparator implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        // Compare wins first
        int winComparison = Integer.compare(p2.getWins(), p1.getWins());
        if (winComparison != 0) {
            // If wins are not equal, return the comparison result
            return winComparison;
        } else {
            // If wins are equal, compare names alphabetically
            return p1.getName().compareTo(p2.getName());
        }
    }

    public List<Player> sortPlayers(List<Player> players) 
    {
        // Create a new list to store sorted players
        List<Player> sortedPlayers = new ArrayList<>(players);
        sortedPlayers.sort(this); // Sort using this comparator
        return sortedPlayers;
    }
}