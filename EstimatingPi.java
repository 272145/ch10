public class EstimatingPi {
    public static void main(String[] args) {
        Fraction milu = new Fraction(355, 113);
        final double EPSILON = Math.abs(Math.PI - milu.toDouble());
        Fraction approximation = new Fraction(3, 1);
        
        while (Math.abs(Math.PI - approximation.toDouble()) >= EPSILON) {
			
            if (approximation.toDouble() < Math.PI) {
				
                approximation.setNum(approximation.getNum() + 1);
                
            } else {
				
                approximation.setDenom(approximation.getDenom() + 1);
                
            }
        }
        System.out.println(approximation);
    }
}
