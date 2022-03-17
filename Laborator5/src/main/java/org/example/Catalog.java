package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name, path;
    private List<Item> items = new ArrayList<>();

    //Constructor pentru creerea unui obicet de tip Catalog
    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    //gettere si settere pentru preluarea datelor despre catalog
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void add(Item item) {
        items.add(item);
    }

    /**
     * <p>Aceasta metoda se va folosi la afisarea obiectelor,scopul ei este de a gasi elementele dupa un id</p>
     *
     * @param id - id-ul obiectului pe care vrem sa il gasim
     * @return - returneaza obiectul daca se gaseste,altfel va return null
     */
    public Item findById(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
