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
        else if (this.type == "AgedBrie"){
            if (this.sellIn >= 0){
                quality += this.rate;
                quality = limitQuality(quality);
            }
            else {
                quality += this.rate*2;
                quality = limitQuality(quality);
            }
        }
        else if (this.type == "BackstagePass"){
            if (this.sellIn > 10){
                quality += this.rate;
                quality = limitQuality(quality);
            }
            else if ((this.sellIn <= 10 && this.sellIn >5)){
                quality += this.rate*2;
                quality = limitQuality(quality);
            }
            else if ((this.sellIn <= 5 && this.sellIn >0)){
                quality += this.rate*3;
                quality = limitQuality(quality);
            }
            else {
                quality = 0;
                quality = limitQuality(quality);
            }
        }
        else {
            if (this.sellIn > 0){
                quality -= this.rate;
                quality = limitQuality(quality);
            }
            else {
                quality -= this.rate*2;
                quality = limitQuality(quality);
            }
        }

    }



}

