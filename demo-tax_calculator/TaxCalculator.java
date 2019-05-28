public class TaxDemo {
    public static void main(String[] args) {
        // 3193.4
        final double salary = 15053;
        final double takeOut = salary - 1234 - 308.5 - 771 - 77.2 - 5000 - 1500 -2000;

        System.out.println("原先纳税： " + 556.23 * 12);

        double sumTax = 0;
        for(int i = 0; i < 12; i++) {
            double sa = takeOut * (i + 1);
            double[] rate = rate(sa);
            double tax = rate[0] * sa - sumTax - rate[1];
            System.out.println((i +  1) + "; " + tax);
            sumTax += tax;
        }

        System.out.println("sum :" + sumTax);
    }

    public static double[] rate(double d) {
        if(d < 36000.0) {
            return new double[]{0.03, 0};
        } else if(d > 36000 && d < 144000) {
            return new double[]{0.1, 2520};
        }

        return new double[]{0.2, 16920};
    }

}
