package com.ysd.entity;

import java.util.Date;

import com.ysd.util.PoiHandler;

/**
 * ѧ����ʵ����
 * 
 * @author ���¾���
 * 
 */
public class Students {
	@PoiHandler(excelHeader = "ѧ����id", excelIgnore = true)
	private int Id;// ѧ����id
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
	@PoiHandler(excelHeader = "������ѯid", excelIgnore = true)
	private String NetPusherId;// ������ѯid
	@PoiHandler(excelHeader = "��ѯʦid", excelIgnore = true)
	private String AskerId;// ��ѯʦid
	@PoiHandler(excelHeader = "ѧ����QQ��")
	private String QQ;// ѧ����QQ��
	@PoiHandler(excelHeader = "΢��")
	private String WeiXin;// ΢��
	@PoiHandler(excelHeader = "��ע��Ϣ")
	private String Content;// ��ע��Ϣ
	@PoiHandler(excelHeader = "����ʱ��")
	private String CreateTime;// ����ʱ��
	@PoiHandler(excelHeader = "�γ̷���")
	private String LearnForward;// �γ̷���
	@PoiHandler(excelHeader = "�Ƿ���Ч")
	private String IsValid;// �Ƿ���Ч
	@PoiHandler(excelHeader = "���")
	private String Record;// ���
	@PoiHandler(excelHeader = "�Ƿ�ط�")
	private String IsReturnVist;// �Ƿ�ط�
	@PoiHandler(excelHeader = "�״λط�ʱ��")
	private String FirstVisitTime;// �״λط�ʱ��
	@PoiHandler(excelHeader = "�Ƿ�����")
	private String IsHome;// �Ƿ�����
	@PoiHandler(excelHeader = "����ʱ��")
	private String HomeTime;// ����ʱ��
	@PoiHandler(excelHeader = "��Чԭ��")
	private String LostValid;// ��Чԭ��
	@PoiHandler(excelHeader = "�Ƿ񸶿�")
	private String IsPay;// �Ƿ񸶿�
	@PoiHandler(excelHeader = "����ʱ��")
	private String PayTime;// ����ʱ��
	@PoiHandler(excelHeader = "������")
	private double Money;// ������
	@PoiHandler(excelHeader = "�Ƿ��˷�")
	private String IsReturnMoney;// �Ƿ��˷�
	@PoiHandler(excelHeader = "�Ƿ����")
	private String IsInClass;// �Ƿ����
	@PoiHandler(excelHeader = "����ʱ��")
	private String InClassTime; // ����ʱ��
	@PoiHandler(excelHeader = "���౸ע")
	private String InClassContent;// ���౸ע
	@PoiHandler(excelHeader = "��ѯʦ��ע")
	private String AskerContent;// ��ѯʦ��ע
	@PoiHandler(excelHeader = "�Ƿ�ɾ��")
	private String IsDel;// �Ƿ�ɾ��
	@PoiHandler(excelHeader = "��Դ����")
	private String FromPart;// ��Դ����
	@PoiHandler(excelHeader = "ѧԱ��ע")
	private String StuConcern;// ѧԱ��ע
	@PoiHandler(excelHeader = "�Ƿ񱨱�")
	private String IsBaoBei;// �Ƿ񱨱�
	@PoiHandler(excelHeader = "��ѯʦ����")
	private String ZiXunName;// ��ѯʦ����
	@PoiHandler(excelHeader = "¼��������")
	private String CreateUser;// ¼��������
	@PoiHandler(excelHeader = "�˷�ԭ��")
	private String ReturnMoneyReason;// �˷�ԭ��
	@PoiHandler(excelHeader = "Ԥ������")
	private double PreMoney;// Ԥ������
	@PoiHandler(excelHeader = "Ԥ������ʱ��")
	private String PreMoneyTime;// Ԥ������ʱ��

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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

	public String getNetPusherId() {
		return NetPusherId;
	}

