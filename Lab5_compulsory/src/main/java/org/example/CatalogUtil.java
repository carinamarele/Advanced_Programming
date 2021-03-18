package org.example;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CatalogUtil {
    /**
     * <p>Salveaza in resurse ce avem in catalog</p>
     *
     * @param catalog - catalogul pe care dorim sa il salvam
     * @throws IOException - arunca exceptie daca nu se poate scrie sau daca nu se gaseste obiectul
     */
    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        } catch (IOException e) {
            System.out.println("Couldn't save: " + e.getMessage());
        }
    }

    /**
     * <p>Imi returnez un fisier dat la path ul scris ca parametru</p>
     *
     * @param path - path-ul fisierului pe care vreau sa il incarc
     * @return - fisierul gasit la path-ul dat
     * @throws Exception - exceptie daca nu se gaseste fisierul la path-ul dat
     */
    public static Object load(String path)
            throws Exception {
        try (var ois = new ObjectInputStream(new FileInputStream(path))) {
            return ois.readObject();
        } catch (Exception e) {
            return ("Couldn't load: " + e.getMessage());
        }
    }

    /**
     * <p>Visualizez elementul dat ca parametru si il deschid folosind clasa Desktop</p>
     *
     * @param item - fisierul pe care vreau sa il afisez
     * @throws Exception - exceptie daca nu se poate afisa sau gasit fisierul
     */
    public static void view(Item item) throws Exception {//play
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(item.getPath()));
        } catch (Exception e) {
            System.out.println("Couldn't view: " + e.getMessage());
        }
    }

    /**
     * <p>Afisez toate elementele catalogului apeland metoda load</p>
     *
     * @param path - path-ul la care se afla catalogul pe care vreau sa il afisez
     * @throws Exception - daca nu se gaseste se va afisa o exceptie
     */
    public static void list(String path) throws Exception {
        Catalog catalog = (Catalog) CatalogUtil.load(path);
        for (int i = 0; i < catalog.getItems().size(); i++) {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(catalog.getItems().get(i).getPath()));
        }
    }
}
