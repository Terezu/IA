public class Main {
    public static void main(String[] args) {
        Arts arts = new Arts();
        Prog prog = new Prog(arts);

        int contador = 0;

        System.out.println("=== INÍCIO DA SIMULAÇÃO ===");

        while (contador < 20) {
            System.out.println("\n--- TURNO " + (contador + 1) + " ---");

            arts.update();
            prog.update();

            contador++;
        }
    }
}