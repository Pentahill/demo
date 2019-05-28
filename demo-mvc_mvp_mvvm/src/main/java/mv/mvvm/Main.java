package mv.mvvm;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(0);
        Model m = new Model(array);
        View v = new View(array);
        ViewModel viewModel = new ViewModel(m, v);

        v.click(2);
        v.render();
        System.out.println(v.value());
        System.out.println(m.value());

        m.setValue(100);
        v.render();
        System.out.println(v.value());
        System.out.println(m.value());

    }

}
