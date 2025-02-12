package ag_hashing.video;

public class Pair {
    int i;
    int j;

    public Pair() {

    }

    public Pair(int i, int j) {
        super();
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    @Override
    public boolean equals(Object obj) {
        obj = (Pair) obj;
        if (this.i == ((Pair) obj).i || this.i == ((Pair) obj).j || this.j == ((Pair) obj).j || this.j == ((Pair) obj).i)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "[" + i + "," + j + "]";
    }

}
