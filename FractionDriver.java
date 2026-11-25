public class FractionDriver {
    public static void main(String[] args) {
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction("1/3");
        Fraction c = new Fraction(a);
        Fraction sum = new Fraction();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(sum);

        System.out.println(a.getNum());
        System.out.println(a.getDenom());
        System.out.println(a.toDouble());

        c.setNum(6);
        c.setDenom(8);
        System.out.println(c);

        c.reduce();
        System.out.println(c);

        System.out.println(Fraction.multiply(a, b));
        System.out.println(Fraction.divide(a, b));
        System.out.println(Fraction.add(a, b));
        System.out.println(Fraction.subtract(a, b));

        Fraction seventh = new Fraction(1, 7);

        for (int i = 0; i < 7; i++) {
            sum = Fraction.add(sum, seventh);
        }

        System.out.println(sum);
    }
}
