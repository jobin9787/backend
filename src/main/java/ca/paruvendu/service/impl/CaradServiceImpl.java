package ca.paruvendu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.paruvendu.domain.Carad;
import ca.paruvendu.repository.CaradRepository;
import ca.paruvendu.service.CaradService;

@Service
public class CaradServiceImpl implements CaradService {
@Autowired
private CaradRepository caradRepository;

	@Override
	public Carad save(Carad carad) {
		// TODO Auto-generated method stub
		return caradRepository.save(carad);
	}

	@Override
	public List<Carad> findAll() {
		// TODO Auto-generated method stub
		return (List<Carad>) caradRepository.findAll();
	}

	@Override
	public Carad findById(String id) {
		// TODO Auto-generated method stub
		return caradRepository.findOne(id);
	}

}
