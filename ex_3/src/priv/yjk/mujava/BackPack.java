package priv.yjk.mujava;

public class BackPack {
//    public static void main(String[] args) {
//        
//        int m = 10;
//        int n = 3;
//        
//        int w[] = {3, 4, 5};
//        int p[] = {4, 5, 6};
//        int c[][] = BackPack_Solution(m, n, w, p);
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                System.out.print(c[i][j] + "\t");
//                if (j == m) {
//                    System.out.println();
//                }
//            }
//        }
////        printPack(c, w, m, n);
//
//    }

    /**
     * @param m 背包总容量
     * @param n 物品数量
     * @param w 各物品所占空间
     * @param p 各物品的价值
     */
    public static int[][] BackPack_Solution(int m, int n, int[] w, int[] p) {
        //c[i][v]表示前i件物品装入容量为v的背包所能得到的最大总价值
        //c[i][m]=max{c[i-1][m-w[i]]+p[i] , c[i-1][m]}
        int c[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            c[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //褰撶墿鍝佷负i浠堕噸閲忎负j鏃讹紝濡傛灉绗琲浠剁殑閲嶉噺(w[i-1])灏忎簬閲嶉噺j鏃讹紝c[i][j]涓轰笅鍒椾袱绉嶆儏鍐典箣涓�锛�
                //(1)鐗╁搧i涓嶆斁鍏ヨ儗鍖呬腑锛屾墍浠[i][j]涓篶[i-1][j]鐨勫��
                //(2)鐗╁搧i鏀惧叆鑳屽寘涓紝鍒欒儗鍖呭墿浣欓噸閲忎负j-w[i-1],鎵�浠[i][j]涓篶[i-1][j-w[i-1]]鐨勫�煎姞涓婂綋鍓嶇墿鍝乮鐨勪环鍊�
                if (w[i - 1] <= j) {
                    if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1])) {
                        c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
                    } else {
                        c[i][j] = c[i - 1][j];
                    }
                } else {
                    c[i][j] = c[i - 1][j];
                }
            }
        }
        return c;
    }
}