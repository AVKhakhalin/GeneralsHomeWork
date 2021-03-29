package GeneralsHomeWork;

import javax.swing.*;

public class Apple extends Fruit
{
    float weight = 1.5f;
    int pos_X = 233;
    int pos_Y = 274 - 100;
    JLabel apple_label;

    Apple (JLabel _apple_label)
    {
        this.apple_label = _apple_label;
        this.apple_label.setBounds(pos_X, pos_Y, this.apple_label.getPreferredSize().width, this.apple_label.getPreferredSize().height);
    }

    public float getWeight()
    {
        return weight;
    }

    public void setPos_X(int pos_X)
    {
        this.pos_X = pos_X;
    }

    public void setPos_Y(int pos_Y)
    {
        this.pos_Y = pos_Y;
    }

    public int getPos_X()
    {
        return pos_X;
    }

    public int getPos_Y()
    {
        return pos_Y;
    }

    public JLabel getApple_label()
    {
        return apple_label;
    }
}