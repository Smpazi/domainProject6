package com.mpazi.repository.implementation.other;

import com.mpazi.domain.templete.ReferralLetterTemplete;
import com.mpazi.repository.other.ReferralLetterTemplateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReferralLetterTempleteRepositoryImpl implements ReferralLetterTemplateRepository {

    private  static  ReferralLetterTempleteRepositoryImpl repository = null;
    private List<ReferralLetterTemplete> referralLetterTempleteList;

    private ReferralLetterTempleteRepositoryImpl(){
        this.referralLetterTempleteList = new ArrayList<>();
    }

    public static ReferralLetterTempleteRepositoryImpl getRepository(){
        if(repository == null)
            repository = new ReferralLetterTempleteRepositoryImpl();
        return repository;
    }

    @Override
    public Set<ReferralLetterTemplete> getAll() {
        return null;
    }

    @Override
    public ReferralLetterTemplete create(ReferralLetterTemplete referralLetterTemplete) {
        this.referralLetterTempleteList.add(referralLetterTemplete);
        return referralLetterTemplete;
    }

    @Override
    public ReferralLetterTemplete update(ReferralLetterTemplete referralLetterTemplete) {
        return null;
    }

    @Override
    public void delete(String referral_ID) {
        referralLetterTempleteList.remove(referral_ID);
    }

    @Override
    public ReferralLetterTemplete read(String referral_ID) {
        return null;
    }
}
