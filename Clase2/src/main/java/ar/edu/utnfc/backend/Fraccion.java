import lombok.Getter;
import lombok.Setter;

public class Fraccion {
    
    private int numerador;
    private int denominador;

    public int metodo1(int numerador, int denominador) {
        return -1;
    }
    
    // constructor 
    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            System.out.print("El denominador no puede ser cero.");
        }
        this.numerador = numerador;
        this.denominador = denominador;
    }

    // Metodo para mostrar los datos

    public String toString() {
        return numerador + "/" + denominador;
    }

    // metodos de acceso

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public void setDenominador (int denominador) {
        if (denominador == 0) {
            System.out.print("El denominador no puede ser cero.");
        } else {
            this.denominador = denominador;
        }
    }

    // operaciones
    public Fraccion sumar(Fraccion f) {
        int num = this.numerador * f.denominador + f.numerador * this.denominador;
        int den = this.denominador * f.denominador;
        return new Fraccion(num, den);
    }

    // Terminar las demas operaciones: restar, multiplicar, dividir

    public double aDecimal() {
        return (double) this.numerador / this.denominador;
    }
}
