package org.company.application;

import java.util.List;

import org.company.domain.Address;

public interface IAddressService {
	public void save(Address address);
	public List<Address> findAll();
}
