package cn.xpbootcamp.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class TestGildedRose {

    /*
    Given
        保值商品Sulfuras初始价值为49, 保质期50
    When
        商品信息更新两天
    Then
        商品价值应为50
    */
    @Test
    public void should_return_50_when_update_good_after_3_days_given_sulfuras_quality_is_49_and_sellIn_is_50() {
        Product product = new Product("Sulfuras", 50, 50);
        GildedRose gildedrose = new GildedRose(product);
        gildedrose.updateProduct(3);
        assertThat(product.quality).isEqualTo(50);
    }

    /*
      Given
          普通商品SS初始价值为1, 保质期0
      When
          商品信息更新三天
      Then
          商品价值应为0
    */
    @Test
    public void should_return_0_when_update_good_after_3_days_given_DaYan_quality_is_1_and_sellIn_is_0() {
        Product product = new Product("DaYan", 0, 1);
        GildedRose gildedrose = new GildedRose(product);
        gildedrose.updateProduct(3);
        assertThat(product.quality).isEqualTo(0);
    }
/*
    Given
        普通商品XX初始价值为50,保质期0天
    When
        商品信息更新3天
    Then
        商品价值应为44
	*/

    @Test
    public void should_return_44_when_update_good_after_3_days_given_DaYan_quality_is_50_and_sellIn_is_0() {
        Product product = new Product("DaYan", 0, 50);
        GildedRose gildedrose = new GildedRose(product);
        gildedrose.updateProduct(3);
        assertThat(product.quality).isEqualTo(44);
    }

    /*
        Given
            陈年干酪(Aged Brie)价值30, 保质期30
        When
            商品信息更新3天
        Then
            商品价值为33
    */
    @Test
    public void should_return_33_when_update_good_after_3_days_given_AgedBrie_is_AgedBrie_and_sellin_is_30_quality_is_30() {
        Product product = new Product("Aged Brie", 30, 30);
        GildedRose gildedrose = new GildedRose(product);
        gildedrose.updateProduct(3);
        assertThat(product.quality).isEqualTo(33);
    }

    /*
      Given
          陈年干酪(Aged Brie)价值30,保质期为0
      When
          商品信息更新3天
      Then
          商品价值为36
    */
    @Test
    public void should_return_36_when_update_good_after_3_days_given_AgedBrie_is_AgedBrie_and_sellin_is_0_quality_is_30() {
        Product product = new Product("Aged Brie", 0, 30);
        GildedRose gildedrose = new GildedRose(product);
        gildedrose.updateProduct(3);
        assertThat(product.quality).isEqualTo(36);
    }

    /*
      Given
          萨弗拉斯(Sulfuras)商品价值30,过期时间0
      When
          商品信息更新3天
      Then
          商品价值为30
    */
    @Test
    public void should_return_30_when_update_good_after_3_days_given_Sulfuras_and_sellin_is_0_quality_is_30() {
        Product product = new Product("Sulfuras", 0, 30);
        GildedRose gildedrose = new GildedRose(product);
        gildedrose.updateProduct(3);
        assertThat(product.quality).isEqualTo(30);
    }

    /*
        Given
            后台门票（Backstage pass）价值为10, 演出前20天
        When
            商品信息更新3天
        Then
            商品价值为13
    */
    @Test
    public void should_return_13_when_update_good_after_3_days_given_BackstagePass_and_sellin_is_20_quality_is_10() {
        Product product = new Product("Backstage pass", 20, 10);
        GildedRose gildedrose = new GildedRose(product);
        gildedrose.updateProduct(3);
        assertThat(product.quality).isEqualTo(13);
    }

    /*
        Given
            后台门票（Backstage pass）价值为10,演出前9天
        When
            商品信息更新3天
        Then
            商品价值为16
    */
    @Test
    public void should_return_16_when_update_good_after_3_days_given_BackstagePass_and_sellin_is_20_quality_is_10() {
        Product product = new Product("Backstage pass", 9, 10);
        GildedRose gildedrose = new GildedRose(product);
        gildedrose.updateProduct(3);
        assertThat(product.quality).isEqualTo(16);
    }

    /*
    Given
        后台门票（Backstage pass）价值为10,演出前4天
    When
        商品信息更新3天
    Then
        商品价值为19
    */
    @Test
    public void should_return_19_when_update_good_after_3_days_given_BackstagePass_and_sellin_is_4_quality_is_10() {
        Product product = new Product("Backstage pass", 4, 10);
        GildedRose gildedrose = new GildedRose(product);
        gildedrose.updateProduct(3);
        assertThat(product.quality).isEqualTo(19);
    }

    /*
    Given
        后台门票（Backstage pass）价值为10,演出前1天
    When
        商品信息更新3天
    Then
        商品价值为0
    */
    @Test
    public void should_return_0_when_update_good_after_3_days_given_BackstagePass_and_sellin_is_1_quality_is_10() {
        Product product = new Product("Backstage pass", 1, 10);
        GildedRose gildedrose = new GildedRose(product);
        gildedrose.updateProduct(3);
        assertThat(product.quality).isEqualTo(0);
    }

}