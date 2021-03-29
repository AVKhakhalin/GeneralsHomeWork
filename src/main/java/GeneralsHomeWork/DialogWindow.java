package GeneralsHomeWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class DialogWindow
{
    int sizeWidth;
    int sizeHeight;

    public String[] arrayStringDates = {"Один", "Два", "Три", "Четыре", "Пять", "Шесть", "Семь", "Восемь", "Девять", "Десять"};
    public Integer[] arrayIntegerDates = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    public Float[] arrayFloatDates = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f, 6.6f, 7.7f, 8.8f, 9.9f, 10.1f};
    public Double[] arrayDoubleDates = {1.11, 2.22, 3.33, 4.44, 5.55, 6.66, 7.77, 8.88, 9.99, 10.11};
    public Boolean[] arrayBooleanDates = {true, true, true, true, true, false, false, false, false, false};

    public String choosedType = "String";
    SolveTask1 solveTask1;
    public int counter;
    JTextField textField_firstElement;
    JTextField textField_secondElement;
    DefaultComboBoxModel<String> originalArray_def;
    DefaultComboBoxModel<String> resultArray_def;

    DialogWindow (int _sizeWidth, int _sizeHeight)
    {
        this.sizeWidth = _sizeWidth;
        this.sizeHeight = _sizeHeight;
    }

    public JPanel createContentPane ()
    {
        // Создаём панель
        JPanel totalGUI = new JPanel();
        totalGUI.setBackground(new Color(200, 203, 255)); // смена фона окна
        totalGUI.setLayout(null);

        // Добавляем текст в окно
        String tabText1 = "&nbsp&nbsp&nbsp&nbsp";
        JLabel blueLabel = new JLabel("<html><font face=\"MyFont, Verdana, Arial\", size=\"5\"><br>" +
                "Домашнее задание №11 включало в себя следующее:<br>" +
                "1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа).<br>" + tabText1 + "Тип массива:&nbsp&nbspИсх.массив:&nbsp&nbsp№ элемента 1:&nbsp&nbsp№ элемента 2:&nbsp&nbspРез.массив:<br><br><br><br>" +
                "2. Написать метод, который преобразует массив в ArrayList.<br><br>" +
                "3. Задача:<br>" +
                "   а. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;<br>" +
                "   b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;<br>" +
                "   c. Для хранения фруктов внутри коробки можно использовать ArrayList;<br>" +
                "   d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);<br>" +
                "   e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;<br>" +
                "   f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;<br>" +
                "   g. Не забываем про метод добавления фрукта в коробку.</html>");
        blueLabel.setLocation(30, 0); // координаты текста
        blueLabel.setSize(sizeWidth - 70, sizeHeight - 100); // размер области с текстом
        blueLabel.setVerticalAlignment(1);
        blueLabel.setHorizontalAlignment(0);
        blueLabel.setForeground(Color.BLACK); // Цвет текста
        totalGUI.add(blueLabel);

        // Создание кнопки для задания №1
        JButton task_1_button = new JButton("Проверить задание");
        task_1_button.setToolTipText("<html>Нажмите для проверки задания №1</html>");
        task_1_button.setLocation(700, 120);
        task_1_button.setSize(150,40);
        totalGUI.add(task_1_button);
        ActionListener actionListener1 = new TestActionListener(1);
        task_1_button.addActionListener(actionListener1);

        // Создание списка оригинального массива списков для задания №1
        originalArray_def = new DefaultComboBoxModel<String>();
        for (counter = 0; counter < arrayStringDates.length; counter++)
        {
            originalArray_def.addElement((counter + 1) + ". " + arrayStringDates[counter]);
        }
        JComboBox<String> originalArray = new JComboBox<String>(originalArray_def);
        originalArray.setToolTipText("<html>Исходный массив типа \"" + choosedType + "\"<br>для проверки заданий №1 и 2</html>");
        originalArray.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
        originalArray.setMaximumRowCount(5);
        originalArray.setBounds(175, 120, 120, 30);
        totalGUI.add(originalArray);

        // Создание текстового поля для ввода номера элемента 1 для задания №1
        textField_firstElement = new JTextField(10);
        textField_firstElement.setToolTipText("<html>Введите номер элемента 1<br>для замены на элемент 2 в задании №1</html>");
        textField_firstElement.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
        textField_firstElement.setBounds(340, 120, 60, 30);
        textField_firstElement.setText("");
        totalGUI.add(textField_firstElement);

        // Создание текстового поля для ввода номера элемента 2 для задания №1
        textField_secondElement = new JTextField(10);
        textField_secondElement.setToolTipText("<html>Введите номер элемента 2<br>для замены на элемент 1 в задании №1</html>");
        textField_secondElement.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
        textField_secondElement.setBounds(480, 120, 60, 30);
        textField_secondElement.setText("");
        totalGUI.add(textField_secondElement);

        // Создание списка результирующего массива списков для задания №1
        resultArray_def = new DefaultComboBoxModel<String>();
        for (counter = 0; counter < arrayStringDates.length; counter++)
        {
            resultArray_def.addElement((counter + 1) + ". " + arrayStringDates[counter]);
        }
        JComboBox<String> resultlArray = new JComboBox<String>(resultArray_def);
        resultlArray.setToolTipText("<html>Результирующий массив типа \"" + choosedType + "\"<br>для проверки задания №1</html>");
        resultlArray.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
        resultlArray.setMaximumRowCount(5);
        resultlArray.setBounds(575, 120, 120, 30);
        totalGUI.add(resultlArray);

        // Создание списка типов списков для задания №1
        String[] defTypesElements_list = {"String", "Integer", "Float", "Double", "Boolean"};
        DefaultComboBoxModel<String> defTypesElements = new DefaultComboBoxModel<String>(defTypesElements_list);
        JComboBox<String> typesElements = new JComboBox<String>(defTypesElements);
        typesElements.setToolTipText("<html>Выберите тип исходного массива<br>для проверки заданий №1 и 2</html>");
        typesElements.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
        typesElements.setMaximumRowCount(5);
        typesElements.setBounds(50, 120, 120, 30);
//        typesElements.setEditable(true);
        ActionListener actionListener_type = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JComboBox typeBox = (JComboBox)e.getSource();
                choosedType = (String)typeBox.getSelectedItem();
                try
                {
                    if (choosedType.equals("String") == true)
                    {
                        solveTask1 = new SolveTask1(arrayStringDates);
                        solveTask1.changeArrayElements(originalArray_def, resultArray_def, Integer.parseInt(textField_firstElement.getText()), Integer.parseInt(textField_secondElement.getText()));
                    }
                    else if (choosedType.equals("Integer") == true)
                    {
                        solveTask1 = new SolveTask1(arrayIntegerDates);
                        solveTask1.changeArrayElements(originalArray_def, resultArray_def, Integer.parseInt(textField_firstElement.getText()), Integer.parseInt(textField_secondElement.getText()));
                    }
                    else if (choosedType.equals("Float") == true)
                    {
                        solveTask1 = new SolveTask1(arrayFloatDates);
                        solveTask1.changeArrayElements(originalArray_def, resultArray_def, Integer.parseInt(textField_firstElement.getText()), Integer.parseInt(textField_secondElement.getText()));
                    }
                    else if (choosedType.equals("Double") == true)
                    {
                        solveTask1 = new SolveTask1(arrayDoubleDates);
                        solveTask1.changeArrayElements(originalArray_def, resultArray_def, Integer.parseInt(textField_firstElement.getText()), Integer.parseInt(textField_secondElement.getText()));
                    }
                    else if (choosedType.equals("Boolean") == true)
                    {
                        solveTask1 = new SolveTask1(arrayBooleanDates);
                        solveTask1.changeArrayElements(originalArray_def, resultArray_def, Integer.parseInt(textField_firstElement.getText()), Integer.parseInt(textField_secondElement.getText()));
                    }
                    else
                    {
                        solveTask1 = new SolveTask1(arrayStringDates);
                        solveTask1.changeArrayElements(originalArray_def, resultArray_def, Integer.parseInt(textField_firstElement.getText()), Integer.parseInt(textField_secondElement.getText()));
                    }
                }
                catch(NumberFormatException e1)
                {
                }
            }
        };
        typesElements.addActionListener(actionListener_type);
        totalGUI.add(typesElements);

        // Создание кнопки для задания №2
        JButton task_2_button = new JButton("Проверить задание");
        task_2_button.setToolTipText("<html>Выберите тип массива из задания №1<br>и нажмите данную кнопку для проверки задания №2</html>");
        task_2_button.setLocation(700, 220);
        task_2_button.setSize(150,40);
        totalGUI.add(task_2_button);
        ActionListener actionListener2 = new TestActionListener(2);
        task_2_button.addActionListener(actionListener2);

        // Создание кнопки для задания №3
        JButton task_3_button = new JButton("Проверить задание");
        task_3_button.setToolTipText("<html>Нажмите для проверки задания №3</html>");
        task_3_button.setLocation(700, 623);
        task_3_button.setSize(150,40);
        totalGUI.add(task_3_button);
        ActionListener actionListener3 = new TestActionListener(3);
        task_3_button.addActionListener(actionListener3);

        // Создание кнопки для выхода из программы
        JButton task_EXIT_button = new JButton("Выйти из программы");
        task_EXIT_button.setToolTipText("<html>Нажмите для выхода из программы</html>");
        task_EXIT_button.setLocation((int) (sizeWidth / 2 - 80), sizeHeight - 98); // это координаты кнопки
        task_EXIT_button.setSize(160,40 ); // это размер кнопки
        totalGUI.add(task_EXIT_button);
        ActionListener actionListener_EXIT = new TestActionListener(0); // Подключение обработчика событий к кнопке
        task_EXIT_button.addActionListener(actionListener_EXIT);

        totalGUI.setOpaque(true);
        return totalGUI;
    }

    // Обработка событий при нажатии на левую кнопку мыши
    public class TestActionListener implements ActionListener
    {
        int taskNumber = 0;

        TestActionListener (int _taskNumber)
        {
            this.taskNumber = _taskNumber;
        }

        public void actionPerformed(ActionEvent e)
        {
            switch (taskNumber)
            {
                case 1:
                    //region Решение задачи 1
                    try
                    {
                        if (choosedType.equals("String") == true)
                        {
                            solveTask1 = new SolveTask1(arrayStringDates);
                            solveTask1.changeArrayElements(originalArray_def, resultArray_def, Integer.parseInt(textField_firstElement.getText()), Integer.parseInt(textField_secondElement.getText()));
                        }
                        else if (choosedType.equals("Integer") == true)
                        {
                            solveTask1 = new SolveTask1(arrayIntegerDates);
                            solveTask1.changeArrayElements(originalArray_def, resultArray_def, Integer.parseInt(textField_firstElement.getText()), Integer.parseInt(textField_secondElement.getText()));
                        }
                        else if (choosedType.equals("Float") == true)
                        {
                            solveTask1 = new SolveTask1(arrayFloatDates);
                            solveTask1.changeArrayElements(originalArray_def, resultArray_def, Integer.parseInt(textField_firstElement.getText()), Integer.parseInt(textField_secondElement.getText()));
                        }
                        else if (choosedType.equals("Double") == true)
                        {
                            solveTask1 = new SolveTask1(arrayDoubleDates);
                            solveTask1.changeArrayElements(originalArray_def, resultArray_def, Integer.parseInt(textField_firstElement.getText()), Integer.parseInt(textField_secondElement.getText()));
                        }
                        else if (choosedType.equals("Boolean") == true)
                        {
                            solveTask1 = new SolveTask1(arrayBooleanDates);
                            solveTask1.changeArrayElements(originalArray_def, resultArray_def, Integer.parseInt(textField_firstElement.getText()), Integer.parseInt(textField_secondElement.getText()));
                        }
                        else
                        {
                            solveTask1 = new SolveTask1(arrayStringDates);
                            solveTask1.changeArrayElements(originalArray_def, resultArray_def, Integer.parseInt(textField_firstElement.getText()), Integer.parseInt(textField_secondElement.getText()));
                        }
                    }
                    catch(NumberFormatException e1)
                    {
                        System.out.println("Номера элементов 1 и 2 нужно задавать в виде чисел. Попробуйте задать их ещё раз и нажмите на кнопку \"Проверить задание\"");
                        JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Номера элементов 1 и 2 нужно задавать в виде чисел.<br>Попробуйте задать их ещё раз и нажмите на кнопку \"Проверить задание\".</html>", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
                    }
                    //endregion
                    break;
                case 2:
                    //region Решение задачи 2
                    SolveTask2 solveTask2;
                    if (choosedType.equals("String") == true)
                    {
                        solveTask2 = new SolveTask2(arrayStringDates, choosedType);
                    }
                    else if (choosedType.equals("Integer") == true)
                    {
                        solveTask2 = new SolveTask2(arrayIntegerDates, choosedType);
                    }
                    else if (choosedType.equals("Float") == true)
                    {
                        solveTask2 = new SolveTask2(arrayFloatDates, choosedType);
                    }
                    else if (choosedType.equals("Double") == true)
                    {
                        solveTask2 = new SolveTask2(arrayDoubleDates, choosedType);
                    }
                    else if (choosedType.equals("Boolean") == true)
                    {
                        solveTask2 = new SolveTask2(arrayBooleanDates, choosedType);
                    }
                    else
                    {
                        solveTask2 = new SolveTask2(arrayStringDates, choosedType);
                    }
                    solveTask2.getInfo();
                    //endregion
                    break;
                case 3:
                    //region Решение задачи 3
/*                    Apple apple1 = new Apple();
                    Box box1 = new Box();
                    box1.addingFruits(apple1);
                    box1.addingFruits(apple1);
                    System.out.println("Вес коробки1 = " + box1.getWeight());

                    Box box2 = new Box();
                    Orange orange1 = new Orange();
                    box2.addingFruits(apple1);
                    box2.addingFruits(apple1);
                    System.out.println("Вес коробки2 = " + box2.getWeight());
                    System.out.println(box1.compare(box2));

                    System.out.println("Результат пересыпания коробки 1 в коробку 2: " + box1.pourItOver(box2));
                    System.out.println("Вес коробки1 = " + box1.getWeight());
                    System.out.println("Вес коробки2 = " + box2.getWeight());
 */
                    new MouseWork(sizeWidth, sizeHeight);
                    //endregion

                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }
}