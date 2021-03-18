package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * OBS pune exceptiile in invalidCatalogException
 */
public class App {
    public static void main(String args[]) throws Exception {
        App app = new App();
        app.testCreateSave();
        app.testLoadView();
        app.testListView();
    }

    /**
     * <p>Imi creaza catalogul si dupa introducerea a mai multor elemente in el se salveaza.</p>
     * <p>Se poate salva catalogul dupa fiecare introducere in el</p>
     *
     * @throws Exception Daca nu se poate accesa ceva se va afisa o exceptie
     */
    private void testCreateSave() throws Exception {
        Catalog catalog = new Catalog("My Books", "E:\\Lab5_compulsory\\h.txt");
        var song = new Song("bestSong", "827332", "C:\\Users\\Carina\\Downloads\\Ziarul-de-ASII-01-01.jpg", "POP", 9000);
        catalog.add(song);
        var book = new Book("bestBook", "hsdgf8", "C:\\Users\\Carina\\Downloads\\lab5ceva.txt", "fiction", "Claire Blossom", 4);
        catalog.add(book);
        CatalogUtil.save(catalog);

        System.out.println(catalog.getItems());

    }

    /**
     * <p> Aceasta metoda imi cauta un document la calea path si daca nu gaseste va arunca o exceptie</p>
     *
     * @throws Exception exceptie daca nu se gaseste fisierul la calea data
     */
    private void testLoadView() throws Exception {
        Catalog catalog = (Catalog) CatalogUtil.load("E:\\Lab5_compulsory\\h.jpg");
        CatalogUtil.view(catalog.findById("827332"));
        //CatalogUtil.view(catalog.findById("hsdgf8"));
        //am argumentat linia 44 pentru a vedea daca functioneaza view-ul
    }

    /**
     * <p>Afiseaza toate elementele catalogului dat la calea path pe care o scriem noi</p>
     *
     * @throws Exception Daca nu gaseste catalogul
     */
    private void testListView() throws Exception {
        CatalogUtil.list("E:\\Lab5_compulsory\\h.jpg");
    }
}
