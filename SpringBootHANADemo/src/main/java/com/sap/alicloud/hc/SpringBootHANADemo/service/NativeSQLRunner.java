package com.sap.alicloud.hc.SpringBootHANADemo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.sap.alicloud.hc.SpringBootHANADemo.dao.NativeSQL;
import com.sap.alicloud.hc.SpringBootHANADemo.model.JobExecutionStatus;

@Service
public class NativeSQLRunner {
	//private static int MAX_RUM = 10;

	@Autowired
	NativeSQL nativeSQL;

	@Async
	public void startTest(int num) {
		nativeSQL.createConnection();
		for (int i = 0; i < num; i++) {
			JobExecutionStatus job = new JobExecutionStatus();
			job.setJobId(UUID.randomUUID().toString());
			job.setJobName("InstanceCreationJob");
			job.setStartTime(System.currentTimeMillis());
			job.setStatus("In Progress");
			job.setResult("");

			nativeSQL.insertJob(job);

			job.setResult("Instance creation successfully completed");
			job.setStatus("Succeeded");

			nativeSQL.updateJob(job);

			nativeSQL.getJob(job.getJobId());
		}
		nativeSQL.closeConnection();
	}

	@Async
	public List<JobExecutionStatus> startTest2() {

		nativeSQL.createConnection();
		List<JobExecutionStatus> items = nativeSQL.getJobAll();
		nativeSQL.closeConnection();

		return items;
	}

	@Async
	public void startTest3() {
		nativeSQL.createConnection();
		nativeSQL.deleteJob();
		nativeSQL.closeConnection();
	}
}