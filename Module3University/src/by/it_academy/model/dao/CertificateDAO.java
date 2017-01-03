package by.it_academy.model.dao;

import by.it_academy.model.entity4dao.Certificate;

/**
 * @author head4max
 *
 */
public interface CertificateDAO extends AbstractDAO<Certificate> {

	int getFacultySumMark(int id);
	int getAverageMark(int id);
}
