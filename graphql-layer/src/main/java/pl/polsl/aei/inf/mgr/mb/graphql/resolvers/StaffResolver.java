package pl.polsl.aei.inf.mgr.mb.graphql.resolvers;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.coxautodev.graphql.tools.GraphQLResolver;

import pl.polsl.aei.inf.mgr.mb.model.AddressEntity;
import pl.polsl.aei.inf.mgr.mb.model.StaffEntity;
import pl.polsl.aei.inf.mgr.mb.model.StoreEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.StaffRepository;

@Component
public class StaffResolver implements GraphQLResolver<StaffEntity>
{

	@Autowired
	private StaffRepository staffRepository;


	AddressEntity getAddress(final StaffEntity staff)
	{
		return staffRepository.findOne(staff.getStaffId(), EntityGraphUtils.fromName("Staff.address")).getAddress();
	}

	StoreEntity getStore(final StaffEntity staff)
	{
		return staffRepository.findOne(staff.getStaffId(), EntityGraphUtils.fromName("Staff.store")).getStore();
	}

	List<String> getPicture(final StaffEntity staffEntity){
		try
		{
			return Arrays.asList(new String(staffEntity.getPicture(), "UTF-8").split(""));
		}
		catch (UnsupportedEncodingException e)
		{
			return Collections.emptyList();
		}
	}
}
