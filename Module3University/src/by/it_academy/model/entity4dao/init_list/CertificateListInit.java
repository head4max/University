package by.it_academy.model.entity4dao.init_list;

import by.it_academy.model.entity4dao.Certificate;

public class CertificateListInit extends AbstractListInit<Certificate> {

	{
		this.countUser = 4;
		this.bundleKey = "user";
		this.bundlePath = "by.it_academy.model.sql.CertificateTableInit";
	}
	
	public CertificateListInit(){
		ListInit();
	}
	
	@Override
	public Certificate getEntity(String strInit) {
		return Certificate.getInstance(strInit);
	}

}
