package com.fdu.daily.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 每日上报对象 fdu_daily_update
 *
 * @author hf
 * @date 2020-11-19
 */
public class FduDailyUpdate extends BaseEntity
        {
private static final long serialVersionUID=1L;

        /** $column.columnComment */
            private Long id;

            /** 今日日期 */
                                                        @JsonFormat(pattern = "yyyy-MM-dd")
            @Excel(name = "今日日期", width = 30, dateFormat = "yyyy-MM-dd")
                        private Date todayDate;

            /** 学号 */
                                                        @Excel(name = "学号")
                        private String studentNo;

            /** 是否在校 */
                                                        @Excel(name = "是否在校")
                        private String onCampus;

            /** 所在区域 */
                                                        @Excel(name = "所在区域")
                        private String currentDistrict;

            /** 所在地点 */
                                                        @Excel(name = "所在地点")
                        private String currentLocation;

            /** 体温范围 */
                                                        @Excel(name = "体温范围")
                        private String temperature;

            /** 是否发烧咳嗽乏力 */
                                                        @Excel(name = "是否发烧咳嗽乏力")
                        private String feeling;

            /** 是否接触中高风险地区人员 */
                                                        @Excel(name = "是否接触中高风险地区人员")
                        private String contact1;

            /** 是否接触疑似确诊人员 */
                                                        @Excel(name = "是否接触疑似确诊人员")
                        private String contact2;

            /** 是否处于隔离期 */
                                                        @Excel(name = "是否处于隔离期")
                        private String isolate;

            /** 是否有其他注意事项 */
                                                        @Excel(name = "是否有其他注意事项")
                        private String other;

                                                public void setId(Long id)
            {
            this.id = id;
            }

    public Long getId()
            {
            return id;
            }
                            public void setTodayDate(Date todayDate)
            {
            this.todayDate = todayDate;
            }

    public Date getTodayDate()
            {
            return todayDate;
            }
                            public void setStudentNo(String studentNo)
            {
            this.studentNo = studentNo;
            }

    public String getStudentNo()
            {
            return studentNo;
            }
                            public void setOnCampus(String onCampus)
            {
            this.onCampus = onCampus;
            }

    public String getOnCampus()
            {
            return onCampus;
            }
                            public void setCurrentDistrict(String currentDistrict)
            {
            this.currentDistrict = currentDistrict;
            }

    public String getCurrentDistrict()
            {
            return currentDistrict;
            }
                            public void setCurrentLocation(String currentLocation)
            {
            this.currentLocation = currentLocation;
            }

    public String getCurrentLocation()
            {
            return currentLocation;
            }
                            public void setTemperature(String temperature)
            {
            this.temperature = temperature;
            }

    public String getTemperature()
            {
            return temperature;
            }
                            public void setFeeling(String feeling)
            {
            this.feeling = feeling;
            }

    public String getFeeling()
            {
            return feeling;
            }
                            public void setContact1(String contact1)
            {
            this.contact1 = contact1;
            }

    public String getContact1()
            {
            return contact1;
            }
                            public void setContact2(String contact2)
            {
            this.contact2 = contact2;
            }

    public String getContact2()
            {
            return contact2;
            }
                            public void setIsolate(String isolate)
            {
            this.isolate = isolate;
            }

    public String getIsolate()
            {
            return isolate;
            }
                            public void setOther(String other)
            {
            this.other = other;
            }

    public String getOther()
            {
            return other;
            }
                        
@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                                .append("id",getId())
                                .append("todayDate",getTodayDate())
                                .append("studentNo",getStudentNo())
                                .append("onCampus",getOnCampus())
                                .append("currentDistrict",getCurrentDistrict())
                                .append("currentLocation",getCurrentLocation())
                                .append("temperature",getTemperature())
                                .append("feeling",getFeeling())
                                .append("contact1",getContact1())
                                .append("contact2",getContact2())
                                .append("isolate",getIsolate())
                                .append("other",getOther())
                                .append("remark",getRemark())
                                .append("createBy",getCreateBy())
                                .append("createTime",getCreateTime())
                                .append("updateBy",getUpdateBy())
                                .append("updateTime",getUpdateTime())
            .toString();
        }
        }
