/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stanfordtree;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Nhuan
 */
public class MapLuat extends ArrayList<Luat> {

    public void put(Luat l1) {
        super.add(l1);
    }

    public Luat getLuat(String ketLuan) {
        Luat l=null;
        for(Luat l1:this)
            if(l1.getKetLuan().equals(ketLuan))
            {
                l = l1;
                break;
            }
        return l;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Luat l1 : this) {
            builder.append(l1.toString());
        }
        return builder.toString();
    }

    public void tinhTapLuat() {
        for (Luat l1 : this) {
            l1.tinhCFKetLuan();
        }
    }
    public Object[][] parseToObject()
    {
        Object[][]objects = new Object[this.size()][3];
        Iterator<Luat>iter = this.iterator();
        int i = 0;
        while(iter.hasNext())
        {
            Luat s = (Luat)iter.next();
            objects[i] = s.toObject();
            i++;
        }
        return objects;
    }

}
