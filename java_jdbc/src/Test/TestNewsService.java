package Test;

import java.util.List;

import Dao.NewsDao;
import Dao.NewsDaoImpl;
import entity.News;
import entity.NewsCategory;
import service.NewsServiceImpl;

public class TestNewsService {
  public static void main(String[] args) {
	
	  NewsServiceImpl newsServiceImpl = new NewsServiceImpl();
	 
//	  NewsCategory newsCategory = new NewsCategory();
//	  newsCategory.setId(2);
//	  newsServiceImpl.deleteNewsCategory(newsCategory); 
	  List<News> list=newsServiceImpl.getNewsList();
	  System.out.println(list.size());
	  for(News news:list) {
		  System.out.println("id:"+news.getId()+",title:"+news.getTitle());
	  }
}
}
