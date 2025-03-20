package ru.yandex;

//В нём будет осуществляться преобразование шагов в километры и килокалории.
public class Converter {
    static final double METER_PER_STEP = 0.75;
    static final double KILOCALORIES_PER_STEP = 0.05;

    int convertToKm(int steps) {
        return (int) (steps * METER_PER_STEP);
    }

    int convertStepsToKilocalories(int steps) {
        return (int) (steps * KILOCALORIES_PER_STEP);
    }

}
