public class Arts {
    private int references = 0;
    private int assets = 0;

    public void inspiracao() {
        this.references += 1;
    }

    public void desenhando() {
        this.assets += 1;
        this.references -= 1;
    }

    public int getInspiracao() {
        return this.references;
    }

    public int getAssets() {
        return this.assets;
    }

    public void setReferences(int ref) {
        this.references = ref;
    }

    public void setAssets(int a) {
        this.assets = a;
    }
}