package problem;

/**
 * Created by xavy_ on 9/17/2017.
 */

public class Problem {
    private String problem;
    private double result;

    public Problem(String problem, double result) {
        this.problem = problem;
        this.result = result;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return problem /*+ " = " + result*/;

    }
}