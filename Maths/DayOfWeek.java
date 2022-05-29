package Maths;

//https://leetcode.com/problems/day-of-the-week
import java.util.HashMap;
import java.util.Map;

public class DayOfWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        // order should match current day
        String[] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        int currDay = getDays(30, 5, 2022);
        int inputDays = getDays(day, month, year);
        int diff = Math.abs(currDay - inputDays) % 7;
        if (diff == 0) {
            return days[0];
        }
        // If we are ahead then benchmark is the end of the array since the end of the
        // array is the
        // 7 diff (next same day as input day of week)
        if (inputDays < currDay) {
            return days[days.length - diff];
        } else {
            // if current days are behind input then the benchmark is start of array
            // with diff being from the currentday+diff
            return days[diff];
        }
    }

    public int getDays(int day, int month, int year) {
        Map<Integer, Integer> d = new HashMap<>();
        d.put(1, 31);
        d.put(2, 28);
        if (isLeap(year)) {
            d.put(2, 29);
        }
        d.put(3, 31);
        d.put(4, 30);
        d.put(5, 31);
        d.put(6, 30);
        d.put(7, 31);
        d.put(8, 31);
        d.put(9, 30);
        d.put(10, 31);
        d.put(11, 30);
        d.put(12, 31);
        int days = 0;
        for (int i = 1971; i < year; i++) {
            days += 365;
            if (isLeap(i)) {
                days += 1;
            }
        }
        for (int i = 1; i < month; i++) {
            days += d.get(i);
        }
        days += day;
        return days;
    }

    public boolean isLeap(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        if (year % 400 == 0) {
            return true;
        }
        return false;
    }
}