package com.cslg.OfficeControl.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

import com.cslg.OfficeControl.DAO.UserDAO;
import com.cslg.OfficeControl.DAO.UserDAOImpl;
import com.cslg.OfficeControl.PO.User;
import com.cslg.OfficeControl.Util.Page;
import com.mysql.fabric.Response;


public class UserServiceImpl implements UserService ,ServletContextAware{
	private UserDAO userDAO = new UserDAOImpl();
	@Override
	public User login(User user) {
		try {
			User u = userDAO.findUserByUserName(user.getUserName());
			if(u==null) return null;
			if(u.getPassword().equals(user.getPassword())){
				return u;
			}else {
				return null;
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean saveUser(User user) {
		try {
			userDAO.saveUser(user);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateUser(User user) {
		try {
			userDAO.updateUser(user);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<User> showAll() {
		List<User> users = null;
		try {
			users = userDAO.findAllUser();
			return users;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return users;
		}
	}
	@Override
	public User findById(int id) {
		User user = null;
		try {
			user = userDAO.findUserById(id);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public void deleteById(int id) {
		try {
			userDAO.deleteUser(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void addUser(User user){
		user.setSuper(false);
		try {
			userDAO.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Page getPage(int beginPage, int everyPage) {
		Page page = new Page();
		try {
			List<User> users = userDAO.getPage(beginPage, everyPage);
			int totalCount = userDAO.getCount();
			page.setList(users);
			page.setBeginPage(beginPage);
			page.setEveryPage(everyPage);
			page.setTotalCount(totalCount);
			int totalPage = (totalCount%everyPage==0)?(totalCount/everyPage):((totalCount/everyPage)+1);
			page.setTotalPage(totalPage);
			page.setHasNextPage(beginPage>=totalCount);
			page.setHasPrePage(beginPage<=1);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}
	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}

}
