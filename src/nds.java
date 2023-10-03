interface calculatorNalog{
    double nalog(double income);
}
class opv implements  calculatorNalog {
    @Override
    public double nalog(double income) {
        if (income * 0.1 > 350000){
            return 350000;
        }
        return income * (0.1);
    }
}

class co implements  calculatorNalog{
    @Override
    public double nalog(double income){
        if (income * 0.035 > 17150){
            return 17150;
        }
        if(income* 0.035 < 2450){
            return 2450;
        }
        return income * (0.035);
    }
}

class Bosms implements  calculatorNalog{
    @Override
    public double nalog(double income){
        if (income * 0.02 >14000){
            return 14000;
        }
        return income * 0.02;
    }
}

class ipn implements calculatorNalog{
    @Override
    public double nalog(double income){
        return income * (0.1);
    }
}

class bzman{
    private calculatorNalog cal;

    public bzman(calculatorNalog cal){
        this.cal = cal;
    }
    public void setCal(calculatorNalog cal){
        this.cal = cal;
    }
    public double calNal(double zar){
        return cal.nalog(zar);
    }
}


public class nds {
    public static void main(String[] args) {
        double zar = 1000000;

        calculatorNalog nalog = new opv();
        bzman calculator = new bzman(nalog);
        double kk = calculator.calNal(zar);
        System.out.println("Налог по Обязательные пенсионные взносы: "+kk);


        calculatorNalog nalog1 = new co();
        bzman calculator2 = new bzman(nalog1);
        double yy = calculator2.calNal(zar);
        System.out.println("Налог по Социальные отчисления: "+yy);

        double cNal= zar-kk-yy;
        System.out.println("Доход с учета налогов: "+ cNal);
    }
}
