package mv;

public class View {

    public void render(int result) {
        System.out.println("显示结果是：" + result);
    }

    public void click(int v, Model m) {

        // 业务逻辑
        v += v;
        v += 100;
        m.setVal(v);

        render(v);
    }

}
