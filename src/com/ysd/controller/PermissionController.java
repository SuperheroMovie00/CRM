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
 * @Description:   Ȩ�޿�����
 * @author         Mashuai 
 * @Date           2018-5-10 ����6:39:06  
 * @Email          1119616605@qq.com
 */
@RestController
@RequestMapping(value="/permission",name="Ȩ��ģ��")
public class PermissionController {
	

	/**
	 * springmvc������ʱ��������������ӳ���ǩ��RequestMapper�����ռ�������װ���ö�����
	 */
    @Autowired
    private RequestMappingHandlerMapping handlerMapping;//SpringMVC���п������е�����ӳ�伯��
    @Autowired
    private PermissionService	service;
	
	/**
	 * http://localhost:8080/CRM/permission/updatePermission
	 * ����ϵͳȨ����Ϣ
	 */    
	@RequestMapping(value="/updatePermission",name="����ϵͳȨ��")
	public Object updatePermission(){
		System.out.println("����ϵͳ������Ȩ��...");
		int k =this.updateSysPermission();//�ռ�ϵͳ������Ȩ�����ݸ��µ����ݿ�
		System.out.println("ϵͳ������Ȩ��ȫ��"+k+"��������� ^_^ ");
		return "updatePermission �ɹ�����Ȩ������=>"+k;
	}
	
	
	/**
	 * �ռ�ϵͳ������Ȩ�����ݸ��µ����ݿ�
	 * ���������̰߳�ȫ�ķ���
	 */
	public int updateSysPermission(){
		
		List<String> ownList = service.queryAll();//��ѯ�����ݿ������е�����Ȩ�����ݼ���
		System.out.println("��ѯ�����ݿ������е�����Ȩ�����ݼ���=>"+ownList);
		Map<RequestMappingInfo, HandlerMethod> requestMap = handlerMapping.getHandlerMethods();//SpringMVC���п������е�����ӳ�伯��
		System.out.println("SpringMVC���п������е�����ӳ�伯��=>"+requestMap);
		Collection<HandlerMethod> handlerMethods = requestMap.values();//��ȡ����controller�����д���@RequestMapperע��ķ���
		if(handlerMethods == null || handlerMethods.size() < 1 ) return 0;//�ɹ�����0������
		List<SysPermission> pList = new ArrayList<SysPermission>();//�ռ����Ĵ�������Ȩ�޼���
		SysPermission permission = null;//����ӵ�Ȩ�޶���
		
		for(HandlerMethod method : handlerMethods){//�������д���@RequestMapperע��ķ���			
			RequestMapping anno = method.getMethodAnnotation(RequestMapping.class);//�ӿ�����ӳ�䷽����ȡ��@RequestMapperע�����
			//@RequestMapperע����û��name��ע����Ϊһ��Ȩ�޵ı�־
			if( !"".equals(anno.name()) ){//@RequestMapperע��д��name���Բ���Ȩ���ռ�������@RequestMapperע����û��name��ע����Ϊһ��Ȩ�޵ı�־
				RequestMapping namespaceMapping = method.getBeanType().getAnnotation(RequestMapping.class);//����@RequestMapperע��ķ������ڿ��������ϵ�RequestMappingע�����
				String namespace =  namespaceMapping.value()[0];//�õ�RequestMappingע���valueֵ,�������ռ�,��ģ��
				String permissionValue = (namespace+":"+anno.value()[0]).replace("/", "");//�õ�Ȩ�� ,���磺user:delete �û�ģ���ɾ��Ȩ��
				System.out.println("�õ�Ȩ�� ,���磺user:delete �û�ģ���ɾ��Ȩ��=>"+permissionValue +"Ȩ��˵��:"+anno.name());
				if( ownList.contains(permissionValue) )continue;//������ݿ��Ѿ��洢�����ע��Ȩ��,����Բ��ռ�
				if( pList.contains(permissionValue) )continue;//����Ѿ��ռ�����Ȩ��,����Բ����ظ��ռ�
				//����Ȩ�޶���,��������:Ȩ��,ģ��˵��,Ȩ��˵��
				
				
				String permissionId = UUID.randomUUID().toString();
				permission = new SysPermission(permissionId,permissionValue,namespaceMapping.name(), anno.name());//��Ȩ�޿���ע��@Permission����ΪȨ�޿��ƶ���SysPermission,����������ݿ�Ȩ�ޱ�
				
				pList.add(permission);//�����ݿ�û�д洢��,�ռ�������Ҳû���ռ����ĵ�Ȩ�޼����ռ�������.
			}			
		}		
		return pList.size()>0?service.batchInsert(pList):0;
	}
	
	
	/**
	 * http://localhost:8080/CRM/permission/queryNode
	 * ����ϵͳȨ����Ϣ
	 */
	
	//��ȡ��ɫ����ӵ�е�Ȩ��
	@RequestMapping(value="/queryNode",name="��ȡ�û�û��ӵ�е�Ȩ��")
	public Object queryNode(String roleId){
		return service.queryNode(roleId);
	}
	
	//��ȡ��ɫ��ӵ�е�Ȩ��
	@RequestMapping(value="/queryNotNode",name="��ȡ�û�ӵ�е�Ȩ��")
	public Object queryNotNode(String roleId){
		return service.queryNotNode(roleId);
	}

	
	//���ݽ�ɫ�����ֲ�ѯȨ��
	@RequestMapping("queryNodeer")
	@ResponseBody
	public List<Node> selectallpermission(String roleName){
		System.out.println(roleName);
		List<Node> list=service.selectallpermission(roleName);
		return list;
	} 

	//����Ȩ�޵����ֲ�ѯȨ��
		@RequestMapping(value="selectpermissionfromname",name="�������ֲ�Ȩ��")
		@ResponseBody
		public List<Node> selectpermissionfromname(String name){
			System.out.println(name);
			
			List<Node> list=service.selectpermissionfromname(name);
			
			
			return list;
		}
	
		
		//����ɫ����Ȩ��
		@RequestMapping(value="rolesetpermission",name="���ý�ɫȨ��")
		@ResponseBody
		public Result rolesetpermission(String rId,@RequestParam("permissionId")List<String> permissionId){
			
			List<rolepermission> list=new ArrayList<rolepermission>();
			for (int i = 0; i < permissionId.size(); i++) {
				//UUID����һ��Ψһֵ��forѭ���������Ҳ��뵽Rolemodule������
				String id=UUID.randomUUID().toString();
				list.add(i, new rolepermission(id,rId, permissionId.get(i)));
			}
			return service.rolesetpermission(list);
		}
		
		
		//����ɫɾ��Ȩ��
		@RequestMapping(value="deleterolepermission",name="ɾ����ɫȨ��")
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
			
			System.out.println("Ȩ�޵�id"+permissionId);
			
			//���Ƚ��˽�ɫӵ�е�Ȩ��ȫ��ɾ��
			service.deletepermission(rId);
			
			List<rolepermission> list=new ArrayList<rolepermission>();
			
			//Ȼ�������ѡ�е�Ȩ��
			for (String string : permissionId) {
				if(!string.equals("null")){
					String id=UUID.randomUUID().toString();
					list.add(new rolepermission(id,rId, string));
				}
			}
			return service.rolesetpermission(list);
		}
		
		
		

	
	

}

