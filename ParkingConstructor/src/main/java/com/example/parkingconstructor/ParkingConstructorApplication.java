package com.example.parkingconstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.parkingconstructor.configuration.ParkFeignClient;
import com.example.parkingconstructor.configuration.RibbonConfiguration;
import com.example.parkingconstructor.entity.FreeParkingSpace;
import com.example.parkingconstructor.entity.ParkingReqDTO;
import com.example.parkingconstructor.repo.ParkingRequestRepo;
import com.example.parkingconstructor.service.ParkingLotserviceImpl;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
@RibbonClient(name="EMPLOYEE_INFO" ,configuration = RibbonConfiguration.class)
public class ParkingConstructorApplication {

	@Autowired
    public ParkingLotserviceImpl lot;
	
	@Autowired
	ParkingRequestRepo repo;
	
	@Autowired
	ParkFeignClient client;

	public static void main(String[] args) {
		SpringApplication.run(ParkingConstructorApplication.class, args);
	}
	
	@Scheduled(initialDelay = 1000, fixedRate = 10000)
	public void run() {
		FreeParkingSpace space=new FreeParkingSpace();
		List<ParkingReqDTO> details=repo.findAvailedVactePaking();
		details.forEach(e->{
			
			long lotId=client.getLotId(e.getEid());
			long noofdays =lot.caluclateDays(e.getFromDate().toString(), e.getToDate().toString());
			for(int i=0;i<8;i++) {
				space.setDate(e.getFromDate());
				space.setEmpId(e.getEid());
				space.setLotId(lotId);
				space.setReqId(e.getRequestID());
			}
		});
		//////
			}
	
}
