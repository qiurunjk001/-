package com.kgc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import com.kgc.entity.Emp;
import com.kgc.util.EmpProvider;
/**
 * 实现对t_emp表进行操作的方法接口
 * @author dell
 *
 */

public interface EmpDao {

    /**
     * 利用动态SQL绑定，当ename=="",进行全局查询
     * 当ename！=""，进行模糊查询
     * 当deptno！=""   进行关于deptno的查询
     * @param ename
     * @return 符合查询要求的员工对象集合
     */
/*	@Select("<script>" 
			+ " select e.empno,e.ename,e.esex,e.eage,e.esalary,"
			+ " d.deptno,d.dname,d.location,"
			+"  m.empno mno, m.ename mname"
			+ " from t_emp e inner join t_dept d "
			+ "  on e.deptno = d.deptno"
			+ "  inner join t_emp m"
			+ "  on e.mgrno =m.empno where 1=1"
			+ "<if test='ename !=\"\" and ename !=null' >"
			+ "and  instr(e.ename,#{ename})>0"
			+ "</if>"
            + "<if test='deptno !=\"\" and deptno !=null' >"
			+ "and d.deptno=#{deptno}"
			+"</if>"
			+ "</script>")*/
	@SelectProvider(type=EmpProvider.class,method="selectByEnameOrDeptno")
	@Results(id="empMapper",value={
			@	Result(id=true,column="empno",property="empno"), //标记主键
			@Result(column="ename",property="ename"),
			@Result(column="esex",property="esex"),
			@Result(column="esalary",property="esalary"),
			@Result(column="eage",property="eage"),
			@Result(column="deptno",property="dept.deptno"),
        	@Result(column="dname",property="dept.dname"),
			@Result(column="location",property="dept.location"),
			@Result(column="mno",property="mgr.empno"),
			@Result(column="mname",property="mgr.ename")
	}	
			)
	public List<Emp> SelectAllOrByEnameOrDeptno(@Param("ename") String ename,@Param("deptno") String deptno);
	/**
	 * 添加成员的方法
	 * @param emp
	 * @return 受影响的行数，以扩展功能
	 */
	@Insert("insert into t_emp values(#{empno},#{ename},${esex},#{eage},#{esalary},#{dept.deptno},#{mgr.empno})")
	public int saveEMP(Emp emp);
	/**
	 * 修改成员信息的方法
	 * @param emp
	 * @return 受影响的行数，以扩展功能
	 */
	public int updataEmp(Emp emp);
	/**
	 * 删除成员信息的方法
	 * @param empno
	 * @return 受影响的行数，以扩展功能
	 */
	@Delete("delete from t_emp where empno=#{empno}")
	public int delete(@Param("empno") String empno );



}
