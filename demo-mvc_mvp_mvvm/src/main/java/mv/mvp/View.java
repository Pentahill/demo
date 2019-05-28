package mv.mvp;

public class View {

    Presenter presenter;

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void render(int result) {
        System.out.println("显示结果是：" + result);
    }

    public void click(int v) {
        presenter.increase(v);
    }

}
