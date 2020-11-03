package com.cmcc.paymentclean.entity.dto.pcac.resp;

import com.cmcc.paymentclean.consts.SysLanEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "RiskInfo")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(
    name = "RiskInfoResp",
    propOrder = {
      "CusType",
      "CusProperty",
      "RiskType",
      "CusNature",
      "CusName",
      "RegName",
      "CusCode",
      "DocType",
      "DocCode",
      "LegRepName",
      "LegDocType",
      "LegDocCode",
      "BankList",
      "Url",
      "ServerIp",
      "MobileNo",
      "Address",
      "Icp",
      "Level",
      "Occurtimeb",
      "Occurtimee",
      "Occurchan",
      "Occurarea",
      "Note",
      "ValidDate",
      "OrgId",
      "RepDate",
      "RepType",
      "RepPerson",
      "RegisteredArea",
      "RegisteredCode",
      "SourceChannel",
      "Currency",
      "Amount",
      "RiskFindTime",
      "LegControlName",
      "LegControlCardType",
      "LegControlCardCode",
      "Remarks",
      "BenList",
      "Mac",
      "Imei",
      "BankNo",
      "OpenBank",
      "Ip",
      "Telephone",
      "RecHostArea",
      "Email",
      "DiskNumber",
      "TaxRegCer",
      "TelePhone",
      "RegAddress",
      "BusinessScope",
      "LegDocName",
      "ValidStatus",
      "PushDate",
      "HandleResult",
      "HandleTime",
      "Id",
      "Count",
      "BankInfo",
      "StopNum",
      "RefuseNum",
      "UseRiseNum",
      "CloseNum",
      "StopPayNum",
      "DownNum",
      "FrozenNum",
      "DelayNum",
      "QuotaNum",
      "AdjustmentCardNum",
      "AdjustmentCycleNum",
      "SuspendNum",
      "FollowNum",
      "AntiMoneyNum",
      "OtherNum"
    })
public class RiskInfo {
  private String CusType;

  private String CusProperty;

  private String RiskType;

  private String CusNature;

  private String CusName;

  private String RegName;

  private String CusCode;

  private String DocType;

  private String DocCode;

  private String LegRepName;

  private String LegDocType;

  private String LegDocCode;

  private BankList BankList;

  private String Url;

  private String ServerIp;

  private String MobileNo;

  private String Address;

  private String Icp;

  private String Level;

  private String Occurtimeb;

  private String Occurtimee;

  private String Occurchan;

  private String Occurarea;

  private String Note;

  private String ValidDate;

  private String OrgId;

  private String RepDate;

  private String RepType;

  private String RepPerson;

  private String RegisteredArea;

  private String RegisteredCode;

  private String SourceChannel;

  private String Currency;

  private String Amount;

  private String RiskFindTime;

  private String LegControlName;

  private String LegControlCardType;

  private String LegControlCardCode;

  private String Remarks;

  private BenList BenList;

  private String Mac;

  private String Imei;

  private String BankNo;

  private String OpenBank;

  private String Ip;

  private String Telephone;

  private String RecHostArea;

  private String Email;

  private String DiskNumber;

  private String TaxRegCer;

  private String TelePhone;

  private String RegAddress;

  private String BusinessScope;

  private String LegDocName;

  private String ValidStatus;

  private String PushDate;

  private String HandleResult;

  private String HandleTime;

  private String Id;

  private String Count;

  private BankInfo BankInfo;

  private String StopNum;

  private String RefuseNum;

  private String UseRiseNum;

  private String CloseNum;

  private String StopPayNum;

  private String DownNum;

  private String FrozenNum;

  private String DelayNum;

  private String QuotaNum;

  private String AdjustmentCardNum;

  private String AdjustmentCycleNum;

  private String SuspendNum;

  private String FollowNum;

  private String AntiMoneyNum;

  private String OtherNum;

  public String getCusType() {
    return CusType;
  }

  public void setCusType(String cusType) {
    CusType = cusType;
  }

  public String getCusProperty() {
    return CusProperty;
  }

  public void setCusProperty(String cusProperty) {
    CusProperty = cusProperty;
  }

  public String getRiskType() {
    return RiskType;
  }

  public void setRiskType(String riskType) {
    RiskType = riskType;
  }

  public String getCusNature() {
    return CusNature;
  }

  public void setCusNature(String cusNature) {
    CusNature = cusNature;
  }

  public String getCusName() {
    return CusName;
  }

  public void setCusName(String cusName) {
    CusName = cusName;
  }

  public String getRegName() {
    return RegName;
  }

  public void setRegName(String regName) {
    RegName = regName;
  }

  public String getCusCode() {
    return CusCode;
  }

  public void setCusCode(String cusCode) {
    CusCode = cusCode;
  }

  public String getDocType() {
    return DocType;
  }

  public void setDocType(String docType) {
    DocType = docType;
  }

  public String getDocCode() {
    return DocCode;
  }

  public void setDocCode(String docCode) {
    DocCode = docCode;
  }

  public String getLegRepName() {
    return LegRepName;
  }

