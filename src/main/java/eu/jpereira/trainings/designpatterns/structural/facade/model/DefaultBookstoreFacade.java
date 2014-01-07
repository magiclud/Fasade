package eu.jpereira.trainings.designpatterns.structural.facade.model;

import eu.jpereira.trainings.designpatterns.structural.facade.BookstoreFacade;
import eu.jpereira.trainings.designpatterns.structural.facade.service.BookDBService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerDBService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.OrderingService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.WharehouseService;

public class DefaultBookstoreFacade implements BookstoreFacade {

	CustomerDBService customerService;
	BookDBService bookService;
	OrderingService orderingService;
	WharehouseService warehouseService;

	@Override
	public void placeOrder(String customerId, String isbn) {

		Book dummyBook = new Book(isbn);
		Customer dummyCustomer = new Customer(customerId);
		dummyCustomer = customerService.findCustomerById(customerId);
		Order dummyOrder = new Order(dummyBook, dummyCustomer);
		dummyOrder = orderingService.createOrder(dummyCustomer, dummyBook);
		DispatchReceipt dummyDispatchReceipt = new DispatchReceipt(dummyOrder);
		dummyDispatchReceipt = warehouseService.dispatch(dummyOrder);
	}

	@Override
	public void setCustomerService(CustomerDBService customerService) {
		this.customerService = customerService;

	}

	@Override
	public void setBookService(BookDBService bookService) {
		this.bookService = bookService;

	}

	@Override
	public void setBookService(OrderingService orderingService) {

		this.orderingService = orderingService;
	}

	@Override
	public void setWarehouseService(WharehouseService warehouseService) {
		this.warehouseService = warehouseService;

	}

}
