package mv.mvc;

public class View {

    Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void render(int result) {
        System.out.println("显示结果是：" + result);
    }

    public void click(int v) {
        controller.increase(v);

        render(controller.m.val);
    }

}
