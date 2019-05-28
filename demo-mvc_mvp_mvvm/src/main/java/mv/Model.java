package mv;

public class Model {

    int val = 0;

    public void setVal(int v) {
        this.val = v;
    }

    public void sub(int v, View view) {
        this.val -= v;

        view.render(val);
    }

}
