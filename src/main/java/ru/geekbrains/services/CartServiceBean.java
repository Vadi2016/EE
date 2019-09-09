package ru.geekbrains.services;

import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;

@Stateful
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class CartServiceBean implements CategoryServiceLocalBean {
}
