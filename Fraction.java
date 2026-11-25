public class Fraction {
    private int num;
    private int denom;

    public Fraction() {
        num = 0;
        denom = 1;
    }

    public Fraction(int n, int d) {
        if (d == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        num = n;
        denom = d;
    }

    public Fraction(String fraction) {
        int slash = fraction.indexOf("/");
        num = Integer.parseInt(fraction.substring(0, slash));
        denom = Integer.parseInt(fraction.substring(slash + 1));

        if (denom == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
    }

    public Fraction(Fraction other) {
        num = other.num;
        denom = other.denom;
    }

    public int getNum() {
        return num;
    }

    public int getDenom() {
        return denom;
    }

    public String toString() {
        return num + "/" + denom;
    }

    public double toDouble() {
        return (double) num / denom;
    }

    public void setNum(int n) {
        num = n;
    }

    public void setDenom(int d) {
        if (d == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        denom = d;
    }

    private static int gcf(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }

        return a;
    }

    public void reduce() {
        int factor = gcf(num, denom);
        num = num / factor;
        denom = denom / factor;

        if (denom < 0) {
            num = -num;
            denom = -denom;
        }
    }

    public static Fraction multiply(Fraction a, Fraction b) {
        Fraction result = new Fraction(
            a.num * b.num, a.denom * b.denom
        );
        result.reduce();
        return result;
    }

    public static Fraction divide(Fraction a, Fraction b) {
        if (b.num == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }

        Fraction flipped = new Fraction(b.denom, b.num);
        return multiply(a, flipped);
    }

    public static Fraction add(Fraction a, Fraction b) {
        int n = a.num * b.denom + b.num * a.denom;
        int d = a.denom * b.denom;

        Fraction result = new Fraction(n, d);
        result.reduce();
        return result;
    }

    public static Fraction subtract(Fraction a, Fraction b) {
        int n = a.num * b.denom - b.num * a.denom;
        int d = a.denom * b.denom;

        Fraction result = new Fraction(n, d);
        result.reduce();
        return result;
    }
}
