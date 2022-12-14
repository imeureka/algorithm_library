package com.example.demo.services;

import java.util.*;

public class Dijkstra {
    public static final int size = 241;

    public static class edge {
        public int first;
        public int second;
    }

    static edge[] p = new edge[241];
    public static int[] visited = new int[size];
    public static int[] path = new int[31];
    //public static int index = 1;
    public static int[] d = new int[size];

    public static void dijkstra(int start) {
        for (int i = 1; i < size; i++) {
            if (p[i].first == start)
                d[p[i].second] = 1;
            else if (p[i].second == start)
                d[p[i].first] = 1;
        }
        while (true) {
            int chk;
            for (chk = 1; chk < size - 20; chk++) {
                if (visited[chk] == 0)
                    break;
            }
            if (chk == 220)
                break;
            else {
                int min = 999999;
                int idx = 0;
                for (int i = 1; i < size; i++) {
                    if (visited[i] == 0 && d[i] < min) {
                        idx = i;
                        min = d[i];
                    }
                }
                visited[idx]++;

                for (int i = 1; i < size; i++) {
                    if (visited[p[i].second] == 0 && p[i].first == idx) {
                        if (d[p[i].first] + 1 < d[p[i].second]) {
                            d[p[i].second] = d[p[i].first] + 1;
                        }
                    } else if (visited[p[i].first] == 0 && p[i].second == idx) {
                        if (d[p[i].second] + 1 < d[p[i].first]) {
                            d[p[i].first] = d[p[i].second] + 1;
                        }
                    }
                }
            }
        }
    }

    public static int findPath(int start, int dest, int index) {
        int cur = dest;
        while (true) {
            if (cur == start)
                break;
            for (int i = 1; i < 241; i++) {
                if (p[i].second == cur && d[p[i].first] < d[cur]) {
                    cur = p[i].first;
                    path[index++] = cur;
                } else if (p[i].first == cur && d[p[i].second] < d[cur]) {
                    cur = p[i].second;
                    path[index++] = cur;
                }
            }
        }
        return index;
    }

    public static int getLocation(String bookNumber, String reference_Room) { // arg : String[] classifyNum, String reference_room

        String[] book = bookNumber.split("\\s+");
        double bookIndex = Double.parseDouble(book[0]);

        if (reference_Room.equals("???????????????")) {
            bookIndex = bookIndex / 10;
            if (bookIndex == 0)
                bookIndex = 1;
            return (int)bookIndex;
        } else {
            bookIndex = bookIndex / 10;
            if (bookIndex == 0)
                bookIndex = 1;
            return (int)bookIndex + 100;
        }

        //int idx = 845;
//         if reference_room == "???????????????"
//                return idx / 10;
//         else
//             return idx / 10 + 100;

    }

    public static void setting() {

        for (int i = 1; i < size; i++) {
            p[i] = new edge();
        }

        for (int j = 0; j < 20; j++) {
            for (int i = 1; i < 10; i++) {
                p[i + j * 10].first = i + j * 10;
                p[i + j * 10].second = i + 1 + j * 10;
            }
        }

        for (int i = 1; i < 19; i++) {
            p[199 + i].first = 200 + i;
            p[199 + i].second = 200 + i + 1;
        }

        for (int i = 1; i < 20; i++) {

            if (i % 2 != 0) {
                if (i == (200 + i) % 200) {
                    p[219 + i / 2].first = i * 10;
                    p[219 + i / 2].second = 200 + i;
                    p[229 + i / 2].first = 200 + i;
                    p[229 + i / 2].second = i * 10 + 1;
                }
            }
        }

        for (int i = 0; i < 241; i++) {
            d[i] = 999999;
        }
    }

    public static ArrayList<String> convertCoordinate(int[] path) {

        ArrayList<String> bookCoordinate = new ArrayList<String>();
        int[][] coordinate = new int[21][2];
        String co = null;
        int x = 0;
        int y = 0;
        int decimal = 0;
        for (int i = 1; i < path.length; i++) {
            int n = path[i];
            if (n == 0) break;
            if (n < 200) {
                for (decimal = 1; decimal <= 20; decimal++) {
                    if (decimal * 10 >= n) break;
                }

                if (decimal % 2 == 1) { // ??????
                    x = n / 10;
                    y = n % 10;
                    if (x % 2 == 1) x--;
                    if (y == 0) y = 10;
                } else { // ?????????
                    x = n / 10 - 1;
                    y = n % 10 + 11;
                    if (x % 2 == 1) x = x - 1;
                    if (y == 11) y = 21;
                }
            } else {
                x = n % 20 - 1;
                y = 11;
            }
            co = String.valueOf(x) + " " + String.valueOf(y);
            bookCoordinate.add(co);
        }


        return bookCoordinate;
    }
}

