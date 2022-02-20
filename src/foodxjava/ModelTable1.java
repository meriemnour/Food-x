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
    private final SimpleStringProperty menuname;
    private final SimpleIntegerProperty menuid;
    private final SimpleIntegerProperty quantity_item;
    private final SimpleIntegerProperty price;

    public ModelTable1(String menuname, int menuid, int quantity_item, int price) {
        this.menuname = new SimpleStringProperty(menuname);
        this.menuid = new SimpleIntegerProperty(menuid);
        this.quantity_item = new SimpleIntegerProperty(quantity_item);
        this.price = new SimpleIntegerProperty(price);
    }

    public String getMenuname() {
        return menuname.get();
    }

    public void setMenuname(String menuname) {
        this.menuname.set(menuname);
    }

    public int getMenuid() {
        return menuid.get();
    }

    public void setMenuid(int menuid) {
        this.menuid.set(menuid); 
    }

    public int getQuantity_item() {
        return quantity_item.get();
    }

    public void setQuantity_item(int quantity_item) {
        this.quantity_item.set(quantity_item);
    }

    public int getPrice() {
        return price.get();
    }

    public void setPrice(int price) {
        this.price.set(price);
    }

    
    
}
