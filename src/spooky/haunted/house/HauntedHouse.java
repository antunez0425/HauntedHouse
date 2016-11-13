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
 * Models the house's rooms as a series of methods that reference one another.
 * Each room-method contains a icon depicting the scene, a description of the
 * room, and choices that the player may pick. The button picked is then used
 * in a switch statement to call the next room's method.
 * 
 * @author 3723641
 * @author antun
 */
public class HauntedHouse
{
    /**
     * The title passed to the JOptionPane.
     */
    private String jOpTitle;
    
    /**
     * The title passed to the JOptionPane.
     */
    private String jOpMessage; 
    
    /**
     * The choices passed to the JOptionPane.
     */
    private String[] choices;

    /**
     * The image associated with the room.
     */
    private ImageIcon icon;
    
    /**
     * The button index the player picks.
     */
    private int playerChoice;


    
    /**
     * The first "room" entered by the player. Also gives an intro message.
     * @param player The player obj that contains name and inventory.
     */
    public void intro(Player player)
    {
        //Show welcoming message.
        jOpTitle = "Haunted House Game";                                                            //Set title
        jOpMessage = ("Hello " + player.getName() + "!\nWelcome to the Haunted House!");            //Set message
        icon = new ImageIcon("src/resources/HauntedHouse.jpg");                                     //Set image
        JOptionPane.showMessageDialog(null, jOpMessage, jOpTitle, JOptionPane.PLAIN_MESSAGE, icon); //Show window

        
        //Show rules message.
        jOpTitle = "Haunted House Game";
        jOpMessage = "This Haunted House has plenty of rooms to explore but there are two special rules:\n" +
                     "1. You cannot leave until you go somewhere else!\n" +
                     "2. If you die, you lose everything you are holding!";
        JOptionPane.showMessageDialog(null, jOpMessage, jOpTitle, JOptionPane.PLAIN_MESSAGE);
        

        //Prepares the options.
        jOpTitle = "Front Door";
        jOpMessage = player + "\n\nYou have entered the front door, where do you want to go?";
        choices = new String[]{"Living Room", "Dining Room", "Upstairs"};
        icon = new ImageIcon("src/resources/frontDoor.jpg");
        playerChoice = JOptionPane.showOptionDialog(null, jOpMessage, jOpTitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, choices, null);

        switch (playerChoice) {
            case 0:
                livingRoom(player);
                break;

            case 1:
                diningRoom(player);
                break;

            case 2:
                upstairs(player);
                break;
        }
    }

    /**
     * Room method (Front door). Offers choice to leave the house.
     * @param player The player obj that contains name and inventory.
     */
    public void frontDoor(Player player)
    {
        //Set up jOptionpane
        jOpMessage = player + "\n\nYou have returned to the front door, where do you want to go?";
        choices = new String[]{"Living Room", "Dining Room", "Upstairs", "Leave Alive"};
        icon = new ImageIcon("src/resources/frontDoorInside.jpg");

        playerChoice = JOptionPane.showOptionDialog(null, jOpMessage, "Front Door", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, icon, choices, null);

        switch (playerChoice) {
            case 0:
                livingRoom(player);
                break;

            case 1:
                diningRoom(player);
                break;

            case 2:
                upstairs(player);
                break;
                
            case 3:
                exitHouse(player);
                break;
        }
    }

    /**
     * Room method (Living room). Has an item that kills the player.
     * @param player The player obj that contains name and inventory.
     */
    public void livingRoom(Player player)
    {
        jOpMessage = player
                + "\nYou are in the Living Room\nThere is a chest in here\nThere is also a door leading to the bathroom."
                + "\nWhat are you going to do?";

        choices = new String[]{
            "Go to the bathroom", "See what's inside the chest", "Go back"
        };

        icon = new ImageIcon("src/resources/livingRoom.jpg");

        playerChoice = JOptionPane.showOptionDialog(null, jOpMessage, "Living Room", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, icon, choices, null);

        switch (playerChoice) {
            case 0:
                bathroom(player);
                break;
            case 1:
                openChest(player);
                break;
            case 2:
                frontDoor(player);
                break;
        }
    }

    /**
     * Item method (Chest). Kills the player.
     * @param player The player obj that contains name and inventory.
     */
    public void openChest(Player player)
    {
        jOpTitle = "Open The Chest";
        jOpMessage = "You opened the chest and ghosts came out and scared you to death!";
        icon = new ImageIcon("src/resources/ghostChest.jpg");
        JOptionPane.showMessageDialog(null, jOpMessage, jOpTitle, JOptionPane.PLAIN_MESSAGE, icon);
        
        killPlayer(player);
    }

