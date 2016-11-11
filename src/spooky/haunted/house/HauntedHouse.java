/*
 * To change this license header, choose License Headers in Project Properties.
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
public class HauntedHouse
{

    /**
     * At this point the player has just started the game and is at the front
     * door
     *
     * @param player
     */
    public void frontDoor(Player player)
    {
        String jOpMessage; // Throughout the program this variable will be used
        // for JOpPane method calls to show the player a
        // message
        String[] choices; // Throughout the program this variable will be used
        // for JOpPane.showOptionDialog method calls to
        // create custom buttons
        int playerChoice;

        ImageIcon icon = new ImageIcon("src/resources/HauntedHouse.jpg");

        JOptionPane.showMessageDialog(null, "Hello " + player.getName() + "!\nWelcome to the Haunted House!",
                "Haunted House Game", JOptionPane.PLAIN_MESSAGE, icon); // welcome
        // message

        jOpMessage = "This Haunted House has plenty of rooms to explore but there are two special rules:\n1. Once you enter a room "
                + "you cannot go back, only forward!"
                + "\n2. Once you interact with something in a room, the game will end there and you will have to start over!";

        JOptionPane.showMessageDialog(null, jOpMessage, "Haunted House Game", JOptionPane.PLAIN_MESSAGE); // explains
        // the
        // rules
        // of
        // the
        // game

        choices = new String[]{
            "Living Room", "Dining Room", "Upstairs"
        };

        jOpMessage = player + "\n\nYou have entered the front door, where do you want to go?";

        icon = new ImageIcon("src/resources/frontDoor.jpg");

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
        }
    }

    public void livingRoom(Player player)
    {
        int playerChoice;
        String jOpMessage;
        String[] choices;
        ImageIcon icon;

        jOpMessage = player
                + "\nYou are in the Living Room\nThere is a chest in here\nThere is also a door leading to the bathroom."
                + "\nWhat are you going to do?";

        choices = new String[]{
            "Go to the bathroom", "See what's inside the chest"
        };

        icon = new ImageIcon("src/resources/livingRoom.jpg");

        playerChoice = JOptionPane.showOptionDialog(null, jOpMessage, "Living Room", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, icon, choices, null);

        switch (playerChoice) {
            case 0:
                bathroom(player);
                break;
            case 1:
                openChest();
                break;
        }
    }

    public void openChest()
    {
        ImageIcon icon = new ImageIcon("src/resources/ghostChest.jpg");
        JOptionPane.showMessageDialog(null, "You opened the chest and ghosts came out and scared you to death!",
                "Open The Chest", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public void bathroom(Player player)
    {
        int playerChoice;
        String jOpMessage;
        String[] choices;
        ImageIcon icon;

        jOpMessage = player + "\nYou are in the bathroom\nThere is a mirror and a shower";

        choices = new String[]{
            "Look in the mirror", "Turn on the shower"
        };
        
        icon = new ImageIcon("src/resources/bathroom.jpg");

        playerChoice = JOptionPane.showOptionDialog(null, jOpMessage, "Bathroom", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, icon, choices, null);

        switch (playerChoice) {
            case 0:
                mirror();
                break;

            case 1:
                shower();
                break;
        }
    }

    public void mirror()
    {
        ImageIcon icon = new ImageIcon("src/resources/bloodyFace.jpg");
        JOptionPane.showMessageDialog(null, "You looked in the mirror and a bloody face was looking back at you!",
                "Look in the mirror", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public void shower()
    {
        ImageIcon icon = new ImageIcon("src/resources/steamyShower.jpg");
        String jOpMessage = "You turned on the shower and the room steams up.\nYou feel fingers stroke the back of your neck.";
        JOptionPane.showMessageDialog(null, jOpMessage, "Turn On The Shower", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public void diningRoom(Player player)
    {
        String jOpMessage;
        int playerChoice;
        String[] choices;
        ImageIcon icon;

        jOpMessage = player + "\n\nYou are in the dining room\nThere is a candelabra sitting on a table\n"
                + "There is also a door leading to the kitchen";

        choices = new String[]{
            "Go to the kitchen", "Check out the candelabra"
        };
        
        icon = new ImageIcon("src/resources/diningRoom.jpg");

        playerChoice = JOptionPane.showOptionDialog(null, jOpMessage, "Dining Room", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, icon, choices, null);

        switch (playerChoice) {
            case 0:
                kitchen(player);
                break;

            case 1:
                candelabra();
                break;
        }
    }

    public void candelabra()
    {
        ImageIcon icon = new ImageIcon("src/resources/candelabra.jpg");
        JOptionPane.showMessageDialog(null, "The candelabra lights up by itself and you see a death shadow", "Candelabra", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public void kitchen(Player player)
    {
        String jOpMessage;
        int playerChoice;
        String[] choices;
        ImageIcon icon = new ImageIcon("src/resources/kitchen.jpg");

        jOpMessage = player + "\n\nYou are in the kitchen\nThere is a refrigerator and a cabinet\n"
                + "There is also a door leading to the pantry";

        choices = new String[]{
            "Open the refrigerator", "Open the cabinet", "Go inside the pantry"
        };

        playerChoice = JOptionPane.showOptionDialog(null, jOpMessage, "Kitchen", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, choices, null);

        switch (playerChoice) {
            case 0:
                refrigerator();
                break;
            case 1:
                cabinet();
                break;
            case 2:
                pantry(player);
                break;
        }
    }

    public void refrigerator()
    {
        ImageIcon icon = new ImageIcon("src/resources/soulFood.jpg");
        JOptionPane.showMessageDialog(null, "You open the refrigerator and find delicious soul food!", "Refrigerator", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public void cabinet()
    {
        ImageIcon icon = new ImageIcon("src/resources/platesFlying.jpg");
        JOptionPane.showMessageDialog(null, "You open the cabinet and dishes and glasses fly at you and you get hit in the head\n\n"
                + "You feel yourself moving towards a light.", "Cabinet", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public void pantry(Player player)
    {
        String jOpMessage;
        int playerChoice;
        String[] choices;
        ImageIcon icon;

        jOpMessage = player + "\n\nYou are in the pantry\nThere is a dusty recipe box and a broom";

        choices = new String[]{
            "Look at the recipe box", "Touch the broom"
        };
        
        icon = new ImageIcon("src/resources/pantry.jpg");

        playerChoice = JOptionPane.showOptionDialog(null, jOpMessage, "Pantry", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, choices, null);

        switch (playerChoice) {
            case 0:
                recipeBox();
                break;
            case 1:
                broom();
                break;
        }
    }

    public void recipeBox()
    {
        ImageIcon icon = new ImageIcon("src/resources/recipe.jpg");
        JOptionPane.showMessageDialog(null, "You open the box and a recipe for devils food cake appears out of nowhere", "Dusty Recipe Box", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public void broom()
    {
        ImageIcon icon = new ImageIcon("src/resources/broom.jpg");
        JOptionPane.showMessageDialog(null, "You touch the broom and it starts flying into the air!", "Touch the broom", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public void upstairs(Player player)
    {
        String jOpMessage;
        int playerChoice;
        String[] choices;
        ImageIcon icon;

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
        String jOpMessage;
        int playerChoice;
        String[] choices;
        ImageIcon icon;

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
        ImageIcon icon = new ImageIcon("src/resources/rockingChair.gif");
        JOptionPane.showMessageDialog(null, "The chair starts to rock on its own with no one in it", "Rocking Chair", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public void window()
    {
        ImageIcon icon = new ImageIcon("src/resources/childSwing.jpg");
        JOptionPane.showMessageDialog(null, "You see a child outside on a swing who suddenly disappears", "Window", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public void bedroom2(Player player)
    {
        String jOpMessage;
        int playerChoice;
        String[] choices;
        ImageIcon icon;

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
        ImageIcon icon = new ImageIcon("src/resources/dollhouse.jpg");
        JOptionPane.showMessageDialog(null, "The dolls start dancing on their own", "Doll House", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public void dresser()
    {
        ImageIcon icon = new ImageIcon("src/resources/ghostDresser.jpg");
        JOptionPane.showMessageDialog(null, "You open the dresser and a ghost flies out and passes through your body", "Dresser", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public void masterBedroom(Player player)
    {
        String jOpMessage;
        int playerChoice;
        String[] choices;
        ImageIcon icon;

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
        ImageIcon icon = new ImageIcon("src/resources/hopeDiamond.jpg");
        JOptionPane.showMessageDialog(null, "You find the cursed Hope Diamond and feel your doom!", "Jewelry Box", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public void masterBathroom(Player player)
    {
        String jOpMessage;
        int playerChoice;
        String[] choices;
        ImageIcon icon;

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
        ImageIcon icon = new ImageIcon("src/resources/genie.jpg");
        JOptionPane.showMessageDialog(null, "You rub the lamp and a genie comes out says he'll grant you 3 wishes", "Rub The Lamp", JOptionPane.PLAIN_MESSAGE, icon);
    }

    public void singingShower()
    {
        ImageIcon icon = new ImageIcon("src/resources/singShower.jpg");
        JOptionPane.showMessageDialog(null, "You hear singing in the shower, but nobody is there", "Shower", JOptionPane.PLAIN_MESSAGE, icon);
    }

}
