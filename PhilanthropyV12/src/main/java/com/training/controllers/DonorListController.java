package com.training.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.websocket.server.PathParam;

import org.services.daos.DonorDaoImpl;
import org.services.daos.ProjectDaoImpl;
import org.services.entity.Donation;
import org.services.entity.Donor;
import org.services.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.owlike.genson.Genson;

@RestController
public class DonorListController {
	
	@Autowired
	private DonorDaoImpl donorDao;
	
	@Autowired
	private ProjectDaoImpl projectDao;
	
	@RequestMapping(value = "/DonorList")
	@ResponseBody
	public String getDonors(@PathParam("projectId") long projectId){
		//get project with project id = project id
		//iterate through list of donations
		//find donors with id's assotiated in donationlist
		
		Project project = projectDao.find(projectId);
		Set<Donation> donationList = project.getDonationList();
		
		HashSet<Donor> donors = new HashSet<>();
		
		for(Donation donation : donationList){
			long donorId = donation.getDonorId();
			Donor donor = donorDao.find(donorId);
			donors.add(donor);
		}
		
		Genson serializer = new Genson();
		
		return serializer.serialize(donors);
	}
	

}
