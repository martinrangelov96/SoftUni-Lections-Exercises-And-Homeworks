package cardealer.service;

import cardealer.domain.dtos.CustomerImportRootDto;

public interface CustomerService {

    void importCustomers(CustomerImportRootDto customerImportRootDto);
}
