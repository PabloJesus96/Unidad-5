package mx.utng.practice.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import mx.utng.practice.model.Contact;
import mx.utng.practice.model.Customer;
import mx.utng.practice.repository.CustomerRepository;

@Named
@ViewScoped
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	private Customer customer = new Customer();
	private List<Customer> customers;
	private boolean editMode = false;
	// private String descriptionContact;
	private Contact contact = new Contact();

	@PostConstruct
	public void init() {
		setCustomers(customerRepository.findAll());
	}

	public void save() {
		customerRepository.save(customer);
		if (!editMode) {
			getCustomers().add(customer);
		}
		customer = new Customer();
		setEditMode(false);
	}

	public void delete(Customer customer) {
		customerRepository.delete(customer);
		customers.remove(customer);
	}

	public void update(Customer customer) {
		setCustomer(customer);
		setEditMode(true);
	}

	public void cancel() {
		customer = new Customer();
		setEditMode(false);
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void addContact() {
		// Contact contact=new Contact(getDescriptionContact());

		contact.setCustomer(customer);
		customer.getContacts().add(contact);
		// setDescriptionContact("");
		contact = new Contact();
	}

	/*
	 * public String getDescriptionContact() { return descriptionContact; }
	 * 
	 * public void setDescriptionContact(String descriptionContact) {
	 * this.descriptionContact = descriptionContact; }
	 */

	public void removeContact(Contact contact) {
		customer.getContacts().remove(contact);
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
