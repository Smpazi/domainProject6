package com.mpazi.repository.implementation.other;

import com.mpazi.domain.templete.TransferLetterTemplate;
import com.mpazi.repository.other.TranferLetterTemplateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TransferLetterTemplateRepositoryImpl implements TranferLetterTemplateRepository {

    private  static TransferLetterTemplateRepositoryImpl repository = null;
    private List<TransferLetterTemplate> transferLetterTemplates;

    private TransferLetterTemplateRepositoryImpl(){
        this.transferLetterTemplates = new ArrayList<>();
    }

    public static TransferLetterTemplateRepositoryImpl getRepository(){
        if(repository == null)
            repository = new TransferLetterTemplateRepositoryImpl();
        return repository;
    }

    @Override
    public Set<TransferLetterTemplate> getAll() {
        return null;
    }

    @Override
    public TransferLetterTemplate create(TransferLetterTemplate transferLetterTemplate) {
        return null;
    }

    @Override
    public TransferLetterTemplate update(TransferLetterTemplate transferLetterTemplate) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public TransferLetterTemplate read(String s) {
        return null;
    }
}