/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_eddi;

/**
 *
 * @author josue
 */
public class CalculadoraMat {

    private ArrayList numeros = new ArrayList();
    private ArrayList operandos = new ArrayList();

    CalculadoraMat() {

    }

    public String Resolver(String formula) {
        try {
            formula = formula.replace('÷', '/');
            formula = formula.replace('x', '*');
            String[] nums = formula.split("\\+|\\-|\\/|\\*");
            float[] num = new float[nums.length];
            for (int i = 0; i < nums.length; i++) {
                num[i] = Float.parseFloat(nums[i]);
            }

            for (int i = 0; i < num.length; i++) {
                numeros.add(num[i]);
            }
            for (int i = 0; i < formula.length(); i++) {
                switch (formula.charAt(i)) {
                    case '+':
                        operandos.add(formula.charAt(i));
                        break;
                    case '-':
                        operandos.add(formula.charAt(i));

                        break;
                    case '/':
                        operandos.add(formula.charAt(i));
                        break;
                    case '*':
                        operandos.add(formula.charAt(i));
                        break;
                    default:
                        break;
                }
            }
            while (operandos.contains('*')) {
                numeros.set(operandos.indexOf('*'), ((float) numeros.get(operandos.indexOf('*'))) * ((float) numeros.get(operandos.indexOf('*') + 1)));
                numeros.remove(operandos.indexOf('*') + 1);
                operandos.remove(operandos.indexOf('*'));
            }
            
            while (operandos.contains('/')) {
                numeros.set(operandos.indexOf('/'), ((float) numeros.get(operandos.indexOf('/'))) / ((float) numeros.get(operandos.indexOf('/') + 1)));
                numeros.remove(operandos.indexOf('/') + 1);
                operandos.remove(operandos.indexOf('/'));
            }
            
            while (operandos.contains('-')) {
                numeros.set(operandos.indexOf('-'), ((float) numeros.get(operandos.indexOf('-'))) - ((float) numeros.get(operandos.indexOf('-') + 1)));
                numeros.remove(operandos.indexOf('-') + 1);
                operandos.remove(operandos.indexOf('-'));
            }

            while (operandos.contains('+')) {
                numeros.set(operandos.indexOf('+'), ((float) numeros.get(operandos.indexOf('+'))) + ((float) numeros.get(operandos.indexOf('+') + 1)));
                numeros.remove(operandos.indexOf('+') + 1);
                operandos.remove(operandos.indexOf('+'));
            }

            float resu = (float) (numeros.get(0));
            this.numeros = new ArrayList();
            this.operandos = new ArrayList();
            return resu + "";

        } catch (ArithmeticException e) {
            return "Error 2";
        } catch (Exception e) {
            return "Error 1";
        }
    }

}
