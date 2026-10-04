public class DebugandoState extends AbstractState<Prog> {
    private final Arts arts;

    public DebugandoState(Prog prog, Arts arts) {
        super(prog);
        this.arts = arts;
    }

    @Override
    public void execute() {
        Prog prog = getCharacter();
        prog.debugando();
        System.out.println("[PROG] Debugando... (Impl: " + prog.getImplementacoes() + ", Bugs: " + prog.getBugs() + ")");

        // checa a transição
        if (prog.getImplementacoes() <= 30 && prog.getBugs() < 25) {
            System.out.println("[PROG] -> Bugs controlados! Volta para PROTOTIPANDO!");
            prog.setState(new PrototipandoState(prog, arts));
        }
    }
}
