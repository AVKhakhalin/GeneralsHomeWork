package GeneralsHomeWork;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseWork extends JFrame
{
    public int NUMBER_ORANGES = 40;
    public int NUMBER_APPLES = 60;
    public int NUMBER_BOXES = 5;

    int sizeWidth;
    int sizeHeight;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    JFrame frame;
    MyPanel fieldPanel;
    public JLabel help_label;
    public JLabel background_label;
    public JLabel allbox_label;
    public JLabel[] box_wall_lable = new JLabel[NUMBER_BOXES];
    public JLabel[] box_lable = new JLabel[NUMBER_BOXES];
    //    public Container[] box = new Container[NUMBER_BOXES];
    boolean beginDrag = false;
    public Dimension size_curLabel;
    int init_X = 0;
    int init_Y = 0;
    int numberCurBox = 0;
    int numberNewBox = 0;
    float tempDistance;
    int temp_X;
    int temp_Y;

    Orange[] orange = new Orange[NUMBER_ORANGES];
    Apple[] apple = new Apple[NUMBER_APPLES];
    Box[] box = new Box[NUMBER_BOXES];

    public MouseWork(int _sizeWidth, int _sizeHeight)
    {
        this.sizeWidth = _sizeWidth - 100 + 18;
        this.sizeHeight = _sizeHeight - 200 + 45;
        try
        {
            frame = new JFrame("Решение задания №3 (для закрытия окна нажмите на крестик справа верху)");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(null);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);

            // Загрузка фона
            background_label = new JLabel(new ImageIcon(MainApp.class.getResource("/background.png")));
            size_curLabel = background_label.getPreferredSize();
            background_label.setBounds(0, 0, size_curLabel.width, size_curLabel.height);

            // Загрузка картинки индикатора появления на сцене всех коробок
            allbox_label = new JLabel(new ImageIcon(MainApp.class.getResource("/allbox.png")));
            size_curLabel = allbox_label.getPreferredSize();
            allbox_label.setBounds(-200, 595 - 100, size_curLabel.width, size_curLabel.height);


            // Загрузка апельсинов
            for (int i = 0; i < NUMBER_ORANGES; i++)
            {
                orange[i] = new Orange(new JLabel(new ImageIcon(MainApp.class.getResource("/orange.png"))));
                orange[i].getOrange_label().setName((i < 10 ? ("0" + i) : i) + "O");
                size_curLabel = orange[i].getOrange_label().getPreferredSize();
                orange[i].getOrange_label().setBounds(orange[i].getPos_X(), orange[i].getPos_Y(), size_curLabel.width, size_curLabel.height);
                tempDistance = 0;
                while(tempDistance == 0)
                {
                    temp_X = orange[i].getPos_X() - 118 + (int) Math.round(Math.random() * 236);
                    temp_Y = orange[i].getPos_Y() - 118 + (int) Math.round(Math.random() * 236);

                    if (Math.sqrt((orange[i].getPos_X() - temp_X) * (orange[i].getPos_X() - temp_X) + (orange[i].getPos_Y() - temp_Y) * (orange[i].getPos_Y() - temp_Y)) < 110)
                    {
                        tempDistance = 1;
                        for (int j = 0; j < i; j++)
                        {
                            if (Math.sqrt((orange[j].getOrange_label().getX() - temp_X) * (orange[j].getOrange_label().getX() - temp_X) + (orange[j].getOrange_label().getY() - temp_Y) * (orange[j].getOrange_label().getY() - temp_Y)) < size_curLabel.width)
                            {
                                tempDistance = 0;
                            }
                        }
                        if (tempDistance == 1)
                        {
                            orange[i].getOrange_label().setBounds(temp_X, temp_Y, size_curLabel.width, size_curLabel.height);
                            orange[i].setPos_X(temp_X);
                            orange[i].setPos_Y(temp_Y);
                        }
                    }
                }
                orange[i].getOrange_label().addMouseMotionListener(mml);
                orange[i].getOrange_label().addMouseListener(ml);
            }

            // Загрузка яблок
            for (int i = 0; i < NUMBER_APPLES; i++)
            {
                apple[i] = new Apple(new JLabel(new ImageIcon(MainApp.class.getResource("/apple.png"))));
                apple[i].getApple_label().setName((i < 10 ? ("0" + i) : i) + "A");
                size_curLabel = apple[i].getApple_label().getPreferredSize();
                apple[i].getApple_label().setBounds(apple[i].getPos_X(), apple[i].getPos_Y(), size_curLabel.width, size_curLabel.height);
                tempDistance = 0;
                while(tempDistance == 0)
                {
                    temp_X = apple[i].getPos_X() - 118 + (int) Math.round(Math.random() * 236);
                    temp_Y = apple[i].getPos_Y() - 118 + (int) Math.round(Math.random() * 236);

                    if (Math.sqrt((apple[i].getPos_X() - temp_X) * (apple[i].getPos_X() - temp_X) + (apple[i].getPos_Y() - temp_Y) * (apple[i].getPos_Y() - temp_Y)) < 206)
                    {
                        tempDistance = 1;
                        for (int j = 0; j < i; j++)
                        {
                            if (Math.sqrt((apple[j].getApple_label().getX() - temp_X) * (apple[j].getApple_label().getX() - temp_X) + (apple[j].getApple_label().getY() - temp_Y) * (apple[j].getApple_label().getY() - temp_Y)) < size_curLabel.width)
                            {
                                tempDistance = 0;
                            }
                        }
                        if (tempDistance == 1)
                        {
                            apple[i].getApple_label().setBounds(temp_X, temp_Y, size_curLabel.width, size_curLabel.height);
                            apple[i].setPos_X(temp_X);
                            apple[i].setPos_Y(temp_Y);
                        }
                    }
                }
                apple[i].getApple_label().addMouseMotionListener(mml);
                apple[i].getApple_label().addMouseListener(ml);
            }

            // Загрузка коробок
            for (int i = 0; i < NUMBER_BOXES; i++)
            {
                box_wall_lable[i] = new JLabel(new ImageIcon(MainApp.class.getResource("/box_walls.png")));
                size_curLabel = box_wall_lable[i].getPreferredSize();
                box_wall_lable[i].setBounds(-200, -200, size_curLabel.width, size_curLabel.height);
                box_wall_lable[i].addMouseMotionListener(box_mml);
                box_wall_lable[i].addMouseListener(box_ml);
                box_lable[i] = new JLabel(new ImageIcon(MainApp.class.getResource("/box_bottom.png")));
                box_lable[i].setBounds(-200, -200, size_curLabel.width, size_curLabel.height);
//                box[i] = new Container();
//                box[i].add(box_lable[i]);
//                box[i].setBounds(-200, -200, size_curLabel.width, size_curLabel.height);
//                box[i].addContainerListener((ContainerListener) box_mml);
//                box[i].addContainerListener((ContainerListener) box_ml);
                box[i] = new Box();
            }

            // Загрузка режима помощи
            help_label = new JLabel(new ImageIcon(MainApp.class.getResource("/help_down.png")));
            size_curLabel = help_label.getPreferredSize();
            help_label.setBounds(0, -1000, size_curLabel.width, size_curLabel.height);

            // Панель с другими элементами
            fieldPanel = new MyPanel(background_label, frame, box_wall_lable, box_lable, NUMBER_BOXES, box, allbox_label, help_label);
            fieldPanel.setLayout(null); // jPanel.setLayout(null); - тоже самое

            // Добавление элементов на экран
            fieldPanel.add(help_label);
            for (int i = 0; i < NUMBER_BOXES; i++)
            {
                fieldPanel.add(box_wall_lable[i]);
            }
            for (int i = 0; i < NUMBER_APPLES; i++)
            {
//                fieldPanel.add(apple_lable[i]);
                fieldPanel.add(apple[i].getApple_label());
            }
            for (int i = 0; i < NUMBER_ORANGES; i++)
            {
//                fieldPanel.add(orange_lable[i]);
                fieldPanel.add(orange[i].getOrange_label());
            }
            fieldPanel.add(background_label);
            fieldPanel.repaint();

            frame.setContentPane(fieldPanel); // frame.add(fieldPanel);

            frame.setLocation((int) ((screenSize.width - sizeWidth) / 2), (int) ((screenSize.height - sizeHeight) / 2));
            frame.setSize(this.sizeWidth, this.sizeHeight);
            frame.setVisible(true);
        }
        catch (Exception e)
        {
            System.out.println("Ошибка: " + e);
        }
    }

    MouseListener ml = new MouseListener()
    {
        public void mouseClicked(MouseEvent e)
        {
//            System.out.println("mouseClicked (" + e.getX() + "; " + e.getY() + ")");
        }
        public void mouseEntered(MouseEvent e)
        {
//            System.out.println("mouseEntered" + e.paramString());
        }
        public void mouseExited(MouseEvent e)
        {
//            System.out.println("mouseExited" + e.paramString());
        }
        public void mousePressed(MouseEvent e)
        {
//            System.out.println("mousePressed (" + e.getX() + "; " + e.getY() + ")");
//            e.translatePoint(e.getX(), e.getY());
//            if (e.getComponent().getY() < 580)
//            if (e.getComponent().getY() < 530) // Нижняя граница захвата фруктов мышкой
            if (e.getComponent().getY() < 430) // Нижняя граница захвата фруктов мышкой
            {
                init_X = e.getX();
                init_Y = e.getY();
                beginDrag = true;
            }
        }
        public void mouseReleased(MouseEvent e)
        {
//            System.out.println("mouseReleased (" + e.getX() + "; " + e.getY() + ")");
            if (beginDrag == true)
            {
//                System.out.println(Integer.parseInt(e.getComponent().getName().substring(0,2)));
                if (e.getComponent().getName().substring(2,3).equals("A") == true)
                {
                    fieldPanel.remove(apple[Integer.parseInt(e.getComponent().getName().substring(0,2))].getApple_label());
                }
                else
                {
                    fieldPanel.remove(orange[Integer.parseInt(e.getComponent().getName().substring(0,2))].getOrange_label());
                }
                fieldPanel.revalidate();
                fieldPanel.repaint();
                beginDrag = false;
            }
            else
            {
                if (e.getComponent().getName().substring(2,3).equals("A") == true)
                {
                    apple[Integer.parseInt(e.getComponent().getName().substring(0,2))].setPos_X(apple[Integer.parseInt(e.getComponent().getName().substring(0,2))].getApple_label().getX());
                    apple[Integer.parseInt(e.getComponent().getName().substring(0,2))].setPos_Y(apple[Integer.parseInt(e.getComponent().getName().substring(0,2))].getApple_label().getY());
                }
                else
                {
                    orange[Integer.parseInt(e.getComponent().getName().substring(0,2))].setPos_X(orange[Integer.parseInt(e.getComponent().getName().substring(0,2))].getOrange_label().getX());
                    orange[Integer.parseInt(e.getComponent().getName().substring(0,2))].setPos_Y(orange[Integer.parseInt(e.getComponent().getName().substring(0,2))].getOrange_label().getY());
                }
            }
        }
    };

    MouseMotionListener mml = new MouseMotionListener()
    {
        public void mouseDragged(MouseEvent e)
        {
//            System.out.println("mouseDragged" + e.paramString());
//            System.out.println(e.getSource().getClass().toString());
            if (beginDrag == true)
            {
//                orange_lable.setLocation(orange_lable.getX() + e.getX() - init_X, orange_lable.getY() + e.getY() - init_Y);
//                if (e.getComponent().getY() < 530)
                if (e.getComponent().getY() < 430)
                {
//                    if (e.getComponent().getY() + e.getY() - init_Y < 530)
                    if (e.getComponent().getY() + e.getY() - init_Y < 430)
                    {
                        e.getComponent().setLocation(e.getComponent().getX() + e.getX() - init_X, e.getComponent().getY() + e.getY() - init_Y);
                    }
                    else
                    {
//                        e.getComponent().setLocation(e.getComponent().getX() + e.getX() - init_X, 532);
                        e.getComponent().setLocation(e.getComponent().getX() + e.getX() - init_X, 432);
                    }
                }
                else
                {
//                    System.out.println(e.getComponent().getName() + " " + e.getComponent().getName().substring(0,2) + " " + e.getComponent().getName().substring(2,3));
// !!!                System.out.println(e.getSource().getClass().getName() + " " + e.getComponent().getName());
//                    System.out.println(e.getSource().getClass().toString() + " " + e.getComponent().getParent().getClass().toString() + " " + e.getID() + " " + e.getSource().hashCode());
//                    System.out.println(e.getSource().getClass().toString() + " " + e.getSource().hashCode() + " " + apple[0].getClass().hashCode() + " " + apple[0].getApple_label().getClass().hashCode());
                    if ((e.getComponent().getX() >= 140) && (e.getComponent().getX() < 260))
                    {
                        numberCurBox = 0;
                    }
                    else if ((e.getComponent().getX() > 260) && (e.getComponent().getX() <= 390))
                    {
                        numberCurBox = 1;
                    }
                    else if ((e.getComponent().getX() > 390) && (e.getComponent().getX() <= 520))
                    {
                        numberCurBox = 2;
                    }
                    else if ((e.getComponent().getX() > 520) && (e.getComponent().getX() <= 650))
                    {
                        numberCurBox = 3;
                    }
                    else if ((e.getComponent().getX() > 650) && (e.getComponent().getX() <= 780))
                    {
                        numberCurBox = 4;
                    }
                    else
                    {
                        numberCurBox = 0;
                    }
                    if (box[numberCurBox].getCreatedForWork() == true)
                    {
                        if (e.getComponent().getName().substring(2,3).equals("A") == true)
                        {
                            beginDrag = box[numberCurBox].addingFruits(apple[Integer.parseInt(e.getComponent().getName().substring(0,2))]) == true ? false : true;
                            System.out.println("Вес коробки №" + (numberCurBox + 1) + " с ЯБЛОКАМИ составляет " + box[numberCurBox].getWeight() + " ед.");
                            if (beginDrag == false)
                            {
                                // 147 225
                                // 130 * (numberExistentBox + 1) + 10
//                                if (130 * (numberCurBox + 1) + 10)
                                size_curLabel = apple[Integer.parseInt(e.getComponent().getName().substring(0,2))].apple_label.getPreferredSize();
//                            apple[Integer.parseInt(e.getComponent().getName().substring(0,2))].apple_label.setBounds(e.getComponent().getX(), 575, size_curLabel.width, size_curLabel.height);
// !!!                                apple[Integer.parseInt(e.getComponent().getName().substring(0,2))].apple_label.setBounds(e.getComponent().getX(), 640, size_curLabel.width, size_curLabel.height);
                                int[] tempInt = box[numberCurBox].putBallsToBox(numberCurBox, apple[Integer.parseInt(e.getComponent().getName().substring(0,2))].apple_label, box[numberCurBox].contents.size() - 1, 182, 637, 146, 656, 204, 698, 238, 666, 182, 605, 140, 619, 207, 655, 245, 627);
                                apple[Integer.parseInt(e.getComponent().getName().substring(0,2))].apple_label.setBounds(tempInt[0], tempInt[1], size_curLabel.width, size_curLabel.height);
                            }
                        }
                        else
                        {
                            beginDrag = box[numberCurBox].addingFruits(orange[Integer.parseInt(e.getComponent().getName().substring(0,2))]) == true ? false : true;
                            System.out.println("Вес коробки №" + (numberCurBox + 1) + " с АПЕЛЬСИНАМИ составляет " + box[numberCurBox].getWeight() + " ед.");
                            if (beginDrag == false)
                            {
                                size_curLabel = orange[Integer.parseInt(e.getComponent().getName().substring(0,2))].orange_label.getPreferredSize();
//                                orange[Integer.parseInt(e.getComponent().getName().substring(0,2))].orange_label.setBounds(e.getComponent().getX(), 640, size_curLabel.width, size_curLabel.height);
//                                box[numberCurBox].putBallsToBox(orange[Integer.parseInt(e.getComponent().getName().substring(0,2))].orange_label, 182, 637, 146, 656, 204, 698, 238, 666, 182, 605, 140, 619, 207, 655, 245, 627);
                                int[] tempInt = box[numberCurBox].putBallsToBox(numberCurBox, orange[Integer.parseInt(e.getComponent().getName().substring(0,2))].orange_label, box[numberCurBox].contents.size() - 1, 182, 637, 146, 656, 204, 698, 238, 666, 182, 605, 140, 619, 207, 655, 245, 627);
                                orange[Integer.parseInt(e.getComponent().getName().substring(0,2))].orange_label.setBounds(tempInt[0], tempInt[1], size_curLabel.width, size_curLabel.height);
                            }
                        }
                    }
                    else
                    {
//                        e.getComponent().setLocation(e.getComponent().getX() + e.getX() - init_X, 528);
                        e.getComponent().setLocation(e.getComponent().getX() + e.getX() - init_X, 428);
                        System.out.println("На этом месте нет коробки, чтобы положить туда ваш плод. Сначала нужно создать коробку. Для этого нажмите кнопкой мышки на левый нижний угол один раз.");
                    }
                }
            }
        }
        public void mouseMoved(MouseEvent e)
        {
//            System.out.println("mouseMoved" + e.paramString());
        }
    };

    MouseListener box_ml = new MouseListener()
    {
        public void mouseClicked(MouseEvent e)
        {
//            System.out.println("mouseClicked (" + e.getX() + "; " + e.getY() + ")");
        }
        public void mouseEntered(MouseEvent e)
        {
//            System.out.println("mouseEntered" + e.paramString());
        }
        public void mouseExited(MouseEvent e)
        {
//            System.out.println("mouseExited" + e.paramString());
        }
        public void mousePressed(MouseEvent e)
        {
            init_X = e.getX();
            init_Y = e.getY();
            beginDrag = true;

            PointerInfo a = MouseInfo.getPointerInfo();
            Point point = new Point(a.getLocation());
//            SwingUtilities.convertPointFromScreen(point, e.getComponent());
            SwingUtilities.convertPointFromScreen(point, SwingUtilities.windowForComponent(e.getComponent())); // !!! Получение текущих координат курсора мышки относительно окна
            int x = (int) point.getX();
//            int y = (int) point.getY();

//            System.out.println(x + " " + e.getX() + " " + e.getXOnScreen());
            if ((x >= 140) && (x <= 250))
            {
                numberCurBox = 0;
            }
            else if ((x >= 270) && (x <= 380))
            {
                numberCurBox = 1;
            }
            else if ((x >= 400) && (x <= 510))
            {
                numberCurBox = 2;
            }
            else if ((x >= 530) && (x <= 640))
            {
                numberCurBox = 3;
            }
            else if ((x >= 660) && (x <= 770))
            {
                numberCurBox = 4;
            }
            else
            {
                numberCurBox = 0;
            }
        }
        public void mouseReleased(MouseEvent e)
        {
            beginDrag = false;
            // Возвращаем коробку на прежнее место
            Dimension size_boxLabel = box_lable[numberCurBox].getPreferredSize();
//            box_lable[numberCurBox].setBounds(130 * (numberCurBox + 1) + 10, 604, size_boxLabel.width, size_boxLabel.height);
//            box_wall_lable[numberCurBox].setBounds(130 * (numberCurBox + 1) + 10, 604, size_boxLabel.width, size_boxLabel.height);
            box_lable[numberCurBox].setBounds(130 * (numberCurBox + 1) + 10, 504, size_boxLabel.width, size_boxLabel.height);
            box_wall_lable[numberCurBox].setBounds(130 * (numberCurBox + 1) + 10, 504, size_boxLabel.width, size_boxLabel.height);

            // Получение координат курсора при отжатии кнопки мышки
            PointerInfo a = MouseInfo.getPointerInfo();
            Point point = new Point(a.getLocation());
//            SwingUtilities.convertPointFromScreen(point, e.getComponent());
            SwingUtilities.convertPointFromScreen(point, SwingUtilities.windowForComponent(e.getComponent())); // Получение текущих координат курсора мышки относительно окна
            int x = (int) point.getX();
            int y = (int) point.getY();

//            System.out.println(x + " " + e.getX() + " " + e.getXOnScreen());
            if ((x >= 140) && (x <= 250))
            {
                numberNewBox = 0;
            }
            else if ((x >= 270) && (x <= 380))
            {
                numberNewBox = 1;
            }
            else if ((x >= 400) && (x <= 510))
            {
                numberNewBox = 2;
            }
            else if ((x >= 530) && (x <= 640))
            {
                numberNewBox = 3;
            }
            else if ((x >= 660) && (x <= 770))
            {
                numberNewBox = 4;
            }
            else
            {
                numberNewBox = numberCurBox;
            }

            if ((box[numberNewBox].getCreatedForWork() == true) && (numberNewBox != numberCurBox))
            {
                // Сравнение коробок
//                if (y >= 604)
                if (y >= 504)
                {
                    box[numberCurBox].compare(box[numberNewBox]);
                    for (int i = 0; i < box[numberCurBox].contents.size(); i++)
                    {
                        if (box[numberCurBox].contents.get(i) instanceof Apple == true)
                        {
                            size_curLabel = ((Apple) box[numberCurBox].contents.get(i)).apple_label.getPreferredSize();
                            temp_X = ((Apple) box[numberCurBox].contents.get(i)).getPos_X();
                            temp_Y = ((Apple) box[numberCurBox].contents.get(i)).getPos_Y();
                            ((Apple) box[numberCurBox].contents.get(i)).getApple_label().setBounds(temp_X, temp_Y, size_curLabel.width, size_curLabel.height);
                        }
                        else
                        {
                            size_curLabel = ((Orange) box[numberCurBox].contents.get(i)).orange_label.getPreferredSize();
                            temp_X = ((Orange) box[numberCurBox].contents.get(i)).getPos_X();
                            temp_Y = ((Orange) box[numberCurBox].contents.get(i)).getPos_Y();
                            ((Orange) box[numberCurBox].contents.get(i)).getOrange_label().setBounds(temp_X, temp_Y, size_curLabel.width, size_curLabel.height);
                        }
                    }
                }
                // Пересыпание коробок
                else
                {
                    int numberElementsInNewBox = box[numberNewBox].contents.size();
                    if (box[numberCurBox].pourItOver(box[numberNewBox]) == true)
                    {
                        // Перенос фруктов на новое место в коробку
                        for (int i = numberElementsInNewBox; i < box[numberNewBox].contents.size(); i++)
                        {
                            if (box[numberNewBox].contents.get(i) instanceof Apple == true)
                            {
                                size_curLabel = ((Apple) box[numberNewBox].contents.get(i)).apple_label.getPreferredSize();
                                int[] tempInt = box[numberNewBox].putBallsToBox(numberNewBox, ((Apple) box[numberNewBox].contents.get(i)).apple_label, i, 182, 637, 146, 656, 204, 698, 238, 666, 182, 605, 140, 619, 207, 655, 245, 627);
                                temp_X = tempInt[0];
                                temp_Y = tempInt[1];
                                ((Apple) box[numberNewBox].contents.get(i)).setPos_X(temp_X);
                                ((Apple) box[numberNewBox].contents.get(i)).setPos_Y(temp_Y);
                                ((Apple) box[numberNewBox].contents.get(i)).getApple_label().setBounds(temp_X, temp_Y, size_curLabel.width, size_curLabel.height);
                            }
                            else
                            {
                                size_curLabel = ((Orange) box[numberNewBox].contents.get(i)).orange_label.getPreferredSize();
                                int[] tempInt = box[numberNewBox].putBallsToBox(numberNewBox, ((Orange) box[numberNewBox].contents.get(i)).orange_label, i, 182, 637, 146, 656, 204, 698, 238, 666, 182, 605, 140, 619, 207, 655, 245, 627);
                                temp_X = tempInt[0];
                                temp_Y = tempInt[1];
                                ((Orange) box[numberNewBox].contents.get(i)).setPos_X(temp_X);
                                ((Orange) box[numberNewBox].contents.get(i)).setPos_Y(temp_Y);
                                ((Orange) box[numberNewBox].contents.get(i)).getOrange_label().setBounds(temp_X, temp_Y, size_curLabel.width, size_curLabel.height);
                            }
                        }
                    }
                    else
                    {
                        // Возвращаем фрукты на прежнее место в коробку
                        for (int i = 0; i < box[numberCurBox].contents.size(); i++)
                        {
                            if (box[numberCurBox].contents.get(i) instanceof Apple == true)
                            {
                                size_curLabel = ((Apple) box[numberCurBox].contents.get(i)).apple_label.getPreferredSize();
                                temp_X = ((Apple) box[numberCurBox].contents.get(i)).getPos_X();
                                temp_Y = ((Apple) box[numberCurBox].contents.get(i)).getPos_Y();
                                ((Apple) box[numberCurBox].contents.get(i)).getApple_label().setBounds(temp_X, temp_Y, size_curLabel.width, size_curLabel.height);
                            }
                            else
                            {
                                size_curLabel = ((Orange) box[numberCurBox].contents.get(i)).orange_label.getPreferredSize();
                                temp_X = ((Orange) box[numberCurBox].contents.get(i)).getPos_X();
                                temp_Y = ((Orange) box[numberCurBox].contents.get(i)).getPos_Y();
                                ((Orange) box[numberCurBox].contents.get(i)).getOrange_label().setBounds(temp_X, temp_Y, size_curLabel.width, size_curLabel.height);
                            }
                        }
                    }
                }
            }
            else
            {
                // Возвращаем фрукты на прежнее место в коробку
                for (int i = 0; i < box[numberCurBox].contents.size(); i++)
                {
                    if (box[numberCurBox].contents.get(i) instanceof Apple == true)
                    {
                        size_curLabel = ((Apple) box[numberCurBox].contents.get(i)).apple_label.getPreferredSize();
                        temp_X = ((Apple) box[numberCurBox].contents.get(i)).getPos_X();
                        temp_Y = ((Apple) box[numberCurBox].contents.get(i)).getPos_Y();
                        ((Apple) box[numberCurBox].contents.get(i)).getApple_label().setBounds(temp_X, temp_Y, size_curLabel.width, size_curLabel.height);
                    }
                    else
                    {
                        size_curLabel = ((Orange) box[numberCurBox].contents.get(i)).orange_label.getPreferredSize();
                        temp_X = ((Orange) box[numberCurBox].contents.get(i)).getPos_X();
                        temp_Y = ((Orange) box[numberCurBox].contents.get(i)).getPos_Y();
                        ((Orange) box[numberCurBox].contents.get(i)).getOrange_label().setBounds(temp_X, temp_Y, size_curLabel.width, size_curLabel.height);
                    }
                }
            }
        }
    };

    MouseMotionListener box_mml = new MouseMotionListener()
    {
        public void mouseDragged(MouseEvent e)
        {
//            System.out.println("mouseDragged" + e.paramString());
//            System.out.println(e.getSource().getClass().toString());
            if (beginDrag == true)
            {
//                if (e.getComponent().getY() + e.getY() - init_Y > 460) // Ограничение на чрезмерно высокое поднятие коробки
                if (e.getComponent().getY() + e.getY() - init_Y > 360) // Ограничение на чрезмерно высокое поднятие коробки
                {
                    e.getComponent().setLocation(e.getComponent().getX() + e.getX() - init_X, e.getComponent().getY() + e.getY() - init_Y);
                    box_lable[numberCurBox].setLocation(box_lable[numberCurBox].getX() + e.getX() - init_X, box_lable[numberCurBox].getY() + e.getY() - init_Y);
                    for (int i = 0; i < box[numberCurBox].contents.size(); i++)
                    {
                        if (box[numberCurBox].contents.get(i) instanceof Apple == true)
                        {
                            size_curLabel = ((Apple) box[numberCurBox].contents.get(i)).apple_label.getPreferredSize();
                            temp_X = ((Apple) box[numberCurBox].contents.get(i)).apple_label.getX() + e.getX() - init_X;
                            temp_Y = ((Apple) box[numberCurBox].contents.get(i)).apple_label.getY() + e.getY() - init_Y;
                            ((Apple) box[numberCurBox].contents.get(i)).getApple_label().setBounds(temp_X, temp_Y, size_curLabel.width, size_curLabel.height);
                        }
                        else
                        {
                            size_curLabel = ((Orange) box[numberCurBox].contents.get(i)).orange_label.getPreferredSize();
                            temp_X = ((Orange) box[numberCurBox].contents.get(i)).orange_label.getX() + e.getX() - init_X;
                            temp_Y = ((Orange) box[numberCurBox].contents.get(i)).orange_label.getY() + e.getY() - init_Y;
                            ((Orange) box[numberCurBox].contents.get(i)).getOrange_label().setBounds(temp_X, temp_Y, size_curLabel.width, size_curLabel.height);
                        }
                    }
                }
            }
        }
        public void mouseMoved(MouseEvent e)
        {
        }
    };
}

