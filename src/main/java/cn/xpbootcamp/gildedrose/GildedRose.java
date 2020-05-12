package cn.xpbootcamp.gildedrose;


public class GildedRose{
    private int sellIn;
    private int quality;
    private String type;
    private int rate=1;

    public void GildedRose(int sellIn, int quality, String stuff ){
        this.sellIn = sellIn;
        this.quality =quality;
        this.type = stuff;
    }

    public GildedRose(int days, int value, String type) {
        GildedRose(days,value,type);
    }

    public GildedRose(){
        GildedRose(25,25,"normal");
    }

    public int getQuality(){
        return this.quality;
    }

    public int getSellIn() {
        return this.sellIn;
    }

    public int limitQuality(int i){
        if (i>50)
            i = 50;
        else if (i<0)
            i = 0;
        return i;
    }

    public void oneMoreDay(){
        this.sellIn-=1;
        if (this.type == "Sulfuras"){
            quality += 0;
            quality = limitQuality(quality);
        }
    }



}

