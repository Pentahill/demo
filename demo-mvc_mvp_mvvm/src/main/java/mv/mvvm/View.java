package mv.mvvm;

import java.util.List;

public class View {

    List<Integer> result;

    ViewModel viewModel;

    public View(List<Integer> result) {
        this.result = result;
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void render() {
        System.out.println("显示结果是：" + result.get(0));
    }

    public void click(int v) {
        viewModel.increase(v);
    }

    public Integer value() {
        return result.get(0);
    }

}
