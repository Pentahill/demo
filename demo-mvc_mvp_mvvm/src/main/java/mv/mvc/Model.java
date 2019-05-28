package mv.mvc;

public class Model {

    int val = 0;

    public void setVal(int v) {
        this.val = v;
    }

    public void sub(int v) {
        this.val -= v;
    }

    View view;

    public void setView(View v) {
        this.view = v;
    }

    public void refreshView() {
        view.render(val);
    }
}
