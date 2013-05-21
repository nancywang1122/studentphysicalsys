package com.joysw.service.sportsconsultmg;

import com.joysw.bean.sportsconsultbean.SportsConsultBean;
import com.joysw.core.page.Page;
import com.joysw.service.base.BaseService;

public interface SportsConsultService extends BaseService<SportsConsultBean> {
	public Object[] getSportConsultBeansList(
			SportsConsultBean sportsConsultBean, Page page);
	
}
