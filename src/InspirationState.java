public class InspirationState extends AbstractState<Arts> {
    public InspirationState(Arts arts) {
        super(arts);
    }

    @Override
    public void execute() {
        Arts arts = getCharacter();
        arts.inspiracao();
        System.out.println("[ARTISTA] Buscando referências... (Refs: " + arts.getInspiracao() + ")");

        // num de referências >= 5 -> Começa a desenhar
        if (arts.getInspiracao() >= 5) {
            System.out.println("[ARTISTA] -> Mudou para DESENHANDO!");
            arts.setState(new DesenhandoState(arts));
        }
    }
}
