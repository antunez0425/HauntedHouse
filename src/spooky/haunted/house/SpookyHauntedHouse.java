//******************************************************************************
// PantherIDs: [Put yours here]
//             3723741
// CLASS:      COP2210-2016
// ASSIGNMENT  #4
// DATE:       2016-11-12
//
// We hereby swear and affirm that this work is solely our own, and not the work
// or the derivative of the work of anyone else.
//******************************************************************************
package spooky.haunted.house;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 *
 * @author 3723641
 * @author antun
 */
public class SpookyHauntedHouse
{

    /**
     * Sets up the player and creates the game world, then gives a closing message.
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // ---------- Naming the player
        String name;
        name = JOptionPane.showInputDialog(null, "What is your name?", "Player Name Entry", JOptionPane.PLAIN_MESSAGE);
        
        if(name == null) // In the event of cancelling the name input.
        {
            name = "Anonymous Player";
            JOptionPane.showMessageDialog(null, "No name? Very well, then.");
        }
        
        while(!isValidName(name))
        {
            JOptionPane.showMessageDialog(null, "That doesn't look like a name to me.", "Invalid Name", JOptionPane.ERROR_MESSAGE);
            name = JOptionPane.showInputDialog(null, "What is your name?", "Player Name Entry", JOptionPane.PLAIN_MESSAGE);
        }
        
        // ---------- Generating the player and world, then starting the game
        Player player = new Player(name);
        HauntedHouse house = new HauntedHouse();
        house.frontDoor(player);
        
        // ---------- End of game.
        ImageIcon icon = new ImageIcon("src/resources/endGame.jpg");
        JOptionPane.showMessageDialog(null, "Thank you for playing!", "Game Over", JOptionPane.PLAIN_MESSAGE, icon);
    }
    
    /**
     * Evaluates the validity of a name.
     * Valid is described as not containing numbers or most special characters.
     * Hyphen, apostrophe, and spaces are permitted.
     * @param name The name being tested.
     * @return If the name is considered valid or not.
     */
    public static boolean isValidName(String name)
    {
        return name.matches("[a-zA-Z- ']+");
    }
    
}