    /**
     * Room method (Bathroom). Has two event items.
     * @param player The player obj that contains name and inventory.
     */
    public void bathroom(Player player)
    {
        jOpTitle = "Bathroom";
        jOpMessage = player + "\nYou are in the bathroom\nThere is a mirror and a shower";
        choices = new String[]{"Look in the mirror", "Turn on the shower", "Go back"};
        icon = new ImageIcon("src/resources/bathroom.jpg");

        playerChoice = JOptionPane.showOptionDialog(null, jOpMessage, jOpTitle, JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, icon, choices, null);

        switch (playerChoice) {
            case 0:
                mirror(player);
                break;
            case 1:
                shower(player);
                break;
            case 2:
                livingRoom(player);
                break;
        }
    }

    /**
     * Item method (Mirror). Displays a message.
     * @param player The player obj that contains name and inventory.
     */
    public void mirror(Player player)
    {
        jOpTitle = "Look in the mirror";
        jOpMessage = "You looked in the mirror and a bloody face was looking back at you!";
        icon = new ImageIcon("src/resources/bloodyFace.jpg");
        
        JOptionPane.showMessageDialog(null, jOpMessage, jOpTitle, JOptionPane.PLAIN_MESSAGE, icon);
        bathroom(player);
    }

    /**
     * Item method (Shower). Displays a message.
     * @param player The player obj that contains name and inventory.
     */
    public void shower(Player player)
    {
        jOpTitle = "Turn On The Shower";
        jOpMessage = "You turned on the shower and the room steams up.\n"+
                     "You feel fingers stroke the back of your neck.";
        icon = new ImageIcon("src/resources/steamyShower.jpg");
        
        JOptionPane.showMessageDialog(null, jOpMessage, jOpTitle, JOptionPane.PLAIN_MESSAGE, icon);
        bathroom(player);
    }

    /**
     * Room method (Dining room). Has an event item.
     * @param player The player obj that contains name and inventory.
     */
    public void diningRoom(Player player)
    {
        jOpTitle = "Dining Room";
        jOpMessage = player + "\n\nYou are in the dining room\nThere is a candelabra sitting on a table\n"
                + "There is also a door leading to the kitchen";
        choices = new String[]{"Go to the kitchen", "Check out the candelabra", "Go back"};
        
        icon = new ImageIcon("src/resources/diningRoom.jpg");

        playerChoice = JOptionPane.showOptionDialog(null, jOpMessage, jOpTitle, JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, icon, choices, null);

        switch (playerChoice) {
            case 0:
                kitchen(player);
                break;
            case 1:
                candelabra(player);
                break;
            case 2:
                frontDoor(player);
            
        }
    }

    /**
     * Item method (Candelabra). Displays a message.
     * @param player The player obj that contains name and inventory.
     */
    public void candelabra(Player player)
    {
        jOpTitle = "Candelabra";
        jOpMessage = "The candelabra lights up by itself and you see a death shadow";
        icon = new ImageIcon("src/resources/candelabra.jpg");
        
        JOptionPane.showMessageDialog(null, jOpMessage, jOpTitle, JOptionPane.PLAIN_MESSAGE, icon);
        
        diningRoom(player);
    }

    /**
     * Room method (Kitchen). Contains an inventory item and one that kills.
     * @param player The player obj that contains name and inventory.
     */
    public void kitchen(Player player)
    {
        jOpTitle = "Kitchen";
        jOpMessage = player + "\n\nYou are in the kitchen\nThere is a refrigerator and a cabinet\n"
                            + "There is also a door leading to the pantry";
        choices = new String[]{"Open the refrigerator", "Open the cabinet", "Go inside the pantry", "Go back"};
        icon = new ImageIcon("src/resources/kitchen.jpg");
        
        playerChoice = JOptionPane.showOptionDialog(null, jOpMessage, jOpTitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, choices, null);

        switch (playerChoice) {
            case 0:
                refrigerator(player);
                break;
            case 1:
                cabinet(player);
                break;
            case 2:
                pantry(player);
                break;
            case 3:
                diningRoom(player);
        }
    }

    /**
     * Item method (Refrigerator). Sets the fields and displays a jOptionPane.
     * @param player The player obj containing name and inventory.
     */
    public void refrigerator(Player player)
    {
        jOpTitle = "Refrigerator";
        if(player.hasItem("Soul Food"))
        {
            jOpMessage = "The refrigerator is empty.";
            icon = new ImageIcon("src/resources/emptyFridge.jpg");
        }
        else
        {
            jOpMessage = "You open the refrigerator and find delicious soul food!";
            player.addItem("Soul Food");
            icon = new ImageIcon("src/resources/soulFood.jpg");
        }
        
        JOptionPane.showMessageDialog(null, jOpMessage, jOpTitle, JOptionPane.PLAIN_MESSAGE, icon);
        kitchen(player);
    }

