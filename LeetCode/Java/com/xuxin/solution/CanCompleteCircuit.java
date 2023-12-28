package com.xuxin.solution;

public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int len = gas.length;
        int index = 0;
        int tank = 0;
        int run = 0;
        while (true) {

            int i = index % len;

            if ((tank += gas[i]) < cost[i]) {
                if (index == i + len) {
                    return -1;
                }
                tank = 0;
                run = 0;
                index++;
                continue;
            }
            if (run == len) {
                return i;
            }
            tank -= cost[i];
            run++;
            index++;

        }
    }

}
