/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author SONGSONG
 */
public class Look {

    private int Looksid;
    private String Lookspic;
    private String Looksalt;

    public Look(String Lookspic, String Looksalt, int Looksid) {
        this.Lookspic = Lookspic;
        this.Looksalt = Looksalt;
        this.Looksid = Looksid;
    }

    public int getLooksid() {
        return Looksid;
    }

    public void setLooksid(int Lookspic) {
        this.Looksid = Looksid;
    }

    public String getLookspic() {
        return Lookspic;
    }

    public void setLookspic(String Lookspic) {
        this.Lookspic = Lookspic;
    }

    public String getLooksalt() {
        return Lookspic;
    }

    public void setLooksalt(String Lookspic) {
        this.Lookspic = Lookspic;
    }
}
