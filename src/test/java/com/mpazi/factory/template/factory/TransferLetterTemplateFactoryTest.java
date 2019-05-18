package com.mpazi.factory.template.factory;

import com.mpazi.domain.template.TransferLetterTemplate;
import com.mpazi.factory.template.factory.TransferLetterTempleteFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransferLetterTemplateFactoryTest {
    @Test
    public void getTransferLetterTest(){

        TransferLetterTemplate transferLetterTemplate = TransferLetterTempleteFactory.getTransferLetter("patient needs specialist");

        assertEquals("patient needs specialist", transferLetterTemplate.getTransferNote());

    }

}