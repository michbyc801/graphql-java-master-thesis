package pl.polsl.aei.inf.mgr.mb.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pl.polsl.aei.inf.mgr.mb.model.PaymentEntity;
import pl.polsl.aei.inf.mgr.mb.repositories.PaymentRepository;

@RestController
@Api("Payment Controller")
@RequestMapping(value = "/payments", method = RequestMethod.GET)
public class PaymentController
{
	@Autowired
	private PaymentRepository paymentRepository;

	@RequestMapping
	public List<PaymentEntity> getAllPayments()
	{
		return paymentRepository.findAll();
	}

	@RequestMapping("/{id}")
	public PaymentEntity getPaymentById(@PathVariable final Integer id)
	{
		return paymentRepository.findOne(id);
	}

	@RequestMapping("/rental/{rentalId}")
	public List<PaymentEntity> getPaymentsByRentalId(@PathVariable final Integer rentalId)
	{
		return paymentRepository.findAllByRental_RentalId(rentalId);
	}

}
