package com.thoughtworks.tddintro.accountbalance;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AccountTests {

    private final Account account = new Account(100);

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        assertThat(account.deposit(50), is(150));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        assertThat(account.withdraw(50), is(50));
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        assertThat(new Account(50).withdraw(100), is(50));
    }
}
