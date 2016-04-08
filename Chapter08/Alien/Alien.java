/* 
  Chapter No. 8 - Exercise No. 1 
  File Name:          Alien.java
  Programmer:         Durell Smith
  Date Last Modified: February 6, 2016

  Problem Statement:
  Modify the Alien class from project 7.3 so that it is abstract because 
  there will be no Alien class instances. Make getDamage method abstrack
  and test the class from the main method to show it still works.
  
  Overall Plan:
  1. Change class header to include abstract tag
  2. Remove DEFAULT_DAMAGE constant since this will no longer be used.
  3. Change getDamage() method to an abstract method by declaring it abstract, 
      removing the body statement and ending with a semicolon

  Classes needed and Purpose:
  main class Alien just needs abstraction Base class for different aliens
  getDamage() calculates damage
*/

abstract class Alien 
{
  private int health; // 0=dead, 100=full strength
  private String name;

  /**
  * Default constructor;  Initialize name and health.
    */
  public Alien()
  {
    health = 100;
    name = "";
  }

  /**
  * Default constructor;  Initialize variables to input parameters.
  * @param health Initial health
  * @param name   Initial name
  */
  public Alien(int health, String name)
  {
    this.health = health;
    this.name = name;
  }

  // ======================
  // Various accessor and mutator methods
  // ======================
  public int getHealth()
  {
    return health;
  }

  public void setHealth(int health)
  {
    this.health = health;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String toString()
  {
    return (name + " " + health);
  }

  /**
  * getDamage returns the amount of damage this alien inflicts.
  * Must be defined in derived classes!
  */
  public abstract int getDamage();
} 
