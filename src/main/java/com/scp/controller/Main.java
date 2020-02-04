package com.scp.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.scp.beans.AddressBean;
import com.scp.config.SpringHiberConfig;
import com.scp.entities.AccountEntity;
import com.scp.entities.AddressEntity;
import com.scp.entities.BankEntity;
import com.scp.entities.CustomerEntity;
import com.scp.service.Impl.AddressServiceImpl;


public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringHiberConfig.class);
		AddressServiceImpl service = (AddressServiceImpl) context.getBean("service");
		//AddressBean adr = new AddressBean(40, "PUNE", "Y");
		//service.save(adr);
		//service.delete(2);
		
		List<AddressBean> allAddress = service.getAllAddress();
		System.out.println(allAddress);
		
	/*		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringHiberConfig.class);
		SessionFactory sf = (SessionFactory) context.getBean("sf");
		
		AddressEntity addr1 = new AddressEntity(1, "PUNE", "Y");
		List<AddressEntity> custAddr = new ArrayList<>();
		custAddr.add(addr1);
		
		CustomerEntity cust1 = new CustomerEntity(1, "ajay", "Y", custAddr);
		AccountEntity acuCust1 = new AccountEntity(1, "Saving", "Y",cust1);
		CustomerEntity cust2 = new CustomerEntity(2, "mukund", "Y", custAddr);
		AccountEntity acuCust2 = new AccountEntity(2, "Saving", "Y",cust2);

		List<CustomerEntity> custList = new ArrayList<CustomerEntity>();
		custList.add(cust1);
		custList.add(cust2);
		
		BankEntity bankEntity = new BankEntity(101, "SBI", "Y", custList);
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(bankEntity);
		session.save(cust1);
		session.save(cust2);
		session.save(acuCust2);
		session.save(acuCust1);

		session.save(addr1);
		session.flush();
		tr.commit();
		System.out.println(sf);
*/		
	}
}
