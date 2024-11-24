import java.util.ArrayList;
import java.util.regex.Pattern;

public class InternalCalculator {
    private final Pattern isNumberPattern = Pattern.compile("-?[0-9]", Pattern.CASE_INSENSITIVE);
    private final Pattern isDecimalPattern = Pattern.compile("-?[0-9]+.[0-9]*", Pattern.CASE_INSENSITIVE);
    private final Pattern MDPattern = Pattern.compile("[*/%]");
    private final Pattern ASPattern = Pattern.compile("[+-]");
    private final ArrayList<String> calc;

    InternalCalculator() {
        calc = new ArrayList<>();
    }

    private boolean isNumber(String input){
        return isNumberPattern.matcher(input).matches();
    }

    private boolean isDecimal(String input) {
        return isDecimalPattern.matcher(input).matches();
    }

    private boolean getMD(String input) {
        return MDPattern.matcher(input).matches();
    }

    private boolean getAS(String input) {
        return ASPattern.matcher(input).matches();
    }

    public void input(String thing) {
        if (calc.isEmpty() && (isNumber(thing) || thing.equals("."))) {// first thing should be a number
            if (thing.equals(".")) {
                calc.add("0" + thing);
            } else {
                calc.add(thing);
            }
        } else if (isNumber(thing) || thing.equals(".")){ // Thing to add is a number or a dot
            if (isDecimal(calc.getLast()) && thing.equals(".")) return; // If the last number has a dot and thing to add is a dot, do nothing.
            if (isNumber(calc.getLast()) && (isNumber(thing) || thing.equals("."))) { // Last thing is a number without a decimal point
                calc.set(calc.size()-1, calc.getLast().concat(thing));
            } else if (isDecimal(calc.getLast()) && isNumber(thing)) { // Last thing is a decimal number
                calc.set(calc.size()-1, calc.getLast().concat(thing));
            } else if ((getMD(calc.getLast()) || getAS(calc.getLast())) && thing.equals(".")) { // Last thing is an action and thing to add is a decimal.
                calc.add("0" + thing);
            } else {
                calc.add(thing);
            }
        }else if (getMD(thing) || getAS(thing)) { // Thing to add is an action
            if (getMD(calc.getLast()) || getAS(calc.getLast())){ // last item is action
                calc.set(calc.size()-1, thing);
            } else { // last item is number
                calc.add(thing);
            }
        }
    }

    public void erase(String thing) {
        if (thing.equals("C")) {
            calc.removeIf((e) -> true);
        } else {
            calc.removeLast();
        }
    }

    public void total() {
        int total = calc.size();
        while (total > 2) {
            for (int i = 0; i < total-1; i++) {
                if (getMD(calc.get(i+1))) {
                    float num1 = Float.parseFloat(calc.get(i));
                    float num2 = Float.parseFloat(calc.get(i+2));
                    if (calc.get(i+1).equals("*")) {
                        calc.set(i, "" + (num1 * num2));
                    } else if (calc.get(i+1).equals("/")) {
                        calc.set(i, "" + (num1 / num2));
                    } else {
                        calc.set(i, "" + (num1 % num2));
                    }
                    calc.remove(i+2);
                    calc.remove(i+1);
                    total -= 2;
                }
            }
            for (int i = 0; i < total-1; i++){
                if (getAS(calc.get(i+1))) {
                    float num1 = Float.parseFloat(calc.get(i));
                    float num2 = Float.parseFloat(calc.get(i + 2));
                    if (calc.get(i+1).equals("+")){
                        calc.set(i, "" + (num1 + num2));
                    } else if (calc.get(i+1).equals("-")){
                        calc.set(i, "" + (num1 - num2));
                    }
                    calc.remove(i+2);
                    calc.remove(i+1);
                    total -= 2;
                }
            }
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(" ");
        for (String i : calc){
            s.append(i);
            s.append(" ");
        }
        return s.toString();
    }
}
