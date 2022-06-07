package com.service;
import java.util.List;

import com.model.Uxtype;
import com.model.PageBean;

public interface UxtypeService {
	/**
	 * ����
	 */
	public void save(Uxtype uxtype);
	/**
	 * �޸�
	 */
	public void modifyUxtype(Uxtype uxtype);
	/**
	 * ɾ��
	 */
	public void deleteUxtype(Integer id);
	/**
	 * ��ȡָ��id�û�
	 */
	public Uxtype getUxtype(Integer id);
	/**
	 * ��ȡ�б�
	 */
	public List<Uxtype> queryUxtypes(Uxtype uxtype,PageBean pageBean);
	
}
