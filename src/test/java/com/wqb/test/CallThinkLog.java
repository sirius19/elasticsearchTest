package com.wqb.test;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * create by Administrator at 2018/10/22 22:56
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Document(indexName = "call_think_log_201810",
        type = "call_think_log", shards = 6, refreshInterval = "-1")
public class CallThinkLog implements Serializable {
    private static final long serialVersionUID = -3384299992213697404L;

    private String id;
    private String vccId;// 企业编号
    private String agId;// 坐席编号
    private String agNum; // 坐席工号
    private String agName; // 坐席名称
    private Long queId; // 技能组id
    private String queName;// 技能组名称
    private Long groupId;
    private Byte callType; // 呼叫类型 1:外呼，2呼入
    private String callId;// 呼叫唯一标识
    private String extId;
    private String agcdrId;
    private String agPhone;// 分机号码
    private String cusPhone; // 客户号码
    private String servNum;// 主叫号码
    private Long startTime;// 开始时间（秒）
    private Long connTime;// 接通时间（秒）
    private Long endTime; // 结束时间（秒）
    private Integer ringSecs;// 振铃时长 （秒）
    private Integer connSecs; // 接通时长（秒）
    private Long allSecs;// 总时长（秒）
    private Byte result; // 呼叫结果 0 接通， 其他：未接通
    private String endresult;
    private String recordMark;
    private String recordFile;
    private String evaluate;// 满意度
    private String agPhoneAreacode;
    private String agPhoneAreaname;
    private String agPhoneType;
    private String agPhoneVendor;
    private String cusPhoneAreacode; // 客户号码所在区号
    private String cusPhoneAreaname;// 客户号码省市
    private String cusPhoneType;// 号码类型
    private String cusPhoneVendor;
    private Long userId; // 拨打坐席ID
    private Boolean own; // 拨打时在自己名下1 不在0

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVccId() {
        return vccId;
    }

    public void setVccId(String vccId) {
        this.vccId = vccId;
    }

    public String getAgId() {
        return agId;
    }

    public void setAgId(String agId) {
        this.agId = agId;
    }

    public String getAgNum() {
        return agNum;
    }

    public void setAgNum(String agNum) {
        this.agNum = agNum;
    }

    public String getAgName() {
        return agName;
    }

    public void setAgName(String agName) {
        this.agName = agName;
    }

    public Long getQueId() {
        return queId;
    }

    public void setQueId(Long queId) {
        this.queId = queId;
    }

    public String getQueName() {
        return queName;
    }

    public void setQueName(String queName) {
        this.queName = queName;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Byte getCallType() {
        return callType;
    }

    public void setCallType(Byte callType) {
        this.callType = callType;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public String getExtId() {
        return extId;
    }

    public void setExtId(String extId) {
        this.extId = extId;
    }

    public String getAgcdrId() {
        return agcdrId;
    }

    public void setAgcdrId(String agcdrId) {
        this.agcdrId = agcdrId;
    }

    public String getAgPhone() {
        return agPhone;
    }

    public void setAgPhone(String agPhone) {
        this.agPhone = agPhone;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getServNum() {
        return servNum;
    }

    public void setServNum(String servNum) {
        this.servNum = servNum;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getConnTime() {
        return connTime;
    }

    public void setConnTime(Long connTime) {
        this.connTime = connTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getRingSecs() {
        return ringSecs;
    }

    public void setRingSecs(Integer ringSecs) {
        this.ringSecs = ringSecs;
    }

    public Integer getConnSecs() {
        return connSecs;
    }

    public void setConnSecs(Integer connSecs) {
        this.connSecs = connSecs;
    }

    public Long getAllSecs() {
        return allSecs;
    }

    public void setAllSecs(Long allSecs) {
        this.allSecs = allSecs;
    }

    public Byte getResult() {
        return result;
    }

    public void setResult(Byte result) {
        this.result = result;
    }

    public String getEndresult() {
        return endresult;
    }

    public void setEndresult(String endresult) {
        this.endresult = endresult;
    }

    public String getRecordMark() {
        return recordMark;
    }

    public void setRecordMark(String recordMark) {
        this.recordMark = recordMark;
    }

    public String getRecordFile() {
        return recordFile;
    }

    public void setRecordFile(String recordFile) {
        this.recordFile = recordFile;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getAgPhoneAreacode() {
        return agPhoneAreacode;
    }

    public void setAgPhoneAreacode(String agPhoneAreacode) {
        this.agPhoneAreacode = agPhoneAreacode;
    }

    public String getAgPhoneAreaname() {
        return agPhoneAreaname;
    }

    public void setAgPhoneAreaname(String agPhoneAreaname) {
        this.agPhoneAreaname = agPhoneAreaname;
    }

    public String getAgPhoneType() {
        return agPhoneType;
    }

    public void setAgPhoneType(String agPhoneType) {
        this.agPhoneType = agPhoneType;
    }

    public String getAgPhoneVendor() {
        return agPhoneVendor;
    }

    public void setAgPhoneVendor(String agPhoneVendor) {
        this.agPhoneVendor = agPhoneVendor;
    }

    public String getCusPhoneAreacode() {
        return cusPhoneAreacode;
    }

    public void setCusPhoneAreacode(String cusPhoneAreacode) {
        this.cusPhoneAreacode = cusPhoneAreacode;
    }

    public String getCusPhoneAreaname() {
        return cusPhoneAreaname;
    }

    public void setCusPhoneAreaname(String cusPhoneAreaname) {
        this.cusPhoneAreaname = cusPhoneAreaname;
    }

    public String getCusPhoneType() {
        return cusPhoneType;
    }

    public void setCusPhoneType(String cusPhoneType) {
        this.cusPhoneType = cusPhoneType;
    }

    public String getCusPhoneVendor() {
        return cusPhoneVendor;
    }

    public void setCusPhoneVendor(String cusPhoneVendor) {
        this.cusPhoneVendor = cusPhoneVendor;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getOwn() {
        return own;
    }

    public void setOwn(Boolean own) {
        this.own = own;
    }

    @Override
    public String toString() {
        return this.id + "," + this.cusPhone + "," + this.agName + "," + this.agId + "," + this.agNum;
    }
}
