package GeneralsHomeWork;

import javax.swing.*;

public class Orange extends Fruit
{
    float weight = 1.0f;
    int pos_X = 600;
    int pos_Y = 280 - 100;
    JLabel orange_label;

    Orange (JLabel _orange_label)
    {
        this.orange_label = _orange_label;
        this.orange_label.setBounds(pos_X, pos_Y, this.orange_label.getPreferredSize().width, this.orange_label.getPreferredSize().height);
    }

    public float getWeight()
    {
        return weight;
    }

    public void setPos_X(int pos_X)
    {
        this.pos_X = pos_X;
    }

    public int getPos_X()
    {
        return pos_X;
    }

    public int getPos_Y()
    {
        return pos_Y;
    }

    public void setPos_Y(int pos_Y)
    {
        this.pos_Y = pos_Y;
    }

    public JLabel getOrange_label()
    {
        return orange_label;
    }
}