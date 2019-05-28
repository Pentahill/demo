package mv.mvp;

public class Presenter {

    Model m;

    View view;

    public Presenter(Model m, View view) {
        this.m = m;
        this.view = view;

        view.setPresenter(this);
    }

    public void increase(int v) {
        // 业务逻辑
        int val = this.m.val;
        val += v;
        val += 100;

        m.setVal(val);
        view.render(val);
    }

    public void sub(int v) {
        m.sub(v);
        view.render(m.val);
    }

}
