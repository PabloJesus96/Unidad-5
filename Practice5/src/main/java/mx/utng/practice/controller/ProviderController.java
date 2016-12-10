package mx.utng.practice.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import mx.utng.practice.model.Customer;
import mx.utng.practice.model.Provider;
import mx.utng.practice.repository.ProviderRepository;

@Named
@ViewScoped
public class ProviderController {
	@Autowired
	private ProviderRepository providerRepository;
	private Provider provider = new Provider();
	private List<Provider> providers;
	
	private boolean editMode = false;
	
	@PostConstruct
	public void init(){
		setProviders(providerRepository.finAll());
	}
	
	public void save(){
		providerRepository.save(provider);
		if(!editMode){
			getProviders().add(provider);
		}
		provider = new Provider();
		setEditMode(false);
	}
	
	public void delete(Provider provider){
		providerRepository.delete(provider);
		providers.remove(provider);
	}
	
	public void update(Provider provider) {
		setProvider(provider);
		setEditMode(true);
	}

	public void cancel() {
		provider = new Provider();
		setEditMode(false);
	}
	
	public boolean isEditMode() {
		return editMode;
	}
	
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public ProviderRepository getProviderRepository() {
		return providerRepository;
	}

	public void setProviderRepository(ProviderRepository providerRepository) {
		this.providerRepository = providerRepository;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}
	
	
}
