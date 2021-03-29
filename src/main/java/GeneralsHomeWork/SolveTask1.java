package GeneralsHomeWork;

import javax.swing.*;
import java.util.ArrayList;

public class SolveTask1<T>
{
    ArrayList<T> arrayToChange = new ArrayList<T>();

    SolveTask1(T[] datesArray)
    {
        for (T curElement : datesArray)
        {
            arrayToChange.add(curElement);
        }
    }

    public void changeArrayElements(DefaultComboBoxModel<String> defCombo_Original, DefaultComboBoxModel<String> defCombo_Result, int numberFrom, int numberTo) // numberFrom и numberTo порядковые номера в массиве (а не его индексы), т.е. они оба >=1
    {
        // Установка нового исходного списка
        defCombo_Original.removeAllElements();
        for (int i = 0; i < arrayToChange.size(); i++)
        {
            defCombo_Original.addElement((i + 1) + ". " + arrayToChange.get(i));
        }

        T tempDates;
        if ((numberFrom - 1 >= 0) && (numberTo - 1 >= 0))
        {
            if ((numberFrom <= this.arrayToChange.size()) && (numberTo <= this.arrayToChange.size()))
            {
                tempDates = arrayToChange.get(numberFrom - 1);
                arrayToChange.set(numberFrom - 1, arrayToChange.get(numberTo - 1));
                arrayToChange.set(numberTo - 1, tempDates);
            }
            else
            {
                System.out.println("Номера элементов не должны превышать количество элементов в исходном массиве (" + arrayToChange.size() + "). Исправьте свой запрос и нажмите на кнопку \"Проверить задание\" ещё раз.");
                JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Номера элементов не должны превышать<br>количество элементов в исходном массиве (" + arrayToChange.size() + ").<br>Исправьте свой запрос и нажмите на кнопку \"Проверить задание\" ещё раз.</html>", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            System.out.println("Нужно указать не индексы элементов, а их порядковый номер от единицы (первый элемент имеет номер 1). Исправьте свой запрос и нажмите на кнопку \"Проверить задание\" ещё раз.");
            JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Нужно указать не индексы элементов, а их порядковый номер<br>от единицы (первый элемент имеет номер 1).<br>Исправьте свой запрос и нажмите на кнопку<br>\"Проверить задание\" ещё раз.</html>", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
        }

        // Установка нового результрирующего списка
        defCombo_Result.removeAllElements();
        for (int i = 0; i < arrayToChange.size(); i++)
        {
            defCombo_Result.addElement((i + 1) + ". " + arrayToChange.get(i));
        }
    }
}