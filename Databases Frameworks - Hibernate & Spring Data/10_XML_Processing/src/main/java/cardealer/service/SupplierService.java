package cardealer.service;

import cardealer.domain.dtos.SupplierImportRootDto;

public interface SupplierService {

    void importSuppliers(SupplierImportRootDto supplierImportRootDto);
}
