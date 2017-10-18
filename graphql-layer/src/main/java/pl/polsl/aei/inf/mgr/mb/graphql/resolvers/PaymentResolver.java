package pl.polsl.aei.inf.mgr.mb.graphql.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphUtils;
import com.coxautodev.graphql.tools.GraphQLResolver;

import pl.polsl.aei.inf.mgr.mb.model.CustomerEntity;
import pl.polsl.aei.inf.mgr.mb.model.PaymentEntity;
import pl.polsl.aei.inf.mgr.mb.model.RentalEntity;
import pl.polsl.aei.inf.mgr.mb.model.StaffEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.PaymentRepository;

@Component
public class PaymentResolver implements GraphQLResolver<PaymentEntity>
{
	@Autowired
	private PaymentRepository paymentRepository;

	CustomerEntity getCustomer(final PaymentEntity payment)
	{
		return paymentRepository.findOne(payment.getPaymentId(), EntityGraphUtils.fromName("Payment.customer")).getCustomer();
	}


	RentalEntity getRental(final PaymentEntity payment)
	{
		return paymentRepository.findOne(payment.getPaymentId(), EntityGraphUtils.fromName("Payment.rental")).getRental();
	}


	StaffEntity getStaff(final PaymentEntity payment)
	{
		return paymentRepository.findOne(payment.getPaymentId(), EntityGraphUtils.fromName("Payment.staff")).getStaff();
	}
}
