package cn.xpbootcamp.gildedrose;


public class GildedRose{
    public int limitQuality(int i){
        if (i>50)
            i = 50;
        else if (i<0)
            i = 0;
        return i;
    }
}

