package uta.cse3310;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lobby {
    private Player ready;
    private static boolean player1ready = false;
    private static boolean player2ready = false;
import java.util.ArrayList;
import java.util.List;

    public void isReady(int playerID){
        /* Allow player to toggle their respective ready status */
        if(playerID == 1)
        {
            player1ready = !player1ready;
        }
        if(playerID==2)
        {
            player2ready = !player2ready;
        }
    }
    public boolean readyCheck(){
        retuen player1ready && player2ready; 
    }    
public class Lobby {


    public List<String> PlayerNames;
    Lobby(){
        PlayerNames = new ArrayList<>();
    }
   /* public int leave(){
        int leave = 0;
        return leave;
    }
    */
public class GameGUI extends JFrame {
     public GameGUI() {
    JButton leaveButton = new JButton("leave");
        leaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("exiting game");
                System.exit(0); 
            }
        }

        getContentPane().add(leaveButton);
        setVisible(true);
}
}    
public static void(){
    new GameGUI();
}



/*
    public boolean readyCheck(){
        // Return true if all players are ready
        return true;
    public void AddPlayers(UserEvent U){
        PlayerNames.add(U.PlayerName);
        System.out.println("PLAYER SUCCESFULLY ADDED");
    }
*/
}
