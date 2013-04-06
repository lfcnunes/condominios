/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lp.condominios.enums;

/**
 *
 * @author Pedro
 */
public final class Ocupacao {

    private int id;
    private String name;
    
    public Ocupacao() {
    }
    
    public Ocupacao(int id, String name) {
        this();
        this.setId(id);
        this.setName(name);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
  
    
    
}
