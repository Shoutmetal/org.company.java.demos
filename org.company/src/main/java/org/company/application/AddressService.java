package org.company.application;

import java.util.List;

import org.company.domain.Address;
import org.company.domain.contracts.IAddressDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService {

	@Autowired
	private IAddressDAO addressDAO;
	
	@Override
	public void save(Address address) {
		addressDAO.save(address);
	}

	@Override
	public List<Address> findAll() {
		
		return null;
	}

}
