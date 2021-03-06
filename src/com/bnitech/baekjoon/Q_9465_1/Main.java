package com.bnitech.acmicpc.Q_9465_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numT = Integer.parseInt(st.nextToken());
        while (numT-- > 0) {
            st = new StringTokenizer(br.readLine());
            int numN = Integer.parseInt(st.nextToken());
            int[][] tile = new int[numN + 1][2];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= numN; i++) {
                tile[i][0] = Integer.parseInt(st.nextToken());
            }

            int[][] memoTile = new int[numN + 1][3];
            st = new StringTokenizer(br.readLine());
            tile[1][1] = Integer.parseInt(st.nextToken());
            memoTile[1][0] = tile[1][0];
            memoTile[1][1] = tile[1][1];
            for (int N = 2; N <= numN; N++) {
                tile[N][1] = Integer.parseInt(st.nextToken());
                memoTile[N][0] = tile[N][0] + Math.max(memoTile[N - 1][1], memoTile[N - 1][2]);
                memoTile[N][1] = tile[N][1] + Math.max(memoTile[N - 1][0], memoTile[N - 1][2]);
                memoTile[N][2] = Math.max(memoTile[N - 1][0], memoTile[N - 1][1]);
            }
            int score = 0;
            for (int i = 0; i < 3; i++) {
                score = Math.max(score, memoTile[numN][i]);
            }
            System.out.println(score);
        }
    }
}
