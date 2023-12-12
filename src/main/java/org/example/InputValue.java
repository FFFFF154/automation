package org.example;

import java.util.Scanner;

public class InputValue {
    private Double pk;
    private static final Scanner SCANNER = new Scanner(System.in);
    public double inputPressure() throws PressureException { // Ввод давления
        if (pk == null) { // Единичный ввод
            System.out.println("Введите значение давления из диапазона 20...24 МПа");
            pk = Double.parseDouble(SCANNER.nextLine());
            if (pk < 20 || (pk > 24)) { // Проверка на корректность ввода
                throw new PressureException("Введите давлениe из диапазона 20...24");
            }
        }
        return pk;
    }
}
