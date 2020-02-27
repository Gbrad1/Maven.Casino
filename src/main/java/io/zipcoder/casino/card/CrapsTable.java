package io.zipcoder.casino.card;

import java.util.Map;

public class CrapsTable{

    public String printTable(Integer balance, Integer pass, Integer dontPass, Integer field, Integer come, Integer dontCome,
                             Map<Integer, Integer> box, Map<Integer, Integer> behindBox, Integer roll, Integer point) {
        String four = " ";
        String five = " ";
        String six  = " ";
        String eight = " ";
        String nine = " ";
        String ten = " ";

        switch (point){
            case 4:
                four = "x";
                break;
            case 5:
                five = "x";
                break;
            case 6:
                six = "x";
                break;
            case 8:
                eight = "x";
                break;
            case 9:
                nine = "x";
                break;
            case 10:
                ten = "x";
                break;
            case 0:
                four = " ";
                five = " ";
                six  = " ";
                eight = " ";
                nine = " ";
                ten = " ";
                break;

        }

        //l1
        StringBuilder crapsTable = new StringBuilder();
        String insertString = " ";
        crapsTable.append(insertString);
        for (int i = 0; i < 47; i++) {
            crapsTable.append("_");
        }
        crapsTable.append(insertString+"\n");
        //l2
        insertString = String.format("|   |      |%1$4d |%2$4d |%3$4d |%4$4d |%5$4d |%6$5d |\n",
                behindBox.get(4), behindBox.get(5), behindBox.get(6), behindBox.get(8),
                behindBox.get(9), behindBox.get(10));
        crapsTable.append(insertString);
        //l3
        crapsTable.append("|   | DONT |");
        for (int i = 0; i < 36; i++) {
            crapsTable.append("-");
        }
        crapsTable.append("|\n");
        //l4
        insertString = String.format("|   | COME |  %s  |  %s  |  %s  |  %s  |  %s  |   %s  |\n",
                four, five, six, eight, nine, ten);
        crapsTable.append(insertString);
        //l5
        insertString = String.format("|   | BAR  |  _  |  _  |  _  |  _  |  _  |  __  |\n");
        crapsTable.append(insertString);
        //l6
        insertString = String.format("| P |  12  | |%d| | |%d| | |%d| | |%d| | |%d| | |%d| |\n",
                4, 5, 6, 8, 9, 10);
        crapsTable.append(insertString);
        //l7
        insertString = String.format("| A |      |  -  |  -  |  -  |  -  |  -  |  --  |\n");
        crapsTable.append(insertString);
        //l8
        insertString = String.format("| S |%5d | %3d | %3d | %3d | %3d | %3d |%5d |\n",
                dontCome,box.get(4),box.get(5),box.get(6),box.get(8),box.get(9),box.get(10));
        crapsTable.append(insertString);
        //l9
        insertString = String.format("| S |______|_____|_____|_____|_____|_____|______|\n","");
        crapsTable.append(insertString);
        //l11
        insertString = String.format("|   |   |        COME            YOUR BET:%5d |\n", come);
        crapsTable.append(insertString);
        //l12
        insertString = String.format("| L |   |_______________________________________|\n");
        crapsTable.append(insertString);
        //l15
        insertString = String.format("| I | D | *2* 3 4 9 11 10 *12*                  |\n");
        crapsTable.append(insertString);
        //l16
        insertString = String.format("| N | O |       FIELD            YOUR BET:%5d |\n", field);
        crapsTable.append(insertString);
        //l17
        insertString = String.format("| E | N |_______________________________________|\n");
        crapsTable.append(insertString);
        //l18
        insertString = String.format("|   | T   P A S S  L I N E       YOUR BET:%5d |\n",dontPass);
        crapsTable.append(insertString);
        //l19
        insertString = String.format("|   |___________________________________________|\n");
        crapsTable.append(insertString);
        //l120
        insertString = String.format("| YOUR BALANCE:%5d  ROLL:%4d  YOUR BET:%5d |\n",balance, roll, pass);
        crapsTable.append(insertString);
        //l21
        insertString = String.format("|_______________________________________________|\n");
        crapsTable.append(insertString);


        return crapsTable.toString();
    }
}
