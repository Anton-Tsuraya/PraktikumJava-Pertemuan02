
package model;


public class Penerbit {
    private int id;
    private String Penerbit;

    public Penerbit() {
    }

    public Penerbit(int id, String Penerbit) {
        this.id = id;
        this.Penerbit = Penerbit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPenerbit() {
        return Penerbit;
    }

    public void setPenerbit(String Penerbit) {
        this.Penerbit = Penerbit;
    }
    
}
