package com.poly.datn.service;

import com.poly.datn.dto.InvoiceDto;
import com.poly.datn.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> getAll();
    List<Invoice> getStatus(String status);
    InvoiceDto detail(String codeBill);

}
