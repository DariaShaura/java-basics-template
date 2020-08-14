package com.epam.izh.rd.online.service;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     * <p>
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        if (value1 < value2) {
            return -1;
        } else if (value1 > value2) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        return Math.max(value1, value2);
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        int answer = Integer.MIN_VALUE;

        for (int v : values) {
            if (answer < v) {
                answer = v;
            }
        }
        return answer;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int sum = 0;

        for (int v : values) {
            sum += v;
        }

        return sum;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        int[] evenDigitsArray;
        int[] tempArray = new int[values.length];
        int numEvenDigits = 0;

        for (int v : values) {
            if ((v % 2) == 0) {
                tempArray[numEvenDigits] = v;
                numEvenDigits++;
            }
        }

        evenDigitsArray = new int[numEvenDigits];
        System.arraycopy(tempArray, 0, evenDigitsArray, 0, numEvenDigits);

        return evenDigitsArray;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {
        long factorial = 1;

        if (initialVal > 0) {
            for (int i = 1; i <= initialVal; i++) {
                factorial *= i;
            }
        }
        return factorial;
    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     * <p>
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     * <p>
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {

        switch (number) {
            case 0:
                return 0;
            case 1:
                return 1;
        }

        long fibNumber = 1;
        long prevNumber = 0;
        long tempNumber;

        for (int i = 2; i <= number; i++) {
            tempNumber = fibNumber;
            fibNumber = fibNumber + prevNumber;
            prevNumber = tempNumber;
        }

        return fibNumber;
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        int[] sortedValues = new int[values.length];
        System.arraycopy(values, 0, sortedValues, 0, values.length);
        int t;

        for (int i = 1; i < sortedValues.length; i++) {
            for (int j = sortedValues.length - 1; j >= i; j--) {
                if (sortedValues[j - 1] > sortedValues[j]) {
                    t = sortedValues[j - 1];
                    sortedValues[j - 1] = sortedValues[j];
                    sortedValues[j] = t;
                }
            }
        }

        return sortedValues;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     * <p>
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        int i = 2;

        while ((number % i) > 0) {
            i++;
        }

        return i == number;
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     * <p>
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        int size = values.length;
        int[] reverseValues = new int[size];

        for (int i = 0; i < size; i++) {
            reverseValues[i] = values[size - 1 - i];
        }

        return reverseValues;
    }
}
