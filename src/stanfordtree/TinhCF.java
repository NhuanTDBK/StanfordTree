/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stanfordtree;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author Nhuan
 */
public class TinhCF {

    private Stack<String> stack;
    private String luat;

    public String getLuat() {
        return luat;
    }

    public void setLuat(String luat) {
        this.luat = luat;
    }

    public Stack<String> getStack() {
        return stack;
    }

    public void setStack(Stack<String> stack) {
        this.stack = stack;
    }

    public TinhCF() {
        stack = new Stack<>();
    }

    public TinhCF(String luat) {
        stack = new Stack<>();
        this.luat = luat;
    }

    public String chuanhoaLuat(String rule) {
        String result = null;
        rule = rule.replace(" ", "");
        rule = rule.replace("(", ",(,");
        rule = rule.replace(")", ",),");
        rule = rule.replace("^", ",^,");
        rule = rule.replace("v", ",v,");
        rule = rule.replace("", "");
        rule = rule.replace("!", "!,");
        rule = rule.replace(",,", ",");
        if (rule.charAt(0) == ',') {
            rule = rule.substring(1, rule.length());
        }
        return rule;
    }

    public float phanTichLuat() {
        float result = 0;
        Stack<Float> value = new Stack<>();
        Stack<String> ops = new Stack<>();
        String luat = chuanhoaLuat(this.getLuat());
        StringTokenizer token = new StringTokenizer(luat, ",");
        while (token.hasMoreTokens()) {
            String a = token.nextToken();
            if (isOperator(a)) {
                ops.push(a);
            } else if (a.equals("(")) {
                ops.add(a);
            } else if (a.equals(")")) {
                while (!ops.peek().equals("(")) {
                    value.push(applyOps(ops.pop(), value));
                }
                ops.pop();
            } else if (!isOperator(a)) {
                float getCF = StanfordTreeController.lstSuKien.getValue(a);
                if (getCF == 0) {
                    getCF = deQuiTinhCF(a);
                }
                value.push(getCF);
            }

        }
        while (!ops.isEmpty()) {
            value.push(applyOps(ops.pop(), value));
        }
        result = value.pop();
        return result;
    }

    public boolean isOperator(byte b) {
        if (b == '^' || b == 'v' || b == '!') {
            return true;
        }
        return false;
    }

    public boolean isOperator(String b) {
        final String[] ops = {"v", "^", "!"};
        return Arrays.asList(ops).contains(b);
    }

    private Float applyOps(String ops, Stack<Float> stack) {
        float result = 0;
        float val1 = stack.pop();
        float val2 = 0;
        SuKien s1 = new SuKien("temp1", val1);
        SuKien s2 = new SuKien("temp2", val2);
        if (ops.equals("^")) {

            val2 = stack.pop();
            s2.setGiaTri(val2);
            result = s1.and(s2);
        } else if (ops.equals("v")) {
            val2 = stack.pop();
            s2.setGiaTri(val2);
            result = s1.or(s2);

        } else if (ops.equals("!")) {

            result = s1.not();
        }
        return result;
    }

    private float deQuiTinhCF(String tenSuKien) {
        Luat l1 = StanfordTreeController.lstLuat.getLuat(tenSuKien);
        return l1.tinhCFKetLuan();
    }
}
