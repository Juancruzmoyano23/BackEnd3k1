package main.java.ar.edu.utnfc.backend;

public class Menu {
    private List<Opcion> = new ArrayList<>();

    public void addOpcion(Opcion op){
        opcion.add(op);
    }

    public void ejecutar() {
        System.out.println("Menu de opciones:");
        System.out.println("=============================")
        for (Opcion op : opciones) {
            Sustem.out.println("id ------- %s\n", op.getIndice(), op.getMensaje());

        }

        System.out.println("0 --------- salir")

        try (Scanner in = new Scanner(System.in)){
            while (true){
                int o = in.nextInt();
                if (o == 0) {
                    break;
                }

                opciones.get(o - 1).getOpcionMenu().ejecutar();
        } catch (Exception e) {
            // TODO: handle exception
        }





    }
}
