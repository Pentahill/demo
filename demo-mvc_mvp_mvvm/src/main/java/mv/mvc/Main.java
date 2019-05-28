package mv.mvc;

public class Main {

    public static void main(String[] args) {
        View v = new View();
        Model m = new Model();
        new Controller(m, v);

        v.click(100);

        m.sub(9);
        m.refreshView();
    }

}
