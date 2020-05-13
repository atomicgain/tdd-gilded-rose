package cn.xpbootcamp.gildedrose;

class GildedRose {
    Product product;

    public GildedRose(Product product) {
        this.product = product;
    }

    public void updateProduct(int days) {
        for (int i = 0; i < days; i++) {
            Good base = getSpecificProduct(product);
            base.updateProductAfterOneDay(product);
        }
    }

    private Good getSpecificProduct(Product product) {
        Good good = null;
        switch (product.name) {
            case "Sulfuras":
                good = new Sulfuras();
                break;
            case "Aged Brie":
                good = new AgedBrie();
                break;
            case "Backstage pass":
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
            if (product.quality < 50) {
                product.quality++;
            }
        }

        protected void subQuality(Product product) {
            if (product.quality > 0) {
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

        private void updateProductAfterOneDay(Product product) {
            updateQuality(product);
            updateSellIn(product);
            if (product.sellIn < 0) {
                updateExpired(product);
            }
        }
    }

    private class AgedBrie extends Good {
        protected void updateExpired(Product product) {
            addQuality(product);
        }

        protected void updateQuality(Product product) {
            addQuality(product);
        }
    }

    private class Sulfuras extends Good {
        protected void updateExpired(Product product) {
        }

        protected void updateSellIn(Product product) {
        }

        protected void updateQuality(Product product) {
        }
    }

    private class BackstagePass extends Good {
        protected void updateExpired(Product product) {
            product.quality = 0;
        }

        protected void updateQuality(Product product) {
            addQuality(product);
            if (product.sellIn <= 10) {
                addQuality(product);
            }
            if (product.sellIn <= 5) {
                addQuality(product);
            }
        }
    }
}

