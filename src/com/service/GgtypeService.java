package com.service;
import java.util.List;

import com.model.Ggtype;
import com.model.PageBean;

public interface GgtypeService {
	/**
	 * 保存
	 */
	public void save(Ggtype ggtype);
	/**
	 * 修改
	 */
	public void modifyGgtype(Ggtype ggtype);
	/**
	 * 删除
	 */
	public void deleteGgtype(Integer id);
	/**
	 * 获取指定id用户
	 */
	public Ggtype getGgtype(Integer id);
	/**
	 * 获取列表
	 */
	public List<Ggtype> queryGgtypes(Ggtype ggtype,PageBean pageBean);
	
}
