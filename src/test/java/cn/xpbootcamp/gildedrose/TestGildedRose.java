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
    }
}