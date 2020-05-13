package cn.xpbootcamp.gildedrose;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class TestGildedRose {
    GildedRose gildedrose = new GildedRose();

    @Test
    public void should_return_50_when_quality_is_greater_then_50 (){
        assertThat(gildedrose.limitQuality(54)).isEqualTo(50);
    }

    @Test
    public void should_return_0_when_quality_is_less_then_0 (){
        assertThat(gildedrose.limitQuality(-1)).isEqualTo(0);
    }


    @Test
    public void should_return_n_when_quality_is_between_0_and_50 (){
        assertThat(gildedrose.limitQuality(1)).isEqualTo(1);
        assertThat(gildedrose.limitQuality(49)).isEqualTo(49);
        assertThat(gildedrose.limitQuality(0)).isEqualTo(0);
        assertThat(gildedrose.limitQuality(50)).isEqualTo(50);
    }

    @Test
    public void should_return_n_when_type_is_Sulfuras (){
        GildedRose gildedrose = new GildedRose(10,10,"Sulfuras");
        gildedrose.oneMoreDay();
        assertThat(gildedrose.getQuality()).isEqualTo(10);

    }

    @Test
    public void should_return_increase1_when_type_is_AgedBrie_and_notexpire (){
        GildedRose gildedrose = new GildedRose(10,10,"AgedBrie");
        gildedrose.oneMoreDay();
        assertThat(gildedrose.getQuality()).isEqualTo(11);

    }

    @Test
    public void should_return_increase1_when_type_is_AgedBrie_and_expire (){
        GildedRose gildedrose = new GildedRose(-1,10,"AgedBrie");
        gildedrose.oneMoreDay();
        assertThat(gildedrose.getQuality()).isEqualTo(12);

    }
    @Test
    public void should_return_increase1_when_type_is_BackstagePass_and_sellin_greater_then_10 (){
        GildedRose gildedrose = new GildedRose(21,10,"BackstagePass");
        gildedrose.oneMoreDay();
        assertThat(gildedrose.getQuality()).isEqualTo(11);

    }
    @Test
    public void should_return_increase2_when_type_is_BackstagePass_and_sellin_between_10_and_5 (){
        GildedRose gildedrose = new GildedRose(9,10,"BackstagePass");
        gildedrose.oneMoreDay();
        assertThat(gildedrose.getQuality()).isEqualTo(12);

    }
    @Test
    public void should_return_increase3_when_type_is_BackstagePass_and_sellin_between_0_and_5 (){
        GildedRose gildedrose = new GildedRose(4,10,"BackstagePass");
        gildedrose.oneMoreDay();
        assertThat(gildedrose.getQuality()).isEqualTo(13);

    }
    @Test
    public void should_return_0_when_type_is_BackstagePass_and_sellin_less_then_0 (){
        GildedRose gildedrose = new GildedRose(0,10,"BackstagePass");
        gildedrose.oneMoreDay();
        assertThat(gildedrose.getQuality()).isEqualTo(0);

    }
    @Test
    public void should_return_decrease1_when_type_is_other_and_sellin_greater_then_0 (){
        GildedRose gildedrose = new GildedRose(12,10,"abc");
        gildedrose.oneMoreDay();
        assertThat(gildedrose.getQuality()).isEqualTo(9);

    }
    @Test
    public void should_return_decrease2_when_type_is_other_and_sellin_less_then_0 (){
        GildedRose gildedrose = new GildedRose(-12,10,"abc");
        gildedrose.oneMoreDay();
        assertThat(gildedrose.getQuality()).isEqualTo(8);

    }
    @Test
    public void should_return_44_when_type_is_other_and_sellin_less_then_0_quality_is_50_3dayslater (){
        GildedRose gildedrose = new GildedRose(0,50,"XX");
        gildedrose.nMoreDays(3);
        assertThat(gildedrose.getQuality()).isEqualTo(44);

    }
    @Test
    public void should_return_33_when_type_is_AgedBrie_and_sellin_is_30_quality_is_30_3dayslater (){
        GildedRose gildedrose = new GildedRose(30,30,"AgedBrie");
        gildedrose.nMoreDays(3);
        assertThat(gildedrose.getQuality()).isEqualTo(33);
    }
}