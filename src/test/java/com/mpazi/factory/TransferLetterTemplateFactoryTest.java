package com.mpazi.factory;

import com.mpazi.domain.templete.TransferLetterTemplate;
import com.mpazi.factory.other.factory.TransferLetterTempleteFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransferLetterTemplateFactoryTest {
    @Test
    public void getTransferLetterTest(){

        TransferLetterTemplate transferLetterTemplate = TransferLetterTempleteFactory.getTransferLetter("patient needs specialist");

        assertEquals("patient needs specialist", transferLetterTemplate.getTransferNote());

    }

}