package ar.edu.utnfc.backend;

public class MuroSeco extends Producto {
    private boolean perfilAcero;
    private double metros;

    public MuroSeco(String codigo, String desc, int stock, ListaPrecio listapreci, boolean perfilAcero, double metros) {
        super(codigo, desc, stock, listapreci);
        this.perfilAcero = perfilAcero;
        this.metros = metros;
    }

    public boolean isPerfilAcero() {
        return perfilAcero;
    }

    public void setPerfilAcero(boolean perfilAcero) {
        this.perfilAcero = perfilAcero;
    }

    public double getMetros() {
        return metros;
    }

    public void setMetros(double metros) {
        this.metros = metros;
    }

    @Override
    public double importarPrecio() {
        return 0; // ListaPrecio();
    }

    @Override
    public int compareTo(Producto o) {
        return Double.compare(this.importarPrecio(), o.importarPrecio());
    }
}
