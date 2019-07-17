package cardealer.service;

import cardealer.domain.dtos.CustomerImportDto;
import cardealer.domain.dtos.CustomerImportRootDto;
import cardealer.domain.entities.Customer;
import cardealer.repository.CustomerRepository;
import cardealer.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void importCustomers(CustomerImportRootDto customerImportRootDto) {
        for (CustomerImportDto customerImportDto : customerImportRootDto.getCustomerImportDtos()) {
            if (!this.validationUtil.isValid(customerImportDto)) {
                System.out.println("Something went wrong.");

                continue;
            }

            Customer customer =
                    this.modelMapper.map(customerImportDto, Customer.class);
            customer.setBirthDate(LocalDate.parse(customerImportDto.getBirthDate()));

            this.customerRepository.saveAndFlush(customer);

        }
    }
}