  public void setLegRepName(String legRepName) {
    LegRepName = legRepName;
  }

  public String getLegDocType() {
    return LegDocType;
  }

  public void setLegDocType(String legDocType) {
    LegDocType = legDocType;
  }

  public String getLegDocCode() {
    return LegDocCode;
  }

  public void setLegDocCode(String legDocCode) {
    LegDocCode = legDocCode;
  }

  public com.cmcc.paymentclean.entity.dto.pcac.resp.BankList getBankList() {
    return BankList;
  }

  public void setBankList(com.cmcc.paymentclean.entity.dto.pcac.resp.BankList bankList) {
    BankList = bankList;
  }

  public String getUrl() {
    return Url;
  }

  public void setUrl(String url) {
    Url = url;
  }

  public String getServerIp() {
    return ServerIp;
  }

  public void setServerIp(String serverIp) {
    ServerIp = serverIp;
  }

  public String getMobileNo() {
    return MobileNo;
  }

  public void setMobileNo(String mobileNo) {
    MobileNo = mobileNo;
  }

  public String getAddress() {
    return Address;
  }

  public void setAddress(String address) {
    Address = address;
  }

  public String getIcp() {
    return Icp;
  }

  public void setIcp(String icp) {
    Icp = icp;
  }

  public String getLevel() {
    return Level;
  }

  public void setLevel(String level) {
    Level = level;
  }

  public String getOccurtimeb() {
    return Occurtimeb;
  }

  public void setOccurtimeb(String occurtimeb) {
    Occurtimeb = occurtimeb;
  }

  public String getOccurtimee() {
    return Occurtimee;
  }

  public void setOccurtimee(String occurtimee) {
    Occurtimee = occurtimee;
  }

  public String getOccurchan() {
    return Occurchan;
  }

  public void setOccurchan(String occurchan) {
    Occurchan = occurchan;
  }

  public String getOccurarea() {
    return SysLanEnum.getSysLanEnumDesc(Occurarea);
  }

  public void setOccurarea(String occurarea) {
    Occurarea = occurarea;
  }

  public String getNote() {
    return Note;
  }

  public void setNote(String note) {
    Note = note;
  }

  public String getValidDate() {
    return ValidDate;
  }

  public void setValidDate(String validDate) {
    ValidDate = validDate;
  }

  public String getOrgId() {
    return OrgId;
  }

  public void setOrgId(String orgId) {
    OrgId = orgId;
  }

  public String getRepDate() {
    return RepDate;
  }

  public void setRepDate(String repDate) {
    RepDate = repDate;
  }

  public String getRepType() {
    return RepType;
  }

  public void setRepType(String repType) {
    RepType = repType;
  }

  public String getRepPerson() {
    return RepPerson;
  }

  public void setRepPerson(String repPerson) {
    RepPerson = repPerson;
  }

  public String getRegisteredArea() {
    return RegisteredArea;
  }

  public void setRegisteredArea(String registeredArea) {
    RegisteredArea = registeredArea;
  }

  public String getRegisteredCode() {
    return RegisteredCode;
  }

  public void setRegisteredCode(String registeredCode) {
    RegisteredCode = registeredCode;
  }

  public String getSourceChannel() {
    return SourceChannel;
  }

  public void setSourceChannel(String sourceChannel) {
    SourceChannel = sourceChannel;
  }

  public String getCurrency() {
    return Currency;
  }

  public void setCurrency(String currency) {
    Currency = currency;
  }

  public String getAmount() {
    return Amount;
  }

  public void setAmount(String amount) {
    Amount = amount;
  }

  public String getRiskFindTime() {
    return RiskFindTime;
  }

  public void setRiskFindTime(String riskFindTime) {
    RiskFindTime = riskFindTime;
  }

  public String getLegControlName() {
    return LegControlName;
  }

  public void setLegControlName(String legControlName) {
    LegControlName = legControlName;
  }

  public String getLegControlCardType() {
    return LegControlCardType;
  }

  public void setLegControlCardType(String legControlCardType) {
    LegControlCardType = legControlCardType;
  }

  public String getLegControlCardCode() {
    return LegControlCardCode;
  }

  public void setLegControlCardCode(String legControlCardCode) {
    LegControlCardCode = legControlCardCode;
  }

  public String getRemarks() {
    return Remarks;
  }

  public void setRemarks(String remarks) {
    Remarks = remarks;
  }

  public com.cmcc.paymentclean.entity.dto.pcac.resp.BenList getBenList() {
    return BenList;
  }

  public void setBenList(com.cmcc.paymentclean.entity.dto.pcac.resp.BenList benList) {
    BenList = benList;
  }

  public String getMac() {
    return Mac;
  }

  public void setMac(String mac) {
    Mac = mac;
  }

  public String getImei() {
    return Imei;
  }

  public void setImei(String imei) {
    Imei = imei;
  }

  public String getBankNo() {
    return BankNo;
  }

  public void setBankNo(String bankNo) {
    BankNo = bankNo;
  }

  public String getOpenBank() {
    return OpenBank;
  }

