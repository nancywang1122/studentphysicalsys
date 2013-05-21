package com.joysw.service.sportsconsultmg.impl;

import java.util.ArrayList;
import java.util.List;

import com.joysw.bean.sportsconsultbean.SportsConsultBean;
import com.joysw.core.page.Page;
import com.joysw.dao.base.BaseDAO;
import com.joysw.service.base.impl.BaseServiceImpl;
import com.joysw.service.sportsconsultmg.SportsConsultService;

public class SportsConsultServiceImpl extends
		BaseServiceImpl<SportsConsultBean> implements SportsConsultService {

	private BaseDAO<SportsConsultBean> baseSportsConsultDAOImpl;



	public BaseDAO<SportsConsultBean> getBaseSportsConsultDAOImpl() {
		return baseSportsConsultDAOImpl;
	}


	public void setBaseSportsConsultDAOImpl(
			BaseDAO<SportsConsultBean> baseSportsConsultDAOImpl) {
		this.baseSportsConsultDAOImpl = baseSportsConsultDAOImpl;
	}


	@Override
	public Object[] getSportConsultBeansList(
			SportsConsultBean sportsConsultBean, Page page) {
		StringBuffer hql = new StringBuffer();
		StringBuffer hqlCount = new StringBuffer();
		hql.append("from SportsConsultBean where 1=1 ");
		hqlCount.append("select count(*) from SportsConsultBean where 1=1 ");
		List<Object> params = new ArrayList<Object>();

		hql.append(" order by sportsConsultId desc");
		int rowCount = this.baseSportsConsultDAOImpl.countListByHqlAndParas(
				hqlCount.toString(), params);
		if (page == null) {
			page = new Page(2, 1, rowCount);
		} else {
			page = new Page(page.getSize(), page.getNum(), rowCount);
		}
		return new Object[] {
				this.baseSportsConsultDAOImpl.getListByHqlAndParas(
						hql.toString(), params, page), page };
	}
	
	@Override
	public void save(SportsConsultBean sportConsultBean) {
		this.baseSportsConsultDAOImpl.save(sportConsultBean);
		
	}

}
