/*
 * Gokhan Has - 161044067
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This is the part2.java class to convert Infix to Postfix notation and
 * calculate its result.
 * @author gokhanHas
 */
public class part2 {

    /**
     * This is the helper class to used to write the numbers instead of the variables.
     * Such as x = 5 , keeps the x as character and 5 as String.
     */
    private class character {
        /**
         * It keeps the variable name.
         */
        private Character ch;

        /**
         * It keeps the variable's number as a String.
         */
        private String value;

        /**
         * Constructor that initialize variable.
         * @param chc variable name.
         * @param val variable's value.
         */
        public character(char chc,String val) {
            this.ch = chc;
            this.value = val;
        }

        /**
         *
         * @return the variable's value.
         */
        public String getValue() {
            return value;
        }

        /**
         *
         * @return the variable name (such as x,y,z).
         */
        public Character getCh() {
            return ch;
        }

        /**
         *
         * @return character name and its value as a String.
         */
        public String toString() {
            return String.format("Character --> " + ch + "   value --> " + value);
        }
    }

    /**
     * This is the readFile2 method to read variable(s) and infix expression,
     * convert postfix notation by using myStack object and calculate its result then
     * prints on the screen.
     */
    public void readFile2() {
        myStack<character> tempStack = new myStack<character>();
        int chArraySize = 0;
        try {
            boolean control = true;
            BufferedReader inputFile = new BufferedReader(new FileReader("src\\test_file_part2.txt"));
            String expressionString = null;
            String line;
            while ((line = inputFile.readLine()) != null) {

                String[] lineChars = line.split("\n");
                for (String str : lineChars) {

                    if(str.isEmpty()){ // Blank line between variables and expression.
                        control = false;
                    }
                    else {

                        if(control == true) { // get variables and its value
                            String tempString = (str.substring(4));
                            // push the character myStack.
                            tempStack.push(new character(str.charAt(0),tempString));
                            chArraySize++;
                        }
                        else{ //get expression
                            expressionString = str;
                        }
                    }

                }


            }
            inputFile.close(); // close the file

            character[] characterArray = new character[chArraySize];

            for(int k=0;k<chArraySize;k++) // assign the characters object to array
                characterArray[k] = tempStack.pop();


            for(int i=0; i<expressionString.length(); ++i) {
                for (int j = 0; j < characterArray.length; ++j) {

                    if((characterArray[j].getCh() == expressionString.charAt(i))) {
                        String temp = characterArray[j].getValue();
                        // The string takes the values of the variables and writes their values.
                        String newStr2 = expressionString.substring(0,i) + temp + expressionString.substring(i+1,expressionString.length());
                        expressionString = new String(newStr2);
                    }
                }
            }

            String postfixString= postfixNotation(expressionString); // return postfix notation
            System.out.println("Postfix Notation -> " + postfixString);
            double result = calculatePostfixNotation(postfixString); // return result
            System.out.println("RESULT           -> " + result);


        }catch( IOException ioException ) {
            System.out.println("Error! File is not found !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method has been written to test the readedFile2 method.
     * It calls this method.
     */
    public void deneme2() {
        this.readFile2();
    }

    /**
     * Convert infix expression to postfix.
     * @param inputStr the infix expression String
     * @return the postfix notation as a String.
     */
    public String postfixNotation(String inputStr) {

        myStack<String> operators = new myStack<String>();
        String outputSting = "";
        String[] tempString = inputStr.split(" ");
        for(String str: tempString) {

            if(str.equals("sin(") || str.equals("cos(") || str.equals("abs(") ) {

                char[] charArray = new char[3];

                for(int i=0;i<3;i++)
                    charArray[i] = str.charAt(i);

                str = new String(charArray);
                operators.push(str);
                operators.push("(");
            }

            else if(str.equals("(")) {
                operators.push(str);
            }

            else if(str.equals(")")) {
                while(!operators.empty() && !operators.peek().equals("(")) {
                    outputSting += operators.pop() + " ";
                }
                if(operators.peek().equals("(")) {
                    operators.pop();
                }
            }

            else if(isOperator(str)) {
                while(!operators.empty() && ProcessPriority(str) <= ProcessPriority(operators.peek())) {
                    outputSting += operators.pop() + " ";
                }
                operators.push(str);
            }

            else {
                outputSting += str + " ";
            }
        }

        while(!operators.empty()) {
            if(isOperator(operators.peek()) || isMathFunction(operators.peek()))
                outputSting += operators.pop() + " ";
            else
                operators.pop();
        }
        return outputSting;
    }

    /**
     * Calculates the result of the Postfix expression.
     * @param inputStr the postfix string.
     * @return the result of expression.
     * @throws Exception if the something went wrong.
     */
    public double calculatePostfixNotation(String inputStr) throws Exception {

        myStack<String> resultStack = new myStack<String>();

        String[] tempString = inputStr.split(" ");
        for(String str: tempString) {

            double result = 0.0;

            if(isOperator(str)) {

                double parameter1 = Double.parseDouble(resultStack.pop());
                double paremeter2= Double.parseDouble(resultStack.pop());

                switch (str) {
                    case("+"): result = parameter1 + paremeter2; break;
                    case("-"): result = (-1) * (parameter1 - paremeter2); break;
                    case("/"): result = parameter1 / paremeter2; break;
                    case("*"): result = parameter1 * paremeter2; break;
                    default:
                        System.out.println("Something went Wrong. Exception will be throwed !"); throw new Exception();
                }
                resultStack.push(String.valueOf(result));
            }
            else if(isMathFunction(str)) {

                double parameter = Double.parseDouble(resultStack.pop());

                switch(str) {
                    case("sin"): result = myMath.mySin(parameter); break;
                    case("cos"): result = myMath.myCos(parameter); break;
                    case("abs"): result = myMath.myAbs(parameter); break;
                    default:
                        System.out.println("Something went Wrong. Exception will be throwed !"); throw new Exception();
                }
                resultStack.push(String.valueOf(result));
            }
            else {
                resultStack.push(str);
            }
        }

        return Double.parseDouble(resultStack.peek());
    }

    /**
     *
     * @param inputStr
     * @return true if the inputStr is operator(*,/,-,+).
     */
    private boolean isOperator(String inputStr) {
        return (inputStr.equals("*") || inputStr.equals("/") ||
                inputStr.equals("+") || inputStr.equals("-") );
    }

    /**
     *
     * @param inputStr
     * @return true if the inputStr is the functions mentioned in the assignment (sin,cos,abs).
     */
    private boolean isMathFunction(String inputStr) {
        return (inputStr.equals("sin") || inputStr.equals("cos") ||
                inputStr.equals("abs"));
    }

    /**
     *
     * @param inputStr
     * @return 1 if the inputStr is + or - , 2 if the inpuStr is / or *, 3 if the inputStr is mathematical functions mentioned in the assignment (sin,cos,abs), -1 if anything else.
     */
    private int ProcessPriority(String inputStr) {

        if(inputStr.equals("sin") || inputStr.equals("cos") || inputStr.equals("abs"))
            return 3;
        else if (inputStr.equals("/") || inputStr.equals("*"))
            return 2;
        else if(inputStr.equals("+") || inputStr.equals("-"))
            return 1;
        else
            return -1;
    }
}