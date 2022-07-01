import org.jetbrains.annotations.NotNull;

public class Personagem {

    String nome;

    Personagem(int qtd){
        nome = getClass().getSimpleName() + " " + qtd;
    }

    void entrar(Barco barco, Rio rio){
        barco.passageiros.add(this);
        rio.lados.get(barco.lado).remove(this);
    }

    void descer(Barco barco, Rio rio){
        barco.passageiros.remove(this);
        rio.lados.get(barco.lado).add(this);
    }

}
