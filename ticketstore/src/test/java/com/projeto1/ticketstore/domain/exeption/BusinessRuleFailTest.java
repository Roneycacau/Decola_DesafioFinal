package com.projeto1.ticketstore.domain.exeption;

import com.projeto1.ticketstore.exception.BusinessRuleFail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * ClientServiceTest
 */
@RunWith(MockitoJUnitRunner.class)
public class BusinessRuleFailTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test(expected = BusinessRuleFail.class)
    public void should_BusinessRuleFailException() {
        throw new BusinessRuleFail("Mensagem");
    }

    @Test(expected = BusinessRuleFail.class)
    public void should_BusinessRuleFailException2() {
        Throwable e = new Throwable();
        throw new BusinessRuleFail("Mensagem", e);
    }
}