package service;

import java.util.List;

import entity.News;
import entity.NewsCategory;

public interface NewsService {

	//查询新闻信息
		public List<News> getNewsList();
		//增加新闻信息
		public boolean add(News news);
		//删除新闻信息by id
		public boolean delete(News news);
		//修改新闻标题信息
		public boolean update(News news);
		//删除新闻类别（联表删除）
		public boolean deleteNewsCategory(NewsCategory newsCategory);
}
