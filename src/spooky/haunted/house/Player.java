//******************************************************************************
// PantherIDs: 5441904
//             3723741
// CLASS:      COP2210-2016
// ASSIGNMENT  #4
// DATE:       2016-11-12
//
// We hereby swear and affirm that this work is solely our own, and not the work
// or the derivative of the work of anyone else.
//******************************************************************************
package spooky.haunted.house;

import java.util.ArrayList;

/**
 * Contains the player's name and inventory. Because item handling in this game
 * is very rudimentary, there is no need for anything other than the addition,
 * retrieval, and removal of items, storing them as a string of their name.
 * <p>
 * It's impossible to set the name to "" or make it null, same with items. If
 * for some godforsaken reason you need to do this, it should be easy enough to
 * hack out the bounds checking.
 * 
 * @author 5441904
 * @author 3723641
 */
public class Player
{
    private String name;
    private ArrayList<String> playerItems = new ArrayList<>();
    
    /**
     * Null constructor; avoid use. Sets name to "Unset."
     */
    public Player()
    {
        this.name = "Unset";
    }
    
    /**
     * Normal constructor. Sets the player's name to the passed string.
     * @param name The name to set the player to.
     */
    public Player(String name)
    {
        if(isValidStr(name)) this.name = name;
        else{
            this.name = "Invalid entry";
            System.out.println("Error: attempted to set the name to an empty or null string!");
        }
    }
    
    /**
     * Sets the player's name. Contains an error check.
     * @param name The player's new name.
     */
    public void setName(String name)
    {
        if(isValidStr(name)) this.name = name;
        else System.out.println("Error: attempted to set the name to an empty or null string!");
    }
    
    /**
     * Gets the player's name.
     * @return The player's name.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Converts the user's name to a string prefixed with "Player: "
     * @return The player's name, prefixed.
     */
    @Override
    public String toString()
    {
        return "Player: " + name;
    }
    
    /**
     * Adds an item to the player's inventory. Contains an error check.
     * @param item The name of the item to add
     */
    public void addItem(String item)
    {
        if(isValidStr(item)) playerItems.add(item);
        else System.out.println("Error: attempted to make a null/empty item!");
    }
    
    /**
     * Removes an item from the inventory by item index. Contains bounds check.
     * @param idx Index of the item to remove.
     */
    public void removeItem(int idx)
    {
        if(isValidIdx(idx)) playerItems.remove(idx);
        else System.out.println("Error: attempted to remove invalid item at idx " + idx);
    }
    
    /**
     * Tries to remove an item via contains(). Failures printed to System.out.
     * @param item Item string to attempt removal.
     */
    public void removeItem(String item)
    {
        boolean containedItem = playerItems.remove(item);
        if(!containedItem) System.out.println("Error: attempted to remove an invalid item named \"" + item + "\"!");
    }
    
    /**
     * Empties the player's inventory.
     */
    public void emptyInventory(){
        playerItems.clear();
    }
    
    /**
     * Retrieves the string associated with the specified item. Bounds checked.
     * @param idx The index to retrieve the item from.
     * @return The item string retrieved, or INVALID ITEM on failure.
     */
    public String getItem(int idx)
    {
        if(isValidIdx(idx)) return playerItems.get(idx);
        
        System.out.println("Error: attempted to get invalid item at idx " + idx);
        return "INVALID ITEM";
    }
    
    /**
     * Returns the number of items (the array's size) in the inventory.
     * @return Number of items the player has.
     */
    public int getNumItems(){
        return playerItems.size();
    }
    
    /**
     * Checks with contains() to see if the player has an item.
     * @param item The string being checked for containing.
     * @return If the player has that item-string.
     */
    public boolean hasItem(String item){
        return playerItems.contains(item);
    }
    
    //Private sanity checks used for bounds checking.
    //Affirms that the index passsed is between 0 and the upper bound.
    private boolean isValidIdx(int idx){
        return (0<=idx && idx<playerItems.size());
    }
    
    //Affirms that the string is neither a null reference nor empty.
    private boolean isValidStr(String str){
        return !((str == null) || str.isEmpty());
    }
}
