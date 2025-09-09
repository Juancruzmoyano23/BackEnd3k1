package ar.edu.utnfc.backend;

import java.util.HashMap;

public class ClientesManager {
    private HashMap<String, Cliente> clientes = new HashMap<>();

    public Cliente obtenerExistenciaCliente(String cuit, String nombreEmpresa) {
        if (!clientes.containsKey(cuit)) {
            clientes.put(cuit, new Cliente(nombreEmpresa, cuit));
        }
        return clientes.get(cuit);
    }

    public int cantidadClientesUnicos() {
        return clientes.size();
    }
}