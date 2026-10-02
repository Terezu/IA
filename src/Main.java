public class Main {
    public enum EstadoProg {
        PROGRAMANDO,
        PROTOTIPANDO,
        DEBUGANDO
    }

    public enum EstadoArts {
        DESENHANDO,
        INSPIRATION
    }

    public static void main(String[] args) {
        Prog prog = new Prog();
        Arts arts = new Arts();

        EstadoProg estadoProg = EstadoProg.PROTOTIPANDO;
        EstadoArts estadoArts = EstadoArts.INSPIRATION;

        int contador = 0;

        System.out.println("=== INÍCIO DA SIMULAÇÃO ===");

        while (contador < 20) {
            System.out.println("\n--- TURNO " + (contador + 1) + " ---");

            // máquina de estados do artista
            switch (estadoArts) {
                case INSPIRATION:
                    arts.inspiracao();
                    System.out.println("[ARTISTA] Buscando referências... (Refs: " + arts.getInspiracao() + ")");

                    // num de referências >= 5 -> Começa a desenhar
                    if (arts.getInspiracao() >= 5) {
                        System.out.println("[ARTISTA] -> Mudou para DESENHANDO!");
                        estadoArts = EstadoArts.DESENHANDO;
                    }
                    break;

                case DESENHANDO:
                    arts.desenhando();
                    System.out.println("[ARTISTA] Desenhando... (Assets: " + arts.getAssets() + ", Refs: " + arts.getInspiracao() + ")");

                    // referências zeraram ou atingiu 5 Assets - volta a buscar referência
                    if (arts.getAssets() >= 5 || arts.getInspiracao() <= 0) {
                        System.out.println("[ARTISTA] -> Assets suficientes ou sem refs. Volta para BUSCAR REFERÊNCIAS!");
                        estadoArts = EstadoArts.INSPIRATION;
                    }
                    break;
            }

            // maquina de estados do programador
            switch (estadoProg) {
                case PROTOTIPANDO:
                    prog.prototipando();
                    System.out.println("[PROG] Prototipando... (Impl: " + prog.getImplementacoes() + ", Bugs: " + prog.getBugs() + ")");

                    // checa a transição a partir do diagrama
                    if (prog.getBugs() >= 25) {
                        System.out.println("[PROG] -> Muitos bugs! Mudou para DEBUGANDO!");
                        estadoProg = EstadoProg.DEBUGANDO;
                    } else if (prog.getBugs() < 25 && arts.getAssets() >= 5) {
                        System.out.println("[PROG] -> Tem Assets suficientes e poucos bugs! Mudou para PROGRAMANDO!");
                        arts.setAssets(arts.getAssets() - 1); // consome 1 asset qunado começa a programar
                        estadoProg = EstadoProg.PROGRAMANDO;
                    }
                    break;

                case PROGRAMANDO:
                    prog.programando();
                    if (arts.getAssets() > 0) {
                        arts.setAssets(arts.getAssets() - 1); // consome 1 asset por turno
                    }
                    System.out.println("[PROG] Programando... (Impl: " + prog.getImplementacoes() + ", Bugs: " + prog.getBugs() + ", Assets restantes: " + arts.getAssets() + ")");

                    // checa a transição
                    if (prog.getBugs() >= 25) {
                        System.out.println("[PROG] -> Acumulou 25+ bugs! Mudou para DEBUGANDO!");
                        estadoProg = EstadoProg.DEBUGANDO;
                    } else if (prog.getImplementacoes() <= 30) {
                        System.out.println("[PROG] -> Implementações <= 30. Volta para PROTOTIPANDO!");
                        estadoProg = EstadoProg.PROTOTIPANDO;
                    }
                    break;

                case DEBUGANDO:
                    prog.debugando();
                    System.out.println("[PROG] Debugando... (Impl: " + prog.getImplementacoes() + ", Bugs: " + prog.getBugs() + ")");

                    // checa a transição
                    if (prog.getImplementacoes() <= 30 && prog.getBugs() < 25) {
                        System.out.println("[PROG] -> Bugs controlados! Volta para PROTOTIPANDO!");
                        estadoProg = EstadoProg.PROTOTIPANDO;
                    }
                    break;
            }

            contador++;
        }
    }
}