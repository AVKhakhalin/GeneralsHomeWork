package GeneralsHomeWork;

import javax.swing.*;
import java.util.ArrayList;

public class Box<Fruit>
{
    ArrayList<Fruit> contents = new ArrayList<>();
    float weight = 0; // Альтернативный способ подсчёта веса положенных в коробку фруктов
    boolean createdForWork = false;

    public boolean addingFruits(Fruit fruit)
    {
        if (contents.size() == 0)
        {
            contents.add(fruit);
            // Альтернативный способ подсчёта веса положенных в коробку фруктов
            if (contents.get(0) instanceof Orange == true)
            {
                weight += ((Orange) contents.get(0)).getWeight();
            }
            else
            {
                weight += ((Apple) contents.get(0)).getWeight();
            }
            return true;
        }
        else
        {
            if (contents.get(0).getClass() == fruit.getClass())
            {
                contents.add(fruit);
                // Альтернативный способ подсчёта веса положенных в коробку фруктов
                if (contents.get(0) instanceof Orange == true)
                {
                    weight += ((Orange) contents.get(0)).getWeight();
                }
                else
                {
                    weight += ((Apple) contents.get(0)).getWeight();
                }
                return true;
            }
            else
            {
                if (contents.get(0) instanceof Orange == true)
                {
                    System.out.println("В данную коробку можно класть только апельсины. Попробуйте положить Ваше яблоко в коробку с яблоками или в другую свободную коробку.");
                }
                else
                {
                    System.out.println("В данную коробку можно класть только яблоки. Попробуйте положить Ваш апельсин в коробку с апельсинами или в другую свободную коробку.");
                }
                return false;
            }
        }
    }

    public void setWeight(float weight)
    {
        this.weight = weight;
    }

    public float getWeightAlternative()
    {
        return this.weight;
    }

    public float getWeight()
    {
        if (contents.size() == 0)
        {
            return 0f;
        }
        else
        {
            if (contents.get(0) instanceof Orange == true)
            {
                return contents.size() * ((Orange) contents.get(0)).getWeight();
            }
            else
            {
                return contents.size() * ((Apple) contents.get(0)).getWeight();
            }
        }
    }

    public boolean compare(Box otherBox)
    {
        if (this.getWeight() == otherBox.getWeight())
        {
            if (contents.size() != 0)
            {
                System.out.println((contents.get(0) instanceof Orange == true ? "Вес апельсинов" : "Вес яблок") + " в одной коробке (" + this.getWeight() + " ед.) РАВЕН (TRUE) весу (" + otherBox.getWeight() + " ед.) " + (otherBox.contents.get(0) instanceof Orange == true ? "апельсинов" : "яблок") + " в другой коробке.");
            }
            else
            {
                System.out.println("Веса обеих пустых коробок совпадают.");
            }
            return true;
        }
        else
        {
            if ((contents.size() != 0) && (otherBox.contents.size() != 0))
            {
                System.out.println((contents.get(0) instanceof Orange == true ? "Вес апельсинов" : "Вес яблок") + " в одной коробке (" + this.getWeight() + " ед.) НЕ РАВЕН (FALSE) весу (" + otherBox.getWeight() + " ед.) " + (otherBox.contents.get(0) instanceof Orange == true ? "апельсинов" : "яблок") + " в другой коробке.");
            }
            else if (contents.size() != 0)
            {
                System.out.println((contents.get(0) instanceof Orange == true ? "Вес апельсинов" : "Вес яблок") + " в одной коробке (" + this.getWeight() + " ед.) НЕ РАВЕН (FALSE) весу (0 ед.) другой пустой коробки.");
            }
            else
            {
                System.out.println("Вес (0 ед.) пустой коробки НЕ РАВЕН (FALSE) весу (" + otherBox.getWeight() + " ед.) " + (otherBox.contents.get(0) instanceof Orange == true ? "апельсинов" : "яблок") + " в другой коробке.");
            }
            return false;
        }
    }

