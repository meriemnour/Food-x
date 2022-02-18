/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodxjava;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Ilyes
 */
public class ModelTable1 {
    private final SimpleStringProperty nom_menu;
    private final SimpleIntegerProperty id_menu;
    private final SimpleDoubleProperty poids_menu;
    private final SimpleDoubleProperty prix_menu;
    private final SimpleStringProperty description_menu;
    private final SimpleStringProperty categorie_menu;
    private final SimpleBooleanProperty veg_menu;

   public ModelTable1( int id_menu, String nom_menu, double prix_menu, double poids_menu ,  boolean veg_menu ,String categorie_menu ,String description_menu ) {
        this.nom_menu = new SimpleStringProperty(nom_menu);
        this.id_menu = new SimpleIntegerProperty(id_menu);
        this.veg_menu = new SimpleBooleanProperty(veg_menu);
        this.prix_menu = new SimpleDoubleProperty(prix_menu);   
        this.poids_menu = new SimpleDoubleProperty(poids_menu);

                this.description_menu = new SimpleStringProperty(description_menu);
        this.categorie_menu = new SimpleStringProperty(categorie_menu);

    }

    public String getMenuname() {
        return nom_menu.get();
    }

    public void setMenuname(String nom_menu) {
        this.nom_menu.set(nom_menu);
    }

    public int getMenuid() {
        return id_menu.get();
    }

    public void setMenuid(int id_menu) {
        this.id_menu.set(id_menu); 
    }

    public String getCategorie() {
        return categorie_menu.get();
    }

    public void setCategorie(String categorie_menu) {
        this.categorie_menu.set(categorie_menu);
    }

    public double getPrix() {
        return prix_menu.get();
    }

    public void setPrix(double prix_menu) {
        this.prix_menu.set(prix_menu);
    }
    public double getPoids() {
        return poids_menu.get();
    }
    public void setPoids(int poids_menu) {
        this.poids_menu.set(poids_menu);
    }
        public String getDescription() {
        return description_menu.get();
    }
    public void setDescription(String description_menu) {
        this.description_menu.set(description_menu);
    }   
        public boolean getVeg() {
        return veg_menu.get();
    }
    public void setDescription(boolean veg_menu) {
        this.veg_menu.set(veg_menu);
    }   


    
}
