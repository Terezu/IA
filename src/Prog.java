public class Prog {
    private int implementacoes = 0;
    private int bugs = 0;

    public void prototipando() {
        this.implementacoes += 5;
        this.bugs += 3;
    }

    public void programando() {
        this.bugs += 5;
        this.implementacoes -= 3;
    }

    public void debugando() {
        this.implementacoes -= 5;
        this.bugs -= 10;
        if (this.bugs < 0) this.bugs = 0; // impede os bugs de ficarem negativos
    }

    public int getImplementacoes() { return implementacoes; }
    public int getBugs() { return bugs; }

    public void setImplementacoes(int implementacoes) { this.implementacoes = implementacoes; }
    public void setBugs(int bugs) { this.bugs = bugs; }
}