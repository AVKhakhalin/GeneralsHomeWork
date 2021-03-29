package GeneralsHomeWork;

import javax.swing.*;
import java.util.ArrayList;

public class SolveTask2<T>
{
    ArrayList<T> resultArray = new ArrayList<T>();
    String typeInitialArray;

    SolveTask2(T[] initialDates, String _typeInitialArray)
    {
        typeInitialArray = _typeInitialArray;
        for (T curValue : initialDates)
        {
            resultArray.add(curValue);
        }
    }

    public void getInfo()
    {
        String resInfo_sout = "Исходный массив из задания 1 типа \"" + typeInitialArray + "\"\nпреобразован в следующий список типа \"ArrayList\":\n";
        String resInfo_message = "Исходный массив из задания 1 типа \"" + typeInitialArray + "\"<br>преобразован в следующий список типа \"ArrayList\":<br>";
        for (int i = 0; i < resultArray.size(); i++)
        {
            resInfo_sout += (i + 1) + ". " + resultArray.get(i) + "\n";
            resInfo_message += (i + 1) + ". " + resultArray.get(i) + "<br>";
        }
        System.out.println(resInfo_sout);
        JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">" + resInfo_message + "</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
    }
}