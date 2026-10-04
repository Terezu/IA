public class DesenhandoState extends AbstractState<Arts> {
    public DesenhandoState(Arts arts) {
        super(arts);
    }

    @Override
    public void execute() {
        Arts arts = getCharacter();
        arts.desenhando();
        System.out.println("[ARTISTA] Desenhando... (Assets: " + arts.getAssets() + ", Refs: " + arts.getInspiracao() + ")");

        // referências zeraram ou atingiu 5 Assets - volta a buscar referência
        if (arts.getAssets() >= 5 || arts.getInspiracao() <= 0) {
            System.out.println("[ARTISTA] -> Assets suficientes ou sem refs. Volta para BUSCAR REFERÊNCIAS!");
            arts.setState(new InspirationState(arts));
        }
    }
}
