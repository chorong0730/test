package com.sap.alicloud.hc.SpringBootHANADemo.model;

import javax.persistence.*;

@Entity
@Table(name = "\"ECM_JOB_EXECUTION_STATUS\"")
public class JobExecutionStatus {

    @Id
    @Column(name = "\"JOB_ID\"", length = 200)
    private String jobId;
    @Column(name = "\"JOB_NAME\"", length = 190)
    private String jobName;
    @Column(name = "\"START_TIME\"")
    private long startTime;
    @Column(name = "\"STATUS\"", length = 16)
    private String status;
    @Column(name = "\"RESULT\"", length = 250)
    private String result;


    public JobExecutionStatus() {
    	
    }
    
    public JobExecutionStatus(String string, String string2, long long1, String string3, String string4) {
		this.jobId = string;
		this.jobName = string2;
		this.startTime = long1;
		this.status = string3;
		this.result = string4;
	}

	public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}