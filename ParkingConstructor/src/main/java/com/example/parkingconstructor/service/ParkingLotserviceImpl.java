package com.example.parkingconstructor.service;

import java.util.List;
import java.util.Optional;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.parkingconstructor.ParkingConstructorApplication;
import com.example.parkingconstructor.dto.ResponseDetailsDTO;
import com.example.parkingconstructor.entity.LotDetail;
import com.example.parkingconstructor.entity.ParkingConfirmartionDTO;
import com.example.parkingconstructor.entity.ParkingReqDTO;
import com.example.parkingconstructor.exception.RecordNotFoundException;
import com.example.parkingconstructor.repo.AllocatedParkingRepo;
import com.example.parkingconstructor.repo.LotDetailsRepo;
import com.example.parkingconstructor.repo.ParkingRequestRepo;

@Service
public class ParkingLotserviceImpl implements ParkingLotservice {
	
	@Autowired
	LotDetailsRepo lotRepo;
	
	@Autowired
	ParkingRequestRepo parkRepo;
	
	@Autowired
	AllocatedParkingRepo allocRepo;
	
	

	@Override
	@Transactional
	public ResponseDetailsDTO processReqParkingDetails(ParkingReqDTO details ) throws RecordNotFoundException {
		
		ResponseDetailsDTO resposne;
		details.setStatus("Y");
		details=parkRepo.save(details);
		 resposne=new ResponseDetailsDTO();
		 resposne.setErrorCode(HttpStatus.OK.toString());
		 resposne.setMsg("Parking "+details.getReqType()+" sucessfully processed");
		 resposne.setRefId(details.getRequestID());
		 return resposne;
	}



	@Override
	public ParkingConfirmartionDTO checkalocatedParking(long parkingId) throws RecordNotFoundException {
		ParkingConfirmartionDTO value=allocRepo.getAllocatedParkingByID(parkingId);
		return value;
	}
}
//	
//	@Transactional
//	@Override
//	public List<LotDetail> searchavailablelot() throws RecordNotFoundException {
//		List<LotDetail> availots=lotRepo.findavailotBystatus();
//		if(availots.size()==0) {
//			throw new RecordNotFoundException("Parking Full ! Lots Not available");
//		}
//		return availots;
//	}
//	
//	@Transactional
//	@Override
//	public List<LotDetail> searchafilledlot() throws RecordNotFoundException {
//		List<LotDetail> notavailots=lotRepo.findNotavailotBystatus();
//		System.out.println("lotbytype: "+notavailots.size());
//		if(notavailots.size()==0) {
//			throw new RecordNotFoundException("Not yet parked vehicles! All Lots are available");
//		}
//		return notavailots;
//	}
//
//	@Override
//	public LotDetail findByLotType(long lottype) throws RecordNotFoundException{
//		
//		Optional<Entry<Long, String>>  result;
//		LotDetail avalilableLot;
//		
//		if(lottype==2) {
//			result = ParkingConstructorApplication.twoWhellerLots.entrySet()
//				      .stream()
//				      .filter(map -> "Available".equalsIgnoreCase(map.getValue()))
//				      .findFirst();
//			
//			if(result.isPresent()) {
//				   avalilableLot=ParkingConstructorApplication.twoWheelerlotDetails.get(result.get().getKey());
//			   }else {
//					throw new RecordNotFoundException("Sorry Parking Slot Full");
//			   }
//			
//		}else {
//			result = ParkingConstructorApplication.fourWhellerLots.entrySet()
//				      .stream()
//				      .filter(map -> "Available".equalsIgnoreCase(map.getValue()))
//				      .findFirst();
//			if(result.isPresent()) {
//				   avalilableLot=ParkingConstructorApplication.fourWheelerlotDetails.get(result.get().getKey());
//			   }else {
//					throw new RecordNotFoundException("Sorry Parking Slot Full");
//			   }
//			
//		}
//		return avalilableLot;
//		
//		
//		
//	}
//
//	@Transactional
//	@Override
//	public LotDetail chackandpark(long lotid, long lottype) throws RecordNotFoundException {
//		Optional<LotDetail> checklot=lotRepo.findById(lotid);
//		if(checklot.isPresent()) {
//			LotDetail lotinfo=checklot.get();
//			if(lottype ==lotinfo.getLottype()) {
//				if(lotinfo.getStatus().equalsIgnoreCase("y")) {
//					lotinfo.setStatus("N");
//					return lotRepo.save(lotinfo);
					
//				}else {
//					System.out.println("Parking lot "+lotid+" Not available");
//					throw new RecordNotFoundException("Parking lot "+lotid+" Not available");
//				}
//			}else {
//				System.out.println("This parking available for "+lotinfo.getLottype()+" wheel only");
//				throw new RecordNotFoundException("This parking available for "+lotinfo.getLottype()+" wheel only");
//			}
			
//		}else {
//			System.out.println("Parking lot Not available");
//			throw new RecordNotFoundException("Parking lot Not available");
//		}
//	}
//
//	@Override
//	public Boolean exitparkinglot(long lotid,long lotType) throws RecordNotFoundException {
//	
//		String status="";
//		boolean lotUpdateStatus=false;
//		if(lotType==2) {
//			status=ParkingConstructorApplication.twoWhellerLots.get(lotid);
//			if("NotAvailable".equalsIgnoreCase(status)){
//				ParkingConstructorApplication.twoWhellerLots.put(lotid, "Available");
//				lotUpdateStatus=true;
//			}else if("Available".equalsIgnoreCase(status)){
//				throw new RecordNotFoundException("Parking slot already vacated");
//		    }else {
//				throw new RecordNotFoundException("Lot ID not Found");
//		    }
//		}else {
//			status=ParkingConstructorApplication.fourWhellerLots.get(lotid);
//			if("NotAvailable".equalsIgnoreCase(status)){
//				ParkingConstructorApplication.fourWhellerLots.put(lotid, "Available");
//				lotUpdateStatus=true;
//			}else if("Available".equalsIgnoreCase(status)){
//				throw new RecordNotFoundException("Parking slot already vacated");
//		    }else {
//				throw new RecordNotFoundException("Lot ID not Found");
//		    }
//		}
//		    return lotUpdateStatus;
//	}
//
//	@Override
//	public void loadallSlotDetails() throws RecordNotFoundException {
//		List<LotDetail> lotbytype=lotRepo.findavailotBystatus();
//		System.out.println("lotbytype: "+lotbytype.size());
//		if(lotbytype.size()==0) {
//			throw new RecordNotFoundException(lotbytype+" Lot Details Not Yet Configured");
//		}else {
//			lotbytype.stream().filter(e->e.getLottype()==2).forEach(e->{
//				long id=e.getLotid();
//				ParkingConstructorApplication.twoWhellerLots.put(id, "Available");
//				ParkingConstructorApplication.twoWheelerlotDetails.put(id, e);
//			});
//			
//			lotbytype.stream().filter(e->e.getLottype()==4).forEach(e->{
//				long id=e.getLotid();
//				ParkingConstructorApplication.fourWhellerLots.put(id, "Available");
//				ParkingConstructorApplication.fourWheelerlotDetails.put(id, e);
//			});
//		}
//		
//		System.out.println("Four Wheeler Details "+ParkingConstructorApplication.twoWhellerLots.toString());
//	}
//
//}
