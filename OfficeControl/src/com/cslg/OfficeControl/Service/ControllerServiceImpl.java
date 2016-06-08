package com.cslg.OfficeControl.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cslg.OfficeControl.DAO.ControllerDAO;
import com.cslg.OfficeControl.DAO.ControllerDAOImpl;
import com.cslg.OfficeControl.PO.Controller;
import com.cslg.OfficeControl.PO.Gather;
import com.cslg.OfficeControl.PO.Order;
import com.cslg.OfficeControl.Util.AnalyzeXML;
import com.cslg.OfficeControl.Util.Page;
public class ControllerServiceImpl implements ControllerService{
private ControllerDAO controllerDAO = new ControllerDAOImpl();
	
	@Override
	public Controller findOneById(int id) {
		try {
			return controllerDAO.findControllerById(id);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Controller> findAll() {
		try {
			return controllerDAO.findAllController();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Controller> findAllByUerId(int id) {
		try {
			return controllerDAO.findControllerByUser(id);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteController(int id) {
		try {
			controllerDAO.deleteController(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void add(Controller controller) {
		try {
			controllerDAO.addController(controller);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Controller controller) {
		try {
			controllerDAO.updateController(controller);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Page getPage(int beginPage, int everyPage) {
		Page page = new Page();
		try {
			List<Gather> gathers = controllerDAO.getPage(beginPage, everyPage);
			int totalCount = controllerDAO.getCount();
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

	@Override
	public void update(Controller controller) {
		try {
			controllerDAO.updateData(controller);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void addOrder(Controller controller, Controller orig,String path) {
		Order order= new Order();
		order.setName(controller.getName());
		AnalyzeXML axl = new AnalyzeXML();
		if(controller.getStatus() == orig.getStatus()){
			if(controller.getStatus()==1){
				//数据操作指令
				String code = (controller.getKind()==0?"cold":"hot")+controller.getTemp();
				order.setComd(axl.analyze(code,path));
				try {
					controllerDAO.addOrder(order);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				return;
			}
		}
		else{
			if(controller.getStatus()==1){
				//开指令和数据操作指令
				order.setComd(axl.analyze("open",path));
				String code = (controller.getKind()==0?"cold":"hot")+controller.getTemp();
				try {
					controllerDAO.addOrder(order);
					order.setComd(axl.analyze(code,path));
					controllerDAO.addOrder(order);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				//关指令
				order.setComd(axl.analyze("close",path));
				try {
					controllerDAO.addOrder(order);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Controller findOneByName(String name) {
		try {
			return controllerDAO.findControllerByName(name);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void updateByName(Controller controller) {
		try {
			controllerDAO.updateDataByName(controller);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
