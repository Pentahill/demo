package mv.mvc;

public class Controller {

    Model m;

    View view;

    public Controller(Model m, View view) {
        this.m = m;
        this.view = view;

        view.setController(this);
        m.setView(view);
    }

    public void increase(int v) {
        // 业务逻辑
        int val = this.m.val;
        val += v;
        val += 100;

        m.setVal(val);
    }
}
