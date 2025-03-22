package ru.yandex;


//В нём будут храниться данные конкретного месяца и логика по подсчёту статистики
public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.printf("День %d: %d\n", i + 1, days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sum = 0;
        for (int day : days) {
            sum += day;
        }
        return sum;
    }

    int maxSteps() {
        int max = 0;
        for (int day : days) {
            if (day > max) {
                max = day;
            }
        }
        return max;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int day : days) {
            if (day >= goalByStepsPerDay) {
                currentSeries++;
            } else {
                currentSeries = 0;
            }
            if (currentSeries > finalSeries) {
                finalSeries = currentSeries;
            }
        }
        return finalSeries;
    }
}