  public void setOpenBank(String openBank) {
    OpenBank = openBank;
  }

  public String getIp() {
    return Ip;
  }

  public void setIp(String ip) {
    Ip = ip;
  }

  public String getTelephone() {
    return Telephone;
  }

  public void setTelephone(String telephone) {
    Telephone = telephone;
  }

  public String getRecHostArea() {
    return RecHostArea;
  }

  public void setRecHostArea(String recHostArea) {
    RecHostArea = recHostArea;
  }

  public String getEmail() {
    return Email;
  }

  public void setEmail(String email) {
    Email = email;
  }

  public String getDiskNumber() {
    return DiskNumber;
  }

  public void setDiskNumber(String diskNumber) {
    DiskNumber = diskNumber;
  }

  public String getTaxRegCer() {
    return TaxRegCer;
  }

  public void setTaxRegCer(String taxRegCer) {
    TaxRegCer = taxRegCer;
  }

  public String getTelePhone() {
    return TelePhone;
  }

  public void setTelePhone(String telePhone) {
    TelePhone = telePhone;
  }

  public String getRegAddress() {
    return RegAddress;
  }

  public void setRegAddress(String regAddress) {
    RegAddress = regAddress;
  }

  public String getBusinessScope() {
    return BusinessScope;
  }

  public void setBusinessScope(String businessScope) {
    BusinessScope = businessScope;
  }

  public String getLegDocName() {
    return LegDocName;
  }

  public void setLegDocName(String legDocName) {
    LegDocName = legDocName;
  }

  public String getValidStatus() {
    return ValidStatus;
  }

  public void setValidStatus(String validStatus) {
    ValidStatus = validStatus;
  }

  public String getPushDate() {
    return PushDate;
  }

  public void setPushDate(String pushDate) {
    PushDate = pushDate;
  }

  public String getHandleResult() {
    return HandleResult;
  }

  public void setHandleResult(String handleResult) {
    HandleResult = handleResult;
  }

  public String getHandleTime() {
    return HandleTime;
  }

  public void setHandleTime(String handleTime) {
    HandleTime = handleTime;
  }

  public String getId() {
    return Id;
  }

  public void setId(String id) {
    Id = id;
  }

  public String getCount() {
    return Count;
  }

  public void setCount(String count) {
    Count = count;
  }

  public com.cmcc.paymentclean.entity.dto.pcac.resp.BankInfo getBankInfo() {
    return BankInfo;
  }

  public void setBankInfo(com.cmcc.paymentclean.entity.dto.pcac.resp.BankInfo bankInfo) {
    BankInfo = bankInfo;
  }

  public String getStopNum() {
    return StopNum;
  }

  public void setStopNum(String stopNum) {
    StopNum = stopNum;
  }

  public String getRefuseNum() {
    return RefuseNum;
  }

  public void setRefuseNum(String refuseNum) {
    RefuseNum = refuseNum;
  }

  public String getUseRiseNum() {
    return UseRiseNum;
  }

  public void setUseRiseNum(String useRiseNum) {
    UseRiseNum = useRiseNum;
  }

  public String getCloseNum() {
    return CloseNum;
  }

  public void setCloseNum(String closeNum) {
    CloseNum = closeNum;
  }

  public String getStopPayNum() {
    return StopPayNum;
  }

  public void setStopPayNum(String stopPayNum) {
    StopPayNum = stopPayNum;
  }

  public String getDownNum() {
    return DownNum;
  }

  public void setDownNum(String downNum) {
    DownNum = downNum;
  }

  public String getFrozenNum() {
    return FrozenNum;
  }

  public void setFrozenNum(String frozenNum) {
    FrozenNum = frozenNum;
  }

  public String getDelayNum() {
    return DelayNum;
  }

  public void setDelayNum(String delayNum) {
    DelayNum = delayNum;
  }

  public String getQuotaNum() {
    return QuotaNum;
  }

  public void setQuotaNum(String quotaNum) {
    QuotaNum = quotaNum;
  }

  public String getAdjustmentCardNum() {
    return AdjustmentCardNum;
  }

  public void setAdjustmentCardNum(String adjustmentCardNum) {
    AdjustmentCardNum = adjustmentCardNum;
  }

  public String getAdjustmentCycleNum() {
    return AdjustmentCycleNum;
  }

  public void setAdjustmentCycleNum(String adjustmentCycleNum) {
    AdjustmentCycleNum = adjustmentCycleNum;
  }

  public String getSuspendNum() {
    return SuspendNum;
  }

  public void setSuspendNum(String suspendNum) {
    SuspendNum = suspendNum;
  }

  public String getFollowNum() {
    return FollowNum;
  }

  public void setFollowNum(String followNum) {
    FollowNum = followNum;
  }

  public String getAntiMoneyNum() {
    return AntiMoneyNum;
  }

  public void setAntiMoneyNum(String antiMoneyNum) {
    AntiMoneyNum = antiMoneyNum;
  }

  public String getOtherNum() {
    return OtherNum;
  }

  public void setOtherNum(String otherNum) {
    OtherNum = otherNum;
  }
}
