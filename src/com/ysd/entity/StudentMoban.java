package com.ysd.entity;

import com.ysd.util.PoiHandler;

public class StudentMoban {
	
	
	
	@PoiHandler(excelHeader = "ѧ��������")
	private String Name;// ѧ��������
	@PoiHandler(excelHeader = "ѧ��������")
	private int Age;// ѧ��������
	@PoiHandler(excelHeader = "ѧ�����Ա�")
	private String Sex;// ѧ�����Ա�
	@PoiHandler(excelHeader = "ѧ�����ֻ���")
	private String Phone;// ѧ�����ֻ���
	@PoiHandler(excelHeader = "ѧ��")
	private String StuStatus;// ѧ��
	@PoiHandler(excelHeader = "״̬")
	private String PerState;// ״̬
	@PoiHandler(excelHeader = "��Դ����")
	private String MsgSource;// ��Դ����
	@PoiHandler(excelHeader = "��Դ��վ")
	private String SourceUrl;// ��Դ��վ
	@PoiHandler(excelHeader = "��Դ�ؼ���")
	private String SourceKeyWord;// ��Դ�ؼ���
	@PoiHandler(excelHeader = "��������")
	private String Address;// ��������
	@PoiHandler(excelHeader = "ѧ����QQ��")
	private String QQ;// ѧ����QQ��
	@PoiHandler(excelHeader = "�Ƿ񱨱�")
	private String IsBaoBei;// �Ƿ񱨱�
	@PoiHandler(excelHeader = "΢��")
	private String WeiXin;// ΢��
	@PoiHandler(excelHeader = "��ע��Ϣ")
	private String Content;// ��ע��Ϣ
	@PoiHandler(excelHeader = "ѧ��������", excelIgnore = true)
	private String AskerId;
	@PoiHandler(excelHeader = "ѧ��������", excelIgnore = true)
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
