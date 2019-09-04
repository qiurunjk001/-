package com.kgc.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.Emp;
import com.kgc.service.EmpService;
import com.kgc.util.PageBean;



@Controller
public class EmpController {
	@Resource
	EmpService ems;
	
   @RequestMapping("/emp/ Likename")
	public String Likename(@RequestParam(value="pageNo",required=false,defaultValue="1")Integer pageNo,
			                                @RequestParam(value="ename",required=false,defaultValue="")String ename,
			                                @RequestParam(value="deptno",required=false,defaultValue="")String deptno,
			                                HttpSession session){
	   List<Emp> empList = new ArrayList<Emp>();
	   int totalCount=0;
	  
	   empList = ems.queryAllOrByEnameOrByDeptno(ename, deptno);  
	   totalCount = empList.size();
	   
	   
	   if((!"".equals(ename)&&ename!=null)||(!"".equals(deptno)&&ename!=null)){
		   System.out.println("名字："+ename+"==="+"编号"+deptno);
		       empList = ems.queryAllOrByEnameOrByDeptno(ename, deptno);  
		       totalCount = empList.size();
	   }else{
		       PageHelper.startPage(pageNo, 3);
		        empList = ems.queryAllOrByEnameOrByDeptno(ename, deptno);
		      
	   }
	   
	 
	   	   
	   PageBean<Emp> pageBean = new PageBean<Emp>(pageNo, 3, empList, totalCount);
	   session.setAttribute("pageBean", pageBean);
	   session.setAttribute("ename", ename);
		return "LikeName";
	}
	
	
}
