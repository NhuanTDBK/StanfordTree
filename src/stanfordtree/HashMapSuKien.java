 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stanfordtree;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Nhuan
 */
public class HashMapSuKien extends HashMap<String, SuKien>{

    public SuKien put(SuKien s1) {
        return super.put(s1.getName(), s1);
    }

    public float getValue(String suKien) {
        System.out.println(suKien);
        SuKien s1 = this.get(suKien);
        return s1.getGiaTri();
    }

    public void putValue(String suKien, float giaTri) {
        this.get(suKien).setGiaTri(giaTri);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (SuKien s : this.values()) {
            builder.append("\n Su kien " + s.getName() + " = " + s.getGiaTri());
        }
        return builder.toString();
    }
    public Object[][] parseObjectToTable()
    {
        Object[][]objects = new Object[this.values().size()][2];
        Iterator<SuKien>iter = this.values().iterator();
        int i = 0;
        while(iter.hasNext())
        {
            SuKien s = (SuKien)iter.next();
            objects[i] = s.toObject();
            i++;
        }
        return objects;
    }

}
