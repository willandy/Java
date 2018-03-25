package com.will.polymorphismtwo;

/*
 * 自定义类和方法，使用父类作为返回值实现打印不同类型商品价格功能
 * 父类：Goods（商品类）
 * 子类：TVs(电视类),Foods(食物类)
 */

public abstract class Goods {
    public abstract void price();
}

//子类：TVs
class TV extends Goods{

	@Override
	public void price() {
		// TODO Auto-generated method stub
		System.out.println("购买电视的价格为：35元");
	}
	
}

//子类：Foods
class Food extends Goods{

	@Override
	public void price() {
		// TODO Auto-generated method stub
	  System.out.println("食物的价格为:10元");	
	}
}

//工厂模式：返回父类类型
class GoodsDoSth{
	public Goods goodsPrice(String type){
		Goods goods = null;
		if(type.equals("tv")){
			goods = new TV();
		}else if(type.equals("food")){
			goods = new Food();
		}
		return goods;
	}
}

class GoodsTerst{
	public static void main(String[] args) {
		String type = "tv";
		GoodsDoSth goods = new GoodsDoSth();
		Goods g=goods.goodsPrice(type);
		g.price();
	}
}
























