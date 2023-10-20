package DataAccess;

import common.Library;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnalysisStringDAO {

    private static AnalysisStringDAO instance = null;
    Library l;

    public AnalysisStringDAO() {
        l = new Library();
    }

    public static AnalysisStringDAO Instance() {
        if (instance == null) {
            synchronized (AnalysisStringDAO.class) {
                if (instance == null) {
                    instance = new AnalysisStringDAO();
                }
            }
        }
        return instance;
    }

    public boolean checkSquareNumber(int n) {
        if (Math.sqrt(n) * Math.sqrt(n) == n) {
            return true;
        }
        return false;
    }

    public void getNumber(String inputString) {
        try {
            HashMap<String, ArrayList<Integer>> hmNumber = new LinkedHashMap<>();
            String number = inputString.replaceAll("\\D+", ",");
            if (number.charAt(0) == ',') {
                number = number.substring(1);
            }
            if (number.charAt(number.length() - 1) == ',') {
                number = number.substring(0, number.length() - 1);
            }
            String[] listNumber = number.split(",");
            int lenNumber = listNumber.length;

            ArrayList<Integer> liPerfectSquare = new ArrayList<>();
            ArrayList<Integer> liOdd = new ArrayList<>();
            ArrayList<Integer> liEven = new ArrayList<>();
            ArrayList<Integer> liAll = new ArrayList<>();
            for (int i = 0; i < lenNumber; i++) {
                int numberCheck = Integer.parseInt(listNumber[i]);
                if (numberCheck % 2 == 1) {
                    liOdd.add(numberCheck);
                }
                if (numberCheck % 2 == 0) {
                    liEven.add(numberCheck);
                }
                if (checkSquareNumber(numberCheck)) {
                    liPerfectSquare.add(numberCheck);
                }
                liAll.add(numberCheck);
            }
            hmNumber.put("Perfect Square Numbers: ", liPerfectSquare);
            hmNumber.put("Odd Numbers: ", liOdd);
            hmNumber.put("Even Numbers: ", liEven);
            hmNumber.put("All Numbers: ", liAll);

            for (Map.Entry m : hmNumber.entrySet()) {
                System.out.println(m.getKey() + " " + m.getValue());
            }
        } catch (Exception e) {
            return;
        }
    }

    public void getCharacter(String inputString) {
        try {
            HashMap<String, String> hmString = new LinkedHashMap<>();
            String uppercase = inputString.replaceAll("\\W|[0-9]|[a-z]", "");
            String lowercase = inputString.replaceAll("\\W|[0-9]|[A-Z]", "");
            String special = inputString.replaceAll("\\w", "");
            String allCharacter = inputString.replaceAll("\\d", "");
            hmString.put("Uppercase: ", uppercase);
            hmString.put("Lowercase: ", lowercase);
            hmString.put("Special: ", special);
            hmString.put("All Character: ", allCharacter);
            for (Map.Entry m : hmString.entrySet()) {
                System.out.println(m.getKey() + " " + m.getValue());
            }
        } catch (Exception e) {
            return;
        }
    }

    public void analysisString() {
        while (true) {
            String inputString = l.inputString("Input String: ");
            System.out.println("-----Result Analysis------");
            getNumber(inputString);
            getCharacter(inputString);
            if (!l.checkInputYN("Do you want continue?(Y/N): ")) {
                System.exit(0);
            }
        }

    }
}
