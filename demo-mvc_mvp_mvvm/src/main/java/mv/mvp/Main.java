package mv.mvp;

public class Main {

    public static void main(String[] args) {
        View v = new View();
        Model m = new Model();
        Presenter presenter = new Presenter(m, v);

        v.click(100);
    }

}
