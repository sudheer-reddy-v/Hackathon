package com.example.employeeManager.listner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
//@Log4j2
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	@Override
	public void afterJob(JobExecution jobExecution) {

		String file = new ClassPathResource("PEMPLOYEE_DETAILS.csv").getPath();
		StringBuilder destinationPath = new StringBuilder();
		destinationPath.append("employee-info_");
		destinationPath.append(String.valueOf(new Date().getMinutes()));
		destinationPath.append("_");
		destinationPath.append(String.valueOf(new Date().getSeconds()));
		destinationPath.append(".csv");
		try {
			Files.move(new File(file).toPath(), new File(destinationPath.toString()).toPath(),
					StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
//			log.error("error while moving file " + e);
		}
	}
}