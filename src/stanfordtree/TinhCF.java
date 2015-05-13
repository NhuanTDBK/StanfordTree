/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stanfordtree;

import java.nio.charset.StandardCharsets;
import java.util.Stack;

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

    public float phanTichLuat() {
        byte[] luatParser = this.luat.getBytes(StandardCharsets.US_ASCII);
        
        Stack<Float> value = new Stack<>();
        Stack<Byte> ops = new Stack<>();
        int i = 0;
        while (i < luatParser.length) {
            if (ignoreWhitespace(luatParser[i])) {
                i++;
                continue;
            }
            if (luatParser[i] == 39) {
                StringBuffer buffer = new StringBuffer();
                while (i + 1 < luatParser.length && luatParser[i + 1] != 39) {
                    buffer.append(Character.toString((char) luatParser[++i]));
                }
                i++;
                float result = StanfordTreeController.lstSuKien.getValue(buffer.toString());
                if (result == 0) {
                    result = deQuiTinhCF(buffer.toString());
                }
                value.push(result);
            } else if (luatParser[i] == '(') {
                ops.add(luatParser[i]);
            } else if (luatParser[i] == ')') {
                while (ops.peek() != '(') {
                    value.push(applyOps(ops.pop(), value));
                }
                ops.pop();
            } else if (isOperator(luatParser[i])) {
                ops.push(luatParser[i]);
            }
            i++;
        }
        while (!ops.empty()) {
            value.push(applyOps(ops.pop(),value));
        }
        return value.pop();
    }

    public boolean ignoreWhitespace(byte b) {
        if (b == ' ') {
            return true;
        }
        return false;
    }

    public boolean isOperator(byte b) {
        if (b == '^' || b == 'v' || b == '!') {
            return true;
        }
        return false;
    }
    private Float applyOps(Byte ops,Stack<Float>stack) {
        float result = 0;
        float val1 = stack.pop();
        float val2 = 0;
        SuKien s1 = new SuKien("temp1", val1);
        SuKien s2 = new SuKien("temp2", val2);
        switch (ops) {
            case '^':
                val2 = stack.pop();
                s2.setGiaTri(val2);
                result = s1.and(s2);
                break;
            case 'v':
                val2 = stack.pop();
                s2.setGiaTri(val2);
                result = s1.or(s2);
                break;
            case '!':
                result = s1.not();
                break;
        }
        return result;
    }

    private float deQuiTinhCF(String tenSuKien) {
        Luat l1 = StanfordTreeController.lstLuat.getLuat(tenSuKien);
        return l1.tinhCFKetLuan();
    }
}