    public boolean pourItOver(Box toBox)
    {
        if (toBox.getCreatedForWork() == true)
        {
            if (contents.size() != 0)
            {
                if ((toBox.contents.size() == 0) || ((contents.get(0) instanceof Orange == true) && (toBox.contents.get(0) instanceof Orange == true)) || ((contents.get(0) instanceof Apple == true) && (toBox.contents.get(0) instanceof Apple == true)))
                {
                    String previousFruitName = (contents.get(0) instanceof Orange == true ? "Апельсины " : "Яблоки ");
                    float toBox_previousWeight = toBox.getWeight();
                    for (int i = contents.size() - 1; i >= 0; i--)
                    {
                        toBox.contents.add(contents.get(i));
                        // Альтернативный способ подсчёта веса положенных в коробку фруктов
                        if (contents.get(0) instanceof Orange == true)
                        {
                            this.setWeight(this.getWeightAlternative() - ((Orange) contents.get(0)).getWeight());
                            toBox.setWeight(toBox.getWeightAlternative() + ((Orange) contents.get(0)).getWeight());
                        }
                        else
                        {
                            this.setWeight(this.getWeightAlternative() - ((Apple) contents.get(0)).getWeight());
                            toBox.setWeight(toBox.getWeightAlternative() + ((Apple) contents.get(0)).getWeight());
                        }
                        contents.remove(i);
                    }
                    System.out.println(previousFruitName + " успешно пересыпаны в другую коробку. Её вес изменился с " + toBox_previousWeight + " ед. до " + toBox.getWeight() + " ед.");
                    return true;
                }
                else
                {
                    System.out.println("Пересыпать содержимое коробки невозможно, потому что в конечной коробке находятся " + (contents.get(0) instanceof Orange == true ? "яблоки." : "апельсины."));
                    return false;
                }
            }
            else
            {
                System.out.println("Пересыпать содержимое коробки невозможно, потому что нечего пересыпать.");
                return false;
            }
        }
        else
        {
            System.out.println("Пересыпать содержимое коробки невозможно, потому что нет коробки на новом месте. Сначала создайте здесь новую коробку.");
            return false;
        }
    }

    public boolean getCreatedForWork()
    {
        return createdForWork;
    }

    public void setCreatedForWork(boolean createdForWork)
    {
        this.createdForWork = createdForWork;
    }

    public int[] putBallsToBox(int numberCurBox, JLabel ball, int curStep, int bottom_1_x, int bottom_1_y, int bottom_2_x, int bottom_2_y, int bottom_3_x, int bottom_3_y, int bottom_4_x, int bottom_4_y, int up_1_x, int up_1_y, int up_2_x, int up_2_y, int up_3_x, int up_3_y, int up_4_x, int up_4_y)
    {
        // bottom_1 - точка левая верхняя;
        // bottom_2 - точка левая нижняя;
        // bottom_3 - точка правая нижняя;
        // bottom_4 - точка правая верхняя;
        // up_1     - точка левая верхняя;
        // up_2     - точка левая нижняя;
        // up_3     - точка правая нижняя;
        // up_4     - точка правая верхняя.

        float dist_bottom_1_2 = (float) Math.sqrt((bottom_1_x - bottom_2_x) * (bottom_1_x - bottom_2_x) + (bottom_1_y - bottom_2_y) * (bottom_1_y - bottom_2_y));
        int numberHorizontalLines_y = Math.round(dist_bottom_1_2 / ball.getPreferredSize().width);
        float dist_bottom_2_3 = (float) Math.sqrt((bottom_2_x - bottom_3_x) * (bottom_2_x - bottom_3_x) + (bottom_2_y - bottom_3_y) * (bottom_2_y - bottom_3_y));
        int numberHorizontalCells_x = Math.round(dist_bottom_2_3 / ball.getPreferredSize().width);
        float dist_bottom_2_up_2 = (float) Math.sqrt((bottom_2_x - up_2_x) * (bottom_2_x - up_2_x) + (bottom_2_y - up_2_y) * (bottom_2_y - up_2_y));
        int numberVerticalCells_z = Math.round(dist_bottom_2_up_2 / (int) (ball.getPreferredSize().height * 0.7));

        int Nz = (int) (curStep / (numberHorizontalCells_x * numberHorizontalLines_y));

        float vb1u1_x = up_1_x - bottom_1_x;
        float vb1u1_y = up_1_y - bottom_1_y;
        float veb1u1_x = vb1u1_x / (float) Math.sqrt(vb1u1_x * vb1u1_x + vb1u1_y * vb1u1_y);
        float veb1u1_y = vb1u1_y / (float) Math.sqrt(vb1u1_x * vb1u1_x + vb1u1_y * vb1u1_y);

        float vb2u2_x = up_2_x - bottom_2_x;
        float vb2u2_y = up_2_y - bottom_2_y;
        float veb2u2_x = vb2u2_x / (float) Math.sqrt(vb2u2_x * vb2u2_x + vb2u2_y * vb2u2_y);
        float veb2u2_y = vb2u2_y / (float) Math.sqrt(vb2u2_x * vb2u2_x + vb2u2_y * vb2u2_y);

        float vb3u3_x = up_3_x - bottom_3_x;
        float vb3u3_y = up_3_y - bottom_3_y;
        float veb3u3_x = vb3u3_x / (float) Math.sqrt(vb3u3_x * vb3u3_x + vb3u3_y * vb3u3_y);
        float veb3u3_y = vb3u3_y / (float) Math.sqrt(vb3u3_x * vb3u3_x + vb3u3_y * vb3u3_y);

        float vb4u4_x = up_4_x - bottom_4_x;
        float vb4u4_y = up_4_y - bottom_4_y;
        float veb4u4_x = vb4u4_x / (float) Math.sqrt(vb4u4_x * vb4u4_x + vb4u4_y * vb4u4_y);
        float veb4u4_y = vb4u4_y / (float) Math.sqrt(vb4u4_x * vb4u4_x + vb4u4_y * vb4u4_y);

        bottom_1_x = (int) (veb1u1_x * ball.getPreferredSize().height * 0.7 * Nz) + bottom_1_x;
        bottom_1_y = (int) (veb1u1_y * ball.getPreferredSize().height * 0.7 * Nz) + bottom_1_y;
        bottom_2_x = (int) (veb2u2_x * ball.getPreferredSize().height * 0.7 * Nz) + bottom_2_x;
        bottom_2_y = (int) (veb2u2_y * ball.getPreferredSize().height * 0.7 * Nz) + bottom_2_y;
        bottom_3_x = (int) (veb3u3_x * ball.getPreferredSize().height * 0.7 * Nz) + bottom_3_x;
        bottom_3_y = (int) (veb3u3_y * ball.getPreferredSize().height * 0.7 * Nz) + bottom_3_y;
        bottom_4_x = (int) (veb4u4_x * ball.getPreferredSize().height * 0.7 * Nz) + bottom_4_x;
        bottom_4_y = (int) (veb4u4_y * ball.getPreferredSize().height * 0.7 * Nz) + bottom_4_y;

        if (bottom_1_y > up_1_x)
        {
            bottom_1_x = up_1_x;
            bottom_2_x = up_2_x;
            bottom_3_x = up_3_x;
            bottom_4_x = up_4_x;
        }

        if (Nz > 0)
        {
            curStep -= Nz * numberHorizontalCells_x * numberHorizontalLines_y;
        }

        int[] resArray = nextCoord(ball.getPreferredSize().width, curStep, bottom_1_x, bottom_1_y, bottom_2_x, bottom_2_y, bottom_3_x, bottom_3_y, bottom_4_x, bottom_4_y);

        resArray[0] += 130 * numberCurBox;

        return resArray;
    }

