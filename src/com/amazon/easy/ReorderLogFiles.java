package com.amazon.easy;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {

    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] log1 = o1.split(" ", 2);
                String[] log2 = o2.split(" ", 2);

                boolean isChar1 = Character.isLetter(log1[1].charAt(0));
                boolean isChar2 = Character.isLetter(log2[1].charAt(0));

                if(isChar1 && isChar2) {
                    int comp = log1[1].compareTo(log2[1]);
                    if(comp == 0) {
                        return log1[0].compareTo(log2[0]);
                    }
                    else {
                        return comp;
                    }
                } else if (isChar1 && !isChar2) {
                    return -1;
                }else if (!isChar1 && isChar2) {
                    return  1;
                }else {
                    return 0;
                }
            }
        });
        return logs;

    }
}
