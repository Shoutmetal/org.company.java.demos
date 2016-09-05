package org.company.repository;

import org.company.domain.Address;
import org.company.domain.contracts.IAddressDAO;
import org.company.repository.base.GenericRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class AddressDAO  extends GenericRepository<Address> implements IAddressDAO {

}
