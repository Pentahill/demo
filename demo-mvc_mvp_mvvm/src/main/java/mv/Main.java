package mv;

public class Main {

    public static void main(String[] args) {
        Model m = new Model();
        View v = new View();

        v.click(100, m);
        m.sub(9, v);
    }

}