    public int[] nextCoord(int diameter, int curStep, int bottom_1_x, int bottom_1_y, int bottom_2_x, int bottom_2_y, int bottom_3_x, int bottom_3_y, int bottom_4_x, int bottom_4_y)
    {
        int[] resCoordPoint = {0, 0};

        float dist_bottom_1_2 = (float) Math.sqrt((bottom_1_x - bottom_2_x) * (bottom_1_x - bottom_2_x) + (bottom_1_y - bottom_2_y) * (bottom_1_y - bottom_2_y));
        int numberHorizontalLines_y = Math.round(dist_bottom_1_2 / diameter);
        float dist_bottom_2_3 = (float) Math.sqrt((bottom_2_x - bottom_3_x) * (bottom_2_x - bottom_3_x) + (bottom_2_y - bottom_3_y) * (bottom_2_y - bottom_3_y));
        int numberHorizontalCells_x = Math.round(dist_bottom_2_3 / diameter);
//        float dist_bottom_1_4 = (float) Math.sqrt((bottom_1_x - bottom_4_x) * (bottom_1_x - bottom_4_x) + (bottom_1_y - bottom_4_y) * (bottom_1_y - bottom_4_y));
//        float dist_bottom_3_4 = (float) Math.sqrt((bottom_3_x - bottom_4_x) * (bottom_3_x - bottom_4_x) + (bottom_3_y - bottom_4_y) * (bottom_3_y - bottom_4_y));

        if (numberHorizontalLines_y == 0)
        {
            numberHorizontalLines_y = 1;
        }
        if (numberHorizontalCells_x == 0)
        {
            numberHorizontalCells_x = 1;
        }

        int divCurStep = curStep;
        if (divCurStep + 1 > numberHorizontalCells_x * numberHorizontalLines_y)
        {
            divCurStep = divCurStep % (numberHorizontalCells_x * numberHorizontalLines_y);
        }
        int Nx = divCurStep % numberHorizontalCells_x;
        int Ny = (int) (divCurStep / numberHorizontalCells_x);

        float vb2b1_x = bottom_1_x - bottom_2_x;
        float vb2b1_y = bottom_1_y - bottom_2_y;
        float veb2b1_x = vb2b1_x / (float) Math.sqrt(vb2b1_x * vb2b1_x + vb2b1_y * vb2b1_y);
        float veb2b1_y = vb2b1_y / (float) Math.sqrt(vb2b1_x * vb2b1_x + vb2b1_y * vb2b1_y);
//        float b2b1 = (float) Math.sqrt(vb2b1_x * vb2b1_x + vb2b1_y * vb2b1_y);

        float vb2b3_x = bottom_3_x - bottom_2_x;
        float vb2b3_y = bottom_3_y - bottom_2_y;
        float veb2b3_x = vb2b3_x / (float) Math.sqrt(vb2b3_x * vb2b3_x + vb2b3_y * vb2b3_y);
        float veb2b3_y = vb2b3_y / (float) Math.sqrt(vb2b3_x * vb2b3_x + vb2b3_y * vb2b3_y);
//        float b2b3 = (float) Math.sqrt(vb2b3_x * vb2b3_x + vb2b3_y * vb2b3_y);

        float vb1b4_x = bottom_4_x - bottom_1_x;
        float vb1b4_y = bottom_4_y - bottom_1_y;
        float veb1b4_x = vb1b4_x / (float) Math.sqrt(vb1b4_x * vb1b4_x + vb1b4_y * vb1b4_y);
        float veb1b4_y = vb1b4_y / (float) Math.sqrt(vb1b4_x * vb1b4_x + vb1b4_y * vb1b4_y);
//        float b1b4 = (float) Math.sqrt(vb1b4_x * vb1b4_x + vb1b4_y * vb1b4_y);

        float vb3b4_x = bottom_4_x - bottom_3_x;
        float vb3b4_y = bottom_4_y - bottom_3_y;
        float veb3b4_x = vb3b4_x / (float) Math.sqrt(vb3b4_x * vb3b4_x + vb3b4_y * vb3b4_y);
        float veb3b4_y = vb3b4_y / (float) Math.sqrt(vb3b4_x * vb3b4_x + vb3b4_y * vb3b4_y);
//        float b3b4 = (float) Math.sqrt(vb3b4_x * vb3b4_x + vb3b4_y * vb3b4_y);

        float coordStartPointLine_2_1_x = veb2b1_x * ((0.5f * (float) diameter) + (float) diameter * (float) Ny) + bottom_2_x;
        float coordStartPointLine_2_1_y = veb2b1_y * ((0.5f * (float) diameter) + (float) diameter * (float) Ny) + bottom_2_y;
        float coordStartPointLine_3_4_x = veb3b4_x * ((0.5f * (float) diameter) + (float) diameter * (float) Ny) + bottom_3_x;
        float coordStartPointLine_3_4_y = veb3b4_y * ((0.5f * (float) diameter) + (float) diameter * (float) Ny) + bottom_3_y;
        float coordStartPointLine_2_3_x = veb2b3_x * ((0.5f * (float) diameter) + (float) diameter * (float) Nx) + bottom_2_x;
        float coordStartPointLine_2_3_y = veb2b3_y * ((0.5f * (float) diameter) + (float) diameter * (float) Nx) + bottom_2_y;
        float coordStartPointLine_1_4_x = veb1b4_x * ((0.5f * (float) diameter) + (float) diameter * (float) Nx) + bottom_1_x;
        float coordStartPointLine_1_4_y = veb1b4_y * ((0.5f * (float) diameter) + (float) diameter * (float) Nx) + bottom_1_y;

        float spv2_3_x = coordStartPointLine_3_4_x - coordStartPointLine_2_1_x;
        float spv2_3_y = coordStartPointLine_3_4_y - coordStartPointLine_2_1_y;
        float spve2_3_x = spv2_3_x / (float) Math.sqrt(spv2_3_x * spv2_3_x + spv2_3_y * spv2_3_y);
        float spve2_3_y = spv2_3_y / (float) Math.sqrt(spv2_3_x * spv2_3_x + spv2_3_y * spv2_3_y);
        float spv2_1_x = coordStartPointLine_1_4_x - coordStartPointLine_2_3_x;
        float spv2_1_y = coordStartPointLine_1_4_y - coordStartPointLine_2_3_y;
//        float spve2_1_x = spv2_1_x / (float) Math.sqrt(spv2_1_x * spv2_1_x + spv2_1_y * spv2_1_y);
//        float spve2_1_y = spv2_1_y / (float) Math.sqrt(spv2_1_x * spv2_1_x + spv2_1_y * spv2_1_y);

        resCoordPoint[0] = (int) (coordStartPointLine_2_1_x + spve2_3_x * ((0.5f * (float) diameter) + (float) diameter * (float) Nx));
        resCoordPoint[1] = (int) (coordStartPointLine_2_1_y + spve2_3_y * ((0.5f * (float) diameter) + (float) diameter * (float) Nx));

        // Точная подстройка положения яблок под картинку коробки
        resCoordPoint[0] -= diameter - 8;
        resCoordPoint[1] -= diameter + 100;

        return resCoordPoint;
    }
}