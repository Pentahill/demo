package mv.mvvm;

import java.util.List;

public class Model {

    List<Integer> val;

    public Model(List<Integer> val) {
        this.val = val;
    }

    public Integer value() {
        return val.get(0);
    }

    public void sub(int v) {
    }

    public void setValue(int v) {
        this.val.add(0, v);
    }

}
