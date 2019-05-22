package com.mpazi.service.template.impl;

import com.mpazi.domain.template.ReferralLetterTemplate;
import com.mpazi.repository.template.ReferralLetterTemplateRepository;
import com.mpazi.repository.template.impl.ReferralLetterTemplateRepositoryImpl;
import com.mpazi.service.template.ReferralLetterTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service ("ServiceImpReferralLetterTemplate")
public class ReferralLetterTemplateServiceImpl implements ReferralLetterTemplateService {
    @Autowired
    @Qualifier("InMemoryReferralLetterTemplate")
    private  static ReferralLetterTemplateServiceImpl service = null;

    ReferralLetterTemplateRepository repository = ReferralLetterTemplateRepositoryImpl.getRepository();

    public static ReferralLetterTemplateServiceImpl getInstance(){
        if(service == null)
            service =new ReferralLetterTemplateServiceImpl();
        return service;
    }
    @Override
    public Map<String, ReferralLetterTemplate> getAll() {
        return repository.getAll();
    }

    @Override
    public ReferralLetterTemplate create(ReferralLetterTemplate referralLetterTemplate) {
        return repository.create(referralLetterTemplate);
    }

    @Override
    public ReferralLetterTemplate update(ReferralLetterTemplate referralLetterTemplate) {
        return repository.update(referralLetterTemplate);
    }

    @Override
    public void delete(String s) {

        repository.delete(s);
    }

    @Override
    public ReferralLetterTemplate read(String s) {
        return repository.read(s);
    }
}
