/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stanfordtree;

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
    }
}
