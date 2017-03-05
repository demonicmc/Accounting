package ru.accounting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by set on 04.03.17.
 */
public class Income {



    List<Double> mi = new ArrayList<>();
    public void addIn(String str){
        if (!str.equals("")){
                double monthly_income = Double.parseDouble(str);
                mi.add(monthly_income);
        }
    }


    public double balanceMonth(){
        double sum = 0.0;
        for(Double d : mi){
            sum += d;
        }

        return sum;
    }

    public  double balanceYear(){
        return balanceMonth()*12;
    }


    public Income() throws IOException {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Income income = (Income) o;

        return mi != null ? mi.equals(income.mi) : income.mi == null;
    }

    @Override
    public int hashCode() {
        return mi != null ? mi.hashCode() : 0;
    }
}
