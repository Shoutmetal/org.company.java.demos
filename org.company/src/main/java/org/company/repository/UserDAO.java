package org.company.repository;

import org.company.domain.User;
import org.company.domain.contracts.IUserDAO;
import org.company.repository.base.GenericRepository;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserDAO extends GenericRepository<User> implements IUserDAO {

	@Override
	public User findByUsername(String username)
	{
		String hql = "select u from User u join u.Roles r where u.Username=:username";

		Query query = getSession().createQuery(hql);
		query.setParameter("username", username);
		
		return (User) query.uniqueResult();
	}
}
