package by.it.zmushko.calculator;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String expression = scanner.nextLine();
            if (!expression.equals("end")) {
                Var resultVar = null;
                try {
                    resultVar = parser.evaluate(expression);
                    printer.print(resultVar);
                }
                catch (CalcException e){
                    printer.print(e);
                }
            } else {
                break;
            }
        }

        Var var = VarCreator.build("{123, 4.0}");
        printer.print(var);
    }
}
