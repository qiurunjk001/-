package com.kgc.entity;
/**
 * 本类是t_emp表的实体类
 * 并引入t_dept 对象
 * 以及以领导编号为主键的虚表对象
 */
public class Emp {
    private String empno; //员工编号
    private String ename; //员工姓名
    private String esex;    //员工性别
    private int eage;        //员工年龄
	private float esalary; //员工工资
	private String deptno; //部门编号
	private String mgrno; //领导编号
	
	private Dept dept; //关联属性,映射到Dept表
	private Emp mgr;  //关联属性 映射到以领导编号为主键的虚表对象
	/**
	 * 无参构造
	 */
	public Emp() {
		super();
	}
   /**
    * 有参构造
    */
	public Emp(String empno, String ename, String esex, int eage, float esalary, String deptno, String mgrno, Dept dept,
			Emp mgr) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.esex = esex;
		this.eage = eage;
		this.esalary = esalary;
		this.deptno = deptno;
		this.mgrno = mgrno;
		this.dept = dept;
		this.mgr = mgr;
	}
public String getEmpno() {
	return empno;
}
public void setEmpno(String empno) {
	this.empno = empno;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getEsex() {
	return esex;
}
public void setEsex(String esex) {
	this.esex = esex;
}
public int getEage() {
	return eage;
}
public void setEage(int eage) {
	this.eage = eage;
}
public float getEsalary() {
	return esalary;
}
public void setEsalary(float esalary) {
	this.esalary = esalary;
}
public String getDeptno() {
	return deptno;
}
public void setDeptno(String deptno) {
	this.deptno = deptno;
}
public String getMgrno() {
	return mgrno;
}
public void setMgrno(String mgrno) {
	this.mgrno = mgrno;
}
public Dept getDept() {
	return dept;
}
public void setDept(Dept dept) {
	this.dept = dept;
}
public Emp getMgr() {
	return mgr;
}
public void setMgr(Emp mgr) {
	this.mgr = mgr;
}

@Override
public String toString() {
	return "Emp [empno=" + empno + ", ename=" + ename + ", esex=" + esex + ", eage=" + eage + ", esalary=" + esalary
			+ ", deptno=" + deptno + ", mgrno=" + mgrno + ", dept=" + dept + ", mgr=" + mgr + "]";
}
	



	
}
