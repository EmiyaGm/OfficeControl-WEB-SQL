package com.cslg.OfficeControl.Service;

import java.util.List;

import com.cslg.OfficeControl.PO.Controller;
import com.cslg.OfficeControl.Util.Page;
public interface ControllerService {

	public Controller findOneById(int id);
	
	public List<Controller> findAll();

	public List<Controller> findAllByUerId(int id);

	public void deleteController(int id);

	public void add(Controller controller);

	public void edit(Controller controller);

	public Page getPage(int beginPage, int everyPage);
	
	public void update(Controller controller);
	
	public void addOrder(Controller controller, Controller orig,String path);

	public Controller findOneByName(String name);

	public void updateByName(Controller controller);
}

