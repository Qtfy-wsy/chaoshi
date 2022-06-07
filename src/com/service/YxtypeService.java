package com.service;
import java.util.List;

import com.model.Yxtype;
import com.model.PageBean;

public interface YxtypeService {
	/**
	 * ����
	 */
	public void save(Yxtype yxtype);
	/**
	 * �޸�
	 */
	public void modifyYxtype(Yxtype yxtype);
	/**
	 * ɾ��
	 */
	public void deleteYxtype(Integer id);
	/**
	 * ��ȡָ��id�û�
	 */
	public Yxtype getYxtype(Integer id);
	/**
	 * ��ȡ�б�
	 */
	public List<Yxtype> queryYxtypes(Yxtype yxtype,PageBean pageBean);
	
}
