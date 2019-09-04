package com.kgc.service;

import java.util.List;

import com.kgc.entity.Emp;

public interface EmpService {
    /**
     *  实现查询所有对象集合
     *  /通过特定姓名查询成员对象集合
     *  /通过部门编号查询目标部门下的所有成员对象集合
     * @param ename
     * @param Deptno
     * @return 满足特定需求的成员对象集合
     */
	public List<Emp> queryAllOrByEnameOrByDeptno(String ename,String deptno);
	/**
	 *  添加成员的方法
	 * @param emp
	 * @return 受影响行数的整数值，以此扩展功能
	 */
	public int AddEmp(Emp emp);
	/**
	 * 修改现有成员信息的方法
	 * @param emp
	 * @return 受影响行数的整数值，以此扩展功能
	 */
	public int upData(Emp emp);
	/**
	 * 删除现有成员信息的方法
	 * @param empno
	 * @return 受影响行数的整数值，以此扩展功能
	 */
	public int delete(String empno);
	
}
