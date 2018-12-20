package com.ysd.entity;

import java.util.Date;

import com.ysd.util.PoiHandler;

/**
 * 学生的实体类
 * 
 * @author 爱新觉罗
 * 
 */
public class Students {
	@PoiHandler(excelHeader = "学生的id", excelIgnore = true)
	private int Id;// 学生的id
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
	@PoiHandler(excelHeader = "网络咨询id", excelIgnore = true)
	private String NetPusherId;// 网络咨询id
	@PoiHandler(excelHeader = "咨询师id", excelIgnore = true)
	private String AskerId;// 咨询师id
	@PoiHandler(excelHeader = "学生的QQ号")
	private String QQ;// 学生的QQ号
	@PoiHandler(excelHeader = "微信")
	private String WeiXin;// 微信
	@PoiHandler(excelHeader = "备注信息")
	private String Content;// 备注信息
	@PoiHandler(excelHeader = "创建时间")
	private String CreateTime;// 创建时间
	@PoiHandler(excelHeader = "课程方向")
	private String LearnForward;// 课程方向
	@PoiHandler(excelHeader = "是否有效")
	private String IsValid;// 是否有效
	@PoiHandler(excelHeader = "打分")
	private String Record;// 打分
	@PoiHandler(excelHeader = "是否回访")
	private String IsReturnVist;// 是否回访
	@PoiHandler(excelHeader = "首次回访时间")
	private String FirstVisitTime;// 首次回访时间
	@PoiHandler(excelHeader = "是否上门")
	private String IsHome;// 是否上门
	@PoiHandler(excelHeader = "上门时间")
	private String HomeTime;// 上门时间
	@PoiHandler(excelHeader = "无效原因")
	private String LostValid;// 无效原因
	@PoiHandler(excelHeader = "是否付款")
	private String IsPay;// 是否付款
	@PoiHandler(excelHeader = "付款时间")
	private String PayTime;// 付款时间
	@PoiHandler(excelHeader = "付款金额")
	private double Money;// 付款金额
	@PoiHandler(excelHeader = "是否退费")
	private String IsReturnMoney;// 是否退费
	@PoiHandler(excelHeader = "是否进班")
	private String IsInClass;// 是否进班
	@PoiHandler(excelHeader = "进班时间")
	private String InClassTime; // 进班时间
	@PoiHandler(excelHeader = "进班备注")
	private String InClassContent;// 进班备注
	@PoiHandler(excelHeader = "咨询师备注")
	private String AskerContent;// 咨询师备注
	@PoiHandler(excelHeader = "是否删除")
	private String IsDel;// 是否删除
	@PoiHandler(excelHeader = "来源部门")
	private String FromPart;// 来源部门
	@PoiHandler(excelHeader = "学员关注")
	private String StuConcern;// 学员关注
	@PoiHandler(excelHeader = "是否报备")
	private String IsBaoBei;// 是否报备
	@PoiHandler(excelHeader = "咨询师名字")
	private String ZiXunName;// 咨询师名字
	@PoiHandler(excelHeader = "录入人姓名")
	private String CreateUser;// 录入人姓名
	@PoiHandler(excelHeader = "退费原因")
	private String ReturnMoneyReason;// 退费原因
	@PoiHandler(excelHeader = "预付定金")
	private double PreMoney;// 预付定金
	@PoiHandler(excelHeader = "预付定金时间")
	private String PreMoneyTime;// 预付定金时间

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
