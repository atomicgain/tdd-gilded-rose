package cn.xpbootcamp.gildedrose;

class GildedRose {
    public final int BACKSTAGE_LEVEL1 = 10;
    public final int BACKSTAGE_LEVEL2 = 5;
    public final int MIN_QUALITY = 0;
    public final int MIN_SELLING = 0;
    public final int MAX_QUALITY = 50;
    public final String SULFURAS = "Sulfuras";
    public final String AGED_BRIE = "Aged Brie";
    public final String BACKSTAGE_PASS = "Backstage pass";

    Product product;

    public GildedRose(Product product) {
        this.product = product;
    }

    public void updateProduct(int days) {
        for (int i = MIN_QUALITY; i < days; i++) {
            Good good = getSpecificGood(product);
            good.updateGoodByDay(product);
        }
    }

    private Good getSpecificGood(Product product) {
        Good good;
        switch (product.name) {
            case SULFURAS:
                good = new Sulfuras();
                break;
            case AGED_BRIE:
                good = new AgedBrie();
                break;
            case BACKSTAGE_PASS:
                good = new BackstagePass();
                break;
            default:
                good = new Good();
                break;
        }
        return good;
    }

    private class Good {
        protected void addQuality(Product product) {
            if (product.quality < MAX_QUALITY) {
                product.quality++;
            }
        }

        protected void subQuality(Product product) {
            if (product.quality > MIN_QUALITY) {
                product.quality--;
            }
        }

        protected void updateExpired(Product product) {
            subQuality(product);
        }

        protected void updateSellIn(Product product) {
            product.sellIn--;
        }

        protected void updateQuality(Product product) {
            subQuality(product);
        }

        private void updateGoodByDay(Product product) {
            updateQuality(product);
            updateSellIn(product);
            if (product.sellIn < MIN_SELLING) {
                updateExpired(product);
            }
        }
    }

    private class AgedBrie extends Good {
        @Override
        protected void updateExpired(Product product) {
            addQuality(product);
        }

        @Override
        protected void updateQuality(Product product) {
            addQuality(product);
        }
    }

    private class Sulfuras extends Good {
        @Override
        protected void updateExpired(Product product) {
        }

        @Override
        protected void updateSellIn(Product product) {
        }

        @Override
        protected void updateQuality(Product product) {
        }
    }

    private class BackstagePass extends Good {
        @Override
        protected void updateExpired(Product product) {
            product.quality = MIN_QUALITY;
        }

        @Override
        protected void updateQuality(Product product) {
            addQuality(product);
            if (product.sellIn <= BACKSTAGE_LEVEL1) {
                addQuality(product);
            }
            if (product.sellIn <= BACKSTAGE_LEVEL2) {
                addQuality(product);
            }
        }
    }
}

