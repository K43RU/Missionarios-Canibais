import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Barco barco = new Barco();
        Rio rio = inicio();
        while (!(rio.lados.get(1).size() == 0) || !(barco.passageiros.size() == 0)) {
            try {
                jogar(rio, barco);
            } catch (ExCarnificina exception) {
                exception.printStackTrace();
                System.exit(0);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        System.out.println("VOCÊ CONSEGUIU!");
    }

    public static void jogar(Rio rio, Barco barco) throws Exception {
        System.out.println(rio.mostrar() +"\n" + barco.mostrar() +
		"\n------------------------------\n"+
				"1 - Embarcar" +
                "\n2 - Desembarcar" +
                "\n3 - Atravessar");
        int acao = sc.nextInt();
        if (acao == 1) {
            if (barco.passageiros.size() < 2) {
                System.out.println(
                        "\nPossíveis passageiros:" +
                        "\n" + rio.mostrarLado(barco));
                System.out.println("Selecione o passageiro a embarcar:");
                int passageiro = sc.nextInt();
                if (passageiro > 0 && passageiro <= rio.lados.get(barco.lado).size()) {
                    rio.lados.get(barco.lado).get(passageiro - 1).entrar(barco, rio);
                } else {
                    throw new ExOpcaoInvalida();
                }
            } else {
                throw new ExBarcoCheio();
            }
        } else if (acao == 2) {
            if (barco.passageiros.size() > 0) {
                System.out.println(
                        "\nPossíveis desembarques:" +
                        "\n" + barco.mostrar());
                System.out.println("Selecione o passageiro a desembarcar:");
                int passageiro = sc.nextInt();
                if (passageiro > 0 && passageiro <= barco.passageiros.size()) {
                    barco.passageiros.get(passageiro - 1).descer(barco, rio);
                } else {
                    throw new ExOpcaoInvalida();
                }
            } else {
                throw new ExBarcoVazio();
            }
        } else if (acao == 3) {
            barco.atravessar(rio);
        } else {
            throw new ExOpcaoInvalida();
        }
    }

    public static Rio inicio() {
        Rio rio = new Rio();
        rio.lados.get(1).add(new Canibal());
        rio.lados.get(1).add(new Canibal());
        rio.lados.get(1).add(new Canibal());
        rio.lados.get(1).add(new Missionario());
        rio.lados.get(1).add(new Missionario());
        rio.lados.get(1).add(new Missionario());
        return rio;
    }
}
