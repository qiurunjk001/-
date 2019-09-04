package com.kgc.util;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public class EmpProvider {
    public String selectByEnameOrDeptno(Map<String, Object> para){
    	String sql ="select e.empno,e.ename,e.esex,e.eage,e.esalary, d.deptno,d.dname,d.location, "
    			+ "m.empno mno, m.ename mname from t_emp e inner join t_dept d "
    			+ "on e.deptno = d.deptno inner join t_emp m on e.mgrno =m.empno";
		sql+=" where 1=1";
		if(!"".equals(para.get("ename").toString()) && para.get("ename") != null){
			sql+=" and instr(e.ename,'"+para.get("ename").toString()+"')>0  ";
		}
		if(!"".equals(para.get("deptno").toString()) && para.get("deptno") != null){
			sql+=" and d.deptno='"+para.get("deptno").toString()+"' ";
		}
		return sql;
    }
	
}
