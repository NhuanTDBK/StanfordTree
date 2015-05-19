/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stanfordtree;

import java.util.StringTokenizer;

/**
 *
 * @author Nhuan
 */
public class Main {
    public StanfordTreeController controller = new StanfordTreeController();
    public GiaoDienChinh view = new GiaoDienChinh();
    public DialogNhapLuat dlgLuat = new DialogNhapLuat(view, true);
    public DialogNhapChungCo dlgChungCo = new DialogNhapChungCo(view, true);
    public Main()
    {
        view.setVisible(true);
        view.setController(controller);
        controller.setView(view);
        view.setDlgChungCo(dlgChungCo);
        view.setDlgLuat(dlgLuat);
        dlgChungCo.setController(controller);
        dlgLuat.setController(controller);
    }
    public static void main(String [] args)
    {
        Main m = new Main();
//        
//        String rule = "(A & B) | !(C&B)";
//        rule = rule.replace(" ", "");
//        rule = rule.replace("(", ",(,");
//        rule = rule.replace(")", ",),");
//        rule = rule.replace("&", ",&,");
//        rule = rule.replace("|", ",|,");
//        rule = rule.replace("", "");
//        rule = rule.replace("!", "!,");
//        rule = rule.replace(",,", ",");
//        if(rule.charAt(0)==',') 
//            rule = rule.substring(1, rule.length());
//        StringTokenizer token = new StringTokenizer(rule,",");
//        while(token.hasMoreTokens())
//        {
//            boolean result = token.nextToken()=="&";
//            System.out.println("token: "+result);
//        }
//        System.out.println("rule phan tich " + rule);
    }
}
