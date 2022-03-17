package org.example;

import java.io.Serializable;

public abstract class Item implements Serializable {
    private String name, id, path;

    //Constructor care imi initializeaza numele,id-ul si path-ul obiectului creat
    public Item(String name, String id, String path) {
        this.name = name;
        this.id = id;
        this.path = path;
    }

    //gettere si settere pentru atributele obiectului
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * <p>Afiseaza datele despre obiectele create</p>
     *
     * @return - un string cu datele necesare
     */
    @Override
    public String toString() {
        return "Numele obiectului creat este" +
                name +
                " are id-ul " + id +
                ", se gaseste in " + path;
    }
}
