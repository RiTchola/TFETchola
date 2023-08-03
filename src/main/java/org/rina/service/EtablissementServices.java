package org.rina.service;

import org.rina.dao.IEtablissementJpaDao;

public class EtablissementServices {
	
	private IEtablissementJpaDao etablissementdao;
		
		public EtablissementServices(IEtablissementJpaDao etablissementdao) {
			this.etablissementdao = etablissementdao;
		}

}
