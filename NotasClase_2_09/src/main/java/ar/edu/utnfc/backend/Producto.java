package main.java.ar.edu.utnfc.backend;

public abstract class Producto implements comparable<T> {
    
    private String codigo;
    private String desc;
    private int stock;
    private ListaPrecio Listapreci;
    private MuroSeco muroSeco;

    public abstract double importarPrecio();    


    public Producto(String codigo, String desc, int stock, ListaPrecio listapreci) {
        this.codigo = codigo;
        this.desc = desc;
        this.stock = stock;
        Listapreci = listapreci;
    }
}
