package com.scp.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scp.entities.AddressEntity;

@Repository("dao")
public class AddressDaoImpl implements AddressDao {
	@Autowired
	SessionFactory sf;

	@Override
	public List<AddressEntity> getAllAddress() {
		Session session = null;
		Transaction tr = null;
		try {
			session = sf.openSession();
			tr = session.beginTransaction();
			Query<AddressEntity> createQuery = session.createQuery("from AddressEntity", AddressEntity.class);
			List<AddressEntity> listOfAddress = createQuery.getResultList();
			return listOfAddress;
		} catch (Exception e) {
			System.out.println("Problem in fetching data...");

		} finally {
			closeResources(session, tr);
		}
		return null;
	}

	@Override
	public AddressEntity getAddress(int addressId) {

		Session session = null;
		Transaction tr = null;
		try {
			session = sf.openSession();
			tr = session.beginTransaction();
			AddressEntity addressEntity = session.get(AddressEntity.class,
					addressId);

			if (addressId == addressEntity.getAddressId())
				return addressEntity;
			else
				return null;
		} catch (Exception e) {
			System.out.println("Problem in fetching data..");
		} finally {
			closeResources(session, tr);
		}
		return null;
	}

	@Override
	public AddressEntity save(AddressEntity address) {
		AddressEntity entity = null;
		Session session = null;
		Transaction tr = null;
		try {
			session = sf.openSession();
			tr = session.beginTransaction();
			session.save(address);
		} catch (Exception e) {
			System.out.println("Problem in fetching data..");
		} finally {
			closeResources(session, tr);
		}
		return address;
	}

	@Override
	public AddressEntity updateAddress(AddressEntity address,int addressId) {

		Calendar.getInstance();
		Runtime.getRuntime();

		Session session = null;
		Transaction tr = null;
		try {
			session = sf.openSession();
			tr = session.beginTransaction();
			AddressEntity addrEntity = session.get(AddressEntity.class,address.getAddressId());
			if (addrEntity.getAddressId() == addressId) {
				addrEntity.setCity(address.getCity());
				addrEntity.setActive(address.getActive());
				return addrEntity;
			}

		} catch (Exception e) {
			System.out.println("Problem in fetching data..");
		} finally {
			closeResources(session, tr);
		}
		return null;
	}

	@Override
	public String delete(int addressId) {

		Session session = null;
		Transaction tr = null;
		try {
			session = sf.openSession();
			tr = session.beginTransaction();
			AddressEntity addrEntity = session.get(AddressEntity.class,
					addressId);
			System.out.println(addrEntity.getAddressId());
			session.delete(addrEntity);

			return "deleted...";
		} catch (Exception e) {

		}
		System.out.println("in if..");
		return null;
	}

	private void closeResources(Session session, Transaction tr) {
		if (session != null) {
			if (tr != null) {
				session.flush();
				tr.commit();
			}
			session.close();
		}

	}

}
