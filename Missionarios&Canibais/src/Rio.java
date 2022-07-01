import java.util.ArrayList;

public class Rio {
    ArrayList<ArrayList<Personagem>> lados = new ArrayList<>();

    Rio(){
        lados.add(new ArrayList<>());
        lados.add(new ArrayList<>());
    }

    public String mostrar() {
        String msg = "";
        for (int i = 0; i < lados.get(0).size() || i < lados.get(1).size(); i++) {
            if (i < lados.get(0).size()) {
                msg += String.format(" %13s |     | ", lados.get(0).get(i).nome);
            } else {
                msg += String.format("               |     | ");
            }
            if (i < lados.get(1).size()) {
                msg += String.format("%-13s \n", lados.get(1).get(i).nome);
            } else {
                msg += String.format("\n");
            }
        }
        return msg;
    }

    public String mostrarLado(Barco barco) {
        String msg = "";
        for (int i = 0; i < lados.get(barco.lado).size() ; i++) {
            msg +=  "\n"+(i + 1) + " - " + lados.get(barco.lado).get(i).nome;
        }
        return msg;
    }
}
