package com.briup.apps.cms.bean.extend;

import java.util.List;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.bean.User;

/**
 * 文章Article扩展类
 * 显示栏目信息Category(Article有category_id)
 * 显示作者信息User(Article有author_id)
 * 评论comment不够体现功能，加入List集合comments评论集合
 * 设置文章状态信息的值（设置为静态常量）
 * */
public class ArticleExtend  extends Article{
		public static final String STATUS_UNCHECK="未审核";
		public static final String STATUS_CHECK_PASS="审核通过";
		public static final String STATUS_CHECK_NOTPASS="审核未通过";
		
		
		private Category category;
		private User author;
		private List<Comment> comments;
		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public User getAuthor() {
			return author;
		}

		public void setAuthor(User author) {
			this.author = author;
		}

		public List<Comment> getComments() {
			return comments;
		}

		public void setComments(List<Comment> comments) {
			this.comments = comments;
		}

		
		
}
