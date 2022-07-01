import java.util.ArrayList;

public class Barco {
    ArrayList<Personagem> passageiros = new ArrayList<>();
    int lado = 1;

    public void atravessar(Rio rio) throws Exception {
        if (this.passageiros.size() > 0) {
            int qtdM = 0, qtdC = 0;
            for (Personagem personagem : rio.lados.get(lado)) {
                if (personagem instanceof Canibal) {
                    qtdC++;
                } else if (personagem instanceof Missionario) {
                    qtdM++;
                }
            }
            if (qtdC > qtdM && qtdM != 0) {
                throw new ExCarnificina();
            }
            mudarLado();
            qtdM = 0;
            qtdC = 0;
            for (Personagem personagem : passageiros) {
                if (personagem instanceof Canibal) {
                    qtdC++;
                } else if (personagem instanceof Missionario) {
                    qtdM++;
                }
            }
            for (Personagem personagem : rio.lados.get(lado)) {
                if (personagem instanceof Canibal) {
                    qtdC++;
                } else if (personagem instanceof Missionario) {
                    qtdM++;
                }
            }
            if (qtdC > qtdM && qtdM != 0) {
                throw new ExCarnificina();
            }
        } else {
            throw new ExBarcoVazio();
        }
    }

    public void mudarLado() {
        if (this.lado == 1) {
            lado = 0;
        } else {
            lado = 1;
        }
    }
    public String mostrar(){
        String msg = "Barco: ";
        if (passageiros.size() > 0) {
            for (int i = 0 ; i < passageiros.size(); i++) {
                msg += "\n"+(i + 1) + " - "+passageiros.get(i).nome;
            }
        } else {
            msg += "\nVazio";
        }
        return msg;
    }
}