class MyPanel extends JPanel implements MouseListener, MouseMotionListener
{
    //    int prevX, prevY;
    JLabel background_label;
    JFrame fieldFrame;
    int numberExistentBox = 0;
    int numberBoxes;
    JLabel[] box_wall_label;
    JLabel[] box_label;
    Box[] boxes;
    JLabel allbox_label;
    JLabel help_label;
    boolean curHelpRegime = false;

    public MyPanel(JLabel _background_label, JFrame _fieldFrame, JLabel[] _box_wall_lable, JLabel[] _box_lable, int _numberBoxes, Box[] _boxes, JLabel _allbox_label, JLabel _help_label)
    {
        this.background_label = _background_label;
        this.fieldFrame = _fieldFrame;
        this.numberBoxes = _numberBoxes;
        box_wall_label = new JLabel[this.numberBoxes];
        box_label = new JLabel[this.numberBoxes];
        this.allbox_label = _allbox_label;
        this.help_label = _help_label;
        for (int i = 0; i < this.numberBoxes; i++)
        {
            this.box_wall_label[i] = _box_wall_lable[i];
            this.box_label[i] = _box_lable[i];
            this.boxes = _boxes;
        }

        addMouseMotionListener(this);
        addMouseListener(this);
        add(background_label);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
//        System.out.println("Кликнули мышкой");
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
//        prevX = label.getX() - e.getX();
//        prevY = label.getY() - e.getY();
//
//        Component c = e.getComponent();
//        if (c instanceof JLabel)
//        {
//            updateLocation(e);
//        }

//        System.out.println(e.getSource().getClass().getSimpleName()); // Имя объекта, к которому применяется слушатель
//        if ((e.getX() <= 110) && (e.getY() >= 604) && (numberExistentBox < this.numberBoxes))
        // Вызов и скрытие режима помощи
        if ((e.getX() <= 110) && (e.getY() >= 390) && (e.getY() < 494))
        {
            if (curHelpRegime == false)
            {
                Dimension size_help_label = help_label.getPreferredSize();
                help_label.setBounds(0,0, size_help_label.width, size_help_label.height);
                curHelpRegime = true;
            }
            else
            {
                Dimension size_help_label = help_label.getPreferredSize();
                help_label.setBounds(0,-1000, size_help_label.width, size_help_label.height);
                curHelpRegime = false;
            }
        }
        // Добавление новых коробок
//        if ((e.getX() <= 110) && (e.getY() >= 504) && (numberExistentBox < this.numberBoxes))
        if ((e.getX() <= 110) && (e.getY() >= 494) && (numberExistentBox < this.numberBoxes) && (curHelpRegime == false))
        {
            // Загрузка новых коробок
            Dimension size_boxLabel = box_label[numberExistentBox].getPreferredSize();
//            box_label[numberExistentBox].setBounds(130 * (numberExistentBox + 1) + 10, 604, size_boxLabel.width, size_boxLabel.height);
//            box_wall_label[numberExistentBox].setBounds(130 * (numberExistentBox + 1) + 10, 604, size_boxLabel.width, size_boxLabel.height);
            box_label[numberExistentBox].setBounds(130 * (numberExistentBox + 1) + 10, 504, size_boxLabel.width, size_boxLabel.height);
            box_wall_label[numberExistentBox].setBounds(130 * (numberExistentBox + 1) + 10, 504, size_boxLabel.width, size_boxLabel.height);

            // Удаление предыдущего фона
            fieldFrame.remove(background_label);

            // Добавление элементов на экран
            fieldFrame.add(box_label[numberExistentBox]);
            boxes[numberExistentBox].setCreatedForWork(true);

            // Изменение счётчика коробок
            numberExistentBox++;

            // Добавление скрытия кнопки, добавляющей коробки
            if (numberExistentBox >= 5)
            {
                Dimension size_allbox_label = allbox_label.getPreferredSize();
//                allbox_label.setBounds(0, 595, size_allbox_label.width, size_allbox_label.height);
                allbox_label.setBounds(0, 495, size_allbox_label.width, size_allbox_label.height);
                fieldFrame.add(allbox_label);
            }

            // Добавление нового фона
            Dimension size_backgroundLabel = background_label.getPreferredSize();
            background_label.setBounds(0, 0, size_backgroundLabel.width, size_backgroundLabel.height);
            fieldFrame.add(background_label);

            // Обновление экрана
            repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
//        Component c = e.getComponent();
//        if (c instanceof JLabel)
//        {
//            updateLocation(e);
//        }
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
//        updateLocation(e);
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {

    }

    private void updateLocation(MouseEvent e)
    {
        //       label.setLocation(prevX + e.getX(), prevY + e.getY());
        //       repaint();
    }
}