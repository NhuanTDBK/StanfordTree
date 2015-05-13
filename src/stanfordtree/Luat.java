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
public class Luat implements Comparable<Luat> {
    private String chungCo;
    private String ketLuan;
    private float giatri;
    private String chuyenDoiLuat;
    private TinhCF tinh = new TinhCF();
    public Luat()
    {
        
    }
    public Luat(String chungCo, String ketLuan, float giaTri)
    {
        this.chungCo = chungCo;
        this.ketLuan = removeNhayKep(ketLuan);
        this.giatri = giaTri;
        tinh = new TinhCF(chungCo);
        StanfordTreeController.lstSuKien.put(new SuKien(this.ketLuan,0F));
    }

    public String getChuyenDoiLuat() {
        return chuyenDoiLuat;
    }

    public void setChuyenDoiLuat(String chuyenDoiLuat) {
        this.chuyenDoiLuat = chuyenDoiLuat;
    }
    
    public String getChungCo() {
        return chungCo;
    }

    public void setChungCo(String chungCo) {
        this.chungCo = chungCo;
    }

    public String getKetLuan() {
        return ketLuan;
    }

    public void setKetLuan(String ketLuan) {
        this.ketLuan = ketLuan;
    }

    public float getGiatri() {
        return giatri;
    }

    public void setGiatri(float giatri) {
        this.giatri = giatri;
    }

    @Override
    public int compareTo(Luat o) {
        return this.ketLuan.compareTo(o.ketLuan);
    }
    public float tinhCFKetLuan()
    {
        float chungCo =  tinh.phanTichLuat();
        
        float result = chungCo*giatri;
        if(StanfordTreeController.lstSuKien.get(ketLuan).getGiaTri()!=0)
        {
            SuKien s1 = StanfordTreeController.lstSuKien.get(ketLuan);
            SuKien s2 = new SuKien("temp",result);
            result = s1.combine(s2);
        }
        
        StanfordTreeController.lstSuKien.putValue(ketLuan,result);
        return result;
    }

    @Override
    public String toString() {
        return "\nLuat "+this.getChungCo()+" -> "+this.getKetLuan();
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    public Object[] toObject()
    {
        Object [] object = new Object[3];
        object[0] = this.chungCo ;
        object[1] = this.ketLuan;
        object[2] = this.giatri;
        return object;
    }
    public String removeNhayKep(String token)
    {
        String result = token.replace("'","");
        return result;
    }
}
