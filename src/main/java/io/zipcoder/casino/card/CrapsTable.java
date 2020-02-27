package io.zipcoder.casino.card;

import java.util.Map;

public class CrapsTable{

    public String printTable(Integer balance, Integer pass, Integer dontPass, Integer field, Integer come, Integer dontCome,
                             Map<Integer, Integer> box, Map<Integer, Integer> behindBox) {
        //line1
        StringBuilder crapsTable = new StringBuilder();
        String insertString = "";
        for (int i = 0; i < 48; i++) {
            crapsTable.append("-");
        }
        crapsTable.append(insertString);
        //line2
        insertString = String.format("|%$35|\n");
        crapsTable.append(insertString);
        //line3
        insertString = String.format("| | DONT |%1$5d.0f|%2$5d.0f|%3$5d.0f|%4$5d.0f|%5$5d.0f|%6$5d.0f|",
                behindBox.get(4), behindBox.get(5), behindBox.get(6), behindBox.get(8), behindBox.get(9), behindBox.get(10));
        crapsTable.append(insertString);


        return null;
    }
}
