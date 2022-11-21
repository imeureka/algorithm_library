package com.example.demo.services;

import java.util.*;


public class Dijkstra {
    public static final int size = 241;
    public static class edge{
        public int first;
        public int second;
    }

    static edge[] p = new edge[241];
    public static int[] visited = new int[size];
    public static int[] path = new int[31];
    //public static int index = 1;
    public static int[] d = new int[size];

    public static void dijkstra (int start){
        for(int i = 1; i < size; i++){
            if (p[i].first == start)
                d[p[i].second] = 1;
            else if(p[i].second == start)
                d[p[i].first] = 1;
        }
        while(true){
            int chk;
            for(chk = 1; chk < size - 20; chk++){
                if(visited[chk] == 0)
                    break;
            }
            if(chk == 220)
                break;
            else{
                int min = 999999;
                int idx = 0;
                for(int i = 1; i < size; i++){
                    if(visited[i] == 0 && d[i] < min){
                        idx = i;
                        min = d[i];
                    }
                }
                visited[idx]++;

                for(int i = 1; i < size; i++){
                    if(visited[p[i].second] == 0 && p[i].first == idx){
                        if (d[p[i].first] + 1 < d[p[i].second]) {
                            d[p[i].second] = d[p[i].first] + 1;
                        }
                    }
                    else if (visited[p[i].first] == 0 && p[i].second == idx) {
                        if (d[p[i].second] + 1 < d[p[i].first]) {
                            d[p[i].first] = d[p[i].second] + 1;
                        }
                    }
                }
            }
        }
    }

    public static int findPath(int start, int dest, int index){
        int cur = dest;
        while (true) {
            if (cur == start)
                break;
            for (int i = 1; i < 241; i++) {
                if (p[i].second == cur && d[p[i].first] < d[cur]) {
                    cur = p[i].first;
                    path[index++] = cur;
                }
                else if (p[i].first == cur && d[p[i].second] < d[cur]) {
                    cur = p[i].second;
                    path[index++] = cur;
                }
            }
        }
        return index;
    }

    public static int getLocation(int num){ // arg : String[] classifyNum, String reference_room

        int idx = 845;
//         if reference_room == "종합자료실"
//                return idx / 10;
//         else
//             return idx / 10 + 100;

        return num / 10;
    }
    public static void setting() {

        for(int i = 1; i < size; i++){
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

    public static void main(String args[]) {

        int dest = Dijkstra.getLocation(845);
        int start = 210;
        Dijkstra.setting();
        Dijkstra.d[start] = 0;
        Dijkstra.visited[start] = 1;
        Dijkstra.dijkstra(start);
        //int dest = 84;
        int index = 1;
        Dijkstra.path[index++] = dest;
        index = Dijkstra.findPath(start, dest, index);

        for (int i = 1; i <= index; i++) {
            System.out.print(Dijkstra.path[i] + " ");
        }

        System.out.println(Dijkstra.d[dest]);

    }
}
