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
    
    /*
Ritam is planning for a vacation to Salasar, Rajasthan. The train for going to Salasar is only available for Monday and 
for coming back from Salasar to his hometown is Sunday. Ritam has start month and end month, and last weekday of end month. 
Consider that her vacation starts on the 1st day of the start month and ends on the last weekday of the end month. 
Find the maximum number of weeks she can stay in Salasar and come back before her end month last weekday.


Example:

Given Year = 2014 , start month = "April" , end Month = "May" and weekday = "Wednesday"
Total number of weeks = 7

Format 
Months = "January", February", "March", "April", "May", "June" "July", "August", "September", "October", "November", "December"
Weekday = "Monday", "Tuesday", "Wednesday", "Thrusday", "Friday", "Saturday", "Sunday"

    */

    public static int solution(int year, String startMonth, String endMoth, String weekday) {
        Calendar startCal = Calendar.getInstance();
        startCal.set(Calendar.YEAR, year);
        startCal.set(Calendar.MONTH, getMonth(startMonth));
        startCal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        startCal.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
        int startWeak = startCal.get(Calendar.WEEK_OF_YEAR);

        Calendar endCal = Calendar.getInstance();
        endCal.set(Calendar.YEAR, year);
        endCal.set(Calendar.MONTH, getMonth(endMoth));
        endCal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        endCal.set(Calendar.DAY_OF_WEEK_IN_MONTH, -1);

        int endWeak = endCal.get(Calendar.WEEK_OF_YEAR);
        if (getWeek(weekday) < Calendar.SUNDAY) endWeak--;
        return endWeak - startWeak;
    }

    private static int getMonth(String month) {
        if (month.equals("January")) return Calendar.JANUARY;
        else if (month.equals("February")) return Calendar.FEBRUARY;
        else if (month.equals("March")) return Calendar.MARCH;
        else if (month.equals("April")) return Calendar.APRIL;
        else if (month.equals("May")) return Calendar.MAY;
        else if (month.equals("June")) return Calendar.JUNE;
        else if (month.equals("July")) return Calendar.JULY;
        else if (month.equals("August")) return Calendar.AUGUST;
        else if (month.equals("September")) return Calendar.SEPTEMBER;
        else if (month.equals("October")) return Calendar.OCTOBER;
        else if (month.equals("November")) return Calendar.NOVEMBER;
        else return Calendar.DECEMBER;
    }

    private static int getWeek(String week) {
        if (week.equals("Monday")) return Calendar.MONDAY;
        else if (week.equals("Tuesday")) return Calendar.TUESDAY;
        else if (week.equals("Wednesday")) return Calendar.WEDNESDAY;
        else if (week.equals("Thursday")) return Calendar.THURSDAY;
        else if (week.equals("Friday")) return Calendar.FRIDAY;
        else if (week.equals("Saturday")) return Calendar.SATURDAY;
        else return Calendar.SUNDAY;
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
