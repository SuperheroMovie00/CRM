package com.ysd.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.ysd.entity.Node;
import com.ysd.entity.NodeER;
import com.ysd.entity.Result;
import com.ysd.entity.SysPermission;
import com.ysd.entity.rolepermission;
import com.ysd.service.PermissionService;


/**
 * 
 * @Description:   权限控制器
 * @author         Mashuai 
 * @Date           2018-5-10 下午6:39:06  
 * @Email          1119616605@qq.com
 */
@RestController
@RequestMapping(value="/permission",name="权限模块")
public class PermissionController {
	

	/**
	 * springmvc在启动时候将所有贴有请求映射标签：RequestMapper方法收集起来封装到该对象中
	 */
    @Autowired
    private RequestMappingHandlerMapping handlerMapping;//SpringMVC所有控制器中的请求映射集合
    @Autowired
    private PermissionService	service;
	
	/**
	 * http://localhost:8080/CRM/permission/updatePermission
	 * 更新系统权限信息
	 */    
	@RequestMapping(value="/updatePermission",name="更新系统权限")
	public Object updatePermission(){
		System.out.println("更新系统中所有权限...");
		int k =this.updateSysPermission();//收集系统中所有权限数据更新到数据库
		System.out.println("系统中所有权限全部"+k+"条更新完毕 ^_^ ");
		return "updatePermission 成功更新权限条数=>"+k;
	}
	
	
	/**
	 * 收集系统中所有权限数据更新到数据库
	 * 并发访问线程安全的方法
	 */
	public int updateSysPermission(){
		
		List<String> ownList = service.queryAll();//查询出数据库中现有的所有权限数据集合
		System.out.println("查询出数据库中现有的所有权限数据集合=>"+ownList);
		Map<RequestMappingInfo, HandlerMethod> requestMap = handlerMapping.getHandlerMethods();//SpringMVC所有控制器中的请求映射集合
		System.out.println("SpringMVC所有控制器中的请求映射集合=>"+requestMap);
		Collection<HandlerMethod> handlerMethods = requestMap.values();//获取所有controller中所有带有@RequestMapper注解的方法
		if(handlerMethods == null || handlerMethods.size() < 1 ) return 0;//成功更新0条数据
		List<SysPermission> pList = new ArrayList<SysPermission>();//收集到的待新增的权限集合
		SysPermission permission = null;//待添加的权限对象
		
		for(HandlerMethod method : handlerMethods){//遍历所有带有@RequestMapper注解的方法			
			RequestMapping anno = method.getMethodAnnotation(RequestMapping.class);//从控制器映射方法上取出@RequestMapper注解对象
			//@RequestMapper注解有没有name备注是作为一个权限的标志
			if( !"".equals(anno.name()) ){//@RequestMapper注解写了name属性才做权限收集：所以@RequestMapper注解有没有name备注是作为一个权限的标志
				RequestMapping namespaceMapping = method.getBeanType().getAnnotation(RequestMapping.class);//带有@RequestMapper注解的方法所在控制器类上的RequestMapping注解对象
				String namespace =  namespaceMapping.value()[0];//得到RequestMapping注解的value值,即命名空间,即模块
				String permissionValue = (namespace+":"+anno.value()[0]).replace("/", "");//得到权限 ,例如：user:delete 用户模块的删除权限
				System.out.println("得到权限 ,例如：user:delete 用户模块的删除权限=>"+permissionValue +"权限说明:"+anno.name());
				if( ownList.contains(permissionValue) )continue;//如果数据库已经存储有这个注解权限,则忽略不收集
				if( pList.contains(permissionValue) )continue;//如果已经收集到该权限,则忽略不再重复收集
				//构造权限对象,三个参数:权限,模块说明,权限说明
				
				
				String permissionId = UUID.randomUUID().toString();
				permission = new SysPermission(permissionId,permissionValue,namespaceMapping.name(), anno.name());//把权限控制注解@Permission解析为权限控制对象SysPermission,方便插入数据库权限表
				
				pList.add(permission);//把数据库没有存储的,收集容器中也没有收集到的的权限加入收集容器中.
			}			
		}		
		return pList.size()>0?service.batchInsert(pList):0;
	}
	
	
	/**
	 * http://localhost:8080/CRM/permission/queryNode
	 * 更新系统权限信息
	 */
	
	//获取角色所不拥有的权限
	@RequestMapping(value="/queryNode",name="获取用户没有拥有的权限")
	public Object queryNode(String roleId){
		return service.queryNode(roleId);
	}
	
	//获取角色所拥有的权限
	@RequestMapping(value="/queryNotNode",name="获取用户拥有的权限")
	public Object queryNotNode(String roleId){
		return service.queryNotNode(roleId);
	}

	
	//根据角色的名字查询权限
	@RequestMapping("queryNodeer")
	@ResponseBody
	public List<Node> selectallpermission(String roleName){
		System.out.println(roleName);
		List<Node> list=service.selectallpermission(roleName);
		return list;
	} 

	//根据权限的名字查询权限
		@RequestMapping(value="selectpermissionfromname",name="根据名字查权限")
		@ResponseBody
		public List<Node> selectpermissionfromname(String name){
			System.out.println(name);
			
			List<Node> list=service.selectpermissionfromname(name);
			
			
			return list;
		}
	
		
		//给角色设置权限
		@RequestMapping(value="rolesetpermission",name="设置角色权限")
		@ResponseBody
		public Result rolesetpermission(String rId,@RequestParam("permissionId")List<String> permissionId){
			
			List<rolepermission> list=new ArrayList<rolepermission>();
			for (int i = 0; i < permissionId.size(); i++) {
				//UUID生成一个唯一值并for循环遍历并且插入到Rolemodule集合中
				String id=UUID.randomUUID().toString();
				list.add(i, new rolepermission(id,rId, permissionId.get(i)));
			}
			return service.rolesetpermission(list);
		}
		
		
		//给角色删除权限
		@RequestMapping(value="deleterolepermission",name="删除角色权限")
		@ResponseBody
		public Result deleterolepermission(String rId,@RequestParam("permissionId")List<String> permissionId){
			
			List<rolepermission> list=new ArrayList<rolepermission>();
			for (int i = 0; i < permissionId.size(); i++) {
				
				list.add(i, new rolepermission(rId, permissionId.get(i)));
			}
			return service.deleterolepermission(list);
		}
		
		
		@RequestMapping("select")
		@ResponseBody
		public List<NodeER> select(String roleId){
			return service.select(roleId);
		}
		
		@RequestMapping("shezhipermission")
		@ResponseBody
	    public Result shezhipermission(@RequestParam("permissionId")List<String> permissionId, String rId){
			
			System.out.println("权限的id"+permissionId);
			
			//首先将此角色拥有的权限全部删掉
			service.deletepermission(rId);
			
			List<rolepermission> list=new ArrayList<rolepermission>();
			
			//然后添加上选中的权限
			for (String string : permissionId) {
				if(!string.equals("null")){
					String id=UUID.randomUUID().toString();
					list.add(new rolepermission(id,rId, string));
				}
			}
			return service.rolesetpermission(list);
		}
		
		
		

	
	

}

