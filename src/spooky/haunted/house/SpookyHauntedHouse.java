/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spooky.haunted.house;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 *
 * @author antun
 */
public class SpookyHauntedHouse
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        String name;
        
        name = JOptionPane.showInputDialog(null, "What is your name", "Player Name", JOptionPane.PLAIN_MESSAGE);
        
        while(!isAlpha(name))
        {
            JOptionPane.showMessageDialog(null, "Your name can only have letters!", "Invalid Name", JOptionPane.ERROR_MESSAGE);
            
            name = JOptionPane.showInputDialog(null, "What is your name", "Player Name", JOptionPane.PLAIN_MESSAGE);
        }
        
        Player player = new Player(name);
        
        HauntedHouse house = new HauntedHouse();
        
        house.frontDoor(player);
        
        ImageIcon icon = new ImageIcon("src/resources/endGame.jpg");
        
        JOptionPane.showMessageDialog(null, "Thank you for playing!", "Game Over", JOptionPane.PLAIN_MESSAGE, icon);
    }
    
    public static boolean isAlpha(String name)
    {
        return name.matches("[a-zA-Z]+");
    }
    
}
