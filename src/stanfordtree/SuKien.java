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
public class SuKien implements Comparable<SuKien> {
    private String name;
    private float giaTri;

    public SuKien(String name,float giaTri) {
        this.name = name;
        this.giaTri = giaTri;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(float giaTri) {
        this.giaTri = giaTri;
    }
    public float and(SuKien s)
    {
        float result = Math.min(this.giaTri, s.giaTri);
        return result;
    }
    
    public float or(SuKien s)
    {
        float result = Math.max(this.giaTri, s.giaTri);
        return result;
    }
    public float not()
    {
        return this.giaTri*(-1);
    }
    public float combine(SuKien s)
    {
        if(s.giaTri>0&&this.giaTri>0)
        {
            return (s.giaTri+this.giaTri-s.giaTri*this.giaTri);
        }
        else if(s.giaTri<0&&this.giaTri<0)
        {
            return (s.giaTri+this.giaTri+s.giaTri*this.giaTri);
        }
        else
        {
            return ((s.giaTri+this.giaTri)/(1-Math.min(Math.abs(s.giaTri),Math.abs(this.giaTri))));
        }
    }

    @Override
    public int compareTo(SuKien o) {
        return this.getName().compareTo(o.getName());
    }
    public Object[] toObject()
    {
        Object[] object =new Object[2];
        object[0] = this.getName();
        object[1] = this.giaTri;
        return object;
    }
}
