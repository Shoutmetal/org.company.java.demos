package org.company.repository;

import org.company.domain.Role;
import org.company.domain.contracts.IRoleDAO;
import org.company.repository.base.GenericRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class RoleDAO extends GenericRepository<Role> implements IRoleDAO {

}
