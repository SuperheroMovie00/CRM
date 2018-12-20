package com.ysd.entity;

import com.ysd.util.PoiHandler;

public class StudentMoban {
	
	
	
	@PoiHandler(excelHeader = "学生的名字")
	private String Name;// 学生的名字
	@PoiHandler(excelHeader = "学生的年龄")
	private int Age;// 学生的年龄
	@PoiHandler(excelHeader = "学生的性别")
	private String Sex;// 学生的性别
	@PoiHandler(excelHeader = "学生的手机号")
	private String Phone;// 学生的手机号
	@PoiHandler(excelHeader = "学历")
	private String StuStatus;// 学历
	@PoiHandler(excelHeader = "状态")
	private String PerState;// 状态
	@PoiHandler(excelHeader = "来源渠道")
	private String MsgSource;// 来源渠道
	@PoiHandler(excelHeader = "来源网站")
	private String SourceUrl;// 来源网站
	@PoiHandler(excelHeader = "来源关键词")
	private String SourceKeyWord;// 来源关键词
	@PoiHandler(excelHeader = "所在区域")
	private String Address;// 所在区域
	@PoiHandler(excelHeader = "学生的QQ号")
	private String QQ;// 学生的QQ号
	@PoiHandler(excelHeader = "是否报备")
	private String IsBaoBei;// 是否报备
	@PoiHandler(excelHeader = "微信")
	private String WeiXin;// 微信
	@PoiHandler(excelHeader = "备注信息")
	private String Content;// 备注信息
	@PoiHandler(excelHeader = "学生的名字", excelIgnore = true)
	private String AskerId;
	@PoiHandler(excelHeader = "学生的名字", excelIgnore = true)
	private String ZiXunName;
	
	
	
	
	public String getAskerId() {
		return AskerId;
	}
	public void setAskerId(String askerId) {
		AskerId = askerId;
	}
	public String getZiXunName() {
		return ZiXunName;
	}
	public void setZiXunName(String ziXunName) {
		ZiXunName = ziXunName;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public String getIsBaoBei() {
		return IsBaoBei;
	}
	public void setIsBaoBei(String isBaoBei) {
		IsBaoBei = isBaoBei;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getStuStatus() {
		return StuStatus;
	}
	public void setStuStatus(String stuStatus) {
		StuStatus = stuStatus;
	}
	public String getPerState() {
		return PerState;
	}
	public void setPerState(String perState) {
		PerState = perState;
	}
	public String getMsgSource() {
		return MsgSource;
	}
	public void setMsgSource(String msgSource) {
		MsgSource = msgSource;
	}
	public String getSourceUrl() {
		return SourceUrl;
	}
	public void setSourceUrl(String sourceUrl) {
		SourceUrl = sourceUrl;
	}
	public String getSourceKeyWord() {
		return SourceKeyWord;
	}
	public void setSourceKeyWord(String sourceKeyWord) {
		SourceKeyWord = sourceKeyWord;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getWeiXin() {
		return WeiXin;
	}
	public void setWeiXin(String weiXin) {
		WeiXin = weiXin;
	}
	@Override
	public String toString() {
		return "StudentMoban [Name=" + Name + ", Age=" + Age + ", Sex=" + Sex
				+ ", Phone=" + Phone + ", StuStatus=" + StuStatus
				+ ", PerState=" + PerState + ", MsgSource=" + MsgSource
				+ ", SourceUrl=" + SourceUrl + ", SourceKeyWord="
				+ SourceKeyWord + ", Address=" + Address + ", QQ=" + QQ
				+ ", IsBaoBei=" + IsBaoBei + ", WeiXin=" + WeiXin
				+ ", Content=" + Content + ", AskerId=" + AskerId
				+ ", ZiXunName=" + ZiXunName + "]";
	}
	

}
