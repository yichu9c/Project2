import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Create a program that estimates the square
 *
 * @author Yihone Chu
 *
 */
public final class Newton3 {
    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton3() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();

        String playAgain = "y";
        while (playAgain.equals("y")) {

            out.println(
                    "A positive number you would like to find the square root of ");
            int n = in.nextInteger();

            out.println("What do you want Epsilon to be? ");
            double epsilon = in.nextDouble();

            out.println(sqrt(n, epsilon));
            out.print("Would you like to play again? ");
            playAgain = in.nextLine();
        }

        in.close();
        out.close();
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @param epsilon
     *            a number that determines how precise estimation is
     * @return estimate of square root
     */
    private static double sqrt(double x, double epsilon) {

        double r = x;

        if (r == 0) {
            return 0;
        }

        while ((Math.abs(r * r - x)) / x > epsilon * epsilon) {
            r = (r + x / r) / 2;
        }
        return r;
    }
}
