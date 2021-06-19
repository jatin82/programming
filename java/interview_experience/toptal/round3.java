// Question 1 similar to coin change
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = getChange(5, 0.99f);
        for (int i = 0; i < coins.length; i++) {
            System.out.print(coins[i] + ","); // should return [1,0,0,0,0,4]
        }

        System.out.println();
        coins = getChange(3.14f, 1.99f); // should return [0,1,1,0,0,1]
        for (int i = 0; i < coins.length; i++) {
            System.out.print(coins[i] + ",");
        }

        System.out.println();
        coins = getChange(3f, 0.01f); // should return [4,0,2,1,1,2]
        for (int i = 0; i < coins.length; i++) {
            System.out.print(coins[i] + ",");
        }

        System.out.println();
        coins = getChange(4f, 3.14f); // should return [1,0,1,1,1,0]
        for (int i = 0; i < coins.length; i++) {
            System.out.print(coins[i] + ",");
        }

        System.out.println();
        coins = getChange(0.45f, 0.34f); // should return [1,0,1,0,0,0]
        for (int i = 0; i < coins.length; i++) {
            System.out.print(coins[i] + ",");
        }
        System.out.println();
    }


    public static int[] getChange(float M, float P) {
        float[] a = new float[]{0.01f, 0.05f, 0.10f, 0.25f, 0.50f, 1f};
        int returnMoney = (int) ((M * 100f) - (P * 100f));

        int[] coins = new int[a.length];
        int index = a.length - 1;

        while (returnMoney != 0) {
            int ai = (int) (a[index] * 100f);
            if (returnMoney >= ai) {
                returnMoney -= ai;
                coins[index]++;
            } else {
                index--;
            }
        }
        return coins;
    }
}

// Spiral Array
public class RobotDirection {

    public static void main(String[] args) {
        System.out.println(robotDirectionAfter(0.3f)); // 'S';
        System.out.println(robotDirectionAfter(7.25f)); // ‘N’
        System.out.println(robotDirectionAfter(1.20f)); // ‘E’
        System.out.println(robotDirectionAfter(19.62f)); // ‘W
    }

    public static char robotDirectionAfter(float dist) {
        int d = Math.round(dist * 100f);
        int stepCount = 10;
        int shift = 0;
        while (d != 0) {
            if (d <= (stepCount * 3)) {
                if (d <= stepCount) return dir(0, shift);
                else if (d <= stepCount * 2) return dir(1, shift);
                else return dir(2, shift);
            } else {
                shift += 2;
                d -= (stepCount * 2);
                stepCount += 10;
            }
        }
        return '#';
    }

    public static char dir(int base, int shift) {
        base = (base + shift) % 4;
        if (base == 0) return 'N';
        else if (base == 1) return 'E';
        else if (base == 2) return 'S';
        else return 'W';
    }

}
