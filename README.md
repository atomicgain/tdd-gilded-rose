# TDD @Gilded Rose


## 开发环境
 - JDK1.8+
 
## 业务需求

"镶金玫瑰"！这是一家魔兽世界里的小商店。出售的商品也都是高质量的。但不妙的是，随着商品逐渐接近保质期，它们的质量也不断下滑。我们用一个IT系统来更新库存信息。

首先，简单介绍一下我们的系统：

- 所有商品都有一个`SellIn`值，这是商品距离过期的天数，最好在这么多天之内卖掉
- 所有商品都有一个`Quality`值，代表商品的价值
- 商品的`SellIn`值和`Quality`值，它们每天会发生变化，但是会有特例


商品的价格规则说明如下：

- 商品的价值永远不会小于0，也永远不会超过50
- 一旦过了保质期，`Quality`就以双倍的速度下滑
- 陈年干酪（`Aged Brie`）是一种特殊的商品，放得越久，价值反而越高
- 萨弗拉斯（`Sulfuras`）是一种传奇商品，没有保质期的概念，价值也不会下滑
- 后台门票（`Backstage pass`）和陈年干酪（`Aged Brie`）有相似之处：
	- 越接近演出日，商品的价值反而上升
	- 在演出前10天，价值每天上升2点
	- 演出前5天，价值每天上升3点
	- 一旦过了演出日，价值就马上变成0


## tasking 


~~~

Given  
	价值大于50时(Quality 的值大于 50 时)
When
	处理
Then
	将价值调整为50 (Quality 的值赋为 50)


Given  
	价值小于0时(Quality 的值小于 0 时)
When
	处理
Then
	将价值调整为0(Quality 的值赋为 0)


Given  
	价值在0到50之间时(Quality 的值大于等于 0 小于等于50时)
When
	处理
Then
	将价值保持原值(Quality 的值赋为自己)

Given  
	萨弗拉斯(Sulfuras)不论是否过期(SellIn 的值任意变化)
When
	商品信息更新1天
Then
	价值不变(Quality=Quality)


Given  
	陈年干酪(Aged Brie)过期前(SellIn 的值大于 0 时)
When
	商品信息更新1天
Then
	价值递增(rate = origin_rate，Quality=Quality+rate)


Given  
	陈年干酪(Aged Brie)过期后(SellIn 的值小于 0 时)
When
	商品信息更新1天
Then
	价值双倍上升(rate = 2*origin_rate，Quality=Quality+rate)




Given  
	后台门票（Backstage pass）在小于10天大于5天的情况下(SellIn 小于10大于5)
When
	商品信息更新1天
Then
	价值加2(Quality=Quality+2)


Given  
	后台门票（Backstage pass）在小于5天大于0天的情况下(SellIn 小于5大于0)
When
	商品信息更新1天
Then
	价值加3(Quality=Quality+3)


Given  
	后台门票（Backstage pass）在小于0天的情况下(SellIn 小于0)
When
	商品信息更新1天
Then
	价值为0(Quality=0)


Given  
	其它商品过期后(SellIn 的值小于 0 时)
When
	商品信息更新1天
Then
	价值双倍下滑(rate = 2*origin_rate，Quality=Quality-rate)

Given
	普通商品XX初始价值为50,保质期0天
When
	商品信息更新3天
Then
	商品价值应为44


Given
	陈年干酪(Aged Brie)价值30, 保质期30
When
	商品信息更新3天
Then
	商品价值为33

~~~
