/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;
/**
 *
 * @author Carina
 */
public class Source {
    public String name;
    public SourceType type;
    public int capacity;
//constructorul care initializeaza atributele clasei
    public Source(String name, SourceType type, int capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }
//gettere pentru fiecare atribut
    public String getName() {
        return name;
    }

    public SourceType getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setType(SourceType type) {
        this.type = type;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    } 

    public void setName(String name) {
        if(name==null){
            throw new IllegalArgumentException("Null??");
        }
        this.name = name;
    }
   //functia pentru afisarea obiectelor
    @Override
    public String toString() {
        return "Source{" + " name = " + name + '}';
    }

    
    
}
