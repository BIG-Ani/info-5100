package Assignment8;

import javax.swing.*;
import java.awt.*;

public class ButtonUI extends BaseGuiFrame {

    private JButton button;

    @Override
    public void create() {
        button = new JButton("0");
    }

    @Override
    public void add(Container container) {
        FlowLayout flowLayout = new FlowLayout();
        container.setLayout(flowLayout);
        container.add(button);
    }

    @Override
    public void addListeners() {
        button.addActionListener((e -> recordClickTimes()));
    }

    public void recordClickTimes(){
        int cur = Integer.parseInt(button.getText());
        button.setText(String.valueOf(cur + 1));
    }

    // main test
    public static void main(String[] args) {
        new ButtonUI();
    }
}
