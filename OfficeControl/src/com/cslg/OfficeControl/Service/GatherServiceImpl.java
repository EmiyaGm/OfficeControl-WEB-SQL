package com.cslg.OfficeControl.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cslg.OfficeControl.DAO.GatherDAO;
import com.cslg.OfficeControl.DAO.GatherDAOImpl;
import com.cslg.OfficeControl.PO.Gather;
import com.cslg.OfficeControl.Util.Page;

public class GatherServiceImpl implements GatherService {
	private GatherDAO gatherDAO = new GatherDAOImpl();
	
	@Override
	public List<Gather> findAll() {
		try {
			return gatherDAO.findAllGather();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Gather> findAllByUerId(int id) {
		try {
			return gatherDAO.findGatherByUserId(id);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteGather(int id) {
		try {
			gatherDAO.deleteGather(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void add(Gather gather) {
		try {
			gatherDAO.addGather(gather);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Gather gather) {
		try {
			gatherDAO.updateGather(gather);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Page getPage(int beginPage, int everyPage) {
		Page page = new Page();
		try {
			List<Gather> gathers = gatherDAO.getPage(beginPage, everyPage);
			int totalCount = gatherDAO.getCount();
			page.setList(gathers);
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

}
