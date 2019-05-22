package com.mpazi.service.template.impl;

import com.mpazi.domain.template.TransferLetterTemplate;
import com.mpazi.repository.template.TranferLetterTemplateRepository;
import com.mpazi.repository.template.impl.TransferLetterTemplateRepositoryImpl;
import com.mpazi.service.template.TransferLetterTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service ("ServiceImpTransferLetterTemplate")
public class TransferLetterTemplateServiceImpl implements TransferLetterTemplateService {
    @Autowired
    @Qualifier("InMemoryTransferLetterTemplate")
    private  static TransferLetterTemplateServiceImpl service = null;

    TranferLetterTemplateRepository repository = TransferLetterTemplateRepositoryImpl.getRepository();

    public static TransferLetterTemplateServiceImpl getInstance(){
        if(service == null)
            service =new TransferLetterTemplateServiceImpl();
        return service;
    }
    @Override
    public Map<String, TransferLetterTemplate> getAll() {
        return repository.getAll();
    }

    @Override
    public TransferLetterTemplate create(TransferLetterTemplate transferLetterTemplate) {
        return repository.create(transferLetterTemplate);
    }

    @Override
    public TransferLetterTemplate update(TransferLetterTemplate transferLetterTemplate) {
        return repository.update(transferLetterTemplate);
    }

    @Override
    public void delete(String s) {

        repository.delete(s);
    }

    @Override
    public TransferLetterTemplate read(String s) {
        return repository.read(s);
    }
}
