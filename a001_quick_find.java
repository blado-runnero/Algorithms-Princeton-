
package Algorithms_1_princeton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a001_quick_find {
    private int[] id;    
    private int count;   
    public a001_quick_find(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }


    public int count() {
        return count;
    }
  
    public int find(int p) {
        validate(p);
        return id[p];
    }

    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }
  
    public void union(int p, int q) {
        validate(p);
        validate(q);
        int pID = id[p];  
        int qID = id[q];  
        if (pID == qID) return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        a001_quick_find uf = new a001_quick_find(n);
        String str = "dsfcscd";
        while (!str.isEmpty()) {
            str = br.readLine();
            if(str.isEmpty()){break;}
            String sttr[] = str.split(" ");
            int p = Integer.parseInt(sttr[0]);
            int q = Integer.parseInt(sttr[1]);
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            System.out.println(p + "-" + q);
        }
        System.out.println(uf.count() + " components");
}
}
