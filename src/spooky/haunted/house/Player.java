/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spooky.haunted.house;

/**
 *
 * @author antun
 */
public class Player
{
    private String name;
    
    
    public Player(String name)
    {
        this.name = name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    @Override
    public String toString()
    {
        return "Player: " + name;
    }
}
