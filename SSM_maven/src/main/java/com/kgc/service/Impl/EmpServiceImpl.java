package com.kgc.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kgc.dao.EmpDao;
import com.kgc.entity.Emp;
import com.kgc.service.EmpService;
@Service("empService")
public class EmpServiceImpl implements EmpService{
	@Resource
	EmpDao ED;
	@Override
	public List<Emp> queryAllOrByEnameOrByDeptno(String ename, String deptno) {
		System.out.println("Service层："+ename);
		return ED.SelectAllOrByEnameOrDeptno(ename, deptno);
	}

	@Override
	public int AddEmp(Emp emp) {
		return ED.saveEMP(emp);
	}

	@Override
	public int upData(Emp emp) {
		return ED.updataEmp(emp);
	}

	@Override
	public int delete(String empno) {
		return ED.delete(empno);
	}

}
