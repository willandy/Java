package com.will.polymorphismtwo;

/*
 * �Զ�����ͷ�����ʹ�ø�����Ϊ����ֵʵ�ִ�ӡ��ͬ������Ʒ�۸���
 * ���ࣺGoods����Ʒ�ࣩ
 * ���ࣺTVs(������),Foods(ʳ����)
 */

public abstract class Goods {
    public abstract void price();
}

//���ࣺTVs
class TV extends Goods{

	@Override
	public void price() {
		// TODO Auto-generated method stub
		System.out.println("������ӵļ۸�Ϊ��35Ԫ");
	}
	
}

//���ࣺFoods
class Food extends Goods{

	@Override
	public void price() {
		// TODO Auto-generated method stub
	  System.out.println("ʳ��ļ۸�Ϊ:10Ԫ");	
	}
}

//����ģʽ�����ظ�������
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
