	public void setNetPusherId(String netPusherId) {
		NetPusherId = netPusherId;
	}

	public String getAskerId() {
		return AskerId;
	}

	public void setAskerId(String askerId) {
		AskerId = askerId;
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

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	public String getLearnForward() {
		return LearnForward;
	}

	public void setLearnForward(String learnForward) {
		LearnForward = learnForward;
	}

	public String getIsValid() {
		return IsValid;
	}

	public void setIsValid(String isValid) {
		IsValid = isValid;
	}

	public String getRecord() {
		return Record;
	}

	public void setRecord(String record) {
		Record = record;
	}

	public String getIsReturnVist() {
		return IsReturnVist;
	}

	public void setIsReturnVist(String isReturnVist) {
		IsReturnVist = isReturnVist;
	}

	public String getFirstVisitTime() {
		return FirstVisitTime;
	}

	public void setFirstVisitTime(String firstVisitTime) {
		FirstVisitTime = firstVisitTime;
	}

	public String getIsHome() {
		return IsHome;
	}

	public void setIsHome(String isHome) {
		IsHome = isHome;
	}

	public String getHomeTime() {
		return HomeTime;
	}

	public void setHomeTime(String homeTime) {
		HomeTime = homeTime;
	}

	public String getLostValid() {
		return LostValid;
	}

	public void setLostValid(String lostValid) {
		LostValid = lostValid;
	}

	public String getIsPay() {
		return IsPay;
	}

	public void setIsPay(String isPay) {
		IsPay = isPay;
	}

	public String getPayTime() {
		return PayTime;
	}

	public void setPayTime(String payTime) {
		PayTime = payTime;
	}

	public double getMoney() {
		return Money;
	}

	public void setMoney(double money) {
		Money = money;
	}

	public String getIsReturnMoney() {
		return IsReturnMoney;
	}

	public void setIsReturnMoney(String isReturnMoney) {
		IsReturnMoney = isReturnMoney;
	}

	public String getIsInClass() {
		return IsInClass;
	}

	public void setIsInClass(String isInClass) {
		IsInClass = isInClass;
	}

	public String getInClassTime() {
		return InClassTime;
	}

	public void setInClassTime(String inClassTime) {
		InClassTime = inClassTime;
	}

	public String getInClassContent() {
		return InClassContent;
	}

	public void setInClassContent(String inClassContent) {
		InClassContent = inClassContent;
	}

	public String getAskerContent() {
		return AskerContent;
	}

	public void setAskerContent(String askerContent) {
		AskerContent = askerContent;
	}

	public String getIsDel() {
		return IsDel;
	}

	public void setIsDel(String isDel) {
		IsDel = isDel;
	}

	public String getFromPart() {
		return FromPart;
	}

	public void setFromPart(String fromPart) {
		FromPart = fromPart;
	}

	public String getStuConcern() {
		return StuConcern;
	}

	public void setStuConcern(String stuConcern) {
		StuConcern = stuConcern;
	}

	public String getIsBaoBei() {
		return IsBaoBei;
	}

	public void setIsBaoBei(String isBaoBei) {
		IsBaoBei = isBaoBei;
	}

	public String getZiXunName() {
		return ZiXunName;
	}

	public void setZiXunName(String ziXunName) {
		ZiXunName = ziXunName;
	}

	public String getCreateUser() {
		return CreateUser;
	}

	public void setCreateUser(String createUser) {
		CreateUser = createUser;
	}

	public String getReturnMoneyReason() {
		return ReturnMoneyReason;
	}

	public void setReturnMoneyReason(String returnMoneyReason) {
		ReturnMoneyReason = returnMoneyReason;
	}

	public double getPreMoney() {
		return PreMoney;
	}

	public void setPreMoney(double preMoney) {
		PreMoney = preMoney;
	}

	public String getPreMoneyTime() {
		return PreMoneyTime;
	}

	public void setPreMoneyTime(String preMoneyTime) {
		PreMoneyTime = preMoneyTime;
	}

	public Students(int id, String name, int age, String sex, String phone,
			String stuStatus, String perState, String msgSource,
			String sourceUrl, String sourceKeyWord, String address,
			String netPusherId, String askerId, String qQ, String weiXin,
			String content, String createTime, String learnForward,
			String isValid, String record, String isReturnVist,
			String firstVisitTime, String isHome, String homeTime,
			String lostValid, String isPay, String payTime, double money,
			String isReturnMoney, String isInClass, String inClassTime,
			String inClassContent, String askerContent, String isDel,
			String fromPart, String stuConcern, String isBaoBei,
			String ziXunName, String createUser, String returnMoneyReason,
			double preMoney, String preMoneyTime) {
		super();
		Id = id;
		Name = name;
		Age = age;
		Sex = sex;
		Phone = phone;
		StuStatus = stuStatus;
		PerState = perState;
		MsgSource = msgSource;
		SourceUrl = sourceUrl;
		SourceKeyWord = sourceKeyWord;
		Address = address;
		NetPusherId = netPusherId;
		AskerId = askerId;
		QQ = qQ;
		WeiXin = weiXin;
		Content = content;
		CreateTime = createTime;
		LearnForward = learnForward;
		IsValid = isValid;
		Record = record;
		IsReturnVist = isReturnVist;
		FirstVisitTime = firstVisitTime;
		IsHome = isHome;
		HomeTime = homeTime;
		LostValid = lostValid;
		IsPay = isPay;
		PayTime = payTime;
		Money = money;
		IsReturnMoney = isReturnMoney;
		IsInClass = isInClass;
		InClassTime = inClassTime;
		InClassContent = inClassContent;
		AskerContent = askerContent;
		IsDel = isDel;
		FromPart = fromPart;
		StuConcern = stuConcern;
		IsBaoBei = isBaoBei;
		ZiXunName = ziXunName;
		CreateUser = createUser;
		ReturnMoneyReason = returnMoneyReason;
		PreMoney = preMoney;
		PreMoneyTime = preMoneyTime;
	}

	public Students() {
		super();
	}

	@Override
	public String toString() {
		return "Students [Id=" + Id + ", Name=" + Name + ", Age=" + Age
				+ ", Sex=" + Sex + ", Phone=" + Phone + ", StuStatus="
				+ StuStatus + ", PerState=" + PerState + ", MsgSource="
				+ MsgSource + ", SourceUrl=" + SourceUrl + ", SourceKeyWord="
				+ SourceKeyWord + ", Address=" + Address + ", NetPusherId="
				+ NetPusherId + ", AskerId=" + AskerId + ", QQ=" + QQ
				+ ", WeiXin=" + WeiXin + ", Content=" + Content
				+ ", CreateTime=" + CreateTime + ", LearnForward="
				+ LearnForward + ", IsValid=" + IsValid + ", Record=" + Record
				+ ", IsReturnVist=" + IsReturnVist + ", FirstVisitTime="
				+ FirstVisitTime + ", IsHome=" + IsHome + ", HomeTime="
				+ HomeTime + ", LostValid=" + LostValid + ", IsPay=" + IsPay
				+ ", PayTime=" + PayTime + ", Money=" + Money
				+ ", IsReturnMoney=" + IsReturnMoney + ", IsInClass="
				+ IsInClass + ", InClassTime=" + InClassTime
				+ ", InClassContent=" + InClassContent + ", AskerContent="
				+ AskerContent + ", IsDel=" + IsDel + ", FromPart=" + FromPart
				+ ", StuConcern=" + StuConcern + ", IsBaoBei=" + IsBaoBei
				+ ", ZiXunName=" + ZiXunName + ", CreateUser=" + CreateUser
				+ ", ReturnMoneyReason=" + ReturnMoneyReason + ", PreMoney="
				+ PreMoney + ", PreMoneyTime=" + PreMoneyTime + "]";
	}

}
