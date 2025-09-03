package main.java.ar.edu.utnfc.backend;

@Data
@AllArgsConstructor
public class MuroSeco extends Producto {
    private boolean perfilAcero;
    private double metros;

    public MuroSeco(String codigo, String desc, int stock, ListaPrecio listapreci, boolean perfilAcero, double metros) {
        super(codigo, desc, stock, listapreci);
        this.perfilAcero = perfilAcero;
        this.metros = metros;
    }


    @Override
    public double importarPrecio() {
        return 0;// ListaPrecio();
    }
    

    @Override
    public int compareTo(Producto o) {
        return Double.compare(this.importarPrecio(), o.importarPrecio());
    }
}
