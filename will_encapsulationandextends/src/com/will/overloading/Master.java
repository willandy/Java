package com.will.overloading;
/*
 * 主人类主要用来宠物健康值低的情况下处理的情况
 */
public class Master {
	/*
	 * 这里是重载的方法，方法名一致，参数不一致
	 */
	//给狗狗看病
	public void cure(Dog dog){
		if(dog.getHealth()<60){
			System.out.println("看病，吃药后");
			dog.setHealth(60);
		}
	}
	
	//给企鹅看病
		public void cure(Penguin penguin){
			if(penguin.getHealth()<60){
				System.out.println("看病，修养后");
				penguin.setHealth(60);
			}
		}
	
}
