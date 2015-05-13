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
public class StanfordTreeController {

    /**
     * @param args the command line arguments
     */
    public static HashMapSuKien lstSuKien = new HashMapSuKien();
    public static MapLuat lstLuat = new MapLuat();
    private GiaoDienChinh view;

    public GiaoDienChinh getView() {
        return view;
    }

    public void setView(GiaoDienChinh view) {
        this.view = view;
    }

    public void init() {
//        view.setVisible(true);
        view.modelChungCo.setDataVector(lstSuKien.parseObjectToTable(), view.headerChungCo);
        view.modelLuat.setDataVector(lstLuat.parseToObject(), view.headerLuat);
    }

    public void addLuat(Luat l1) {
        view.modelLuat.addRow(l1.toObject());
        view.modelLuat.fireTableDataChanged();
        lstLuat.put(l1);
    }

    public void addSuKien(SuKien s1) {
        view.modelChungCo.addRow(s1.toObject());
        view.modelChungCo.fireTableDataChanged();
        lstSuKien.put(s1);
    }
    public void tinhTapLuat()
    {
        lstLuat.tinhTapLuat();
        init();
    }
    public void resetAll()
    {
        lstLuat.clear();
        lstSuKien.clear();
        init();
    }
    public static void main(String[] args) {
        // TODO code application logic here

//        lstSuKien.put(new SuKien("e1",0.9F));
        lstSuKien.put(new SuKien("e2", 0.9F));
//        lstSuKien.put(new SuKien("e3",-0.3F));
//        lstSuKien.put(new SuKien("e4",0.4F));
//        lstSuKien.put(new SuKien("e5",-0.3F));

        //Luat r1 = new Luat("'e1'","'c1'",0.8F);
        Luat r2 = new Luat("'e2'", "'c2'", 0.9F);

        //lstLuat.put(r1);
        lstLuat.put(r2);
        lstLuat.tinhTapLuat();
        System.out.println(lstSuKien.toString());
        System.out.println(lstLuat.toString());
        StanfordTreeController c = new StanfordTreeController();
    }

}
