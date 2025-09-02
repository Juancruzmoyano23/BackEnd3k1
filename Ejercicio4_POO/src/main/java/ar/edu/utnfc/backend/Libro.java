package Ejercicio4_POO.src.main.java.ar.edu.utnfc.backend;

public class Libro {
    private String isbn;
    private String titulo;
    private int nroEstante;
    private int paginas;
    private double precioPorDia;
    private Autor autor;

    public Libro(String isbn, String titulo, int nroEstante, int paginas, double precioPorDia, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.nroEstante = nroEstante;
        this.paginas = paginas;
        this.precioPorDia = precioPorDia;
        this.autor = autor;
    }

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public int getNroEstante() { return nroEstante; }
    public int getPaginas() { return paginas; }
    public double getPrecioPorDia() { return precioPorDia; }
    public Autor getAutor() { return autor; }

    @Override
    public String toString() {
        return "Libro: " + titulo + " | Autor: " + autor + " | Estante: " + nroEstante;
    }
}
