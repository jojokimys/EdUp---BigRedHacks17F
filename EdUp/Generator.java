
public class Generator {
    private double result;
    private String problem;
    private char operator;

    public static void main(String[] args) {
        Generator gen = new Generator();
        gen.random();
    }

    private int randBetween(int low, int high){
        return (int) Math.round(Math.random() * (high - low)) + low;
    }

    private void compute(int diff) {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        if (diff == 1) {
            a = randBetween(0, 99);
            b = randBetween(0, 99);
            if(operator == '+') {
                result = a + b;
            } else if(operator == '-') {
                result = a - b;
            } else if(operator == '*') {
                result = a * b;
            } else if(operator == '/') {
                result = (double) a / b;
            }
            problem = "" + a + " " + operator + " " + b + "";
        } else if (diff == 2) {
            a = randBetween(0, 999);
            b = randBetween(0, 999);
            if(operator == '+') {
                result = a + b;
            } else if(operator == '-') {
                result = a - b;
            } else if(operator == '*') {
                result = (a * b);
            } else if(operator == '/') {
                result = (double) a / b;
            }
            problem = "" + a + " " + operator + " " + b + "";
        } else if (diff == 3) {
            a = randBetween(0, 99);
            b = randBetween(0, 99);
            c = randBetween(0, 99);
            d = randBetween(0, 99);
            if(operator == '+') {
                result = (a/c) + (b/d);
            } else if(operator == '-') {
                result = (a/c) - (b/d);
            } else if(operator == '*') {
                result = (a/c) * (b/d);
            } else if(operator == '/') {
                result = (double) (a/c) / (b/d);
            }
            problem = "" + a + "/" + c + " " + operator + " " + b + "/" + d;
        } else if (diff == 4) {
            a = randBetween(0, 999);
            b = randBetween(0, 999);
            c = randBetween(0, 999);
            d = randBetween(0, 999);
            e = randBetween(0, 999);
            f = randBetween(0, 999);
            if(operator == '+') {
                result = ((double) a/c) + ((double) b/d) + ((double) e/f);
            } else if(operator == '-') {
                result = ((double) a/c) - ((double) b/d) - ((double) e/f);
            } else if(operator == '*') {
                result = ((double) a/c) * ((double) b/d) * ((double) e/f);
            } else if(operator == '/') {
                result = (double) ( ((double)a/c) /  ((double) b/d)) / ((double) e/f);
            }
            problem = "" + a + "/" + c + " " + operator + " " + b + "/" + d + " " + operator + " " + e + "/" + f;
        }
    }

    public Problem makeProblem(int lvl, int diff){
        switch(lvl){
            case 1:
                operator = '+';
                compute(diff);
                break;
            case 2:
                operator = '-';
                compute(diff);
                break;
            case 3:
                operator = '*';
                compute(diff);
                break;
            case 4:
                operator = '/';
                compute(diff);
                break;
            case 5:
                switch (randBetween(1,4)) {
                    case 1:
                        operator = '+';
                        compute(diff);
                        break;
                    case 2:
                        operator = '-';
                        compute(diff);
                        break;
                    case 3:
                        operator = '*';
                        compute(diff);
                        break;
                    case 4:
                        operator = '/';
                        compute(diff);
                        break;
                    default:
                        operator = '\0';
                        result = Double.NaN;
                }
                break;
            default:
                operator = '\0';
                result = Double.NaN;
        }
        Problem problem1 = new Problem(problem,result);
        return problem1;
    }

    public void random(){
        Problem prob = makeProblem(5,4);
        System.out.println(prob.toString());
    }
}
