import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws MyException {
        //Main c = new Main();
        Scanner s = new Scanner(System.in);
        System.out.println("введите выражение");
        String str  = s.nextLine();

        String result = Main.calc(str);

        System.out.println(result);

    }
}

class Main {
    public static String calc(String input) throws MyException {
        //System.out.println("арифметическая операция...");
        String expr = input;
        String[] romN = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        List<String> romList = new ArrayList<>(Arrays.asList(romN));
        expr = expr.replaceAll("\\s+", ""); // if any spaces or tabs
        String [] arrExpr = expr.split("(?=[+-/*])|(?<=[+-/*])");
        if (arrExpr.length != 3) {
            throw new MyException("Должны быть 2 операнда и 1 оператор!");
        }
        int leftNum = 0;
        int rightNum = 0;
        int leftRom;
        int rightRom;
        int resRom = 0;
        if ((romList.contains(arrExpr[0])) && (romList.contains(arrExpr[2]))) {
            leftRom = romList.indexOf(arrExpr[0])+1;
            rightRom = romList.indexOf(arrExpr[2])+1;
            switch (arrExpr[1]) {
                case ("+"):
                    resRom = leftRom + rightRom;
                    break;
                case ("-"):
                    resRom = leftRom - rightRom;
                    break;
                case ("*"):
                    resRom = leftRom * rightRom;
                    break;
                case ("/"):
                    resRom = leftRom / rightRom;
                    break;
            }
            if (resRom <= 0) {
                throw new MyException("Результатом операции над римскими числами должно быть полож. число");
            }
            String a = romanConverter(resRom); //временно
            return a;

        } else {
            try {
            leftNum = Integer.parseInt(arrExpr[0]);
            rightNum = Integer.parseInt(arrExpr[2]);
            if ((leftNum <= 0) || (leftNum > 10)) {
                throw new MyException("Число слева должно быть от 1 до 10");
            } else if ((rightNum <= 0) || (rightNum > 10)) {
                throw new MyException("Число справа должно быть от 1 до 10");
            }
        }
        catch (Exception e) {
            throw e;
        }
        }
        int res =0;
        switch (arrExpr[1]) {
            case ("+"):
                res = leftNum + rightNum;
                break;
            case ("-"):
                res = leftNum - rightNum;
                break;
            case ("*"):
                res = leftNum * rightNum;
                break;
            case ("/"):
                res = leftNum / rightNum;
                break;
        }

        return Integer.toString(res);
    }

    public static String romanConverter(int number) {
        String resRom = "";
        int arabic = number;
        int j = RomanNum.values().length - 1;
        while (j>=0) { // == 8
            if (RomanNum.values()[j].getNumber() == arabic) {
                resRom = resRom + RomanNum.values()[j];
                break;
            }
            if (RomanNum.values()[j].getNumber() < arabic) {
                resRom = resRom + RomanNum.values()[j];
                arabic = arabic - RomanNum.values()[j].getNumber();
                if (RomanNum.values()[j].getNumber() == arabic) {
                    resRom = resRom + RomanNum.values()[j];
                    break;
                }
            }
            else j--;

        }
        return resRom;   //Arrays.toString(romValues);
    }
}