public class PrototipandoState extends AbstractState<Prog> {
    private final Arts arts;

    public PrototipandoState(Prog prog, Arts arts) {
        super(prog);
        this.arts = arts;
    }

    @Override
    public void execute() {
        Prog prog = getCharacter();
        prog.prototipando();
        System.out.println("[PROG] Prototipando... (Impl: " + prog.getImplementacoes() + ", Bugs: " + prog.getBugs() + ")");

        // checa a transição a partir do diagrama
        if (prog.getBugs() >= 25) {
            System.out.println("[PROG] -> Muitos bugs! Mudou para DEBUGANDO!");
            prog.setState(new DebugandoState(prog, arts));
        } else if (prog.getBugs() < 25 && arts.getAssets() >= 5) {
            System.out.println("[PROG] -> Tem Assets suficientes e poucos bugs! Mudou para PROGRAMANDO!");
            arts.setAssets(arts.getAssets() - 1); // consome 1 asset qunado começa a programar
            prog.setState(new ProgramandoState(prog, arts));
        }
    }
}
