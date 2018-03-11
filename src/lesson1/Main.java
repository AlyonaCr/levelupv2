package lesson1;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

     CoffeeMachine coffeeMachine = new CoffeeMachine(null, 0, 0 , null);

        System.out.println("Before: " + coffeeMachine.concatString());

        ArrayList<String> groupOfSigns = new ArrayList<String>();

        ArrayList <String> fields = new ArrayList <String>();

        File text = new File("item.txt");
        try {
            FileInputStream inputStream = new FileInputStream(text);

            byte[] buffer = new byte[(int)text.length()];
            while (inputStream.read(buffer) > 0) {
                String input = new String(buffer);
                char[] sequence = input.toCharArray();

                for (int i = 0; i < sequence.length; i++) {
                    String a = String.valueOf(sequence[i]);
                        groupOfSigns.add(a);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        String newStr = "";
        for (int i = 0; i < groupOfSigns.size(); i++) {

            if ((!newStr.equals(""))&&(groupOfSigns.get(i).equals(","))) {

                    fields.add(newStr);
                    newStr = "";
                

                }else if ((!newStr.equals(""))&&(i == (groupOfSigns.size()-1))) {
                    StringBuffer stringBuffer = new StringBuffer(newStr);
                    stringBuffer.append(newStr += groupOfSigns.get(i));
                    fields.add(newStr);
                    newStr = "";

                } else {

                StringBuffer stringBuffer = new StringBuffer(newStr);
                stringBuffer.append(newStr += groupOfSigns.get(i));
            }

        }

            Class coffeeMachineClass = coffeeMachine.getClass();

            for (int i = 0; i < fields.size(); i++) {
                if (i == 0) {

                    Field brandField = coffeeMachineClass.getDeclaredField("brand");
                    brandField.setAccessible(true);
                    brandField.set(coffeeMachine, fields.get(i));

                } else if (i == 1) {

                    Field typeOfCoffeeMachineField = coffeeMachineClass.getDeclaredField("typeOfCoffeeMachine");
                    typeOfCoffeeMachineField.setAccessible(true);
                    typeOfCoffeeMachineField.set(coffeeMachine, fields.get(i));

                } else if (i == 2) {

                    Field weightField = coffeeMachineClass.getDeclaredField("weight");
                    weightField.setAccessible(true);
                    double reverseWeight = Double.parseDouble(fields.get(i));
                    weightField.set(coffeeMachine, reverseWeight);

                } else if (i == 3) {
                    Field powerField = coffeeMachineClass.getDeclaredField("power");
                    powerField.setAccessible(true);
                    double reversePower = Double.parseDouble(fields.get(i));
                    powerField.set(coffeeMachine, reversePower);


                } else if (i == 4) {

                    Field typeOfCoffeeField = coffeeMachineClass.getDeclaredField("typeOfCoffeeMachine");
                    typeOfCoffeeField.setAccessible(true);
                    typeOfCoffeeField.set(coffeeMachine, fields.get(i));
                }

            }

            System.out.println("After: " + coffeeMachine.concatString());
        }


    }
