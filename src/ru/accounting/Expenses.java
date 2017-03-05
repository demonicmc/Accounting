package ru.accounting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by set on 04.03.17.
 */
public class Expenses {
//    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//    String str = reader.readLine();

    public Expenses() throws IOException {

    }

    List<Double> cm = new ArrayList<>();

    public void addEx(String str){
            if (!str.equals("")) {
                double consumption_month = Double.parseDouble(str);
                cm.add(consumption_month);
            }
    }

    public List<Double> getCm() {
        return cm;
    }

    public double balanceMonth(){
        double sum = 0.0;
        for(Double d : cm){
            sum += d;
        }

        return sum;
    }

    public  double balanceYear(){
        return balanceMonth()*12;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expenses expenses = (Expenses) o;

        return cm != null ? cm.equals(expenses.cm) : expenses.cm == null;
    }

    @Override
    public int hashCode() {
        return cm != null ? cm.hashCode() : 0;
    }
}
