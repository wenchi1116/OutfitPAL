package fourpeople.socute.outfitpal;

public class Clothes {
    private String clothestype;
    private String clothes;
    private String clothescolor;
    private String clothesseason;
    private String gender;
    
    public Clothes(String gender, String clothestype, String clothes, String clothescolor) {
        this.gender = gender;
        this.clothestype = clothestype;
        this.clothes = clothes;
        this.clothescolor = clothescolor;
    }

    public String getGender() {
        return gender;
    }

    public String getClothestype() {
        return clothestype;
    }

    public String getClothes() {
        return clothes;
    }

    public String getClothescolor() {
        return clothescolor;
    }
    public String getClothesseason() {
        return clothesseason;
    }
}
