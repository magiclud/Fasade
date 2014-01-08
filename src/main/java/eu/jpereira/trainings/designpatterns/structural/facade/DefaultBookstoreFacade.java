package eu.jpereira.trainings.designpatterns.structural.facade;

import eu.jpereira.trainings.designpatterns.structural.facade.model.Book;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Customer;
import eu.jpereira.trainings.designpatterns.structural.facade.model.DispatchReceipt;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Order;
import eu.jpereira.trainings.designpatterns.structural.facade.service.BookDBService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerDBService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerNotificationService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.OrderingService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.WharehouseService;

public class DefaultBookstoreFacade implements BookstoreFacade {

	CustomerDBService customerService;
	BookDBService bookService;
	OrderingService orderingService;
	WharehouseService warehouseService;
	CustomerNotificationService customerNotificationService;

	@Override
	public void placeOrder(String customerId, String isbn) {

		Book dummyBook = bookService.findBookByISBN(isbn);
		Customer dummyCustomer = customerService.findCustomerById(customerId);
		Order dummyOrder = orderingService.createOrder(dummyCustomer, dummyBook);
		customerNotificationService.notifyClient(dummyOrder);
		DispatchReceipt dummyDispatchReceipt = warehouseService.dispatch(dummyOrder);
		customerNotificationService.notifyClient(dummyDispatchReceipt);

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

	@Override
	public void setNotificationService(CustomerNotificationService customerNotificationService) {
		this.customerNotificationService = customerNotificationService;

	}

}
