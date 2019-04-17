package com.mpazi.factory;

import com.mpazi.domain.TransferLetter;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransferLetterFactoryTest {
    @Test
    public void getTransferLetterTest(){

        TransferLetter transferLetter= TransferLetterFactory.getTransferLetter("patient needs specialist");

        assertEquals("patient needs specialist",transferLetter.getTransferNote());

    }

}