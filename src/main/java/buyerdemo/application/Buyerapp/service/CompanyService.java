package buyerdemo.application.Buyerapp.service;

import buyerdemo.application.Buyerapp.dto.CompanyDto;

public interface CompanyService {

    Object saveCompany(CompanyDto companyDto);

    Object getAllCompanyList();

    Object getCompanyById(Long id);

    Object companyStatusUpdate(Long id) throws Exception;

    Object deleteCompanyById(Long id);

}
