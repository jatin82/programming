package com.toptal;

import java.util.*;

public class Q1 {

    public static void main(String[] args) {
        System.out.println(solution(2014, "April","May","Wednesday"));
    }

    public static String solution1(String[] A, String[] B, String P) {
        List<String> matches = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (B[i].contains(P)) matches.add(A[i]);
        }
        Collections.sort(matches);
        if (matches.isEmpty()) {
            return "NO CONTACT";
        } else return matches.get(0);

    }

    public static String solution2(String s) {
        // write your code in Java SE 8
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                len++;
                sb.append(c);
            }
            if ((i != s.length() - 1) && len == 3) {
                len = 0;
                sb.append('-');
            }
        }

        if (sb.length() > 2) {
            if (!Character.isDigit(sb.charAt(sb.length() - 2))) {
                char c = sb.charAt(sb.length() - 3);
                sb.setCharAt(sb.length() - 3, '-');
                sb.setCharAt(sb.length() - 2, c);
            }
        }

        return sb.toString();
    }

    public static int solution(int year, String startMonth, String endMoth, String weekday) {
        Calendar startCal = Calendar.getInstance();
        startCal.set(Calendar.YEAR,year);
        startCal.set(Calendar.MONTH,getMonth(startMonth)-1);
        startCal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        startCal.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
        int startWeak = startCal.get(Calendar.WEEK_OF_YEAR);

        Calendar endCal = Calendar.getInstance();
        endCal.set(Calendar.YEAR,year);
        endCal.set(Calendar.MONTH,getMonth(endMoth)-1);
        endCal.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
        endCal.set(Calendar.DAY_OF_WEEK_IN_MONTH, -1);

        int endWeak = endCal.get(Calendar.WEEK_OF_YEAR);
        return endWeak - startWeak;
    }

    private static int getMonth(String month){
        if(month.equals("January")) return 1;
        else if(month.equals("February")) return 2;
        else if(month.equals("March")) return 3;
        else if(month.equals("April")) return 4;
        else if(month.equals("May")) return 5;
        else if(month.equals("June")) return 6;
        else if(month.equals("July")) return 7;
        else if(month.equals("August")) return 8;
        else if(month.equals("September")) return 9;
        else if(month.equals("October")) return 10;
        else if(month.equals("November")) return 11;
        else if(month.equals("December")) return 12;
        return -1;
    }

    private static int getWeek(String week){
        if(week.equals("Monday")) return Calendar.MONDAY;
        else if(week.equals("Tuesday")) return Calendar.TUESDAY;
        else if(week.equals("Wednesday")) return Calendar.WEDNESDAY;
        else if(week.equals("Thursday")) return Calendar.THURSDAY;
        else if(week.equals("Friday")) return Calendar.FRIDAY;
        else if(week.equals("Saturday")) return Calendar.SATURDAY;
        else if(week.equals("Sunday")) return Calendar.SUNDAY;
        return -1;
    }

    public static boolean solution4(int n, int[] a, int[] b) {

        List<Set<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) ls.add(new HashSet<>());
        for (int i = 0; i < a.length; i++) {
            ls.get(a[i] - 1).add(b[i] - 1);
            ls.get(b[i] - 1).add(a[i] - 1);
        }
        n--;
        int current = 0;
        while(current != n){
            int next = current + 1;
            if(!ls.get(current).contains(next)) return false;
            current = next;
        }
        return true;
    }

}
