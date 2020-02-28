package io.zipcoder.casino.card;


import io.zipcoder.casino.utilities.Console;

public class SicBoTable {

    private Console console = new Console(System.in, System.out);

    public SicBoTable() {
        console.print("\n");
        console.print("\n|----------------------------------------------|");
        console.print("\n|                     SicBo                    |");
        console.print("\n|----------------------------------------------|");
        console.print("\n|          |    EVEN    |    ODD    |          |");
        console.print("\n|   SMALL  |    1:1     |    1:1    |    BIG   |");
        console.print("\n|   #3-10  |------------|-----------|  #11-18  |");
        console.print("\n|    1:1   |        ANY TRIPLE      |    1:1   |");
        console.print("\n|          |           30:1         |          |");
        console.print("\n|----------------------------------------------|");
        console.print("\n");
    }
}
