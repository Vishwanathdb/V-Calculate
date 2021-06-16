package com.example.vcalculate;

import java.util.HashMap;

public class Subjects {

    public HashMap<String,Integer> credits = new HashMap<String, Integer>();
    public String[][] subject = new String[9][10];

    Subjects() {
        subject[1][1] = "18MAT11";
        subject[1][2] = "18XX12";
        subject[1][3] = "18XX13";
        subject[1][4] = "18XX14";
        subject[1][5] = "18XX15";
        subject[1][6] = "18XXL16";
        subject[1][7] = "18XXL17";
        subject[1][8] = "18EGH18";
        subject[1][9] = "NOTHING TO ENTER";

        subject[2][1] = "18MAT21";
        subject[2][2] = "18XX22";
        subject[2][3] = "18XX23";
        subject[2][4] = "18XX24";
        subject[2][5] = "18XX25";
        subject[2][6] = "18XXL26";
        subject[2][7] = "18XXL27";
        subject[2][8] = "18EGH28";
        subject[2][9] = "NOTHING TO ENTER";

        subject[3][1] = "18MAT31";
        subject[3][2] = "18XX32";
        subject[3][3] = "18XX33";
        subject[3][4] = "18XX34";
        subject[3][5] = "18XX35";
        subject[3][6] = "18XX36";
        subject[3][7] = "18XXL37";
        subject[3][8] = "18XXL38";
        subject[3][9] = "18XXX39";

        subject[4][1] = "18MAT41";
        subject[4][2] = "18XX42";
        subject[4][3] = "18XX43";
        subject[4][4] = "18XX44";
        subject[4][5] = "18XX45";
        subject[4][6] = "18XX46";
        subject[4][7] = "18XXL47";
        subject[4][8] = "18XXL48";
        subject[4][9] = "18XXX49";

        subject[5][1] = "18XX51";
        subject[5][2] = "18XX52";
        subject[5][3] = "18XX53";
        subject[5][4] = "18XX54";
        subject[5][5] = "18XX55";
        subject[5][6] = "18XX56";
        subject[5][7] = "18XXL57";
        subject[5][8] = "18XXL58";
        subject[5][9] = "18CIV59";

        subject[6][1] = "18XX61";
        subject[6][2] = "18XX62";
        subject[6][3] = "18XX63";
        subject[6][4] = "18XX64X";
        subject[6][5] = "18XX65X";
        subject[6][6] = "18XXL66";
        subject[6][7] = "18XXL67";
        subject[6][8] = "18XX68";
        subject[6][9] = "NOTHING TO ENTER";

        subject[7][1] = "18XX71";
        subject[7][2] = "18XX72";
        subject[7][3] = "18XX73X";
        subject[7][4] = "18XX74X";
        subject[7][5] = "18XX75X";
        subject[7][6] = "18XXL76";
        subject[7][7] = "18XX77";
        subject[7][8] = "NOTHING TO ENTER";
        subject[7][9] = "NOTHING TO ENTER";

        subject[8][1] = "18XX81";
        subject[8][2] = "18XX82X";
        subject[8][3] = "18XX83";
        subject[8][4] = "18XX84";
        subject[8][5] = "18XX85";
        subject[8][6] = "NOTHING TO ENTER";
        subject[8][7] = "NOTHING TO ENTER";
        subject[8][8] = "NOTHING TO ENTER";
        subject[8][9] = "NOTHING TO ENTER";


        credits.put("18MAT11", 4);
        credits.put("18XX12", 4);
        credits.put("18XX13", 3);
        credits.put("18XX14", 3);
        credits.put("18XX15", 3);
        credits.put("18XXL16", 1);
        credits.put("18XXL17", 1);
        credits.put("18EGH18", 1);

        credits.put("18MAT21", 4);
        credits.put("18XX22", 4);
        credits.put("18XX23", 3);
        credits.put("18XX24", 3);
        credits.put("18XX25", 3);
        credits.put("18XXL26", 1);
        credits.put("18XXL27", 1);
        credits.put("18EGH28", 1);

        credits.put("18MAT31", 3);
        credits.put("18XX32", 4);
        credits.put("18XX33", 3);
        credits.put("18XX34", 3);
        credits.put("18XX35", 3);
        credits.put("18XX36", 3);
        credits.put("18XXL37", 2);
        credits.put("18XXL38", 2);
        credits.put("18XXX39", 1);

        credits.put("18MAT41", 3);
        credits.put("18XX42", 4);
        credits.put("18XX43", 3);
        credits.put("18XX44", 3);
        credits.put("18XX45", 3);
        credits.put("18XX46", 3);
        credits.put("18XXL47", 2);
        credits.put("18XXL48", 2);
        credits.put("18XXX49", 1);

        credits.put("18XX51", 3);
        credits.put("18XX52", 4);
        credits.put("18XX53", 4);
        credits.put("18XX54", 3);
        credits.put("18XX55", 3);
        credits.put("18XX56", 3);
        credits.put("18XXL57", 2);
        credits.put("18XXL58", 2);
        credits.put("18CIV59", 1);

        credits.put("18XX61", 4);
        credits.put("18XX62", 4);
        credits.put("18XX63", 4);
        credits.put("18XX64X", 3);
        credits.put("18XX65X", 3);
        credits.put("18XXL66", 2);
        credits.put("18XXL67", 2);
        credits.put("18XX68", 2);


        credits.put("18XX71", 4);
        credits.put("18XX72", 4);
        credits.put("18XX73X", 3);
        credits.put("18XX74X", 3);
        credits.put("18XX75X", 3);
        credits.put("18XXL76", 2);
        credits.put("18XX77", 1);


        credits.put("18XX81", 3);
        credits.put("18XX82X", 3);
        credits.put("18XX83", 8);
        credits.put("18XX84", 1);
        credits.put("18XX85", 3);


        credits.put("NOTHING TO ENTER",0);

    }
}
