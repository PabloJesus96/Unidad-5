package mx.utng.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.utng.practice.model.Customer;
import mx.utng.practice.model.Provider;

@Repository
public interface ProviderRepository extends JpaRepository  <Provider, Long>{
	@Query("select prov from Provider prov")
	public List<Provider> finAll();

}
