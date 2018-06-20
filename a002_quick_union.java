/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms_1_princeton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author bladeRUNNER
 */
public class a002_quick_union {
    private int[] parent;  
    private int count;    

    public a002_quick_union(int n) {
        parent = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int count() {
        return count;
    }
  
    public int find(int p) {
        validate(p);
        while (p != parent[p])
            p = parent[p];
        return p;
    }

    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

  
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ; 
        count--;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        a002_quick_union uf = new a002_quick_union(n);
        String str = "none";
        while (!str.isEmpty()) {
           str = br.readLine();
            if(str.isEmpty()){break;}
            String sttr[] = str.split(" ");
            int p = Integer.parseInt(sttr[0]);
            int q = Integer.parseInt(sttr[1]);
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(uf.count() + " components");
    }


}
