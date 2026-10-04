public class ProgramandoState extends AbstractState<Prog> {
    private final Arts arts;

    public ProgramandoState(Prog prog, Arts arts) {
        super(prog);
        this.arts = arts;
    }

    @Override
    public void execute() {
        Prog prog = getCharacter();
        prog.programando();
        if (arts.getAssets() > 0) {
            arts.setAssets(arts.getAssets() - 1); // consome 1 asset por turno
        }
        System.out.println("[PROG] Programando... (Impl: " + prog.getImplementacoes() + ", Bugs: " + prog.getBugs() + ", Assets restantes: " + arts.getAssets() + ")");

        // checa a transição
        if (prog.getBugs() >= 25) {
            System.out.println("[PROG] -> Acumulou 25+ bugs! Mudou para DEBUGANDO!");
            prog.setState(new DebugandoState(prog, arts));
        } else if (prog.getImplementacoes() <= 30) {
            System.out.println("[PROG] -> Implementações <= 30. Volta para PROTOTIPANDO!");
            prog.setState(new PrototipandoState(prog, arts));
        }
    }
}
