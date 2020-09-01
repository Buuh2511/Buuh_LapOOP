/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Utils {

    public static Scanner sc = new Scanner(System.in);

    public static Double getDouble(String input, String error, double lowerBound, String error1) {
        double dou;
        while (true) {
            try {
                System.out.print(input);
                dou = Double.parseDouble(sc.nextLine());
                if (dou <= lowerBound) {
                    throw new GreaterThanException(error1);
                } else {
                    return dou;
                }
            } catch (GreaterThanException e) {
                System.out.println(error1);
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    public static String getString(String input, String error) {
        String name;
        while (true) {
            System.out.print(input);
            name = sc.nextLine().trim();
            if (name.length() == 0 || name.isEmpty()) {
                System.out.println(error);
            } else {
                return name;
            }
        }
    }

    public static String getID(String input, String error, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(input);
            id = sc.nextLine().toUpperCase().trim();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false) {
                System.out.println(error);
            } else {
                return id;
            }
        }
    }

    public static double getDouble(String input, String error, double lowerBound, double upperBound, String err1, String err2) {
        double dou;
        while (true) {
            try {
                System.out.print(input);
                dou = Double.parseDouble(sc.nextLine());
                if (dou < lowerBound) {
                    throw new LessThanException(err1);
                } else if (dou > upperBound) {
                    throw new GreaterThanException(err2);
                } else {
                    return dou;
                }
            } catch (LessThanException e) {
                System.out.println(err1);
            } catch (GreaterThanException e) {
                System.out.println(err2);
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

    public static String check(String input, String error1) {
        String check;
        while (true) {
            System.out.print(input);
            check = sc.nextLine().trim().toUpperCase();
            if (check.length() == 0 || check.isEmpty()) {
                System.out.println(error1);
            } else if (check.equalsIgnoreCase("Y") || check.equalsIgnoreCase("N")) {
                return check;
            }
        }
    }

    public static int getInt(String input, String err, int lowerBound, int upperBound, String err1, String err2) {
        int integer;
        while (true) {
            try {
                System.out.print(input);
                integer = Integer.parseInt(sc.nextLine());
                if (integer < lowerBound) {
                    throw new GreaterThanException(err1);
                } else if (integer > upperBound) {
                    throw new LessThanException(err2);
                } else {
                    return integer;
                }
            } catch (GreaterThanException e) {
                System.out.println(err1);
            } catch (LessThanException e) {
                System.out.println(err2);
            } catch (Exception e) {
                System.out.println(err);
            }
        }
    }
    
    public static String getDate(){
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }
}
