package eu.jpereira.trainings.designpatterns.structural.facade.model;

import eu.jpereira.trainings.designpatterns.structural.facade.BookstoreFacade;
import eu.jpereira.trainings.designpatterns.structural.facade.service.BookDBService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerDBService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.OrderingService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.WharehouseService;

public class DefaultBookstoreFacade implements BookstoreFacade {

	String isbn = "123";
	String customerId = "wall-e";
	Book dummyBook;
	Customer dummyCustomer;
	Order dummyOrder;
	DispatchReceipt dummyDispatchReceipt;

	@Override
	public void placeOrder(String customerId, String isbn) {
		dummyBook = new Book(isbn);
		dummyCustomer = new Customer(customerId);
	}

	@Override
	public void setCustomerService(CustomerDBService customerService) {
		dummyCustomer = customerService.findCustomerById(customerId);

	}

	@Override
	public void setBookService(BookDBService bookService) {
		dummyBook = bookService.findBookByISBN(isbn);

	}

	@Override
	public void setBookService(OrderingService orderingService) {
		dummyOrder = orderingService.createOrder(dummyCustomer, dummyBook);

	}

	@Override
	public void setWarehouseService(WharehouseService warehouseService) {
		dummyDispatchReceipt = warehouseService.dispatch(dummyOrder);// TODO

	}



	

}
