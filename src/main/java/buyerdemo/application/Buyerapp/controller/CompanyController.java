package buyerdemo.application.Buyerapp.controller;

import buyerdemo.application.Buyerapp.dto.CompanyDto;
import buyerdemo.application.Buyerapp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping
    public Object saveCompany(@RequestBody CompanyDto companyDto){
        return companyService.saveCompany(companyDto);
    }

    @GetMapping("company")
    public Object getAllCompany(){
        return companyService.getAllCompanyList();
    }

    @GetMapping("company/{id}")
    public Object getCompanyById(@PathVariable("id") Long id){
        return companyService.getCompanyById(id);
    }

    @PutMapping("/status/{id}")
    public Object statusUpdateForCompany(@PathVariable(value = "id") Long id) throws Exception {
        return companyService.companyStatusUpdate(id);
    }

    @DeleteMapping("company/{id}")
    public Object deleteCompanyById(@PathVariable("id") Long id){
        return companyService.deleteCompanyById(id);
    }
}
