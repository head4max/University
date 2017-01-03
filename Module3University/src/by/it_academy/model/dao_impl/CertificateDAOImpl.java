/**
 * 
 */
package by.it_academy.model.dao_impl;

import java.util.List;

import by.it_academy.model.dao.CertificateDAO;
import by.it_academy.model.entity4dao.Certificate;

/**
 * @author head4max
 *
 */
public class CertificateDAOImpl implements CertificateDAO {

	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.AbstractDAO#create(java.util.List)
	 */
	@Override
	public void create(List<Certificate> entity) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.AbstractDAO#add(by.it_academy.model.entity4dao.Entity)
	 */
	@Override
	public boolean add(Certificate entity) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.AbstractDAO#delete(int)
	 */
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.AbstractDAO#getById(int)
	 */
	@Override
	public Certificate getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see by.it_academy.model.dao.AbstractDAO#getAll()
	 */
	@Override
	public List<Certificate> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFacultySumMark(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAverageMark(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
