package mv.mvvm;

public class ViewModel {

    Model m;

    View view;

    public ViewModel(Model m, View v) {
        this.m = m;
        this.view = v;
        view.setViewModel(this);
    }

    public void increase(int v) {
        // 业务逻辑
        int val = v;

        view.result.add(0, val);
    }

}
