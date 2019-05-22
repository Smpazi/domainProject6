package com.mpazi.repository.template.impl;

import com.mpazi.domain.template.TransferLetterTemplate;
import com.mpazi.repository.template.TranferLetterTemplateRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository("InMemoryTransferLetterTemplate")

public class TransferLetterTemplateRepositoryImpl implements TranferLetterTemplateRepository {

    private  static TransferLetterTemplateRepositoryImpl repository = null;
    private Map<String, TransferLetterTemplate> transferLetterTemplates;

    private TransferLetterTemplateRepositoryImpl(){
        this.transferLetterTemplates = new HashMap<>();
    }

    public static TransferLetterTemplateRepositoryImpl getRepository(){
        if(repository == null)
            repository = new TransferLetterTemplateRepositoryImpl();
        return repository;
    }

    @Override
    public Map<String, TransferLetterTemplate> getAll() {
        return transferLetterTemplates;
    }

    @Override
    public TransferLetterTemplate create(TransferLetterTemplate transferLetterTemplate) {
        transferLetterTemplates.put(transferLetterTemplate.getTransfer_ID(),transferLetterTemplate);
        TransferLetterTemplate savedTrans = transferLetterTemplates.get(transferLetterTemplate.getTransfer_ID());
        return savedTrans;
    }

    @Override
    public TransferLetterTemplate update(TransferLetterTemplate transferLetterTemplate) {
        transferLetterTemplates.put(transferLetterTemplate.getTransfer_ID(),transferLetterTemplate);
        TransferLetterTemplate savedTrans = transferLetterTemplates.get(transferLetterTemplate.getTransfer_ID());
        return savedTrans;    }

    @Override
    public void delete(String s) {
        transferLetterTemplates.remove(s);
    }

    @Override
    public TransferLetterTemplate read(String s) {
        TransferLetterTemplate letterTemplate =transferLetterTemplates.get(s);
        return letterTemplate;
    }
}
