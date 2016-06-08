package com.cslg.OfficeControl.Service;

import java.util.List;

import com.cslg.OfficeControl.PO.Gather;
import com.cslg.OfficeControl.Util.Page;

public interface GatherService {
	public List<Gather> findAll();

	public List<Gather> findAllByUerId(int id);

	public void deleteGather(int id);

	public void add(Gather gather);

	public void edit(Gather gather);

	public Page getPage(int beginPage, int everyPage);
}
