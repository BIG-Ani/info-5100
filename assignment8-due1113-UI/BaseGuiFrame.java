package Assignment8;

import javax.swing.*;
import java.awt.*;

public abstract class BaseGuiFrame extends JFrame {

    abstract public void create();

    abstract public void add(Container container);

    abstract public void addListeners();

    public void makeVisible(){
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    };

    public BaseGuiFrame(){
        setBounds(500, 300, 500, 400);
        create();

        Container container = getContentPane();
        add(container);

        addListeners();

        makeVisible();
    }

}
