package ar.edu.utnfc.backend;

public class Cliente {
    private String nombreEmpresa;
    private String cuit;

    public Cliente(String nombreEmpresa, String cuit) {
        this.nombreEmpresa = nombreEmpresa;
        this.cuit = cuit;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
}