    /**
     * Item method (Cabinet). Sets the fields and displays a jOptionPane.
     * @param player The player obj containing name and inventory.
     */
    public void cabinet(Player player)
    {
        jOpTitle = "Cabinet";
        jOpMessage = "You open the cabinet and dishes and glasses fly at you and you get hit in the head\n\n"
                      + "You feel yourself moving towards a light.";
        icon = new ImageIcon("src/resources/platesFlying.jpg");
        JOptionPane.showMessageDialog(null, jOpMessage, jOpTitle, JOptionPane.PLAIN_MESSAGE, icon);
        killPlayer(player);
    }

    /**
     * Room method (Pantry). Contains an inventory item and an event item.
     * @param player The player obj that contains name and inventory.
     */
    public void pantry(Player player)
    {
        jOpTitle = "Pantry";
        jOpMessage = player + "\n\nYou are in the pantry\nThere is a dusty recipe box and a broom";
        choices = new String[]{"Look at the recipe box", "Touch the broom", "Go Back"};
        icon = new ImageIcon("src/resources/pantry.jpg");

        playerChoice = JOptionPane.showOptionDialog(null, jOpMessage, jOpTitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, choices, null);

        switch (playerChoice) {
            case 0:
                recipeBox(player);
                break;
            case 1:
                broom(player);
                break;
            case 2:
                kitchen(player);
                break;
        }
    }

    /**
     * Item method (Recipe Box). Sets the fields and displays a jOptionPane.
     * @param player The player obj containing name and inventory.
     */
    public void recipeBox(Player player)
    {
        jOpTitle = "Dusty Recipe Box";
        if(player.hasItem("Cake Recipe")) jOpMessage = "You already took the recipe.";
        else
        {
            jOpMessage = "You open the box and a recipe for\n"+
                         "devils food cake appears out of nowhere.\n\n"+
                         "You pick it up.";
            player.addItem("Cake Recipe");
        }
        icon = new ImageIcon("src/resources/recipe.jpg");
        
        JOptionPane.showMessageDialog(null, jOpMessage, jOpTitle, JOptionPane.PLAIN_MESSAGE, icon);
        pantry(player);
    }

    /**
     * Item method (Broom). Sets the fields and displays a jOptionPane.
     * @param player The player obj containing name and inventory.
     */
    public void broom(Player player)
    {
        jOpTitle = "Touch the broom";
        jOpMessage = "You touch the broom and it starts flying into the air!";
        icon = new ImageIcon("src/resources/broom.jpg");
        
        JOptionPane.showMessageDialog(null, jOpMessage, jOpTitle, JOptionPane.PLAIN_MESSAGE, icon);
        pantry(player); //Go back
    }

    
/* BELOW THIS LINE IS UPSTAIRS */

    
    public void upstairs(Player player)
    {
        jOpMessage = player + "\n\nYou are upstairs\nThere are doors leading to two bedrooms and the master bedroom"
                + "\nWhere do you want to go?";

        choices = new String[]{
            "Bedroom 1", "Bedroom 2", "Master Bedroom"
        };
        
        icon = new ImageIcon("src/resources/hallway.jpg");

        playerChoice = JOptionPane.showOptionDialog(null, jOpMessage, "Upstairs", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, choices, null);

        switch (playerChoice) {
            case 0:
                bedroom1(player);
                break;
            case 1:
                bedroom2(player);
                break;
            case 2:
                masterBedroom(player);
                break;
        }
    }

    public void bedroom1(Player player)
    {
        jOpMessage = player + "\n\nYou are in Bedroom 1\nThere is a rocking chair and a window\nThere is also a door to a bathroom";

        choices = new String[]{
            "Look at the chair", "Look out the window", "Go into the bathroom"
        };
        
        icon = new ImageIcon("src/resources/bedroom1.jpg");

        playerChoice = JOptionPane.showOptionDialog(null, jOpMessage, "Bedroom 1", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, choices, null);

        switch (playerChoice) {
            case 0:
                chair();
                break;
            case 1:
                window();
                break;
            case 2:
                bathroom(player);
                break;
        }
    }

