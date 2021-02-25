/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Objects;

/**
 *
 * @author Carina
 */
public class Destination {
      public String name;
    public int demand;
//setter pentru atribuirea 
    public void setDemand(int demand) {
        this.demand = demand;
    }
//constructor pentru initializarea atributelor
    public Destination(String name, int demand) {
        this.name = name;
        this.demand = demand;
    }

    public int getDemand() {
        return demand;
    }

    public Destination(int demand) {
        this.demand = demand;
    }

    public Destination(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//functie pentru afisarea obiectelor cu toate informatiile lor
    @Override
    public String toString() {
        return "Destination{" + " name = " + name + '}';
    }

    
}
