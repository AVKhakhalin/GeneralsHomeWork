package GeneralsHomeWork;

import javax.swing.*;
import java.awt.*;

public class MainApp
{
    public static final int SIZE_WIDTH = 900;
    public static final int SIZE_HEIGHT = 800;

    public static void main(String[] args)
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerLocationX = (int) ((screenSize.width - SIZE_WIDTH) / 2);
        int centerLocationY = (int) ((screenSize.height - SIZE_HEIGHT) / 2);

        JFrame.setDefaultLookAndFeelDecorated(false); // отображение стандартного вида окна
        JFrame frame = new JFrame("Домашнее задание №11 студента GeekBrains Хахалина Андрея Владимировича");

        //Create and set up the content pane.
        DialogWindow dialogWindow = new DialogWindow(SIZE_WIDTH, SIZE_HEIGHT); // создаём класс с диалоговым окном
        frame.setContentPane(dialogWindow.createContentPane()); // запускаем метод описывающий внешний вид
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(centerLocationX, centerLocationY);
        frame.setSize(SIZE_WIDTH, SIZE_HEIGHT);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}