    public void chair()
    {
        icon = new ImageIcon("src/resources/rockingChair.gif");
        JOptionPane.showMessageDialog(null, "The chair starts to rock on its own with no one in it", "Rocking Chair", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public void window()
    {
        icon = new ImageIcon("src/resources/childSwing.jpg");
        JOptionPane.showMessageDialog(null, "You see a child outside on a swing who suddenly disappears", "Window", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public void bedroom2(Player player)
    {
        jOpMessage = player + "\n\nYou are in Bedroom 2\nThere is a dollhouse and a dresser\n"
                + "There is also a door leading to a bathroom";

        choices = new String[]{
            "Look at the doll house", "Open the dresser", "Go to the bathroom"
        };
        
        icon = new ImageIcon("src/resources/bedroom2.jpg");

        playerChoice = JOptionPane.showOptionDialog(null, jOpMessage, "Bedroom 2", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, choices, null);

        switch (playerChoice) {
            case 0:
                dollHouse();
                break;
            case 1:
                dresser();
                break;
            case 2:
                bathroom(player);
                break;
        }
    }

    public void dollHouse()
    {
        icon = new ImageIcon("src/resources/dollhouse.jpg");
        JOptionPane.showMessageDialog(null, "The dolls start dancing on their own", "Doll House", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public void dresser()
    {
        icon = new ImageIcon("src/resources/ghostDresser.jpg");
        JOptionPane.showMessageDialog(null, "You open the dresser and a ghost flies out and passes through your body", "Dresser", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public void masterBedroom(Player player)
    {
        jOpMessage = player + "\n\nYou are in the master bedroom\nThere is a jewelry box\nThere is also a door leading to the master bathroom";

        choices = new String[]{
            "Open the jewelry box", "Go to the master bathroom"
        };
        
        icon = new ImageIcon("src/resources/masterBedroom.jpg");

        playerChoice = JOptionPane.showOptionDialog(null, jOpMessage, "Master Bedroom", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, choices, null);

        switch (playerChoice) {
            case 0:
                jewelryBox();
                break;
            case 1:
                masterBathroom(player);
                break;
        }
    }

    public void jewelryBox()
    {
        icon = new ImageIcon("src/resources/hopeDiamond.jpg");
        JOptionPane.showMessageDialog(null, "You find the cursed Hope Diamond and feel your doom!", "Jewelry Box", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public void masterBathroom(Player player)
    {
        jOpMessage = player + "\n\nYou are in the master bathroom\nThere is an intricate oil lamp and a shower";

        choices = new String[]{
            "Rub the lamp", "Check out the shower"
        };
        
        icon = new ImageIcon("src/resources/masterBathroom.jpg");

        playerChoice = JOptionPane.showOptionDialog(null, jOpMessage, "Master Bathroom", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, choices, null);

        switch (playerChoice) {
            case 0:
                lamp();
                break;
            case 1:
                singingShower();
                break;
        }
    }

    public void lamp()
    {
        icon = new ImageIcon("src/resources/genie.jpg");
        JOptionPane.showMessageDialog(null, "You rub the lamp and a genie comes out says he'll grant you 3 wishes", "Rub The Lamp", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public void singingShower()
    {
        icon = new ImageIcon("src/resources/singShower.jpg");
        JOptionPane.showMessageDialog(null, "You hear singing in the shower, but nobody is there", "Shower", JOptionPane.PLAIN_MESSAGE, icon);
    }
    
    /* BELOW THIS LINE IS HANDLING PLAYER DEATH AND LEAVING THE HOUSE */
    
    /**
    * Prints a triumph message, prints inventory, then asks for replay.
    * @param player The player obj containing name and inventory.
    */
    public void exitHouse(Player player){
        int i=0;
        jOpTitle = "Leaving The House";
        jOpMessage = "You made it out of the haunted house with your life!\n"+
                     "Here is your loot:\n";
        do
        {
            if(player.getNumItems() == i) jOpMessage += "Nothing else.\n";
            else jOpMessage += (player.getItem(i)+"\n");
            i++;
        } while(i<=player.getNumItems());
        
        icon = new ImageIcon("src/resources/HauntedHouse.jpg");
        
        JOptionPane.showMessageDialog(null, jOpMessage, jOpTitle, JOptionPane.PLAIN_MESSAGE, icon);
        
        askForReplay(player);
    }
    
    /**
    * Prints the death message and goes to ask for replay.
    * @param player The player obj containing name and inventory.
    */
    public void killPlayer(Player player){
        jOpTitle = "YOU DIED";
        jOpMessage = "You have succumbed to the\n"+
                     "dangers of the haunted house.";
        icon = new ImageIcon("src/resources/youDied.png");
                
        JOptionPane.showMessageDialog(null, jOpMessage, jOpTitle, JOptionPane.PLAIN_MESSAGE, icon);
        
        askForReplay(player);
    }
    
    /**
    * Clears the player's inventory if yes and then puts them at the intro. Exits if no.
    * @param player The player obj containing name and inventory.
    */
    public void askForReplay(Player player){
        jOpTitle = "Play Again?";
        jOpMessage = "Would you like to play again?";
        choices = new String[]{"Yes","No"};
        
        playerChoice = JOptionPane.showOptionDialog(null, jOpMessage, jOpTitle, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, choices, null);
        if(playerChoice == 0)
        {
            player.emptyInventory();
            intro(player);
        }
    }
}
