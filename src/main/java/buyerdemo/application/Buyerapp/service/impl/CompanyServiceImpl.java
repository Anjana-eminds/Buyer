package buyerdemo.application.Buyerapp.service.impl;

import buyerdemo.application.Buyerapp.dto.CompanyDto;
import buyerdemo.application.Buyerapp.entities.Company;
import buyerdemo.application.Buyerapp.entities.Status;
import buyerdemo.application.Buyerapp.repository.CompanyRepository;
import buyerdemo.application.Buyerapp.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CompanyRepository companyRepository;


    @Override
    public Object saveCompany(CompanyDto companyDto) {
        Date currentDate = new Date();
        Company company = Company.builder()
                .name(companyDto.getName())
                .email(companyDto.getEmail())
                .phoneNumber(companyDto.getPhoneNumber())
                .address(companyDto.getAddress())
                .password(companyDto.getPassword())
                .status(Status.ACTIVE)
                .createdAt(currentDate)
                .build();
        companyRepository.save(company);
        return HttpStatus.OK;
    }

    @Override
    public Object getAllCompanyList() {
        List<Company> company = companyRepository.findAll();
        return company.stream()
                .map(companyEntity -> modelMapper.map(companyEntity, CompanyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Object getCompanyById(Long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isEmpty()) {
            throw new RuntimeException();
        }
        Company company = optionalCompany.get();
        return modelMapper.map(company, CompanyDto.class);
    }

    @Override
    public Object companyStatusUpdate(Long id) throws Exception{
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isEmpty()) {
            throw new Exception("Company Not Found!!");
        }
        Company company = optionalCompany.get();
        companyRepository.updateStatus(id, company.getStatus());
        return "Company status updated successfully";
    }

    @Override
    public Object deleteCompanyById(Long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isEmpty()) {
            throw new RuntimeException();
        }
        companyRepository.deleteCompany(id);
        return "Company deleted successfully";
    }

}
