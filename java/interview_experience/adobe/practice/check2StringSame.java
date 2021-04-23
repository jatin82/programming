
public class Driver {
    public static void main(String[] args) {
        System.out.println(isSame("abrtab####c", "#asa##bc"));
    }

    public static boolean isSame(String s1, String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        while (i >= 0 && j >= 0) {
            int skip = 0;
            while (i >= 0 && s1.charAt(i) == '#') {
                i--;
                skip++;
            }
            i -= skip;

            skip = 0;
            while (j >= 0 && s2.charAt(j) == '#') {
                j--;
                skip++;
            }
            j -= skip;

            if (i >= 0 && j >= 0 && s1.charAt(i) != '#' && s2.charAt(j) != '#' && s1.charAt(i--) != s2.charAt(j--))
                return false;
        }
        return isEmpty(s1, i) && isEmpty(s2, j);
    }

    private static boolean isEmpty(String s1, int index) {
        if (index < 0 || s1.isEmpty()) return true;
        for (int i = index; i >= 0; i--) {
            if (s1.charAt(i) != '#') return false;
        }
        return true;
    }

}
