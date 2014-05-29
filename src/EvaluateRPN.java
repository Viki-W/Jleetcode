public class EvaluateRPN {
    public int evalRPN(String[] tokens) {
        Stack<String> stk = new Stack<String>();
        int left = 0, right = 0;
        for (String token : tokens){
            if (token.codePointAt(0) < 48 && token.length() == 1){ //operator
                right = Integer.parseInt(stk.pop());
                left = Integer.parseInt(stk.pop());
            }
            switch (token){
                case "+":
                    stk.push(Integer.toString(left + right));
                    break;
                case "-":
                    stk.push(Integer.toString(left - right));
                    break;
                case "*":
                    stk.push(Integer.toString(left * right));
                    break;
                case "/":
                    stk.push(Integer.toString(left / right));
                    break;
                default: //number
                    stk.push(token);
            }
        }
        
        return  Integer.parseInt(stk.pop());        
    }
}