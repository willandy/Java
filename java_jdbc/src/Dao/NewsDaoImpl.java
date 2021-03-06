package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.News;
import entity.NewsCategory;
import java_jdbc.BaseDaoImpl;

public class NewsDaoImpl extends BaseDaoImpl implements NewsDao {

	List<News> newsList = new ArrayList<News>();
	//查询信息
	@Override
	public List<News> getNewsList() {
		// TODO Auto-generated method stub
		//String sql="select * from news_detail";
		//来个联表查询
		String sql="SELECT d.*,c.name AS categoryName FROM news_detail d , news_category c WHERE d.categoryId = c.id";
		Object[] params = {};
		ResultSet rs=this.executeQuery(sql, params);
		try {
			while(rs.next()) {
				int id=rs.getInt("id");
				String category=rs.getString("categoryId");
				String title=rs.getString("title");
				String summary=rs.getString("summary");
				String content=rs.getString("content");
				String author=rs.getString("author");
				//之所以用getTimestamp，是因为getDate取不到时分秒
				Timestamp createDate=rs.getTimestamp("createDate");
				//查找联表查询里的内容
				String categoryName = rs.getString("categoryName");
				//System.out.println("id:"+id+"\t"+"title:"+title+"\t"+"createDate:"+createDate);
			   
				News news = new News();
				news.setId(id);
				news.setTitle(title);
				news.setSummary(summary);
				news.setAuthor(author);
				news.setCreateDate(createDate);
				//插入联表查询里查出的内容
				news.setCategoryName(categoryName);
				newsList.add(news);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.close();
		}
		return newsList;
	}

	//新增信息
	@Override
	public boolean add(News news) {
		// TODO Auto-generated method stub
		boolean flag = false;
		//String sql="insert into news_detail values("+news.getId()+","+news.getCategoryId()+",'"+news.getTitle()+"','"+news.getSummary()+"','"+news.getContent()+"','"+news.getPicPath()+"','"+news.getAuthor()+"','"+new Timestamp(news.getCreateDate().getTime())+"','"+new Timestamp(news.getModifyDate().getTime())+"')";
		String sql="insert into news_detail values(?,?,?,?,?,?,?,?,?)";
		Object[] params = {news.getId(),news.getCategoryId(),news.getTitle(),news.getSummary(),news.getContent(),news.getPicPath(),news.getAuthor(),news.getCreateDate(),news.getModifyDate()};
		int i=this.executeUpdate(sql, params);
		if(i>0) {
			System.out.println("插入新闻成功!");
			flag = true;
		}
		this.close();
		return flag;
	}

	@Override
	public boolean delete(News news) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql ="delete from news_detail where id=?";
		Object[] params = {news.getId()};
		int i=this.executeUpdate(sql, params);
		if(i>0) {
			System.out.println("删除成功!");
			flag = true;
		}
		this.close();
		return flag;
	}

	@Override
	public boolean update(News news) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql ="update news_detail set author=? where id=?";
		Object[] params = {news.getAuthor(),news.getId()};
		
		int i=this.executeUpdate(sql, params);
		if(i>0) {
			System.out.println("更新成功!");
			flag = true;
		}
		this.close();
		return flag;
	}

//	@Override
//	public boolean deleteNewsCategory(NewsCategory newsCategory) {
//		// TODO Auto-generated method stub
//		/*
//		 * 测试联表删除
//		 */
//		String delNewsDataDetailSql="delete from news_detail where categoryId=?";
//		String delNewsCategorySql="delete from news_category where id=?";
//		//删除子表(news_detail),后删除主表(news_category)
//		Object[] params = {newsCategory.getId()};
//		int i=this.executeUpdate(delNewsDataDetailSql, params);
//		if(i!=-1) {//只要不报错，就删除
//			int j=this.executeUpdate(delNewsCategorySql, params);
//			if(j>0) {
//				System.out.println("删除新闻类别成功");
//			}
//		}
//		this.close();
//		return false;
//	}
	
	public static void main(String[] args) {
		
		NewsDaoImpl newsDaoImpl = new NewsDaoImpl();
		News news = new News();
		news.setTitle("增加新闻test");
		news.setSummary("摘要测试");
		news.setAuthor("liwei");
		news.setCategoryId(3);
		news.setContent("新闻内容");
		news.setCreateDate(new Date());
		news.setModifyDate(new Date());
		
		List<News> newsList = new ArrayList<News>();
		newsList=newsDaoImpl.getNewsList();
		for(News n:newsList) {
			System.out.println("id:"+n.getId()+"==title:"+n.getTitle()+"==categotyName:"+n.getCategoryName());
		}
		
		//更新
		/*news.setId(3);
		newsDaoImpl.update(news);*/
		
	}

	@Override
	public int getNewsCount(News news) {
		// TODO Auto-generated method stub
		int count = 0;
		String sql="select count(1) as count from news_detail where categoryId=?";
		Object[] params = {news.getCategoryId()};
		ResultSet rs=this.executeQuery(sql, params);
		try {
			while(rs.next()) {
				count=rs.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	/*
	 * 根据ID删除新闻类别
	 */
	@Override
	public boolean deleteNewsCategory(NewsCategory newsCategory) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String delNewsCategorySql="delete from news_category where id=?";
		//删除子表(news_detail),后删除主表(news_category)
		Object[] params = {newsCategory.getId()};
		if(this.executeUpdate(delNewsCategorySql, params)>0) {
			flag = true;
		}
		this.close();
		return flag;
	}
	
}
