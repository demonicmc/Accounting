package ru.accounting;

import ru.accounting.excel.Excel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by set on 04.03.17.
 */
public class Agregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Excel excel = new Excel();
        String str = null;
        Income income = new Income();
        Expenses expenses = new Expenses();


        while (true){
            menu();
            System.out.println("Выберите действие:");
            int n = Integer.parseInt(reader.readLine());

            if (n==1){

                str = reader.readLine();
                if (!str.equals(""))
                    income.addIn(str);
            }
            if (n==2){

                str = reader.readLine();
                if (!str.equals("")){
                    expenses.addEx(str);
                }
            }

            if (n==3){
                double monthIn = income.balanceMonth();
                System.out.println("Доход за месяц: " + monthIn);}
            if (n ==4 ){
                double monthEx = expenses.balanceMonth();
                System.out.println("Расход за месяц: " + monthEx);}
            if (n==5){
                double yearIn = income.balanceYear();
                System.out.println("Доход за год " + yearIn);
            }
            if (n == 6){
                double yearEx = expenses.balanceYear();
                System.out.println("Расход за год: " + yearEx);
            }

            if (n == 7){
                double differenceMonth = income.balanceMonth() - expenses.balanceMonth();
                System.out.println("Баланс: " + differenceMonth);
            }

            if (n == 8){
               break;
//                System.exit(0);
            }
        }


            excel.method1(income,expenses);


//        double differenceYear = yearIn - yearEx;


//        System.out.println("Месячный доход: " + monthIn + " Доход за год: " + yearIn);
//        System.out.println("Месячный расход: " + monthEx + " Расход за год: " + yearEx);

    }

    public static void menu(){
        System.out.println("1. Добавить в доходы");
        System.out.println("2. Добавить в расходы");
        System.out.println("3. Вывести доходы за месяц");
        System.out.println("4. Вывести расходы за месяц");
        System.out.println("5. Вывести доход за год");
        System.out.println("6. Вывести расход за год");
        System.out.println("7. Баланс");
        System.out.println("8. Выход");
    }

}
